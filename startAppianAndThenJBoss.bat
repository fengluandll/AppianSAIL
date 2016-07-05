REM start Appian

F:
cd F:\Appian711\server\_scripts\
CALL F:\Appian711\server\_scripts\start-suite.bat

REM start search server
cd F:\Appian711\search-server\bin
CALL F:\Appian711\search-server\bin\start.bat

REM wait for 1 minutes
TIMEOUT 60

REM now start JBoss
cd F:\jboss-eap-6.4.0_for_711\bin

CALL standalone.bat

TIMEOUT 300

echo "Appian and JBoss now are started....Login...."