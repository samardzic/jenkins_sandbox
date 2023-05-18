ECHO OFF

:loop
for /F "tokens=3 delims=: " %%H in ('sc query "Jenkins" ^| findstr "        STATE"') do (
  if /I "%%H" EQU "RUNNING" (
   cmd /c "wscript.exe C:\jenkins_local\invisible.vbs C:\jenkins_local\jenkins_start.bat"
   goto :break
  )
	
)
timeout 60
goto:loop

:break
