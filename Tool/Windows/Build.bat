
echo "1. build"

set rw=%~dp0../../
cd %rw%

set SOURCE_PATH=%RootPath%Source/DaPu/app/build/outputs/apk/debug/app-debug.apk
del %SOURCE_PATH%

cd Source/DaPu
gradlew build