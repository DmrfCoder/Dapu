#!/bin/sh


echo "0. git pull"
rw=`dirname $0`/../
cd $rw
git stash
git pull origin master -f 