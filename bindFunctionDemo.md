### Bind function Demo

#### Example1

	load(
	  
	  local!testVar: fn!bind(
		get: ri!testBool,
		
		set:fn!startprocesswrite(
		  processModelId:fn!tointeger(
			cons!TEST_BIND_FUNCTION_PROCESS_MODEL
		  ),
		  
		  processParameters: _
		)
	  ),
	  
	  
	  a!formLayout(
		label: "bind function demo",
		firstColumnContents: {
		  a!radioButtonField(
			label: "Please Select",
			choiceLabels: {"Yes", "No"},
			choiceValues: {true, false},
			value: ri!testBool,
			saveInto: {ri!testBool
			},
			required: true
		  )
		},
		
		buttons: a!buttonLayout(
		  primaryButtons: a!buttonWidget(
			label: "Trigger process model",
			style: "PRIMARY",
			confirmMessage: "This will trigger a process model. Are you sure?",
			value: {testBool: ri!testBool},
			saveInto: local!testVar,
			validate: true
		  )
		)
	  )
	  
	)

#### Example2	
	
	load(
		  
		local!txt_Param:bind(
		  get: ri!txt_parameter,
		  
		  set:  rule!61L_returnWriter_To_Start_Excel_Report_Generator(
			txt_testParam: _
		  )
		),

		a!textField(
		  label: "Enter a value",
		  value: local!txt_Param,
		  saveInto: {
		   local!txt_Param,
		   ri!txt_parameter
		  
		  }
		)
	  
	)