/*
 * Author:      Cameron Heard
 * Course #:    COSC 311
 * Semester:    Fall 2018
 * Assignment:  hw1129
 * Source Code: https://github.com/cameronheard/cosc311/tree/master/src/HW1129
 *
 * HW1129
 */
package HW1129;

public class HW1129 {

    public static void main(String[] args){

        int[][] pqArrays = new int[7][];
        pqArrays[0] = new int[] {1,2,3,4,5};
        pqArrays[1] = new int[] {1,1,0,1,1};
        pqArrays[2] = new int[] {1,5,1,2,5,6};
        pqArrays[3] = new int[] {1,2,2,3,2,2,17,4};
        pqArrays[4] = new int[] {1,2,2,0,2,2,17,4};
        pqArrays[5] = new int[1023];
        pqArrays[6] = new int[1023];

        int k = 0;
        for(int i = 0; i < 10; i++)
            for(int j = 0; j < (int)Math.pow(2, i); j++, k++)
                pqArrays[5][k] = pqArrays[6][k] = (int)Math.pow(2, i);
        pqArrays[6][500] = 1;

        outerloop: for(int x = 0; x < pqArrays.length; x++){
            for(int i = pqArrays[x].length -1; i >= 0; i--)
                if (pqArrays[x][i] < pqArrays[x][(i - 1) / 2] || pqArrays[x][(i - 1) / 2] == 0 || pqArrays[x][i] == 0){
                    System.out.println("PQ " + (x + 1) + ": invalid - fails at index " + (pqArrays[x][i] == 0 ? i : (i - 1) / 2));
                    continue outerloop;
                }
            System.out.println("PQ " + (x + 1) + ": valid");
        }
    }
}