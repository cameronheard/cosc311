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
import java.util.stream.IntStream;

public class HW1108 {

    public static void main(String[] args){
        int[] table = hashTable(8, makeInput());

        System.out.println("index\tdata value");

        for(int i = 0; i < table.length; i++){
            String tVal = table[i] == 0 ? "" : Integer.toString(table[i]);
            System.out.printf("%2d\t\t%s\n", i, tVal);
        }
    }

    private static int[] hashTable(int tableSize, int[] input){
        int[] table = new int[tableSize];
        int index;
        double count = 0;

        for(int key : input){
            index = key % table.length;

            while(table[index] !=0)
                index++;

            table[index] = key;

            if(++count/tableSize >= .75)
                return hashTable(tableSize * 2, input);
        }
        return table;
    }

    private static int[] makeInput(){
        int[] inputPool = IntStream.rangeClosed(10,50).toArray(), arr = new int[20];
        int index, max = inputPool.length - 1;
        Random rand = new Random(97);

        for(int x = 0; x < arr.length; x++){
            index = rand.nextInt(max);
            arr[x] = inputPool[index];
            inputPool[index] = inputPool[max];
            max--;
        }
        return arr;
    }
}