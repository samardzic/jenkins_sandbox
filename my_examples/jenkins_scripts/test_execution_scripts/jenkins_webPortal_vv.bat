:: ==================================================================================
:: DESC   : Web Portal pytest launcher for VV env
:: ==================================================================================
@echo off

set WEBPORTAL_LOCATION=c:\sindri_automation\sindri_webPortal
@REM set TEST_SUITE=webPortal
set TEST_SUITE=jnkTest
set TEST_RERUNS=--reruns 2 --reruns-delay 1

@REM default="user_main" [user_dragana, user_nenad, user_maja, user_jenkins, user_main]
set TEST_USER=--user=user_main

@REM default="vv" [vv, dev, cicd, cicd_api]"
set TEST_ENV=--env=vv

@REM default="chrome" [chrome, firefox, safari, ie, edge]
set TEST_BROWSER=--browser=chrome




:: Start PyTest test run
:: /************************************************************************************/
echo.
ECHO ===== Starting PyTest test run  =====
echo.



echo.
ECHO ===== Activating VENV =====
echo.

call %WEBPORTAL_LOCATION%\venv\Scripts\activate 



echo.
ECHO ===== Running specific test suite =====
echo.
cd %WEBPORTAL_LOCATION%
call pytest %TEST_RERUNS% -m %TEST_SUITE% %TEST_USER% %TEST_ENV%


echo.
ECHO ===== Closing Test Suite Execution =====
echo.
exit /b 0


:: /************************************************************************************/
