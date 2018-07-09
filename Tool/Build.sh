#!/bin/sh

echo "1. build"

rw=`dirname $0`

cd $rw
cd ../Source/DaPu
sh gradlew build