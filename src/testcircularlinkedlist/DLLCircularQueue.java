/**
 * CSC-223 Queue Tester    </br>
 * DUE DATE:               </br>
 * DATE SUBMITTED:         </br>
 * PROGRAMMED BY: A. Wright
 
 *
 */
 
package testcircularlinkedlist;
//import java.util.Exc

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author A. Wright
 * CLASS DESCRIPTION:
 */
public class DLLCircularQueue<Type> implements QueueADT<Type> {
   private int count;
   private DLLNode<Type> head, tail;
   
   /**
    * C O N S T R U C T O R
    */
   public DLLCircularQueue() {
      count = 0;
      head = tail = null;
   }
   
    /**
     * Mutator: enqueue() Add an element to the end of the queue (tail)
     *
     */
    public void enqueue(Type elem) {
        DLLNode<Type> node = new DLLNode<Type>(elem);
        if(this.isEmpty()){
            node.setPrevious(node);
            node.setNext(node);
            head = node;
            tail = node;
        }else{
            // always insert to the rear of the queue
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
            tail.setNext(head);
            head.setPrevious(tail);
        }
        count++;
    }
   /**
    * Mutator: dequeue() Removes the first item from the head of the queue
    */
   public Type dequeue() throws RuntimeException {
      if (isEmpty()) {
         throw new RuntimeException("Empty queue -- cannot dequeue");
      }
      Type result = head.getElement();
      head = head.getNext();
      count--;

      if (count == 0) // empty queue
      {
         tail = null;
      }

      return result;
   }

   /**
    * Accessor first() -- returns a copy of the item at the front of the queue;
    * no remove
    *
    * @return copy of the element
    */
   public Type first() throws RuntimeException {
      if (isEmpty()) {
         throw new RuntimeException("Empty queue -- no front element");
      }

      Type result = head.getElement();
      return result;
   }

   /**
    * Accessor: isEmpty() indicates whether or not the queue has no elements
    */
   public boolean isEmpty() {
      if (head == null) {
         return true;
      } else {
         return false;
      }
   }

   /**
    * Accessor size() reports the number of elements in the queue
    *
    * @return count of items in the queue
    */
   public int size() {
      return count;
   }

    /**
     * Accessor: toString() displays the contents of the queue: </br>
     * one element after the other from front to rear
     */
    public String toString() {
        String out = "";
        DLLNode<Type> current = new DLLNode<Type>();
        DLLNode<Type> headNode = new DLLNode<Type>();
        headNode = head;
        
        if (size() == 0) {
            out += "Empty queue\n";
            return out;
        }
        
        current = createCircle();
        
        if(headNode.getNext() == headNode){
            // display the first elemetn
            out += headNode.getElement() + " <-> " + current.getElement() + "\n";
            return out;
        }
        out += headNode.getElement() + " <-> ";
        current = headNode.getNext(); // move to the second element
        while(current.getNext() != headNode){
            out += current.getElement() + " <-> ";
            current = current.getNext();
        }
        // print the last element
        out += current.getElement() + " <-> ";
        current = current.getNext();
        // print the head element at the last position to make a circle
        out += current.getElement() + "\n";
        return out;
    }
   
    /**
     * 
     * @return the head element
     * Pre-conditions: none
     * postconditions: just assign the head's previous pointer to the
     * tail's next pointer and assign the tail's next pointer to the 
     * head's previous pointer
     */
    private DLLNode<Type> createCircle(){
        head.setPrevious(tail);
        tail.setNext(head);
        return head;

    }
    
    /**
     * Accessor: traverse(Type element)
     * @param element the element needs to find in the queue
     * @return the position of element is exist in the queue if the
     * element exisit in the queue, if not, return -1 for the element does
     * not exist in the queue. If queue is empty, return 0
     * Pre-conditions: none
     * postconditions: travers all the elements in the queue to seach value
     * return the position of element is exist in the queue if the
     * element exisit in the queue, if not, return -1 for the element does
     * not exist in the queue. If queue is empty, return 0
     */
    private ArrayList<Integer> traverse(Type element){
        int target = 0;
        ArrayList<Integer> listElement = new ArrayList<Integer>();
        DLLNode<Type> elementSearch = new DLLNode<Type>(element);
        DLLNode<Type> current = new DLLNode<Type>();
        if(this.isEmpty() == true){
            return null;
        }
        
        current = head;
        
        if(this.isEmpty() == false){
            target = 1;
            while(current != tail){
                if(current.getElement() == elementSearch.getElement()){
                    listElement.add(target);
                }
                current = current.getNext();
                target++;
            }
        }
        if(tail.getElement() == elementSearch.getElement()){
            listElement.add(target);
        }
        return listElement;
    }
    
    private int getFirstElement(Type element){
        int targetIndex = -1;
        DLLNode<Type> elementSearch = new DLLNode<Type>(element);
        DLLNode<Type> current = new DLLNode<Type>();
        if(this.isEmpty() == true){
            targetIndex = 0;
            return targetIndex;
        }
        
        current = head;
        
        if(this.isEmpty() == false){
            targetIndex = 1;
            while(current != tail){
                if(current.getElement() == elementSearch.getElement()){
                    return targetIndex;
                }else{
                    targetIndex++;
                    current = current.getNext();
                }
            }
        }
        if(tail.getElement() == elementSearch.getElement()){
            targetIndex = size();
        }else{
            targetIndex = -1;
        }
        return targetIndex;
    }
    
    /**
     * Mutator: remove(Type element)
     * @param element the element needs to find in the queue and delete 
     * Pre-conditions: traverse(Type element) method must be defined to find
     * the element is exist in the queue
     * postconditions: If the queue is empty, notify the empty queue
     * If the element is not exisit, notify the element does
     * not exist in the queue
     * If the queue is existed
     * The element is removed is the head element and size() != 1 => move 
     * the head element to next element and remove head
     * The element is removed is the head element and size() == 1 => just
     * assigned head and tail is null
     * The element is removed is the tail element and size() != 1 => move 
     * assigned the element is the tail element and next of this element is 
     * the head element, then remove the tail element
     * The element is removed is any position in the queue. Using the
     * traverse method to find the position in the element. Assign the 
     * element to be remove to the head element, use for loop the traver
     * to the position need to be removed and removed it.
     */
    private void remove(Type element){
        DLLNode<Type> elementDelete = new DLLNode<Type>(element);
        DLLNode<Type> currentElement = new DLLNode<Type>();
        int index = getFirstElement(elementDelete.getElement());
        ArrayList<Integer> listPosition = this.traverse(element);
        for(Integer e : listPosition){
            System.out.println("vitri: " + e);
        }
        System.out.println("vi tri index: " + index);
        if(index == 0){
            System.out.println("There are no element in Circle Queue");
            return;
        }else if(index == -1){
            System.out.println("Element " + elementDelete.getElement() + " is not exist "
                    + "in Circle Queue");
            return;
        }else{
            if(index == 1 && size() == 1){
                head = null;
                tail = null;
            }else if(index == 1){
                System.out.println("size: " + listPosition.size());
                System.out.println("vi tri: " + index);
                for(int i = 0; i < listPosition.size(); i++){
                    while(currentElement == head){
                        head = head.getNext();
                        head.setPrevious(tail);
                        tail.setNext(head);
                    }
                    currentElement = head;
                    while(currentElement.getElement() != elementDelete.getElement()){
                        currentElement = currentElement.getNext();
                    }
                    DLLNode<Type> ele_prev = currentElement.getPrevious();
                    DLLNode<Type> ele_next = currentElement.getNext();
                    ele_next.setPrevious(ele_prev);
                    ele_prev.setNext(ele_next);
                    count--;
                }
            }else{
                System.out.println("size: " + listPosition.size());
                System.out.println("vi tri: " + index);
                for(int i = 0; i < listPosition.size(); i++){
                    currentElement = head;
                    while(currentElement.getElement() != elementDelete.getElement()){
                        currentElement = currentElement.getNext();
                    }
                    DLLNode<Type> ele_prev = currentElement.getPrevious();
                    DLLNode<Type> ele_next = currentElement.getNext();
                    ele_next.setPrevious(ele_prev);
                    ele_prev.setNext(ele_next);
                    count--;
                }
            }
        }
    }
    
    /**
     * mutator menuInterface() 
     * Provide the user/client with options menu to select from 
     * preconditions: inputManager(option) method must be defined 
     * postconditions: displays menu options,
     * exits on command
     */
    public void menuInterface() {
        int option = 0;
        Scanner cin = new Scanner(System.in);
        
        boolean isValidData = false;

        while (isValidData == false) {
            try {
                do {
                    System.out.println(" CIRCULAR QUEUE. Menu Options"
                            + "\n\t0.  EXIT SYSTEM "
                            + "\n\t1.  Enqueue. "
                            + "\n\t2.  Deque. "
                            + "\n\t3.  Display Queue. "
                            + "\n\t4.  Traverse.  "
                            + "\n\t5.  Remove elements. "
                            + "\n\t6.  Load Data Available.  ");
                    System.out.print("\t\t Select 0 - 6 --> ");

                    option = Integer.parseInt(cin.nextLine());
                    
                    /**
                     * we need to be sure the input is between 0 .. 8
                     */
                    inputManager(option);
                } while (option != 0);
                isValidData = true;
            } catch (NumberFormatException e) {
                System.err.println("Input is not a valid integer "
                        + "data type.");
                System.err.println("The exception message is:"
                        + " " + e.getMessage());
            }
        }
    }

    /**
     * Mutator Method: inputManager(int input)
     * @param input select from the menu to implement the case
     * Pre-condition: none
     * Post-condition: Programmers will select the function of application 
     * from Menu and implement each case that Programmers selected
     */
    private void inputManager(int input) {
        Scanner cin = new Scanner(System.in);
        boolean isValidData = false;
        switch (input) {
            case 0:
                break;
            case 1:
                Integer elememt = 0;
                while (isValidData == false) {
                    try {
                        System.out.print("Enter the element to enqueue: ");
                        elememt = Integer.parseInt(cin.nextLine());
                        isValidData = true;
                    } catch (NumberFormatException e) {
                        System.err.println("Input is not a valid integer "
                                + "data type.");
                        System.err.println("The exception message is:"
                                + " " + e.getMessage());
                    }
                }
                this.enqueue((Type) elememt);
                isValidData = false;
                break;
            case 2:
                System.out.println("Element " + this.dequeue() + " has been dequeued.");
                break;
            case 3:
                System.out.println("Number of element in the queue: " + size());
                System.out.println(this);
                break;
            case 4:
                Integer elememtSearch = 0;
                while (isValidData == false) {
                    try {
                        System.out.print("Enter the element to search: ");
                        elememtSearch = Integer.parseInt(cin.nextLine());
                        isValidData = true;
                    } catch (NumberFormatException e) {
                        System.err.println("Input is not a valid integer "
                                + "data type.");
                        System.err.println("The exception message is:"
                                + " " + e.getMessage());
                    }
                }
                int position = this.getFirstElement((Type) elememtSearch);
                if(position == 0){
                    System.out.println("Empty Queue.");
                }else if(position == -1){
                    System.out.println("Element " + elememtSearch + " is not exist in the queue");
                }else{
                    ArrayList<Integer> getPositions = this.traverse((Type) elememtSearch);
                    for(Integer eachElement : getPositions){
                        System.out.println("Element " + elememtSearch + " at the position: " + eachElement + ".");
                    }
                }
                isValidData = false;
                break;
            case 5:
                Integer elememtRemove = 0;
                while (isValidData == false) {
                    try {
                        System.out.print("Enter the element to remove to queue: ");
                        elememtRemove = Integer.parseInt(cin.nextLine());
                        isValidData = true;
                    } catch (NumberFormatException e) {
                        System.err.println("Input is not a valid integer "
                                + "data type.");
                        System.err.println("The exception message is:"
                                + " " + e.getMessage());
                    }
                }
                this.remove((Type) elememtRemove);
                System.out.println("The element " + elememtRemove + " has been removed.");
                isValidData = false;
                break;
            case 6:{
                this.loadData();
                break;
            }
            default:
                System.out.println(" Invalid input, try again!");
                break;
        }
    }
    
    private void loadData(){
        this.enqueue((Type)new Integer(5));
        //queue.enqueue(5);
        this.enqueue((Type)new Integer(3));
        this.enqueue((Type)new Integer(3));
        this.enqueue((Type)new Integer(4));
        this.enqueue((Type)new Integer(1));
        this.enqueue((Type)new Integer(3));
        this.enqueue((Type)new Integer(8));
        this.enqueue((Type)new Integer(4));
        this.enqueue((Type)new Integer(2));
        this.enqueue((Type)new Integer(8));
        this.enqueue((Type)new Integer(3));
        this.enqueue((Type)new Integer(5));
        this.enqueue((Type)new Integer(2));
    }
}