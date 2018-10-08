/*
 * Author:      Cameron Heard
 * Course #:    COSC 311
 * Semester:    Fall 2018
 * Assignment:  hw0927
 * Source Code: https://github.com/cameronheard/cosc311/blob/master/src/HW0927/HW0927.java
 */
package HW0927;

import java.util.Random;

public class HW0927 {

    private static int sizeOfQueue = 0;
    private static final int ITERATIONS = 20,
                             OPS = 10_000_000,
                             INCREMENT  = 10_000_000;

    private static int[] randOps(int length){
        int[] arr = new int[length];
        Random rand = new Random();

        for(int i = 0; i < length; i++){
            arr[i] = rand.nextInt(2);
        }

        return arr;
    }

    public static void main(String[] args){

        System.out.println("Inserting and Deleting from Circular Queue.");
        System.out.println("===========================================");
        System.out.printf("%-21s|%21s\n", "Size of Queue", "Elapsed Time (ns)");
        System.out.println("-------------------------------------------");

        for(int i = 0; i < ITERATIONS; i++){
            sizeOfQueue += INCREMENT;
            int[] ops = randOps(OPS);
            CircularQueue cq = new CircularQueue(sizeOfQueue);

            long startTime = System.nanoTime();

            for(int x = 0; x < OPS; x++){
                if(ops[x] == 0)
                    cq.delete();
                else
                    cq.insert(1);
            }

            long stopTime = System.nanoTime();

            long elTime = stopTime - startTime;

            System.out.printf("%20s |%21s\n", sizeOfQueue, elTime);
        }
    }



}
