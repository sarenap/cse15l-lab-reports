**# Lab Report 2: Servers & Bugs**

Write a web server called StringServer that supports the path and behavior described below. 
It should keep track of a single string that gets added to by incoming requests.
Request to type: /add-message?s=<string>

# Part 1
  
![image](https://user-images.githubusercontent.com/122493371/215353277-56937293-4e8a-4bc8-9a58-27a310e798c7.png)
1. **Which methods in your code are called?:** 3 methods,
2. public String handleRequest(URI url), 
3. public static void main(String[] args) throws IOException,  
4. Server.start(port, new Handler()) were called.
5. **What are the relevant arguments to those methods, and the values of any relevant fields of the class?**
6. **How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.**
7. *public String handleRequest(URI url)* argument is URI url (the request being entered by user). *URI url was /add-message?s=Hello*
8. fields: we made a string str reference that we keep adding to as requests are entered. each added string will be printed on a new line. *Hello* was added to str.
9. *public static void main(String[] args) throws IOException* argument is String[] args.
10. fields: args.length==0 if user did not enter anything. If so, user is prompted to enter port number. *my port number was 4101, started as a string and got parsed to an int*. this doesnt change as long as we are stay on the server.
11. String[] args is the string port number that user enters. throws an exception if they didn't enter a number string (parse int won't work later)
12. int port = Integer.parseInt(args[0]) parses the port number (entered as string argument), into an int
13. *Server.start(port, new Handler())* takes in 2 arguments, int port and Handler() method call from the URLHandler interface  
 


![image](https://user-images.githubusercontent.com/122493371/215353330-719bb1e4-70e2-43b0-aafa-2c1e3608a3af.png)

1. **Which methods in your code are called?:** 3 methods,
2. public String handleRequest(URI url), 
3. public static void main(String[] args) throws IOException,  
4  Server.start(port, new Handler()) were called.
5. **What are the relevant arguments to those methods, and the values of any relevant fields of the class?**
6. **How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.**
7. *public String handleRequest(URI url)* argument is URI url (the request being entered by user). *URI url was /add-message?s=How are you*
8. fields: we made a string str reference that we keep adding to as requests are entered. each added string will be printed on a new line. *How are you* was added to str.
9. *public static void main(String[] args) throws IOException* argument is String[] args.
10. fields: args.length==0 if user did not enter anything. If so, user is prompted to enter port number. *my port number was 4101, started as a string and got parsed to an int*. this doesnt change as long as we are stay on the server.
11. String[] args is the string port number that user enters. throws an exception if they didn't enter a number string (parse int won't work later)
12. int port = Integer.parseInt(args[0]) parses the port number (entered as string argument), into an int
13. *Server.start(port, new Handler())* takes in 2 arguments, int port and Handler() method call from the URLHandler interface  
  
  
## Code For String Server

` import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
class Handler implements URLHandler {

//keep track of a single string that gets added to by incoming requests.
String str = ""; 
public String handleRequest(URI url) {
    if (url.getPath().equals("/")) {
        return "String server: %d";
    } else {

        System.out.println("Path: " + url.getPath());
        if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) { //add word to list
                str += parameters[1]+"\n";
                return str;
            }
        }
       }
        return "404 Not Found!";
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);
        Server.start(port, new Handler());
    }
} `

# Part 2
 
*Choose one of the bugs from lab 3.*: 

Provide:
 
**The symptom, as the output of running the tests (provide it as a screenshot of running JUnit with at least the two inputs above)**
![image](https://user-images.githubusercontent.com/122493371/215666422-21916a2e-d172-4573-8d73-cd4b0dc02615.png)
  **list was reversed instead of staying in original order**

  # A failure-inducing input for the buggy program, as a JUnit test and any associated code (write it as a code block in Markdown)
  `@Test
     public void testFilter(){
        //test if same order
        ArrayList<String> s = new ArrayList<String>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("d");
        s.add("e");

        List<String> t = ListExamples.filter(s, new StringChecker() {
            public boolean checkString(String s) {
                return true; 
            }
        }); 
        assertEquals(s,t);
     }`
  
  
  # An input that doesn’t induce a failure, as a JUnit test and any associated code (write it as a code block in Markdown)
  list only has letter a so we can't tell if the letters were added wrong or right
  `@Test
     public void testFilter2(){
        //test if same order
        ArrayList<String> s = new ArrayList<String>();
        s.add("a");
        s.add("a");
        s.add("a");
        s.add("a");
        s.add("a");

        List<String> t = ListExamples.filter(s, new StringChecker() {
            public boolean checkString(String s) {
                return true; 
            }
        }); 
        assertEquals(s,t);
     }` 
  
# The bug, as the before-and-after code change required to fix it (as two code blocks in Markdown)
Briefly describe why the fix addresses the issue.
*Before code*
  ` static List<String> filter(List<String> list, StringChecker sc) {
    List<String> result = new ArrayList<>();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(0,s); //BUG that adds to beginning of list instead of end. this reverses the list
      }
    }
    return result;
  }`
  
*Fixed the bug*
`static List<String> filter(List<String> list, StringChecker sc) {
    List<String> result = new ArrayList<>();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(s); //add to end of list to keep same order
      }
    }
    return result;
  }`

# Part 3

In a couple of sentences, describe something you learned from lab in week 2 or 3 that you didn’t know before.
  In lab 2,  I have a better idea of how servers store information, like incrementing or decrementing a number, or adding to a string. That can be applied to other concepts like online gaming servers that multiple computers can access and change data. 
In lab 3, I learned that writing tests is an important skill to debug code since it can be hard to see the mistake without testing different inputs.
  I learned how to debug more efficiently. 
