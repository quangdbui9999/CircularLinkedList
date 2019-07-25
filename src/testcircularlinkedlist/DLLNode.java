

/**
 * CSC-223 Linked List Stack Node class </br>
 * DUE DATE:                            </br>
 * DATE SUBMITTED:                      </br>
 * PROGRAMMED BY: A. Wright             </br>
 
 *
 */
package testcircularlinkedlist;

/**
 *
 * @author A. Wright
 * CLASS DESCRIPTION: A double linked node is a container for any class type
 * with two links (references) 1) to the next Node and 2) the previous Node
 */
public class DLLNode<T> {
   private T element;
   private DLLNode<T> next;
   private DLLNode<T> previous;
   
   /**
    * C O N S T R U C T O R
    * default set node and next to null
    */
   public DLLNode() {
      element = null;
      next = null;
      previous = null;
   }

   /**
    * C O N S T R U C T O R
    * conversion set node to input element and and next to null
    */
   public DLLNode(T inElem) {
      element = inElem;
      next = null;
      previous = null;
   }

   /**
    * Accessor: getElement()
    *
    * @return this LLNode
    */
    public T getElement() {
        return element;
    }

   /**
    * Accessor: getNext()
    *
    * @return reference to next DLLNode
    */

   public DLLNode<T> getNext() {
      return next;
   }
   
   /**
    * Accessor: getPrevious()
    *
    * @return reference to previous DLLNode
    */

   public DLLNode<T> getPrevious() {
      return previous;
   }

   /**
  * Mutator: setElement(T inputElement) allow user/client to change the value
    * of the Node
    *
    */
   public void setNode(T inElem) {
      element = inElem;
   }

   /**
    * Mutator: setNext( LLNode<T> ptr)
    *
    * @return reference to next DLLNode
    */

   public void setNext(DLLNode<T> nodePtr) {
      next = nodePtr;
   }
   
   /**
    * Mutator: setPrevious( LLNode<T> ptr)
    *
    * @return reference to previous DLLNode
    */

   public void setPrevious(DLLNode<T> nodePtr) {
      previous = nodePtr;
   }
}
