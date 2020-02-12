/**
 * A class to represent a linked list of nodes.
 * @author Harold Connamacher in EECS 132 (Altered by Eddie Xu)
 */
public class DSLinkedList<T> {
  /** the first node of the list, or null if the list is empty */
  private LLNode<T> firstNode;
  /** the last node of the list, or null if the list is empty*/
  private LLNode<T> backNode;
  /** the next node of the list */
  private LLNode<T> next;
  
  /**
   * Creates an initially empty linked list
   */
  public DSLinkedList() {
    firstNode = null;
  }
  
  /**
   * Returns the first node.
   */
  protected LLNode<T> getFirst() {
    return firstNode;
  }

  /**
   * method to set the back node to some other node
   */
  protected void setBack(LLNode<T> node) {
    this.backNode = node;
  }
  /**
   * Returns the next node.
   */
  protected LLNode<T> getNext() {
    return next;
  }
  /**
   * Changes the first node.
   * @param node  the first node of the new linked list
   */
  protected void setFirst(LLNode<T> node) {
    this.firstNode = node;
  }
  
  /**
   * Add an element to the front of the linked list
   * @param element  the element to add
   */
  public void addToFront(T element) {
    setFirst(new LLNode<T>(element, getFirst()));
  }
  
  
  /**
   * Return whether the list is empty
   * @return true if the list is empty
   */
  public boolean isEmpty() {
    return (getFirst() == null);
  }
  
  /**
   * Return the ith node in your list
   */
  
  public LLNode<T> get(int i) {
    // Looping through the nodes within the list until the ith index
    LLNode<T> f = getFirst();
    for (int j = 0; j < i; j++) {
      f = f.getNext();
    }
    // return the node at the ith index
    return f;
  }
  
  /**
   * Add an element to the very end of the list
   * @param element the element to add to the end of the list
   */
  public void add(T element) {
    if (isEmpty()) 
      addToFront(element);
    else {
      LLNode<T> nodeptr = getFirst();
      // the loop will end with nodeptr looking at the last node in list
      while (nodeptr.getNext() != null)
        nodeptr = nodeptr.getNext();
      // Set the last node to a node with the element, and point that node to null
      nodeptr.setNext(new LLNode<T>(element, null));
    }
  }
  
  // Method to check if list contains element of type String
  public boolean contains(String element) {
    LLNode<T> trav = getFirst();
    // Traversing through the list
    while (trav != null) {
      // If the name of the element at the node of my index equals the element of the parameter, return true
      if (trav.getElement().equals(element)) {
        return true;
      }
      // Increment my pointer for traversing
      trav = trav.getNext();
    }
    return false;
  }
  
  // Method to get the indexOf a value
  public int indexOf(String element) {
    LLNode<T> pointer = firstNode;
    int counter = 0;
    // Traversing through the list
    while (pointer != null) {
      counter++;
      // If there is a match between the parameter element and the element at the index
      if (pointer.getElement().equals(element)) {
        // return the index of that node (starting from 0)
        return counter - 1;
      }
      // Increment my pointer
      pointer = pointer.getNext();
    }
    // If the list does not contain the element
    return -1;
  }
}
