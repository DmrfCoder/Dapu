
echo "0. git pull"
set rw=%~dp0../../
cd %rw%
git stash
git pull origin master -f 
cd Tool/Windows