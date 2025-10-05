import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2);
        numbers.sort((a, b) -> a.compareTo(b));  // مرتب‌سازی صعودی
        System.out.println(numbers);
    }
}
