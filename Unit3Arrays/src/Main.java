import java.util.Arrays;

public class Main {



    static void increaseArray(int[] array) {

        System.out.println("Original Array: " + Arrays.toString(array));
        array = Arrays.copyOf(array, array.length + 1); //create new array from old array and allocate one less element
        array[array.length - 1] = 5;
        System.out.println("Array with addition: " + Arrays.toString(array));
    }

    static void decreaseArray(int[] array) {

        System.out.println("Original Array: " + Arrays.toString(array));
        array = Arrays.copyOf(array, array.length - 1); //create new array from old array and allocate one more element
        System.out.println("Array with deletion: " + Arrays.toString(array));
    }

    static void insertArray(int[] array) {

        System.out.println("Original Array: " + Arrays.toString(array));
        array = Arrays.copyOf(array, array.length + 1); //create new array from old array and allocate one more element
        array[array.length - 2] = 4;
        array[array.length - 1] = 5;
        System.out.println("Array with insertion: " + Arrays.toString(array));
    }
    public static void main(String[] args) {
        int[] newArray = {1, 2, 3, 4};
        int[] newArray2 = {2, 3, 5};
        increaseArray(newArray);
        decreaseArray(newArray);
        insertArray(newArray2);

    }


}