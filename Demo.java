import java.util.LinkedList; 

public class Demo {
  
  /** 
   * Counts the number of courses starting with a given prefix 
   * @param list The list of courses 
   * @param prefix The given prefix 
   * @return the count of courses 
   */ 
  public static int prefixCountArrayList(CourseArrayList list, String prefix){  
    // variable to count the number of courses with the same prefix in the list
    int counter = 0;
    // Value that will be used in the for-loop and substring method
    int prefixLength = prefix.length();
    for (int i = 0; i < list.size(); i++) {
      // If there is a possible course in the index of the array
      if (list.search(i) != null) {
        // If the course at that index begins with the same prefix as in the parameter
        if (list.search(i).courseName().substring(0, prefixLength).equals(prefix)) {
          counter++;
        }
      }
    }
    return counter;
  }
  
  /** 
   * Counts the number of courses starting with a given prefix 
   * @param list The list of courses 
   * @param prefix The given prefix 
   * @return the count of courses 
   */ 
  public static int prefixCountLinkedList(CourseLinkedList list, String prefix){ 
    // variable to count the number of courses with the same prefix in the list
    int counter = 0;
    // Value that will be used in the for-loop and substring method
    int prefixLength = prefix.length();
    for (int i = 0; i < list.size(); i++) {
      // If there is a possible course in the index of the array
      if (list.search(i) != null) {
        // If the course at that index begins with the same prefix as in the parameter
        if (list.search(i).courseName().substring(0, prefixLength).equals(prefix)) {
          counter++;
        }
      }
    }
    return counter;
  }
  
  
  public static void main (String [] args) 
  { 
    CourseArrayList alist = new CourseArrayList();   
    Course course1 = new Course("MATH444", 30); 
    Course course2 = new Course("EECS123", 120); 
    Course course3 = new Course("EECS233", 140); 
    Course course4 = new Course("EBME399", 50); 
    
    
    // Add course objects to arraylist 
    alist.addCourse(0, course1); 
    alist.addCourse(0, course2); 
    alist.addCourse(5, course3); 
    alist.addCourse(3, course4); 
    
    System.out.println("----------------------------------------"); 
    //Testing ArrayList methods 
    System.out.println("Capacity of " + alist.search(1).courseName() + " is " + alist.search(1).length()); 
    
    System.out.println("\nCapacity of EECS233: " + alist.search(2).length()); 
    System.out.println("Change capacity method: " + alist.changeCapacity("EECS233", 100)); 
    System.out.println("Change capacity method: " + alist.changeCapacity("EECS133", 100)); 
    System.out.println("Capacity of EECS233: " + alist.search(2).length()); 
    
    System.out.println("\nNumber of courses: " + alist.size()); 
    System.out.println("Course removed:" + alist.removeCourse(1)); 
    System.out.println("Course removed:" + alist.removeCourse(5)); 
    System.out.println("Number of courses: " + alist.size()); 
    
    System.out.println("\nNumber of courses starting with EECS: " + prefixCountArrayList(alist, "EECS")); 
    System.out.println("----------------------------------------"); 
    
    //Change back the capacity of EECS233 to 140 
    alist.changeCapacity("EECS233", 140); 
    
    CourseLinkedList llist = new CourseLinkedList();  
    // Add course objects to Linkedlist 
    llist.addCourse(0, course1); 
    llist.addCourse(0, course2); 
    llist.addCourse(5, course3); 
    llist.addCourse(3, course4); 
    
    
    System.out.println("----------------------------------------"); 
    //Testing LinkedList methods   
    System.out.println("Capacity of " + llist.search(1).courseName() + " is " + llist.search(1).length()); 
    
    System.out.println("\nCapacity of EECS233: " + llist.search(2).length()); 
    System.out.println("Change capacity method: " + llist.changeCapacity("EECS233", 100)); 
    System.out.println("Change capacity method: " + llist.changeCapacity("EECS133", 100)); 
    System.out.println("Capacity of EECS233: " + llist.search(2).length()); 
    
    System.out.println("\nNumber of courses: " + llist.size()); 
    System.out.println("Course removed:" + llist.removeCourse(1)); 
    System.out.println("Course removed:" + llist.removeCourse(5)); 
    System.out.println("Number of courses: " + llist.size()); 
    
    System.out.println("\nNumber of courses starting with EECS: " + prefixCountLinkedList(llist, "EECS")); 
    System.out.println("----------------------------------------"); 
    
  } 
}
