import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public double calculateAverage(List<Integer> grades) {
        return grades.stream().mapToInt(Integer::intValue).average().orElseGet(() -> 0.0);
    }

    public int findMaxGrade(List<Integer> grades) {
        return grades.stream().mapToInt(Integer::intValue).max().orElseGet(() -> 0);
    }

    public List<Integer> filterPassingGrades(List<Integer> grades) {
        return grades.stream().filter(a -> a >= 10).collect(Collectors.toList());
    }

    public List<Integer> boostGrades(List<Integer> grades) {
        return grades.stream().map(a -> a + 2).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> grades = Arrays.asList(12, 8, 15, 7, 19, 10);

        Main processor = new Main();

        System.out.println(processor.calculateAverage(grades));     // 11.83
        System.out.println(processor.findMaxGrade(grades));         // 19
        System.out.println(processor.filterPassingGrades(grades));  // [12, 15, 19, 10]
        System.out.println(processor.boostGrades(grades));          // [14, 10, 17, 9, 21, 12]
    }
}
