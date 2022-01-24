public class Main {
    static double pyth(double a, double b){
        return squareRoot(a*a + b*b);
    }
    static double squareRoot(double num){


    }

    public static void main(String[] args) {
        double a = 3;
        double b = 4;
        double c = pyth(a,b);
        System.out.println("Hypoteneuse: " + c);
    }
}
