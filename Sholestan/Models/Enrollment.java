package Models;

public class Enrollment {

    private int stdNo;
    private int classId;
    private String enrollDate;

    // Constructor
    public Enrollment(int stdNo, int classId, String enrollDate) {
        this.stdNo = stdNo;
        this.classId = classId;
        this.enrollDate = enrollDate;
    }

    // Getters
    public int getStdNo() {
        return stdNo;
    }

    public int getClassId() {
        return classId;
    }

    public String getEnrollDate() {
        return enrollDate;
    }
}
