/*
 * Author:      Cameron Heard
 * Course #:    COSC 311
 * Semester:    Fall 2018
 * Assignment:  hw0927
 * Source Code:
 *
 * HW0927
 * CircularQueue
 */
package HW0927;

public class CircularQueue {

    private int[] q;
    private int head, tail, size;
    private static int arrSize = 300_000_000;

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
            tail = (tail + 1) % size;
            q[tail] = x;
        }
    }

    int delete(){
        if(!this.isEmpty()){
            head = (head + 1) % size;
            return q[head];
        }
        else{
            return -1;
        }
    }
}
