package Models;

public class Class {

    private int classId;
    private String className;

    // Constructor
    public Class(int classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    // Getters
    public int getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }
}
