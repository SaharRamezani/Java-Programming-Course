import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>(3);
        String input;
        do {
            input = sc.nextLine();
            String[] inps = input.split(" ");
            switch (inps[0])
            {
                case "1":
                    list = new ArrayList<>(3);
                    break;
                case "2":
                    // initialize the list with null
                    list = null;
                    break;
                case "3":
                    // add number to list
                    try {
                        list.add(Integer.parseInt(inps[1]));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                    catch (NullPointerException e) {
                        System.out.println("nulle");
                    }
                    break;
                case "4":
                    // read and print the inps[1]-th element
                    try {
                        int index = Integer.parseInt(inps[1]);
                        if (index < 0 || index >= list.size()) {
                            System.out.println("oute");
                        } else {
                            System.out.println(list.get(index));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid index.");
                    }
                    catch (NullPointerException e) {
                        System.out.println("nulle");
                    }
                    break;
                case "5":
                    // divide inps[1] by inps[2] and print the result
                    try {
                        int num1 = Integer.parseInt(inps[1]);
                        int num2 = Integer.parseInt(inps[2]);
                        System.out.println(num1 / num2);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter valid numbers.");
                    } catch (ArithmeticException e) {
                        System.out.println("sefre");
                    }
                    break;
            }
        } while (!input.equals("6"));
    }
}
