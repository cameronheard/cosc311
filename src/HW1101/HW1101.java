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

import java.util.Random;

public class HW1101 {

    private static final double PoissonMean = 0.25;
    private static int time = 1, completed = 0;

    public static void main(String[] args){

        boolean serverVerbose = true, tickVerbose = true;

        CustomerQueue q1 = new CustomerQueue(1);
        CustomerQueue q2 = new CustomerQueue(2);

        Customer cust, q2cc;

        int q1Arrivals, q2Arrivals, st;

        while(completed < 5) {
            //serve customers
            q1.doService(time, serverVerbose);
            q2.doService(time, serverVerbose);

            //if current customer switched queues and is done
            q2cc = q2.currentCustomer();
            if(q2cc != null && q2cc.switchedQueues() && q2cc.getRemainingServiceTime() <= 1){
                completed++;
            }

            //do arrivals for Queue 2
            q2Arrivals = getPoissonRandom(PoissonMean);
            for (int c = 0; c < q2Arrivals; c++) {
                st = new Random().nextInt(5) + 1;
                cust = new Customer(st, q2.getWaitForNewCustomers(), q2.getQId());
                q2.addCustomer(cust);
            }

            //do arrivals for Queue 1, randomly moving them to Queue 2
            q1Arrivals = getPoissonRandom(PoissonMean);
            for (int c = 0; c < q1Arrivals; c++) {
                st = new Random().nextInt(5) + 1;
                cust = new Customer(st, q1.getWaitForNewCustomers(), q1.getQId());
                if(new Random().nextBoolean())
                    q2.addCustomer(cust);
                else
                    q1.addCustomer(cust);

            }

            if(tickVerbose){
                System.out.printf("***************** Tick: %3d *****************\n", time);
                q1.printStatus();
                q2.printStatus();
            }

            q1.bumpTime();
            q2.bumpTime();
            time ++;
        }
    }

    private static int getPoissonRandom(double mean) {
        Random r = new Random();
        double L = Math.exp(-mean), p = 1.0;
        int k = 0;

        do{
            p = p * r.nextDouble();
            k++;
        }
        while (p > L);

        return k - 1;
    }
}
