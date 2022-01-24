public class Main {
// method to calculate when father will be double the son's age
    private static void calculateAge (int fathersAge, int sonsAge){
        int i = sonsAge;
        int j = fathersAge;
        for (i = sonsAge, j = fathersAge; i < fathersAge; i++, j++) {
            if (i * 2 == j) {
                System.out.println("The son's age will be: " + i + " when his father is double his age.");
            }
        }
    }
    public static void main(String[] args) {
        calculateAge(50, 5);
    }
}
