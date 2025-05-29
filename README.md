# PlanSourceAutomation
Install eclipse IDE
Install testNG from eclipse market and maven from google
Add maven path to the environment variable
Use log4j.properties and ExtentReports for logs and reports
Convert testcases to TestNG
run testNG.xml suite
Add compiler and surefire plugins to run from maven
Create an empty rep on github
Use git commands : 
   git init //create an empty git repository
   git remote add origin //connects local git repository to github repository
   git status //shows status of repository (tracked and untracked files)
   git add -A //adds files to the staging area

   git commit -m "comment" //add files from staging area to local git repository
   git push -u origin master //add files from local git repo to remote github repo
   git pull origin master //get files from github repo to local repo

   Since I have 2 branches becasue my first commit was in main and second commit (code) was in master. 
   To handle this, use: - git fetch origin
                          git branch -a
                          git checkout main
                          git merge origin/master --allow-unrelated-histories
                          git push origin main