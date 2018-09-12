/**
 * Author:      Cameron Heard
 * Course #:    COSC 311
 * Semester:    Fall 2018
 * Assignment:  hw0906
 */
public class HW0906 {

    private static int[] repeat(int[] a, int factor){
        int[] newArray;

        if (factor <= 0) {
            newArray = new int[0];
        }
        else {
            int tl = a.length * factor;
            newArray = new int[tl];
            int newIndex = 0;

            for (int i = 0; i < factor; i++){
                for (int j = 0; j < a.length; j++){
                    newArray[newIndex] = a[j];
                    newIndex++;
                }
            }
        }

        return newArray;
    }

    private static void printArray(int[] array){
        for (int i = 0; i < array.length; i++)
            System.out.print(" " + array[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int factor;


        factor = 1;
        printArray( repeat(a, factor) );


        factor = 2;
        printArray( repeat(a, factor) );


        factor = -2;
        printArray( repeat(a, factor) );
    }
}
