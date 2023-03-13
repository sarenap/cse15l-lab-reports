# Lab Report 5
## Reflecting on lab report 6

-For this lab I had to make many improvements to the grading script to make it run properly, spent extra time doing research on the commands and syntax of bash.
-Here is the grade.sh script
```
CPATH='.;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar'

rm -rf student-submission
git clone $1 student-submission
echo 'Finished cloning'
cd student-submission 
cp ../TestListExamples.java ./ #../ and ./ order matters
cp -r ../lib ./

JAVAPATH="ListExamples.java"
if [[ -f "$JAVAPATH" ]] #f is find
then
    echo "Found ListExamples.java"
else
    echo "Could not find ListExamples.java"
    exit 1
fi
cp $JAVAPATH ./
CRESULT="$(javac -cp $CPATH *.java 2>&1)" # output redirect?
if [[  $? != 0  ]] #is $? the output. only 0 meant javac succeeded 
then
    echo "Compilation failed: $CRESULT"   
    exit 1
else 
    echo "Compilation succeeded"
fi
TESTRESULTS=$(java -cp $CPATH org.junit.runner.JUnitCore TestListExamples)
if [[ $? == 0 ]]
then 
    echo "Full score!"
    exit 0
else 
    echo "Some issues"
fi

FAILURES=$(grep -oP "Failures:\s+\K\w+" <<< $TESTRESULTS)
TESTS=$(grep -oP "Tests run:\s+\K\w+" <<< $TESTRESULTS)
echo "Score: " $FAILURES/$TESTS
echo $TESTRESULTS
```

## Here is what the gradescope script does, each line explained

1. Declare a CPATH variable, set it to a path containing jar files.
2. Removes the student-submission directory if it exists, and clone a git repository from the first argument, into a NEW student-submission directory. so we can grade multiple students.
3. Copy the TestListExamples.java file from the current directory (../) to the student-submission directory (./)
4. Copy the lib directory (containing the hamcrest-core-1.3.jar and junit-4.13.2.jar jar files) from the current directory (../) to the student-submission directory (./)
5. Set JAVAPATH variable to "ListExamples.java".
6. Check if the ListExamples.java file exists in student-submission directory, and print a message saying if file was found or not. If the file is not found, the script exits with an error code of 1.
7. If found, Copy ListExamples.java file (stored in $JAVAPATH) from current directory to student-submission directory.
8. Run javac command to compile all .java files in the student-submission directory, using the classpath in the CPATH variable. OUTPUT OF THE JAVAC COMMAND is redirected to CRESULT variable. 
9. Check exit status of javac command. If it's not= 0 (failed compile), print error message containing output of the javac command, and exit with error code 1.
10. Else: If javac command succeeded, print a message indicating it succeeded.
11. Using classpath specified by CPATH, run the java command to execute TestListExamples class. OUTPUT OF THE COMMAND IS redirected to TESTRESULTS variable.
12. Check exit status of java command. If=0 (all tests passed), print a message indicating full score, and exit with a success code of 0.
13. If some tests failed, print a message indicating issues.
14. From java command's output, Extract the number of test failures from output of the JUnit test, store into $TESTRESULTS variable. 
15. Extract total number of tests run to TESTS variable. Calculate and print the score as failures divided by total tests.
16. Print the TESTRESULTS variable, which contains the output of the java command.

-Crucial lines that I had to look over carefully
-![image](https://user-images.githubusercontent.com/122493371/224589638-0949f279-3a4b-4dc8-9683-5a24c6c5e3f0.png)
![image](https://user-images.githubusercontent.com/122493371/224590059-ea008e59-abf3-4118-9326-79066edb9c45.png)

## Demonstrating the script works.
![image](https://user-images.githubusercontent.com/122493371/224590670-e32626ed-e87b-4217-b0ec-a441d3e0dc07.png)
![image](https://user-images.githubusercontent.com/122493371/224590694-95b28037-cd22-4af5-ba81-0228aa5263ab.png)
![image](https://user-images.githubusercontent.com/122493371/224590796-92ece93f-6731-49b3-a02d-6395598a0ec5.png)
![image](https://user-images.githubusercontent.com/122493371/224590882-9d0c60bb-2c58-4654-a182-c9aea680d38c.png)
![image](https://user-images.githubusercontent.com/122493371/224591002-8f383355-0a03-40d1-a1ca-f801b1b15e16.png)

An extra addition to this script would be assigning a letter grade depending on which tests pass or fail. 


