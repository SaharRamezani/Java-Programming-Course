package Models;

import java.util.ArrayList;

public class Pharmacy {
    String name;
    ArrayList<Drug> drugs;
    ArrayList<Employee> employees;
    
    public Pharmacy(String name)
    {
        this.name = name;

        drugs = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public void addDrug(Drug drug)
    {
        drugs.add(drug);
    }

    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }

    public int totalPrice()
    {
        int total = 0;
        for (Drug drug : drugs) {
            total += drug.price * drug.amount;
        }
        return total;
    }

    public String employeeSummary()
    {
        StringBuilder summary = new StringBuilder();
        summary.append("Employees:\n");
        int i = 1;
        for (Employee employee : employees) {
            summary.append("The employee number ").append(i + " is ")
            .append(employee.firstName).append(" ")
            .append(employee.lastName).append(" who is ").append(employee.age)
            .append(" years old.\n");
            i++;
        }
        return summary.toString();
    }
}