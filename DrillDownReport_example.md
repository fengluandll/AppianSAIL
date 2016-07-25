load(
  local!clickedBar,
  with(
    {
      a!columnChartField(
        label: "A bar chart",
        categories: {
          "Orange",
          "Mango",
          "Apple"
        },
        series: {
          a!chartSeries(
            data: {
              40,
              30,
              20
            },
            links: a!applyComponents(
              a!dynamicLink(
                value: _,
                saveInto: ri!clickedBar
              ),
              {
                1,
                2,
                3
              }/*1 - Orange, 2 - Mango, 3 - Apple */
              
            )
          )
        },
        xAxisTitle: "Fruit",
        yAxisTitle: "Count",
        showLegend: false
      ),
      
      
      if(
        fn!or(
          fn!isnull(
            ri!clickedBar
          ),
          ri!clickedBar = ""
        ),
        a!richTextDisplayField(
          value: "No fruit selected"
        ),
        a!columnChartField(
          label: "Details",
          showLegend: false,
          categories: {
            fn!choose(
              ri!clickedBar,
              "Orange",
              "Mango",
              "Apple"
            )
          },
          series: a!chartSeries(
            data: if(
              ri!clickedBar = 1,
              {
                40
              },
              if(
                ri!clickedBar = 2,
                {
                  30
                },
                if(
                  ri!clickedBar = 3,
                  {
                    20
                  },
                  {}
                )
              )
            )
          ),
          xAxisTitle: "fruit",
          yAxisTitle: "Count"
        )
      )
    }
  )
)