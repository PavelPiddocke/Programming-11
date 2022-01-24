import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int changenum(int num){
        num += 10;
        changeAgain(num);
        return num;
    }
    public static void changeAgain(int num){
        num+=10;
    }
    public static void main(String[] args) {
        int num = 10;
        num = changenum(5);
        System.out.println(num);
        }

    }

