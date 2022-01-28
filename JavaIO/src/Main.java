import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String query;
        Scanner scan = new Scanner(System.in);
        // a little prompt to make the application more interesting by requesting a word to look for
        System.out.println("Look for a word in ProgrammingHistory.txt: Please enter the word:");
        query = (scan.next());
        textHandler("ProgrammingHistory.txt", query);
    }

    private static ArrayList<String> textHandler(String file, String query) throws IOException {
        //Create ArrayList of Lines in Document
        String line;
        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(file)));
        //loop through lines looking for word
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        //create an ArrayList of words from each line by splitting the words in the line and adding them to the list.
            ArrayList<String> words = new ArrayList<String>();
            for (String word : line.split(" ")){
                words.add(word);
            }

            // run through lines to check if the query word appears.
            if (line.contains(query)) {
                int pos = lines.indexOf(line);
                System.out.println("Your word, " + query + ", appears at position " + words.indexOf(query) + " in line "  + pos + " of the document with the line: '" + line +"'");
            } else
                System.out.println("Your word does not appear in line: '" + line + "'");
                }


        //close the BufferedReader
        reader.close();
        return lines;
    }

}
