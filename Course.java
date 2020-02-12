/**
 * Course class with a name and capcaity size
 * @author Eddie Xu
 */

public class Course {
  // Two variables as given in prompt
  private String courseID;
  private int capacity;
  
  // Constructor to create a course with a name and size
  public Course(String courseID, int capacity) {
    this.courseID = courseID;
    this.capacity = capacity;
  }
  
  // abstract data type
  public interface CourseList {
    // returns current size of list (total number of courses)
    int size();
    // Adds new element before i-th element of list (first entry is 0). If i
    // is greater than the list size, add to end
    void addCourse(int i, Course course);
    // Change course capacity whose courseID = ID, true. False if ID not in list
    boolean changeCapacity(String ID, int cap);
    // Deletes i-th element of list and return true. False if < i elements
    boolean removeCourse(int i); 
    // returns i-th element of list, if < i, return null
    Course search(int i);     
  }
  
  // Find the capacity of the course (Named getCapacity in demo but I'm dumb and called it length());
  public int length() {
    return capacity;
  }
  
  // Helper method to change the capacity of a course
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
  
  // Getting the name of the course (named getCourse in demo but I didn't see and called it courseName());
  public String courseName() {
    return courseID;
  }
}
