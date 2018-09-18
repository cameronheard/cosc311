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

/* The basic structure for of this is from the Node class I made for
 ** COSC-211.
 */
class Node{
    private double data;
    private Node link;

    public Node(double num, Node n){
        data = num;
        link = n;
    }

    public Node getNext(){
        return this.link;
    }

    public double getData(){
        return this.data;
    }

    public void setNext(Node next) {
        this.link = next;
    }

    public String toString(){
        String string = "";
        string += this.data;
        return string;
    }
}