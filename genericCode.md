### Generic queryEntity, PagingGrid, queryFilter.

#### An attempt at generic queryEntity:

	with(

	  local!pagingInfo: if(
		ri!pagingInfo="", 
		
		a!pagingInfo(
		  startIndex:1,
		  batchSize: -1
		),
		
		ri!pagingInfo
	  ),
	  
	  a!queryEntity(
		entity:  ri!entityToQuery,
		
		query:  a!query(
		  
		  selection: a!querySelection(
			columns:  a!applyComponents(
			  function: a!queryColumn(
				field: _
			  ),
			  array: ri!arr_fieldsToQuery 
			)  
		  ),
		  
		  pagingInfo :  local!pagingInfo,
		  
		  logicalExpression: if(
			ri!logicalExpression="",
			null,
			ri!logicalExpression
			)
		  
		)
	  )
	  
	)
	
#### At attempt at a 'safe' queryFilter wrapper

	with(

	  local!pagingInfo: if(
		ri!pagingInfo="", 
		
		a!pagingInfo(
		  startIndex:1,
		  batchSize: -1
		),
		
		ri!pagingInfo
	  ),
	  
	  a!queryEntity(
		entity:  ri!entityToQuery,
		
		query:  a!query(
		  
		  selection: a!querySelection(
			columns:  a!applyComponents(
			  function: a!queryColumn(
				field: _
			  ),
			  array: ri!arr_fieldsToQuery 
			)  
		  ),
		  
		  pagingInfo :  local!pagingInfo,
		  
		  logicalExpression: if(
			ri!logicalExpression="",
			null,
			ri!logicalExpression
			)
		  
		)
	  )
	  
	)

#### At attempt at generic paging Grid:

	with(
	  
	  a!gridField(
		label: ri!label,
		
		totalCount: fn!index(ri!dataset, "totalCount", 0),
		columns: a!applyComponents(
		  
		  function: a!gridTextColumn(
			label: _,
			field:  _,
			data: _
			
		  ),
		  
		  array: fn!merge(
			/*Underscores will be replaced by spaces */
			ri!arrtxt_fieldsToQuery,
			ri!arrtxt_fieldsToQuery,
			fn!apply(
			  fn!index(ri!dataset, "data", _, {}),
			  ri!arrtxt_fieldsToQuery
			)
		  ),
		  
		  arrayVariable: null
		),
		identifiers: fn!index(ri!dataset, "identifiers", null),
		value: ri!gridValue ,
		saveInto: {
		  ri!gridValue
		},
		selection: ri!showSelectionCol,
		requireSelection: ri!requireSelection
		
	  )  
	)