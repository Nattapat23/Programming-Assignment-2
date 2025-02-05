import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.StringTokenizer;
import java.util.Arrays;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your pathname : ");
        String pathname = input.nextLine();
        File f = new File(pathname);
        Scanner inf = new Scanner(f);

        long timeStart = System.nanoTime();
        String Charcount = "", word ;
        int NumEmo , line = 0 ,countTOken = 0,sum = 0, longToken = 0 , numCharcount = 0, emoticon = 0 ;
        double average ;
        ArrayList<String> token = new ArrayList<>();
        ArrayList<Integer> chartoken = new ArrayList<>();
        String[] emoji = { ":)" , ":(" , ":D" , ":P" , ":O" , ":/" , ":|" , ";)" , ":'(" , "XD" , ":3" , ":')" , "^_^" , "-_-"};


        while (inf.hasNextLine()) {
            Charcount += inf.nextLine();
            numCharcount += Charcount.length();
            StringTokenizer tk = new StringTokenizer(Charcount, " ");
            while (tk.hasMoreTokens()) {
                word = tk.nextToken();
                token.add(word);
                chartoken.add(word.length());

                if (word.length() > longToken) {
                    longToken = word.length();
                }

               if (Arrays.asList(emoji).contains(word)) {
                emoticon++;
               }
                sum += word.length();
                
            }
            line++;
            Charcount="";
        }
        average = (double)sum/chartoken.size();

        long timeEnd = System.nanoTime();
        long totalTime = (timeEnd - timeStart) / 1000000;
        double second = totalTime / 1000.0;

        System.out.println("Total # Character count : " + numCharcount);
        System.out.println("Total # Palindrome found : "+Palindrome(token));
        System.out.println("Total Number of tokens : "+chartoken.size());
        System.out.println("Total Number of emoticon : "+emoticon);
        System.out.println("Total # of new line : "+line);
        System.out.println("The longest : "+longToken+" and average token size token : "+average);
        System.out.println("Total time to execute this program : "+second+" secs");
        


    }
     
    public static int Palindrome(ArrayList<String> token){
        int palin = 0 ;
        String tamp ="";
        String word ;
        for(int i = 0; i< token.size(); i++){
            word= token.get(i);
            for(int j = word.length();j > 0; j--){
                tamp += word.charAt(j-1);
            }
            if (tamp.equals(word)) {
                palin++;
            }
            tamp = "";
        }

        return palin;
    }
  
}