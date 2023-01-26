LAB REPORT 1
Teach 15L students  how to log into a course-specific account on ieng6. 

## Install VSCode

 Install VS code for your device ![alt text](https://user-images.githubusercontent.com/122493371/211989434-ea5fb506-bbe3-48de-bb53-b61602863fea.PNG) 

## Remotely connecting

   *install gitbash if you don't have linux already
     -[GitBash](https://stackoverflow.com/a/50527994)
    
     =Once installed, use the steps in this post to set your default terminal to use the newly-installed git bash in Visual Studio Code
   *install openSSH if not installed already
     [Git]([https://www.example.com](https://gitforwindows.org/))
     
     -`$ ssh cs15lwi23zz@ieng6.ucsd.edu`
      use ssh, open a terminal in VScode. 
      (Ctrl or Command + `, or use the Terminal → New Terminal menu option).
      Your command will look like this, but with the zz replaced by the letters in your course-specific account.
      

3. inside BASH TERMINAL, type` ⤇ ssh cs15lwi23zz@ieng6.ucsd.edu` and press enter. but replace zz with your ucsd username
The authenticity of host 'ieng6.ucsd.edu (128.54.70.227)' can't be established.
RSA key fingerprint is SHA256:ksruYwhnYH+sySHnHAtLUHngrPEyZTDl/1x99wUQcec.
Are you sure you want to continue connecting (yes/no/[fingerprint])? type yes to connect to server



4. BASH terminal asks you to enter your UCSD account password. type it and click enter, 
   *or reset if you don't know it(wait couple minutes for change to happen). https://sdacs.ucsd.edu/~icc/index.php
5. When you log in successfully it should look like this: 
# Now on remote server
Last login: Sun Jan  2 14:03:05 2022 from 107-217-10-235.lightspeed.sndgca.sbcglobal.net
quota: No filesystem specified.
Hello cs15lwi23zz, you are currently logged into ieng6-203.ucsd.edu

You are using 0% CPU on this system

Cluster Status 
Hostname     Time    #Users  Load  Averages  
ieng6-201   23:25:01   0  0.08,  0.17,  0.11
ieng6-202   23:25:01   1  0.09,  0.15,  0.11
ieng6-203   23:25:01   1  0.08,  0.15,  0.11

Sun Jan 02, 2022 11:28pm - Prepping cs15lwi23
![alt text](https://user-images.githubusercontent.com/122493371/211988591-d262593b-128a-47f4-88ab-748a37c3b02d.PNG)

## Run some commands in vscode terminal

Try running the commands cd, ls, pwd, mkdir, and cp a few times in different ways, both on your computer, and on the remote computer after ssh-ing 
![alt text](https://user-images.githubusercontent.com/122493371/211988767-4f329561-791c-4e26-b8a3-aca956391a1e.PNG)


 specific useful commands to try:

`cd ~
cd
ls -lat
ls -a
ls <directory> where <directory> is /home/linux/ieng6/cs15lwi23/cs15lwi23abc, where the abc is one of the other group members’ username
cp /home/linux/ieng6/cs15lwi23/public/hello.txt ~/
cat /home/linux/ieng6/cs15lwi23/public/hello.txt`
  
  common errors we might occur
  no such file or directory if the path doesn't exist
  Permission denied if trying to access someone else's files

## Logout of Bash terminal
  
 use:

'Ctrl-D
Run the command exit'
  
  now you know how to connect to a remote server by logging in with Bash terminal, run commands on vscode terminal, and logout of remote server
  
  ![alt text](https://user-images.githubusercontent.com/122493371/211988591-d262593b-128a-47f4-88ab-748a37c3b02d.PNG)
  ![alt text](https://user-images.githubusercontent.com/122493371/211988767-4f329561-791c-4e26-b8a3-aca956391a1e.PNG))
  ![alt text]([image.jpg](https://user-images.githubusercontent.com/122493371/211989620-e796739d-6973-41ae-9fcf-3d6f5cbf4ad3.PNG))
  
