import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//Declare variable to use
        Scanner scan = new Scanner(System.in);
        String playerString = " ";
        String choice = "y";


//Request word from player. Loop request until no decryption.
        while (!choice.equals("n")) {
            System.out.println("Please enter any word");
            playerString = (scan.next());

// moving first letter to the end.
            String encryptedString = playerString.substring(1) + playerString.charAt(0);

// printing output and adding ay
            System.out.println("You have entered '" + playerString + "'. ");
            System.out.println("The encrypted string is: " + encryptedString + "ay");

//ask to decrypt
            System.out.println("Would you like to decrypt");
            choice = (scan.next());

// check for something other than y
            if(!choice.equals("n")) {
                System.out.println("The decrypted string is: " + playerString);
            }
        }

        }

    }

