
public class Student {

    // Student details
    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.marks = 0;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for marks
    public double getMarks() {
        return marks;
    }

    // Setter for marks with validation
    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid marks! Enter between 0 and 100.");
        }
    }

    // Calculate GPA on a 10-point scale
    public double calculateGPA() {
        return marks / 10.0;
    }

    // Calculate grade
    public String calculateGrade() {
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
