import Models.*;

public class Main {
    public static void main(String[] args) {
        Pharmacy p = new Pharmacy("My Pharmacy");
        p.addDrug(new Drug("Paracetamol", 10, 1000));
        p.addEmployee(new Employee("Mohammad", "Mohammadi", 19));

        System.out.println("Total Price: " + p.totalPrice());
        System.out.println(p.employeeSummary());
    }
}