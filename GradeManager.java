
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class GradeManager {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add student
    public static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        students.add(new Student(id, name));

        System.out.println("Student added successfully!");
    }

    // Record marks
    public static void recordMarks() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter Marks (0-100): ");
        double marks = sc.nextDouble();

        if (marks >= 0 && marks <= 100) {
            student.setMarks(marks);
            System.out.println("Marks recorded successfully!");
        } else {
            System.out.println("Invalid marks!");
        }
    }

    // Find student
    public static Student findStudent(int id) {

        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    // Display all students
    public static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        System.out.println("\nID\tName\tMarks\tGrade\tGPA");

        for (Student s : students) {
            System.out.printf(
                    "%d\t%s\t%.2f\t%s\t%.2f%n",
                    s.getId(),
                    s.getName(),
                    s.getMarks(),
                    s.calculateGrade(),
                    s.calculateGPA()
            );
        }
    }

    // Calculate class average
    public static void calculateAverage() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        double total = 0;

        for (Student s : students) {
            total += s.getMarks();
        }

        double average = total / students.size();

        System.out.printf("Class Average: %.2f%n", average);
    }

    // Calculate class median
    public static void calculateMedian() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        ArrayList<Double> marksList = new ArrayList<>();

        for (Student s : students) {
            marksList.add(s.getMarks());
        }

        marksList.sort(Comparator.naturalOrder());

        int n = marksList.size();
        double median;

        if (n % 2 == 0) {
            median = (
                    marksList.get(n / 2 - 1)
                            + marksList.get(n / 2)
            ) / 2.0;
        } else {
            median = marksList.get(n / 2);
        }

        System.out.printf("Class Median: %.2f%n", median);
    }

    // Generate individual report
    public static void generateReport() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student s = findStudent(id);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("\n===== STUDENT REPORT CARD =====");
        System.out.println("Student ID: " + s.getId());
        System.out.println("Student Name: " + s.getName());
        System.out.println("Marks: " + s.getMarks());
        System.out.println("Grade: " + s.calculateGrade());
        System.out.printf("GPA: %.2f%n", s.calculateGPA());
        System.out.println("===============================");
    }

    // Main menu
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT GRADE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Record Marks");
            System.out.println("3. Display All Students");
            System.out.println("4. Calculate Class Average");
            System.out.println("5. Calculate Class Median");
            System.out.println("6. Generate Student Report");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    recordMarks();
                    break;

                case 3:
                    displayStudents();
                    break;

                case 4:
                    calculateAverage();
                    break;

                case 5:
                    calculateMedian();
                    break;

                case 6:
                    generateReport();
                    break;

                case 7:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
