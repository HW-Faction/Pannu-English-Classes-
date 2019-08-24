echo starting git daemon.......
git add --all
git commit -m "v1.2.1" .
git push origin master
sleep 10000
echo 2nd 
git add --all
git commit -m "v1.2.2" .
git push origin master
sleep 10000
echo 3rd
git add --all
git commit -m "v1.2.3" .
git push origin master
sleep 10000
echo 4th
git add --all
git commit -m "v1.2.4" .
git push origin master
sleep 10000
echo 5th
git add -all
git commit -m "v1.2.5" .
git push origin master

