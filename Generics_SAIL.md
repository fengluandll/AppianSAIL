/*Wrapper over queryEntity() 
Params: 
1. pagingInfo - a pagingInfo variable, not mandatory
2. entity - a constant of Data Store entity - mandatory
3. arr_fieldsToQuery- list of columnNames you want
4. logicalExpression - a variable of type logicalExpression - you can even use the simple dictionary Syntax - not mandatory.
*/

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


##################################################################################################################
##A wrapper over Paging Grid:


/*
*
* Inputs:
  label: Text (Mandatory - no)
  arrtxt_fieldsToQuery: List of fields to query (Madatory - yes)
  dataset: Dataset object (Mandatory - yes)
  gridValue: a pagingInfo or gridSelection object (Madatory - yes)
  showSelectionCol: boolean
  requireselection: boolean
*/

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

###############################################################################################################

queryFilter wrapper:

/*
*field: text (Mandatory - yes)
*operator: text (Mandatory - yes)
*value: Any Type (Mandatory - yes)
*/

with(
  
  
  if(
    rule!CRD_checkFieldLength(ri!value),  /*This rule just checks if the field is null or has no chars in it after trimming whitespace */
    
    {},
    
      
    a!queryFilter(
      field: ri!field,
      operator: ri!operator,
      value: ri!value
    )
    
  )
  
)




###################################################################################################################

Using a reduce function to produce a  new List instead of a single value.
Usually, we use reduce to reduce the list to a single value. It is possible to generate or even expand the input list into a new list.
In below example 


fn!reduce(
  
  rule!TEST_APPEND(
    list: _,
    number: _
  ),
  
  {},
  
  {1,2,3}
)

/* Above code returns {3,2,1}*/

where rule!TEST_APPEND is :   
fn!append(
  ri!number,
  ri!list
)

#######################################################################################################################

generate fibonacci series upto nth term

fn!reduce(
  rule!TEST_FIBONACCI_NEW_TERM(
		list: _,
		num: _
  ),
  {0,1},
  fn!ldrop(1 + fn!enumerate(ri!int_uptoWhichTerm),2)
)



#######################################################################################################################

###generate a list of functions to apply..

with(
  
  local!myFun: fn!apply(_, _),
  
  local!add5: fn!sum(5, _),
  
  local!add6: fn!prod(6,_),
  
  local!remainder: fn!mod(_, 2),
  
  local!isZero: if(_, local!add5(), local!add6()),
  
  local!funList: fn!apply(
    local!isZero,
    fn!toboolean(fn!apply(local!remainder, {3,4,2,6,9}) )
   ),
   
  local!funList
)