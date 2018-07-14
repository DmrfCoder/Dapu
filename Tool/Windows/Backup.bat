

echo "0. git pull"
set RootPath=%~dp0../../

set hh=%TIME:~0,2%
if "%time:~0,2%" lss "10" (set hh=0%time:~1,1%) else (set hh=%time:~0,2%)
set mm=%TIME:~0,2%
if "%time:~3,2%" lss "10" (set mm=0%time:~4,1%) else (set mm=%time:~3,2%)

set PROJECT_NAME=%1_%date:~6,4%.%date:~0,2%.%date:~3,2%_T%hh%.%mm%-debug.apk
echo %PROJECT_NAME%

set SOURCE_PATH=%RootPath%Source/DaPu/app/build/outputs/apk/debug/app-debug.apk
set Target_PATH=C:/work/backup/baiduyun/DapuAndroid/%PROJECT_NAME%
cd %RootPath%Source/DaPu/app/build/outputs/apk/debug/
copy "app-debug.apk" "%Target_PATH%"
cd %RootPath%Tool/Windows



