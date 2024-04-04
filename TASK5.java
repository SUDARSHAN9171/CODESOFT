import java.util.*;

class CourseClass {
    String code;
    String title;
    String description;
    int capacity;
    List<String> schedule;
    List<String> registeredStudents;

    public CourseClass(String code, String title, String description, int capacity, List<String> schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    public boolean registerStudent(String studentId) {
        if (registeredStudents.size() < capacity) {
            registeredStudents.add(studentId);
            return true;
        }
        return false;
    }

    public void removeStudent(String studentId) {
        registeredStudents.remove(studentId);
    }

    public int getAvailableSlots() {
        return capacity - registeredStudents.size();
    }

    public String toString() {
        return "Course Code: " + code + "\nTitle: " + title + "\nDescription: " + description + "\nCapacity: "
                + capacity +
                "\nSchedule: " + schedule + "\nAvailable Slots: " + getAvailableSlots() + "\n";
    }
}

class StudentClass {
    String id;
    String name;
    List<String> registeredCourses;

    public StudentClass(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }

    public String toString() {
        return "Student ID: " + id + "\nName: " + name + "\nRegistered Courses: " + registeredCourses + "\n";
    }
}

public class TASK5 {
    public static void main(String[] args) {
        List<CourseClass> courses = new ArrayList<>();
        courses.add(new CourseClass("CS101", "Introduction to Computer Science",
                "An introductory course to computer science.", 30, Arrays.asList("Mon 9-11am", "Wed 9-11am")));
        courses.add(new CourseClass("MATH201", "Calculus I", "A course covering basic Maths.", 25,
                Arrays.asList("Tue 1-3pm", "Thu 1-3pm")));
        courses.add(
                new CourseClass("ENG101", "English Composition", "A course focusing on writing skills and Grammer.", 20,
                        Arrays.asList("Mon 1-3pm", "Wed 1-3pm")));

        List<StudentClass> students = new ArrayList<>();
        students.add(new StudentClass("S001", "SUDARSHAN JADHAV"));
        students.add(new StudentClass("S002", "UJAL PADIA"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Course Listing");
            System.out.println("2. Student Registration");
            System.out.println("3. Course Removal");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayCourseListing(courses);
                    break;
                case 2:
                    registerStudent(students, courses, scanner);
                    break;
                case 3:
                    removeCourse(students, courses, scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void displayCourseListing(List<CourseClass> courses) {
        System.out.println("Available Courses:");
        for (CourseClass course : courses) {
            System.out.println(course);
        }
    }

    public static void registerStudent(List<StudentClass> students, List<CourseClass> courses, Scanner scanner) {
        System.out.println("Enter student ID:");
        String studentId = scanner.nextLine();
        System.out.println("Enter course code:");
        String courseCode = scanner.nextLine();

        StudentClass student = findStudentById(students, studentId);
        CourseClass course = findCourseByCode(courses, courseCode);

        if (student == null) {
            System.out.println("Student not found!");
        } else if (course == null) {
            System.out.println("Course not found!");
        } else {
            if (course.registerStudent(studentId)) {
                student.registerCourse(courseCode);
                System.out.println("Registration successful!");
            } else {
                System.out.println("Course is full. Registration failed.");
            }
        }
    }

    public static void removeCourse(List<StudentClass> students, List<CourseClass> courses, Scanner scanner) {
        System.out.println("Enter student ID:");
        String studentId = scanner.nextLine();
        System.out.println("Enter course code:");
        String courseCode = scanner.nextLine();

        StudentClass student = findStudentById(students, studentId);
        CourseClass course = findCourseByCode(courses, courseCode);

        if (student == null) {
            System.out.println("Student not found!");
        } else if (course == null) {
            System.out.println("Course not found!");
        } else {
            course.removeStudent(studentId);
            student.dropCourse(courseCode);
            System.out.println("Course removed successfully.");
        }
    }

    public static StudentClass findStudentById(List<StudentClass> students, String id) {
        for (StudentClass student : students) {
            if (student.id.equals(id)) {
                return student;
            }
        }
        return null;
    }

    public static CourseClass findCourseByCode(List<CourseClass> courses, String code) {
        for (CourseClass course : courses) {
            if (course.code.equals(code)) {
                return course;
            }
        }
        return null;
    }
}
