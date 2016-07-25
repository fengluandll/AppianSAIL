Service backed records:
1. Source of data is an expression rule which returns datasubset.
2. The expression may get data from either a process, web service or a database. In this respect, service backed records have the greatest functionality than any other record type.
3. service backed records are more flexible since you can define default filters and user filters using expression rules.
Filter options can be dynamically configured. Use the a!facet option to create filter groups
4. A service backed record is most flexible and highly configurable - even more configurable than entity backed records or process backed records.
5. Although Service backed records are more flexible, you have to write more code(and hence more time will be spent while developing them). Searching in service back records does not work by default. You have to handle searching and security in your expression  rules(this can also be an advantage - since you can configure your own searching logic rather than Appian's default searching logic). also, you have to write code for displaying summary view correctly when some record is clicked in List view.
6. service backed records are believed to get more control on Record performance. 


Tutorial on service backed records on forum: https://forum.appian.com/suite/help/16.1/Service-Backed_Record_Tutorial.html

###############################################################################################################################

When to use Service backed records:
1. If you want to get data from web service and show records based on it.
2. You want more control on filters, searching logic and performance. Filters need to be dynamic or Filters/searching logic requirements are prone to requirements change.
3. You need to get data and you dont have existing rules/functions to get that data in-built in Appian. In this case, java code is necessary.

In most cases, if you have a clear requirement of the Record type you wnat to create, you can simply go with "Entity Backed records".
Use Service backed records only when Entity backed records will prove to be inflexible for your requirements.

################################################################################################################################

Creating Service Backed records in Java
Writing Java is necessary when there are no existing rules or functions that provide the capabilities needed to power the record.
For eg: there is no in-built function to get all the existing groups available in the Appian environment.

https://forum.appian.com/suite/help/16.1/Create_Service-Backed_Records_in_Java.html
