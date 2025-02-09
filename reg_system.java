import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolledStudents = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean hasAvailableSlots() {
        return enrolledStudents < capacity;
    }

    public boolean enrollStudent() {
        if (hasAvailableSlots()) {
            enrolledStudents++;
            return true;
        }
        return false;
    }

    public boolean removeStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
            return true;
        }
        return false;
    }

    public void displayCourseDetails() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Capacity: " + capacity);
        System.out.println("Enrolled Students: " + enrolledStudents);
        System.out.println("Available Slots: " + (capacity - enrolledStudents));
    }
}

class Student {
    private String studentId;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public boolean registerForCourse(Course course) {
        if (course.enrollStudent()) {
            registeredCourses.add(course);
            System.out.println(name + " successfully registered for " + course.getTitle());
            return true;
        } else {
            System.out.println("No available slots in " + course.getTitle() + " for " + name);
            return false;
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            if (course.removeStudent()) {
                registeredCourses.remove(course);
                System.out.println(name + " successfully dropped " + course.getTitle());
            } else {
                System.out.println("Error: Could not drop " + course.getTitle());
            }
        } else {
            System.out.println(name + " is not registered in " + course.getTitle());
        }
    }

    public void displayRegisteredCourses() {
        System.out.println(name + "'s Registered Courses:");
        for (Course course : registeredCourses) {
            System.out.println(course.getTitle());
        }
    }
}

public class CourseManagement {
    public static void main(String[] args) {
        // Create courses
        Course course1 = new Course("BIO101", "Introduction to Biology", "Study the fundamentals of biology.", 4);
        Course course2 = new Course("CHEM101", "General Chemistry", "Explore the basics of chemistry.", 3);

        // Create students
        Student student1 = new Student("S101", "Sophia");
        Student student2 = new Student("S102", "Liam");

        // Display course details
        System.out.println("Available courses:");
        course1.displayCourseDetails();
        course2.displayCourseDetails();

        // Students register for courses
        student1.registerForCourse(course1);
        student1.registerForCourse(course2);
        student2.registerForCourse(course2);

        // Display registered courses for each student
        student1.displayRegisteredCourses();
        student2.displayRegisteredCourses();

        // Sophia drops a course and re-displays the details
        student1.dropCourse(course1);
        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}
