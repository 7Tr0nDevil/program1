import java.util.*;

public class StudentCourses {
    private String studentName;
    private Map<Integer, List<Course>> semesterCourses;

    public StudentCourses(String studentName) {
        this.studentName = studentName;
        semesterCourses = new HashMap<>();
    }

    public void addCourse(int semester, String courseName, int marks) {
        semesterCourses.putIfAbsent(semester, new ArrayList<>());
        semesterCourses.get(semester).add(new Course(courseName, marks));
    }

    public void displayCourses() {
        System.out.println("Courses and Marks for " + studentName + ":");
        for (int semester : semesterCourses.keySet()) {
            System.out.println("\nSemester " + semester + ":");
            for (Course course : semesterCourses.get(semester)) {
                System.out.println("  - " + course.getName() + ": " + course.getMarks() + " marks");
            }
        }
    }

    private static class Course {
        private final String name;
        private final int marks;

        public Course(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public int getMarks() {
            return marks;
        }
    }
}
