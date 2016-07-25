External system - not developed in Appian

1. Publish the PM as web service. 
  WSDL will be available. Only ProcessId of the processs started will be returned to the caller. 
  
  
  Java Backend (made using Servlets)      Front End UI (HTML5)
  
  We capture values on form fields which were entered by user on form submit.
  We send these values to Servlet by making a HTTP POST request.
  
  
  Java Servlet contains the code to call the process model which was published as web service (WSDL)
  Authentication details(loginId and password) for calling process model were stored in servlet code itself.
  
  
  Calling a SOAP web service basically involves the following:
  1. You need to communicate in XML format i.e data needs to be sent in XML format
  2. Construct the XML message
  3. HTTP POST the request i.e POST the XML message to WSDL URL
  
2. Embedded SAIL. - SSO is required you can refer https://forum.appian.com/suite/help/16.1/Embedded_Interfaces.html



