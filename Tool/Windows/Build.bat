
echo "1. build"

set RootPath=%~dp0../../


set SOURCE_PATH=%RootPath%Source/DaPu/app/build/outputs/apk/debug/app-debug.apk
cd %RootPath%Source/DaPu/app/build/outputs/apk/debug/
del app-debug.apk

cd %RootPath%
cd Source/DaPu
call  gradlew build
cd %RootPath%Tool/Windows