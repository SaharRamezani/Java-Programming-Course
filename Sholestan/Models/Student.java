package Models;

public class Student {

    private int stdNo;
    private String firstName;
    private String lastName;

    // Constructor
    public Student(int stdNo, String firstName, String lastName) {
        this.stdNo = stdNo;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters
    public int getStdNo() {
        return stdNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
