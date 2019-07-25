
/**
 * CSC-223 Weeks #4/5 Lab #2
 * DUE DATE:
 * DATE SUBMITTED:
 * PROGRAMMED BY: 
 * DESCRIPTION: Create and test circular double linked list
 *
 */
 

package testcircularlinkedlist;

import java.util.Scanner;

/**
 *
 * @author Anita
 */
public class TestCircularLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DLLCircularQueue<Integer> queue = new DLLCircularQueue<Integer>();
        queue.enqueue(5);
        //queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(8);
        queue.enqueue(4);
        queue.enqueue(2);
        queue.enqueue(8);
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(2);
        queue.menuInterface();
    }

}
