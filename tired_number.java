import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first_int = scanner.nextInt();
        int second_int = scanner.nextInt();
        int b_first = first_int;
        int b_second = second_int;
        
        int firstIsBigger = 0;
        for (int i = 0; i < 3; i++, first_int = first_int / 10, second_int = second_int / 10)
        {
            int y1 = first_int % 10;
            int y2 = second_int % 10;
            
            if (y1 > y2)
            {
                firstIsBigger = 1;
                break;
            }
            else if (y1 < y2)
            {
                firstIsBigger = 2;
                break;
            }
        }
        
        if (firstIsBigger == 1)
            System.out.println(b_second + " < " + b_first);
        else if (firstIsBigger == 2)
            System.out.println(b_first + " < " + b_second);
        else
            System.out.println(b_first + " = " + b_second);
    }
}
