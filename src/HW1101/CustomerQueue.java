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

class CustomerQueue {

    private Customer head;
    private int qId, waitForNewCustomers;

    CustomerQueue(int qId){
        head = null;
        this.qId = qId;
        waitForNewCustomers = 0;
    }

    Customer currentCustomer(){
        return head;
    }

    int getQId(){
        return this.qId;
    }

    private void increaseWait(int w){
        waitForNewCustomers += w;
    }

    int getWaitForNewCustomers(){
        return waitForNewCustomers;
    }

    //serve a customer for 1 service tick
    void doService(int time, boolean verbose){
        if(head != null){
            if(head.getRemainingServiceTime() > 0){
                if(verbose && head.starting()){
                    System.out.printf("Tick: %3d - server %d start service on customer %d\n",
                            time, qId, head.getId());
                }
                head.reduceServiceTime();
            }
            else{
                if(verbose){
                    System.out.printf("Tick: %3d - server %d end service on customer %d\n",
                            time, qId, head.getId());
                }
                head = head.getNext();
            }
        }
        if(waitForNewCustomers > 0){
            waitForNewCustomers--;
        }
    }

    //add a new customer to the queue, increasing wait time for new customers
    void addCustomer(Customer c){
        if(head == null)
            head = c;
        else{
            Customer tmp = head;
            while(tmp.getNext() != null)
                tmp = tmp.getNext();
            tmp.setNext(c);
        }
        c.setQueue(qId);
        increaseWait(c.getRemainingServiceTime() + 1);
    }

    //determine if the server is busy
    private Boolean serverBusy(){
        return head != null;
    }

    //get number of customers in queue
    private int customerCount(){
        int c = 0;
        Customer tmp = head;
        if(tmp != null){
            c++;
            while(tmp.getNext() != null){
                tmp = tmp.getNext();
                c++;
            }
        }
        return c;
    }

    //increment time for all customers
    void bumpTime(){
        Customer tmp = head;
        if(tmp != null){
            while(tmp.getNext() != null){
                tmp = tmp.getNext();
                tmp.increaseTimeWaited();
            }
        }
    }

    //print out current queue status
    void printStatus(){
        String label = "Queue " + qId + ": ";

        System.out.println(label + "server busy - " + serverBusy().toString());
        System.out.println(label + "number in queue - " + customerCount());

        Customer tmp = head;

        if(tmp != null){
            System.out.println(label + "customers in queue:");
            System.out.println(tmp.toString());

            while(tmp.getNext() != null){
                tmp = tmp.getNext();

                System.out.println(tmp.toString());
            }
        }
        System.out.println();
    }
}
