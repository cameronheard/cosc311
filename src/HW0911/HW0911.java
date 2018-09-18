/**
 * Author:      Cameron Heard
 * Course #:    COSC 311
 * Semester:    Fall 2018
 * Assignment:  hw0911
 *
 * HW0911
 * LinkedList
 * Node
 */
package HW0911;

public class HW0911 {

    public static void main(String[] args){

        double[] arr1 = {100.0};

        LinkedList ll1 = new LinkedList(arr1);

        System.out.println("Starting list:" + ll1.toString() + "\n");

        double avg1 = ll1.sumNodes()/arr1.length;
        System.out.println("Average: " + avg1 + "\n");

        ll1.deleteAbove(avg1);

        System.out.println("Ending list:" + ll1.toString() + "\n\n\n");


        double[] arr2 = {10.0, 100.0, 10.0};

        LinkedList ll2 = new LinkedList(arr2);

        System.out.println("Starting list:" + ll2.toString() + "\n");

        double avg2 = ll2.sumNodes()/arr2.length;
        System.out.println("Average: " + avg2 + "\n");

        ll2.deleteAbove(avg2);

        System.out.println("Ending list:" + ll2.toString() + "\n\n\n");


        double[] arr3 = {100.0,  10.0,  15.0,  20.0,  200.0,  30.0,  40.0,  300.0};

        LinkedList ll3 = new LinkedList(arr3);

        System.out.println("Starting list:" + ll3.toString() + "\n");

        double avg3 = ll3.sumNodes()/arr3.length;
        System.out.println("Average: " + avg3 + "\n");

        ll3.deleteAbove(avg3);

        System.out.println("Ending list:" + ll3.toString() + "\n");
    }
}
