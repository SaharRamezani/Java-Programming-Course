import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList good = new ArrayList();
        ArrayList bad = new ArrayList();
        
        Scanner scanner = new Scanner(System.in);
        String[] inp = scanner.nextLine().split(" ");
        int opt = Integer.parseInt(inp[0]);
        
        while (opt != 9)
        {
            switch(opt)
            {
                case 1:
                    good.add(inp[1]);
                    break;
                case 2:
                    bad.add(inp[1]);
                    break;
                case 3:
                    System.out.println(good.size());
                    break;
                case 4:
                    System.out.println(bad.size());
                    break;
                case 5:
                    good.clear();
                    break;
                case 6:
                    bad.clear();
                    break;
                case 7:
                    try {
                        int n = Integer.parseInt(inp[1]);
                        System.out.println(good.get(n - 1));
                    }
                    catch (Exception e) {
                        System.out.println("not available!");
                    }
                    break;
                case 8:
                    try {
                        int n = Integer.parseInt(inp[1]);
                        System.out.println(bad.get(n - 1));
                    }
                    catch (Exception e) {
                        System.out.println("not available!");
                    }
                    break;
            }
            
            inp = scanner.nextLine().split(" ");
            opt = Integer.parseInt(inp[0]);
        }
    }
}
