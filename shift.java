import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inp = scanner.nextLine().split(" ");
        String[] arr = scanner.nextLine().split(" ");
        String[] arr_copy = Arrays.copyOf(arr, arr.length);
        int n = Integer.parseInt(inp[0]);
        int shift = Integer.parseInt(inp[1]);
        
        for (int i = n - 1; i >= 0; i--)
        {
            int s_ind = (i + n - shift) % n;
            arr[i] = arr_copy[s_ind];
        }
        
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
