REM stop JBoss

F:

cd F:\jboss-eap-6.4.0_for_711\bin

CALL shutdown.bat

TIMEOUT 300

REM stop search server
cd F:\Appian711\search-server\bin
CALL F:\Appian711\search-server\bin\stop.bat


REM now stop Appian

F:

cd F:\Appian711\server\_scripts

CALL F:\Appian711\server\_scripts\stop-suite.bat

REM wait for 1 minutes
TIMEOUT 60

echo "Appian server, search server and JBoss now are stopped."