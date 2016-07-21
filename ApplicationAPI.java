package persistent.types.bc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;



//import org.apache.log4j.Logger;
import com.appiancorp.ix.Type;
import com.appiancorp.suiteapi.applications.Application;
import com.appiancorp.suiteapi.applications.ApplicationNotFoundException;
import com.appiancorp.suiteapi.applications.ApplicationService;
import com.appiancorp.suiteapi.common.exceptions.InvalidVersionException;
import com.appiancorp.suiteapi.common.exceptions.PrivilegeException;
import com.appiancorp.suiteapi.content.Content;
import com.appiancorp.suiteapi.content.ContentConstants;
import com.appiancorp.suiteapi.content.ContentFilter;
import com.appiancorp.suiteapi.content.ContentService;
import com.appiancorp.suiteapi.content.exceptions.InvalidContentException;
import com.appiancorp.suiteapi.expression.annotations.AppianScriptingFunctionsCategory;
import com.appiancorp.suiteapi.expression.annotations.Function;
import com.appiancorp.suiteapi.expression.annotations.Parameter;
import com.appiancorp.suiteapi.rules.Constant;
import com.appiancorp.suiteapi.type.AppianType;
import com.appiancorp.type.external.config.PersistedDataStoreConfig;
import com.appiancorp.type.external.config.PersistedEntity;
import com.appiancorp.type.external.config.content.DataStoreConfigContent;
import com.appiancorp.type.external.config.content.DataStoreConfigRepositoryContentImpl;

@AppianScriptingFunctionsCategory
public class ApplicationAPI {

	private static final Logger LOG = Logger.getLogger(ApplicationAPI.class);
	
	/*Returns a list of constant names and their associated CDT type IDs*/
	/*You will need a list of appids instead of a single appId */
	@Function
	public BCEntityData[] BC_getConstantListOfTypeDatabaseEntity(
			final ApplicationService appSvc,
			final ContentService contentSvc,
			@Parameter(required=true) final Long[] appIds) throws PrivilegeException, ApplicationNotFoundException, InvalidContentException, InvalidVersionException {
		
		/*5 threads in parallel.. usually every project will 
		 * have at-most 4-5 applications associated with it */
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		Set<Callable<List<BCEntityData>>> callables = new HashSet<Callable<List<BCEntityData>>>();
		
		for(final Long currAppId: appIds){
			callables.add(new Callable<List<BCEntityData>>() {
				public List<BCEntityData> call() throws Exception {
					return getConstantListOfTypeDatabaseEntity(appSvc, contentSvc, currAppId) ;
				}
				
			});
		}
		
		
		List<Future<List<BCEntityData>>> futures;
		List<BCEntityData> returnArrayList = new ArrayList<BCEntityData>();
		
		try {
			futures = executorService.invokeAll(callables);
			for(Future<List<BCEntityData>> future : futures){
				List<BCEntityData> currList = future.get() ;
				LOG.debug("future.get = " + currList);
				returnArrayList.addAll(currList) ;
			}

		} catch (InterruptedException e) {
			throwError("Interrupted Exception");
		} catch (ExecutionException e) {
			throwError("Execution Exception");
		}
		

		executorService.shutdown();
		
		return returnArrayList.toArray(new BCEntityData[0]) ;

	}
	
	
	/*This is for single appId */
	private static List<BCEntityData> getConstantListOfTypeDatabaseEntity(
			final ApplicationService appSvc,
			final ContentService contentSvc,
			final Long appId) throws PrivilegeException, ApplicationNotFoundException, InvalidContentException {
		
List<BCEntityData> returnArrayList = new ArrayList<BCEntityData>();
		
		/* get all the data stores */
		Content[] dataStoreConfigArray = null;
		try {
			dataStoreConfigArray = contentSvc.getAllChildrenAndVersions(
					DataStoreConfigRepositoryContentImpl.DATA_STORE_CONFIGS_CONTENT_ROOT_ID.longValue(),		
					new ContentFilter(ContentConstants.TYPE_APPLICATION, ContentConstants.SUBTYPE_DATA_STORE_CONFIG)
					);
		} catch (Exception e) {
			BCEntityData errorMessage = new BCEntityData();
			errorMessage.setConstantName("You do not have rights to access this data store. Contact System Administrator.");
			returnArrayList.add(errorMessage);
			return returnArrayList;
		}
		
		LOG.debug("Application Service returned " + dataStoreConfigArray.length + " Data Stores ");
		
		/* null check  - if no datastores in application*/
		if (dataStoreConfigArray.length == 0) {
			return returnArrayList;
		}

		Long[] constantIdArray = new Long[0];

		Application appObj = appSvc.getApplication(appId);

		if (appObj != null) {
			/* get all constants in the application */
			Set<?> constantsSet = appObj.getObjectsByType(Type.CONTENT);	
			/* convert UUIds to Ids */
			if (constantsSet != null && constantsSet.size() > 0) {
				constantIdArray = contentSvc.getIdsByUuid(constantsSet.toArray(new String[constantsSet.size()]));
			}

			LOG.debug("Application Service returned " + constantIdArray.length + " constants ");
			
			/*newConstantIds should contain only the content constants to
			 * which the current user has access   */
			ArrayList<Long> newConstantIds = new ArrayList<Long>();
			for (Long oneConstantId: constantIdArray) {
				if (oneConstantId != null && contentSvc.canView(oneConstantId)) {
					newConstantIds.add(oneConstantId);
				}
			}
		
			/*So now newConstantIds contains only the contentids of the constants to which the current user has access */
			
			Content[] constantArray = null;
			try{
			    constantArray = contentSvc.getVersions(
			    		newConstantIds.toArray(new Long[newConstantIds.size()]),
			    		ContentConstants.VERSION_CURRENT 
			    		);
			}catch (Exception e){
				throwError("Error while getting the constant from the Id ");
			}
			/*now constantArray has the contents to which the current user has access. */
			
			
			List<Constant> dseConstantList = new ArrayList<Constant>();
			for (Content oneConstant : constantArray) {
				if (oneConstant != null && oneConstant instanceof Constant
						&& ((Constant) oneConstant).getTypedValue().getInstanceType() == AppianType.DATA_STORE_ENTITY) {
					
					dseConstantList.add(((Constant) oneConstant));
				}
			}
			
			/*now dseConstantList contains only the Datastore entity constants. It will not contain the DSE constants
			 * to which the current user does not have access to */
			LOG.debug("Application Service returned " + dseConstantList.size() + " Data Store Entity Constants ");
			for (Constant oneDseConstant : dseConstantList) {

				String dseConstantStringValue = oneDseConstant.getTypedValue().getValue().toString();
				Long dataTypeNumber = getDataTypeForEntity(dataStoreConfigArray, dseConstantStringValue);

				if (dataTypeNumber != null) {
					BCEntityData oneDataObj = new BCEntityData();
					oneDataObj.setDataTypeNumber(dataTypeNumber.intValue());
					oneDataObj.setConstantName(oneDseConstant.getName());
					returnArrayList.add(oneDataObj);
				}

			}
		}
		else {
			throwError("No Application exist with Id " + appId);
		}

		return returnArrayList;
		
	}
	
	private static Long getDataTypeForEntity(final Content[] dataStoreConfigArray, final String dseImplId) {
		final Long dseStoreId = new Long(dseImplId.split("@")[1]);
		Long dataTypeNumber = null;
		
		for (Content oneConfigContent : dataStoreConfigArray) {

			if (oneConfigContent.getVersionId() > 0) {
				/* not the latest version */
				continue;
			}

			if (oneConfigContent instanceof DataStoreConfigContent) {

				PersistedDataStoreConfig config = ((DataStoreConfigContent) oneConfigContent)
						.getDataStoreConfig();

				// match data store id - to save unnecessary loops
				// also do not continue, if dataType is already found
				if (config.getId().equals(dseStoreId) && dataTypeNumber == null) {

					List<PersistedEntity> entityList = config.getEntities();
					LOG.debug("***** number of Entities: "+entityList.size());
					for (PersistedEntity oneEntity : entityList) {
						LOG.debug("**** oneEntity ID: "+oneEntity.getId());
						if (oneEntity.getId().equalsIgnoreCase(dseImplId)) {
							dataTypeNumber = oneEntity.getTypeRef().getId();
							LOG.debug("**** Found dataTypeNumber: "+dataTypeNumber); 
							break;
						}
					}

				}
			}

			else {
				LOG.debug("one of the content is not data store content");
			}
		}

		return dataTypeNumber;
	}
	
	
	/*Error handling function  */
	public static void throwError(final String message){
		LOG.error(message);
		throw new Error(message);
	}

}
