import java.util.Scanner;

public class randoms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int random = (int)Math.random()*100; // create a random number and multiply it by 100 to make an int
        int choice = Integer.parseInt(scan.next());
        System.out.println(choice);
    }
}
