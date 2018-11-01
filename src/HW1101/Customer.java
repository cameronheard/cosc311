/*
 * Author:      Cameron Heard
 * Course #:    COSC 311
 * Semester:    Fall 2018
 * Assignment:  hw1101
 * Source Code: https://github.com/cameronheard/cosc311/tree/master/src/HW1101
 *
 * HW1101
 * CustomerQueue
 * Customer
 */
package HW1101;

public class Customer {
    private long id;
    private int startingServiceTime, remainingServiceTime, originalWaitTime;
    private int timeWaited, originalQueue, currentQueue;
    private Customer link;

    Customer(int st, int wt, int q){
        id = System.nanoTime();
        startingServiceTime = remainingServiceTime = st;
        originalWaitTime = wt;
        originalQueue = currentQueue = q;
        timeWaited = 0;
    }

    Customer getNext(){
        return this.link;
    }

    long getId(){
        return id;
    }

    int getRemainingServiceTime(){
        return remainingServiceTime;
    }

    void setQueue(int id){
        currentQueue = id;
    }

    void setNext(Customer next) {
        link = next;
    }

    //whether any service has been performed
    boolean starting(){
        return remainingServiceTime == startingServiceTime;
    }

    //whether the customer is in their original queue
    boolean switchedQueues(){
        return currentQueue != originalQueue;
    }

    void reduceServiceTime(){
        remainingServiceTime--;
    }

    void increaseTimeWaited(){
        timeWaited ++;
    }

    public String toString(){
        return "\t\t ********************************\n" +
                "\t\t * Customer ID: " + id + "\n" +
                "\t\t * Original Queue: " + originalQueue + "\n" +
                "\t\t * Current Queue: " + currentQueue + "\n" +
                "\t\t * Original Wait Time: " + originalWaitTime + "\n" +
                "\t\t * Current Time Waited: " + timeWaited;
    }
}
