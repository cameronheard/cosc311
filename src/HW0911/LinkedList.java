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

/* The basic structure for of this is from the LinkedList class I made for
** COSC-211.
*/
class LinkedList {

    public Node head;

    public LinkedList(){
        head = null;
    }

    public LinkedList(double[] arr){
        head = null;
        for(double item : arr){
            addLast(item);
        }
    }

    public void addFirst(double num){
        head = new Node(num, head);
    }

    public void addLast(double num){
        if(head == null)
            addFirst(num);
        else{
            Node tmp = head;
            while(tmp.getNext() != null)
                tmp = tmp.getNext();
            tmp.setNext(new Node(num, null));
        }
    }

    public double sumNodes(){
        double total = 0.0;
        Node tmp = head;
        do{
            total = total + tmp.getData();
            if(tmp.getNext() == null)
                return total;
            else{
                tmp = tmp.getNext();
            }
        }
        while(true);
    }

    public String toString(){
        Node node = head;
        String string = "";
        do{
            string = string + " " + node.getData();
            if(node.getNext() == null)
                return string;
            else{
                node = node.getNext();
            }
        }
        while(true);
    }

    /* This is the delete method from your shared example, modified to allow for
    ** continued traversal even after a match. Also, calling methods defined in
    ** my Node class.
     */
    public void deleteAbove(double num) {

        if (head == null) {
            return;
        }

        if (head.getData() > num) {
            head = head.getNext();
        }

        Node p, q;
        for (p = head.getNext(), q = head; p != null; p = p.getNext(), q = q.getNext()) {
            if (p.getData() > num) {
                q.setNext(p.getNext());
                if(q.getNext() != null)
                    p = q.getNext();
            }
        }
    }
}