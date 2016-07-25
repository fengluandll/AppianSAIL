	######################################

	View all the applications in list view:

	a!appdesigner_applicationlistview()

	load(
	  a!formLayout(
		firstColumnContents: a!appdesigner_applicationlistview()
	  )

	)

	##################################################
	get info of an application from ID:
	a!appdesigner_getapplicationinfo(6012)


	########################################################

	Find missing dependencies of an application from its ID:
	a!appdesigner_getmissingdependencies(6012)

	#########################################

	Load UI for importing an application.

	load(
	  
	  a!appdesigner_importstartui()
	)


	######################################################
	Picker field which allows you to select any folder:

	load(
	  a!appdesigner_pickerfieldallfolders()
	)

	#############################################################

	generates unique URL identifiers which are used for sufffixing application URLS. Try this in expression editor.

	fn!getuniqueapplicationurl_appian_internal()

	##############################################################

	a!appdesigner_impactanalysis_modal_controller()
	
	##############################################################
	 this can allow us to create new applications
	
	a!designerwrapper_main()  
	
	################################################################
	get the rules root folder:
	a!rulesrootfolder()
	
	####################################################################
	Toolbar layout padded
	
	load(
	  a!formLayout(
		firstColumnContents: a!toolbarlayout_padded()
	  )

	)
	
	
    ########################################################################
     Internal Grid Layout
	
	load(
  
	  a!formLayout(
		firstColumnContents: a!gridlayout_appian_internal(
		  headerCells: {
			a!gridLayoutHeaderCell(label: "Header1"),
			a!gridLayoutHeaderCell(label: "Header2")
		  }
		)
	  )

	)
	
	############################################################################
	expd_navigationtree_view
	expd_navigator -- Selectable Tree
	
	
	################################################################################
	
	This provides expression editor. We can expose this to end user... (maybe a bad idea)
	a!expressioneditorinternal() -- with all autocompletions.
	
	a!pickerfieldrulefolder(
	  maxSelections:1
	) 
	
	
	
	a!expd_pickerpanel() 
	
	####################################################################################
	
	
	prefixes:
	
	appdesigner_
	expd_
	erd_
	dtd_
	util_
	
	
	############################################################################################
	
	a!appdesigner_uilist()
	
	-- this is returning a list of UI interfaces used for creating appdesigner
	
	
	##############################################################################################
	
	
	
	
[
addExistingApplication:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "addExistingApplication"],

addExistingObjects:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "addExistingObjects"],

addFolderContents:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "addFolderContents"],

applicationActions:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "applicationActions"],

applicationList:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "applicationList"],

applicationSecurity:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "applicationSecurity"],

applicationSecurityFromAppList:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "applicationSecurityFromAppList"],

deleteApplication:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "deleteApplication"],

exportPatch:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "exportPatch"],

exportApp:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "exportApp"],

failedActionError:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "failedActionError"],

globalObjects:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "globalObjects"],impactAnalysisDependents:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "impactAnalysisDependents"],impactAnalysisPrecedents:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "impactAnalysisPrecedents"],importApp:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "importApp"],importPatch:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "importPatch"],main:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "main"],missingDependencies:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "missingDependencies"],newApplication:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newApplication"],newConstant:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newConstant"],newDataStore:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newDataStore"],newDataType:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newDataType"],newDocument:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newDocument"],newFeed:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newFeed"],newFolder:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newFolder"],newGroup:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newGroup"],newGroupType:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newGroupType"],newInterface:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newInterface"],newProcessReport:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newProcessReport"],newProcessModel:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newProcessModel"],newQueryRule:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newQueryRule"],newRecordType:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newRecordType"],newReport:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newReport"],newRule:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newRule"],newSite:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "newSite"],noAppDependents:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "noAppDependents"],noAppPrecedents:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "noAppPrecedents"],updateApplication:lambda!["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] "l" 1 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "with" 2 "with" 3 ["evaluatedui" 0 "evaluatedui" 1 "designerwrapper_main" "erroronsaveerrors"] 0] "l" "erd_main" "load" 2 2 "load" "erd_currentdisplay_controller" "load" "with" 1 "erd_exprdesigner_applayout" "load" "centerpane" "target" "erd_centerpane" 1 "load" "erd_testresultpane_controller" 2 "with" "testbuttonsaveinto" "erd_testresultpane_evalwithinputs" "load" "result" 2 0 "evalwithcontext_result" 0 "with" "appdesigner_uilist" "updateApplication"]]




a!appdesigner_newcontent_menu()

##############################################################################
a!pickerfieldrulefolder(maxSelections:1)

#############################################################################

a!millercolumnbrowserfieldcustom(
  label: "test Miller column",
  nodes: {
    a!millercolumnbrowserfieldcustom_node()
  }
)
















