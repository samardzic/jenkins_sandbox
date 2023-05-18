:: ==================================================================================
:: NAME     : Jenkins Squish runner
:: VERSION  : 0.0.1
:: ==================================================================================
@echo off

@REM suite_preconditions, suite_smoke_test_plan, suite_regression_test_plan, suite_login 
set TEST_SUITE=suite_login

set PROJECT_LOCATION=C:\sindri_mobile
set REPORTS_PATH=c:\sindri_mobile\reports




:: Starting SQUISH server
:: /************************************************************************************/
echo.
ECHO ===== Starting SQUISH server =====
echo.
taskkill /IM squishserver.exe

cd "C:\Program Files\Squish\bin"
start squishserver.exe
timeout 10
set vreme = TIME /t

echo.
ECHO ===== Running *** %TEST_SUITE% *** test suite =====
echo.
cd %PROJECT_LOCATION%
@REM "C:\Program Files\Git\bin\git" pull origin development
@REM squishrunner --debugLog alpw --testsuite suite_preconditions --reportgen html,/tmp/results/%vreme%
@REM squishrunner --debugLog alpw --testsuite suite_smoke_test_plan --reportgen html,/tmp/results/%vreme%
@REM squishrunner --debugLog alpw --testsuite suite_regression_test_plan --reportgen html,/tmp/results/%vreme%
@REM squishrunner --debugLog alpw --testsuite %TEST_SUITE% --reportgen html,%REPORTS_PATH%
squishrunner --testsuite %TEST_SUITE% --testcase tst_sindri_1539_user_login_successfull --reportgen html,%REPORTS_PATH%






:: Stop / Kill SQUISH server
:: /************************************************************************************/
echo.
ECHO ===== Stop / Kill SQUISH server =====
echo.

taskkill /IM squishserver.exe


:: /************************************************************************************/
echo.
ECHO ===== Test Execution Completed =====
echo.
exit /b 0