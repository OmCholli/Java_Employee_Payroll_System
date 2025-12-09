
import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private List<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("John Doe", 101, 5000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Jane Smith", 102, 30, 15.0);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        payrollSystem.removeEmployee(101);

        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployees();
    }
}

//*****WITH DYNAMIC INPUT************

//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        PayrollSystem payrollSystem = new PayrollSystem();
//
//        while (true) {
//            System.out.println("\n------ Payroll System Menu ------");
//            System.out.println("1. Add Full-Time Employee");
//            System.out.println("2. Add Part-Time Employee");
//            System.out.println("3. Remove Employee");
//            System.out.println("4. Display Employees");
//            System.out.println("5. Exit");
//            System.out.print("Enter your choice: ");
//            int choice = sc.nextInt();
//
//            switch (choice) {
//
//                case 1:
//                    System.out.print("Enter Name: ");
//                    sc.nextLine(); // clear buffer
//                    String ftName = sc.nextLine();
//                    System.out.print("Enter ID: ");
//                    int ftId = sc.nextInt();
//                    System.out.print("Enter Monthly Salary: ");
//                    double salary = sc.nextDouble();
//
//                    payrollSystem.addEmployee(new FullTimeEmployee(ftName, ftId, salary));
//                    System.out.println("Full-Time Employee Added!");
//                    break;
//
//                case 2:
//                    System.out.print("Enter Name: ");
//                    sc.nextLine(); // clear buffer
//                    String ptName = sc.nextLine();
//                    System.out.print("Enter ID: ");
//                    int ptId = sc.nextInt();
//                    System.out.print("Enter Hours Worked: ");
//                    int hours = sc.nextInt();
//                    System.out.print("Enter Hourly Rate: ");
//                    double rate = sc.nextDouble();
//
//                    payrollSystem.addEmployee(new PartTimeEmployee(ptName, ptId, hours, rate));
//                    System.out.println("Part-Time Employee Added!");
//                    break;
//
//                case 3:
//                    System.out.print("Enter Employee ID to Remove: ");
//                    int removeId = sc.nextInt();
//                    payrollSystem.removeEmployee(removeId);
//                    break;
//
//                case 4:
//                    System.out.println("\n--- Employee Details ---");
//                    payrollSystem.displayEmployees();
//                    break;
//
//                case 5:
//                    System.out.println("Exiting... Goodbye!");
//                    sc.close();
//                    return;
//
//                default:
//                    System.out.println("Invalid choice! Please try again.");
//            }
//        }
//    }
//}
