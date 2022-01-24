import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//declare variables
        String compChoice;
        String playerChoice;
        String compChoiceDisplayName;
        String playerChoiceDisplayName;
        int playerScore = 0;
        int compScore = 0;


//request choice from player
        Scanner scan = new Scanner(System.in);

        while (true) {
            int random = (int)(Math.random()*3);
            System.out.println("Choose rock paper or scissors. 'r' for rock, 'p' for paper, and 's' for scissors.");
            playerChoice = (scan.next());

//check the if answer is valid
            if (!playerChoice.equals("r") && !playerChoice.equals("p") && !playerChoice.equals("s")) {
                System.out.println("invalid selection. please play again. ");
            }

//generate computers choice
            if (random == 0) {
                compChoice = "r";
            } else if (random == 1) {
                compChoice = "p";
            } else {
                compChoice = "s";
            }

// evaluate the winner
            if (playerChoice.equals(compChoice)) {
                System.out.println("Draw!");
            } else if (playerChoice.equals("r") && compChoice.equals("s")) {
                playerScore++;
                System.out.println("You Win!");
            } else if (playerChoice.equals("r") && compChoice.equals("p")) {
                compScore++;
                System.out.println("You Lose!");
            } else if (playerChoice.equals("s") && compChoice.equals("r")) {
                compScore++;
                System.out.println("You Lose!");
            } else if (playerChoice.equals("s") && compChoice.equals("p")) {
                playerScore++;
                System.out.println("You Win!");
            } else if (playerChoice.equals("p") && compChoice.equals("r")) {
                playerScore++;
                System.out.println("You Win!");
            } else if (playerChoice.equals("p") && compChoice.equals("s")) {
                compScore++;
                System.out.println("You Lose!");
            }

//Give the output full names
            if (compChoice.equals("r")) {
                compChoiceDisplayName = "rock";
            } else if (compChoice.equals("p")) {
                compChoiceDisplayName = "paper";
            } else {
                compChoiceDisplayName = "scissors";
            }

            if (playerChoice.equals("r")) {
                playerChoiceDisplayName = "rock";
            } else if (playerChoice.equals("p")) {
                playerChoiceDisplayName = "paper";
            } else {
                playerChoiceDisplayName = "scissors";
            }
            System.out.print("Computer Choice: " + compChoiceDisplayName);
            System.out.println("  Player choice: " + playerChoiceDisplayName);


//Display the score
            System.out.println("********************************** \t" );
            System.out.print("  Wins: " + playerScore);
            System.out.println("  Losses: " + compScore);
            System.out.println(" \n Let's play again!");

        }
    }
}
