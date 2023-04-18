:: ==================================================================================
:: NAME     : MKdosc server start
:: VERSION  : 0.0.1
:: ==================================================================================
@echo off

set SERVER_PORT=9005
set IP_ADDRESS=127.0.0.1


:: Start MKdosc server
:: /************************************************************************************/
echo.
ECHO ===== Starting MKdocs server =====
echo.

ECHO --- CD to MKdocs foder ---
call cd c:/Build/jenkins_sandbox/workshop_presentation/
echo.


ECHO --- MKdosc server run ---
call start cmd /k mkdocs serve -a %IP_ADDRESS%:%SERVER_PORT%
echo.
:: /************************************************************************************/
