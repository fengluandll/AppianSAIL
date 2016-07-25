    
  with(
    
    {
      if(
        or(ri!listOfValues="", fn!length(ri!listOfValues)=0),
        
        {
          
          rule!ucTextField(
            listOfValues: ri!listOfValues,
            index: 1
          )
        },
        
        a!applyComponents(
          rule!ucTextField(
            listOfValues: ri!listOfValues,
            index:_
          ),
          
          1 + fn!enumerate(fn!length(ri!listOfValues))
        )        
        
      ),
      
      a!buttonLayout(
        secondaryButtons: { a!buttonWidget(
          label: "Add another",
          saveInto: {
           a!save(
             ri!listOfValues,
             
             fn!append(ri!listOfValues, " ")
           )
          
          }
        ),
        
        
           a!buttonWidget(
             label: "Remove",
             disabled:   or(ri!listOfValues="", fn!length(ri!listOfValues) < 2),
             saveInto: a!save(
               ri!listOfValues,
               
               fn!rdrop( ri!listOfValues, 1)
             )
           )
        }
      )
      
      
    }
  )



--------------------------------------------------------------------------------


a!textField(
      label: "Text Field",
      value:  if(
        
        or(ri!listOfValues="", fn!length(ri!listOfValues)=0),
        
        null,
        
        ri!listOfValues[ri!index]
      ) ,
      saveInto:ri!listOfValues[ri!index]
    )