/**
 * Way to represent courses using an array
 * @author Eddie Xu
 */

public class CourseArrayList implements CourseList{
  // Array of type Course, as specified in the directions
  private Course[] course;
  
  // Constructor with no parameters (size 10 to test)
  public CourseArrayList() {
    this.course = new Course[10];
  }
  
  // method to return the current size of the list (array) O(n) time
  public int size() {
    // Counter set to zero, which will be incremented as array fills up
    int counter = 0;
    // Looping through the array
    for (int i = 0; i < course.length; i++) {
      // If there is an array cell that is empty, increment counter by one
      if (course[i] != null) {
        counter++;
      }
    }
    // return number of non-null cells in my Course array
    return counter;
  }
  
  // method to add a Course into our array O(n)
  public void addCourse(int i, Course course) {
    // If the index you are adding at is greater than the number of the elements in the array
    if (i >= size()) {
      // add to the end
      this.course[size()] = course;
    }
    // If the index is within the size of the number of classes
    else {
      for (int j = size(); j > i; j--) {
        // shift the classes after the index to the right
        this.course[j] = this.course[j-1];
      }
      // insert the course into the index
      this.course[i] = course;
    }
  }
  
  // method to change the capacity of a course in your array of courses O(n^2)
  public boolean changeCapacity(String ID, int cap) {
    // looping through all of the courses
    for (int i = 0; i < course.length; i++) {
      // If there is a course at the index
      if (course[i] != null) {
        // Check if the course ID equals the name of the ID
        if (course[i].courseName().equals(ID)) {
          // Set that index to the same course but with a different capacity.
          course[i] = new Course(course[i].courseName(), cap);
          return true;
        }
      }
    }
    // The course ID in the parameter is not in the array
    return false;
  }
  
  // Method to remove the course at the given index O(n)
  public boolean removeCourse(int i) {
    // If the value of the index is smaller than the total number of courses in the array
    if (i < size()) {
      for (int j = 0; j < size(); j++) {
        // Set the index (where the course would have been) to null ~Deleting the course~
        course[i] = null;
        return true;
      }
    }
    // The given index does not contain a course
    return false;
  }
  
  // Method to receive the course at the i-th position in the array O(n)
  public Course search(int i) {
    // If the index is a valid index (will result in a course existing at the index)
    if (i < size()) {
      // Return the name of the course at that index
      return course[i];
    }
    else {
      return null;
    }
  }
}
