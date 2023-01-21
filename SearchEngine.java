import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
class Handler implements URLHandler {

ArrayList<String> words = new ArrayList<String>(); //search engine class later
int size = 0;


public String handleRequest(URI url) {
    if (url.getPath().equals("/")) {
        return "Search engine: %d";//?
    } else {

        System.out.println("Path: " + url.getPath());
        if (url.getPath().contains("/add")) {//3 functiosn
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) { //add word to list
                words.add(parameters[1]); size++;
                return "word "+parameters[1]+" added";
            }
            //still in the path add.ex: http://localhost:4013/add?/search=the
        else if( parameters[0].equals("/search")){ //search engine
            String foundwords="";
            for(String s: words){//serach whole word
                if(parameters[1].equals(s)){
                    foundwords+=s+"\n";
                }
            }
            //search substring. param1 is a substring
           
        //     for(String s: words){
        //         int paramLen = parameters[1].length();//len of substring
        //     for(int i=0; i<s.length()+paramLen;i++){ //loop thru substring of word
        //         if(parameters[1].equals(s.substring(i,i+paramLen))){
        //             foundwords+=s+"\n";
        //         }
        //     }
        // }
            return foundwords;
        }

        }

        return "404 Not Found!";
    }
}
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
