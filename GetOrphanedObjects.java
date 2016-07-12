package com.persistent.plugins.orphanobjects;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import com.appiancorp.ix.Type;
import com.appiancorp.ix.analysis.index.IaType;
import com.appiancorp.ix.analysis.index.ObjectRelationshipsService;
import com.appiancorp.ix.analysis.index.TypedUuid;
import com.appiancorp.suiteapi.applications.Application;
import com.appiancorp.suiteapi.applications.ApplicationNotFoundException;
import com.appiancorp.suiteapi.applications.ApplicationService;
import com.appiancorp.suiteapi.common.exceptions.InvalidProcessModelException;
import com.appiancorp.suiteapi.common.exceptions.InvalidVersionException;
import com.appiancorp.suiteapi.common.exceptions.PrivilegeException;
import com.appiancorp.suiteapi.content.Content;
import com.appiancorp.suiteapi.content.ContentConstants;
import com.appiancorp.suiteapi.content.ContentService;
import com.appiancorp.suiteapi.content.exceptions.InvalidContentException;
import com.appiancorp.suiteapi.expression.annotations.AppianScriptingFunctionsCategory;
import com.appiancorp.suiteapi.expression.annotations.Function;
import com.appiancorp.suiteapi.expression.annotations.Parameter;
import com.appiancorp.suiteapi.process.ProcessDesignService;
import com.appiancorp.suiteapi.process.ProcessModel;
import com.persistent.plugins.orphanobjects.types.ORPHANEDOBJECT;


@AppianScriptingFunctionsCategory
public class GetOrphanedObjects {
	
	private static final Logger LOG = Logger.getLogger(GetOrphanedObjects.class);
	
	@Function
	public ORPHANEDOBJECT[] GetOrphanedObjectsForApplication(
			ApplicationService appService,
			ContentService contentService,
			ProcessDesignService pds,
			ObjectRelationshipsService objectRelationshipSvc,
			@Parameter final String appUUID,
			@Parameter final String objectType){
		
		LOG.debug("Begun execution, given appUUID is "+appUUID);
		
		try {
			/*find the UUIDs of all the objects in the application */
			final Application app =  appService.getApplicationByUuid(appUUID) ;
						
			Set<TypedUuid> typeUUIDSOfObjects = getTypedUUIDs(app, objectType, contentService);			
			/*ObjectDependencies is telling you what other objects must be imported for 
			 * importing the current object successfully to other
			 * environments.
			 * It is thus "Precedents" */
			/*ObjectDependencies objectDependencies =
					objectRelationshipSvc.getDependencies(new TypedUuid(IaType.FREEFORM_RULE, testRule.getUuid()));*/
			
			/*we need ObjectImpacts - which will show the Dependents - not including the application names*/
			Set<IaType> desiredTypes = new HashSet<IaType>() ;
			/*exclude the Application type.
			 * Note: we just can't use .remove on allTypes because the API returns a 
			 * RegularImmutableSet on which the .remove() method has no effect.
			 * hence the for loop */
			for(IaType iaType: IaType.ALL_TYPES){
				if(iaType == IaType.APPLICATION){
					
				}else{
					desiredTypes.add(iaType) ;
				}
			}
			
			Map<TypedUuid, Long> impactsCount = objectRelationshipSvc
					.getCountOfImpactsFiltered(typeUUIDSOfObjects, desiredTypes) ;

			
			/*we will return a list of orphaned Objects */
			
			ArrayList<ORPHANEDOBJECT> orphanedObjects = new ArrayList<ORPHANEDOBJECT>() ;
			for( Map.Entry<TypedUuid, Long> entry: impactsCount.entrySet() ){
				
				/*0 dependents */
				if(entry.getValue() == 0L){
					String currUUId = entry.getKey().getUuid() ;
					ORPHANEDOBJECT orphanObj = new ORPHANEDOBJECT() ;
					try {
						/*You have to check if it is a rule or constant or process model */
						/*Do not directly use contentService
						 * assuming that it is a rule/constant */
						if( objectType.equals("RULE")  || objectType.equals("CONSTANT")  ){
							Content content = contentService.
									getVersion(currUUId, ContentConstants.VERSION_CURRENT) ;
							
							orphanObj.setName(content.getName());
							orphanObj.setType(objectType);
							orphanObj.setUuid(currUUId);
							orphanObj.setLastUpdated(
									getXMLGregorianCalendarFromTimestamp(content.getUpdatedTimestamp()));
							
							orphanedObjects.add(orphanObj) ;
							
							
						}else if( objectType.equals("PROCESS_MODEL") ){
							ProcessModel pm = pds.getProcessModelByUuid(currUUId) ;
							
							orphanObj.setName(pm.getName().get(Locale.US));
							orphanObj.setType(objectType);
							orphanObj.setUuid(currUUId);
							orphanObj.setLastUpdated(
									getXMLGregorianCalendarFromTimestamp(pm.getTimeStampUpdated()) );
							
							orphanedObjects.add(orphanObj) ;
							
						}else{
							throwError("Invalid Object Type Specified");
						}

						
					} catch (InvalidContentException e) {
						throwError("The rule/constant with UUID "+currUUId + " is invalid") ;
					} catch (InvalidVersionException e) {
						throwError("The code tried to reference invalid version of the object with uuid "+currUUId);
					} catch (InvalidProcessModelException e) {
						throwError("The process model with UUID "+ currUUId + " is invalid") ;
					}
				}
				
			}
			
			LOG.debug(orphanedObjects);
			return orphanedObjects.toArray(new ORPHANEDOBJECT[orphanedObjects.size()]) ;
		
			
		} catch (PrivilegeException e) {
			throwError("You do not have permissions to access the application with UUID: "+appUUID);
		} catch (ApplicationNotFoundException e) {
			throwError("No application with UUID "+appUUID+" exists");
		}
		
		return null;
		
	}
	
	
	/*This method will get the TypedUUIDs in the application for given
	 * objectType */
	/*objectType can be a RULE|CONSTANT|PROCESS_MODEL */
	public static Set<TypedUuid> getTypedUUIDs(
			final Application app,
			final String objectType, 
			final ContentService contentService){
		
		Set<?> objectSet ;
		ArrayList<String> objectUUIds ;
		Set<TypedUuid> typeUUIDSOfObjects = new HashSet<TypedUuid>() ;
		
		switch(objectType.trim()) {
		
		case "RULE":
			LOG.debug("For Rules");
			objectSet = app.getObjectsByType(Type.get(Type.CONTENT_KEY)) ;
			objectUUIds = getObjectUUIDsFromObjectSet(objectSet) ;
			for(String objectUUID: objectUUIds){
				try {
					Content content = contentService.getVersion(objectUUID, ContentConstants.VERSION_CURRENT);
					if( content.getType() == ContentConstants.TYPE_RULE  && 
						content.getSubtype() == ContentConstants.SUBTYPE_RULE_FREEFORM  ) {
						
						typeUUIDSOfObjects.add(
								new TypedUuid(IaType.FREEFORM_RULE, objectUUID)) ;
	
					}
				} catch (InvalidContentException e) {
					throwError("This Object with UUID "+objectUUID+" does not exist");
				} catch (InvalidVersionException e) {
					throwError("Invalid version of the object with UUID "+objectUUID);
				} catch (PrivilegeException e) {
					throwError("You do not have access to the object with UUID: "+objectUUID);
				}

			}
			
			break;
			
		case "CONSTANT":
			LOG.debug("For Constants");
			objectSet = app.getObjectsByType(Type.get(Type.CONTENT_KEY)) ;
			objectUUIds = getObjectUUIDsFromObjectSet(objectSet) ;
			for(String objectUUID: objectUUIds){
				try {
					Content content = contentService.getVersion(objectUUID, ContentConstants.VERSION_CURRENT);
					if( content.getType() == ContentConstants.TYPE_RULE  && 
						content.getSubtype() == ContentConstants.SUBTYPE_RULE_CONSTANT  ) {
						
						typeUUIDSOfObjects.add(
								new TypedUuid(IaType.CONSTANT, objectUUID)) ;
	
					}
				} catch (InvalidContentException e) {
					throwError("This Object with UUID "+objectUUID+" does not exist");
				} catch (InvalidVersionException e) {
					throwError("Invalid version of the object with UUID "+objectUUID);
				} catch (PrivilegeException e) {
					throwError("You do not have access to the object with UUID: "+objectUUID);
				}

			}
			
			break;
			
		case "PROCESS_MODEL":
			LOG.debug("For Process Models");
			objectSet = app.getObjectsByType(Type.get(Type.PROCESS_MODEL_KEY)) ;
			objectUUIds = getObjectUUIDsFromObjectSet(objectSet) ;
			for(String objectUUID: objectUUIds){
				typeUUIDSOfObjects.add(
						new TypedUuid(IaType.PROCESS_MODEL, objectUUID)) ;
			}
			
			break;
			
		default:
			throwError("Invalid Object Type specified");
			
		}
		
		/*end of switch case. */
		return typeUUIDSOfObjects;
	}
	
	
	
	
	/*This method returns a list of objectUUIDs in ArrayList<String>
	 * from a Set. */
	public static ArrayList<String> getObjectUUIDsFromObjectSet(Set<?> objectSet){
		ArrayList<String> objectUUIds = new ArrayList<String>();
		
		if(objectSet != null && objectSet.size() > 0){ 
			objectUUIds = new ArrayList<String>(Arrays.asList(objectSet.toArray(new String[0])));
			return objectUUIds ;
		}else{
			throwError("Content set is empty");
		}
		
		return objectUUIds ;
	}
	
	
	/*Utility method for throwing a new ErrorMesage. 
	 * This will also log it in the application log */
	public static void throwError(final String message){
		LOG.error(message);
		throw new Error(message);
	}
	
	
	/*This is for date/timestamp conversion */
	public static XMLGregorianCalendar getXMLGregorianCalendarFromTimestamp(Timestamp t){
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(t);
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			throwError("Error while converting Timestamp to DateTime");
		}
		return null;
	}
	
	
}
