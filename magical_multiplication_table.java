import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++)
        {
            for (int j = 1; j <= 10; j++)
            {
                if (i == j){
                    System.out.print("0");
                }
                else if (j > i){
                    System.out.print(-1 * j * i);
                }
                else if (j < i){
                    System.out.print(j * i);
                }
                
                System.out.print(" ");
            }
            
            System.out.println("");
        }
    }
}
