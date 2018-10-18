/*
 * Author:      Cameron Heard
 * Course #:    COSC 311
 * Semester:    Fall 2018
 * Assignment:  hw1011
 *
 * HW1011
 * CircularQueue
 */
package HW1011;

import java.util.Arrays;

public class CircularQueue {

    private int[] q;
    private int head, tail, size;
    private static final int arrSize = 10;

    public CircularQueue(){
        head = tail = 0;
    }

    CircularQueue(int s){
        head = tail = 0;
        size = s;
        q = new int[arrSize];
    }

    private boolean isFull(){
        return head == (tail + 1) % size;
    }

    private boolean isEmpty(){
        return head == tail;
    }

    void insert(int x){
        if(!this.isFull()){
            q[tail] = x;
            tail = (tail + 1) % size;
        }
    }

    void delete(){
        if(!this.isEmpty()){
            q[head] = 0;
            head = (head + 1) % size;
        }
    }

    public String toString(){
        if(this.isEmpty())
            return "Empty queue";
        else
            return Arrays.toString(q);
    }
}
