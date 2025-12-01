import Models.Class;
import Models.Enrollment;
import Models.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Calculate {

    /**
     * Returns a list of strings in the form "classId:studentNumbers",
     * sorted by:
     *  1. ascending number of students
     *  2. then ascending classId
     */
    public List<String> countAllClasses(List<Enrollment> enrollments) {
        Map<Integer, Integer> classCounts = new HashMap<>();

        // Count students for each classId
        for (Enrollment e : enrollments) {
            int classId = e.getClassId();
            classCounts.put(classId, classCounts.getOrDefault(classId, 0) + 1);
        }

        // Convert map entries to a list so we can sort
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(classCounts.entrySet());

        // Sort by value (student count), then by key (classId)
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int cmp = Integer.compare(o1.getValue(), o2.getValue());
                if (cmp == 0) {
                    // if student counts are equal, compare classId
                    return Integer.compare(o1.getKey(), o2.getKey());
                }
                return cmp;
            }
        });

        // Build the result list "classId:studentNumbers"
        List<String> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            String line = entry.getKey() + ":" + entry.getValue();
            result.add(line);
        }

        return result;
    }

    /**
     * Returns the number of students enrolled in a given classId.
     */
    public int countClassStudents(List<Enrollment> enrollments, int classId) {
        int count = 0;
        for (Enrollment e : enrollments) {
            if (e.getClassId() == classId) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the number of classes that a given student (stdNo) is enrolled in.
     */
    public int countStudentClasses(List<Enrollment> enrollments, int stdNo) {
        int count = 0;
        for (Enrollment e : enrollments) {
            if (e.getStdNo() == stdNo) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns "firstName lastName" for the given student number.
     * If not found, returns an empty string.
     */
    public String getStudentFullName(List<Student> students, int stdNo) {
        for (Student s : students) {
            if (s.getStdNo() == stdNo) {
                return s.getFirstName() + " " + s.getLastName();
            }
        }
        return "";
    }

    /**
     * Returns the list of class names that a given student (stdNo) is enrolled in,
     * sorted by ascending classId.
     */
    public List<String> getStudentClassNames(List<Class> classes,
                                             List<Enrollment> enrollments,
                                             int stdNo) {
        // Collect all classIds for this student (unique)
        Set<Integer> classIdSet = new HashSet<>();
        for (Enrollment e : enrollments) {
            if (e.getStdNo() == stdNo) {
                classIdSet.add(e.getClassId());
            }
        }

        // Sort the classIds
        List<Integer> classIds = new ArrayList<>(classIdSet);
        Collections.sort(classIds);

        // For each classId, find the className from classes list
        List<String> classNames = new ArrayList<>();
        for (Integer classId : classIds) {
            for (Class c : classes) {
                if (c.getClassId() == classId) {
                    classNames.add(c.getClassName());
                    break;
                }
            }
        }

        return classNames;
    }
}
