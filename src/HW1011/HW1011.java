/*
 * Author:      Cameron Heard
 * Course #:    COSC 311
 * Semester:    Fall 2018
 * Assignment:  hw1011
 * Source Code: https://github.com/cameronheard/cosc311/tree/master/src/HW1011
 *
 * HW1011
 * CircularQueue
 */
package HW1011;

import java.util.Random;

public class HW1011 {

    public static void main(String[] args){

        Random rand = new Random(3);

        int i = 0;

        while(i < 3){
            CircularQueue cq = new CircularQueue(10);

            int x = (rand.nextInt(5) + 1);

            while(x > 0){
                cq.insert(rand.nextInt(100));
                x--;
            }


            int y = (rand.nextInt(5) + 1);

            while(y > 0){
                cq.delete();
                y--;
            }

            System.out.println(cq.toString());

            i++;
        }
    }
}
