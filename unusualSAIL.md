### This contains code snippets which show unusual usage of SAIL code.

/*Using a UI component as a variable */

	with(
	  
	  local!readOnlyTextBox: a!textField(
		label: "Test Field",
		readOnly: true,
		value: _
	  ),
	  
	  a!applyComponents(
	   local!readOnlyTextBox,
	   
	   {"chetan", "nikhil"}
		
	  )
	)


	Note:  Replacing with by load does not  work...

	Implications:  UI components can be used like variables.. this is cool..

	--------------------------------------------------------------------------

	load(
	 
	  with(
		
		local!readOnlyTextBox: a!textField(
		  label: "Test Field",
		  readOnly: true,
		  value: _
		),
		
		a!applyComponents(
		 local!readOnlyTextBox,
		 
		 {"chetan", "nikhil"}
		  
		)
	  ) 
	  
	)