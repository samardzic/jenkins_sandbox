@REM test suites=[smoke, webPortal, emailTests, billing, jnkTest]
set TEST_SUITE=webPortal

@REM "--reruns 5" re-run all test failures 5 times, "--reruns-delay 3" time between re-runs in seconds
set TEST_RERUNS=--reruns 2 --reruns-delay 3

@REM default="user_main" [user_dragana, user_nenad, user_maja, user_jenkins, user_main]
set TEST_USER=--user=user_main

@REM default="vv" [vv, dev, cicd, cicd_api]"
set TEST_ENV=--env=vv

@REM default="chrome" [chrome, firefox, safari, ie, edge]
set TEST_BROWSER=--browser=chrome

call "c:\sindri_automation\sindri_webPortal\venv\Scripts\activate.bat"
cd c:\sindri_automation\sindri_webPortal
pytest -v %TEST_RERUNS% -m %TEST_SUITE% %TEST_USER% %TEST_ENV% %TEST_BROWSER%


exit /b 0
