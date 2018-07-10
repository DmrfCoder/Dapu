
echo "1. build"

set RootPath=%~dp0../../
cd %RootPath%

set SOURCE_PATH=%RootPath%Source/DaPu/app/build/outputs/apk/debug/app-debug.apk
del "%SOURCE_PATH%" /s

cd Source/DaPu
call  gradlew build
cd %RootPath%Tool/Windows