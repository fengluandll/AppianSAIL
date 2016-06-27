### Simulating Switch case in SAIL.

A combination of fn!choose and fn!displayvalue can be used to simulate a "switch" case in Appian. fn!choose is like switch case - but with one caveat - the "key" should be a number - it does not allow text values or float values. So, you can use fn!displayvalue with fn!choose when the value which decides which branch to takes is not a number.

Example Snippet:



	load(
	
		/*local!statusCode will be 1 or 2 or -1
		1 - Approved
		2 - Rejected
		-1 - Some invalid value*/
		local!statusCode: fn!displayvalue(
							ri!status,
							{"Approved", "Rejected"},
							{1,2},
							-1
							),
  
		fn!choose(
			local!statusCode,
		
			{
				/*code for choice1 */
			},
    
			{
				/*code for choice2 */
			}
		)
	)
 