/**
 * Way to represent courses using a linkedlist
 * @author Eddie Xu
 */

public class CourseLinkedList implements CourseList{
  DSLinkedList<Course> list = new DSLinkedList<Course>();
  
// method to return the current size of the list (array) O(n) time
  public int size() {
    int counter = 0;
    LLNode trav = list.getFirst();
    // Traversing through the array until there are no more courses
    while (trav != null) {
      // Incrementing the counter (size of list) everytime there is a course at the index
      counter++;
      // Move to the next element
      trav = trav.getNext();
    }
    return counter;
  }
  
  // Method to add a course to your list O(n)
  public void addCourse(int i, Course course) {
    // If you are trying to add a course at an index greater than the number of courses in the list,
    // simply add to the back of the list
    if (i > size()) {
      list.add(course);
    }
    // If you are trying to insert a course at the beginning of the list,
    //simply add the course to the front of the list
    else if (i == 0) {
      list.addToFront(course);
    }
    // Otherwise, create a new course node that points to the i-th indexed Course-node
    // and set the previous node to the new one you created (As a way to "insert" the new node)
    else {
      LLNode<Course> pointer = new LLNode<Course>(course, list.get(i));
      list.get(i-1).setNext(pointer);
    }
  }
  
  // Method to change the capcity of a course in your linkedlist if the ID is the same O(n^2)
  public boolean changeCapacity(String ID, int cap) {
    for (int i = 0; i < size() - 1; i++) {
      // If the name of the course in the list equals the ID in your parameter 
      if (list.get(i).getElement().courseName().equals(ID)) {
        // Change the capacity of the course to the capacity in the parameter
        list.get(i).getElement().setCapacity(cap);
        return true;
      }
    }
    return false;
  }
  
  // Method to remove the i-th index of the list (set the node at the i-1 index to the node at the i+1 index) O(n)
  public boolean removeCourse(int i) {
    // If the index is smaller than the number of courses in the list 
    // (allowing you to remove an actual course and not null)
    if (i < size()) {
      // Point the node before the i-th index to the node after the ith index
      list.get(i-1).setNext(list.get(i+1));
      return true;
    }
    // If you want to remove the first element, set the head node to the second element of the list
    else if (i == 0) {
      list.setFirst(list.get(i+1));
      return true;
    }
    return false;
  }
  
  // Find the Course at the ith index of the course (Using helper method in DSLinkedList Class)  O(n)
  public Course search(int i) {
    return list.get(i).getElement();
  }
}
