import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++)
        {
            arr[i] = String.valueOf(i + 1);
        }
        
        int temp = 1;
        while (temp < n)
        {
            temp = temp * 2;
        }
        temp = temp / 2;
        int l = n - temp;
        
        System.out.println(arr[(2 * l) % n]);
    }
}
