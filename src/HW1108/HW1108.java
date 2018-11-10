/*
 * Author:      Cameron Heard
 * Course #:    COSC 311
 * Semester:    Fall 2018
 * Assignment:  hw1108
 * Source Code: https://github.com/cameronheard/cosc311/tree/master/src/HW1108
 *
 * HW1108
 */
package HW1108;

import java.util.Random;

public class HW1108 {

    private static final int seed = 97;

    public static void main(String[] args){
        int min = 10, max = 50, size = 20;

        int[] inputArray = makeInput(min, max, size);

        int table[] = hashTable(8, inputArray);

        System.out.println("index\tdata value");

        for(int i = 0; i < table.length; i++){
            String tVal = table[i] == 0 ? "" : Integer.toString(table[i]);
            System.out.printf("%2d\t\t%s\n", i, tVal);
        }
    }

    private static int[] hashTable(int tableSize, int[] input){
        int[] table = new int[tableSize];
        int index, count = 0;

        for(int key : input){
            index = key % table.length;

            if(table[index] == 0)
                table[index] = key;
            else{
                int bump = 1;
                while (table[index + bump] != 0){
                    bump++;
                }
                table[index + bump] = key;
            }

            count++;
            if ((double) count / (double) tableSize >= .75){
                return hashTable(tableSize * 2, input);
            }
        }

        return table;
    }

    private static int[] makeInput(int poolMin, int poolMax, int arrLen){
        int poolSize = poolMax - poolMin + 1;
        Random rand = new Random(seed);

        int[] inputPool = new int[poolSize];
        int[] arr = new int[arrLen];

        for(int x = 0; x < inputPool.length; x++){
            inputPool[x] = x + poolMin;
        }

        int max = inputPool.length - 1;

        for(int x = 0; x < arr.length; x++){
            int i = rand.nextInt(max);
            arr[x] = inputPool[i];
            inputPool[i] = inputPool[max];
            max--;
        }

        return arr;
    }
}