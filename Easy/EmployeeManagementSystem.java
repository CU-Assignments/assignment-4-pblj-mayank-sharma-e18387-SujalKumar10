import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    employees.add(new Employee(id, name, salary));
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    boolean foundForUpdate = false;
                    for (Employee emp : employees) {
                        if (emp.getId() == updateId) {
                            scanner.nextLine();
                            System.out.print("Enter New Name: ");
                            String newName = scanner.nextLine();
                            System.out.print("Enter New Salary: ");
                            double newSalary = scanner.nextDouble();
                            emp.setName(newName);
                            emp.setSalary(newSalary);
                            System.out.println("Employee updated successfully!");
                            foundForUpdate = true;
                            break;
                        }
                    }
                    if (!foundForUpdate) {
                        System.out.println("Employee not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    boolean foundForRemove = false;
                    for (Employee emp : employees) {
                        if (emp.getId() == removeId) {
                            employees.remove(emp);
                            System.out.println("Employee removed successfully!");
                            foundForRemove = true;
                            break;
                        }
                    }
                    if (!foundForRemove) {
                        System.out.println("Employee not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    boolean foundForSearch = false;
                    for (Employee emp : employees) {
                        if (emp.getId() == searchId) {
                            System.out.println(emp);
                            foundForSearch = true;
                            break;
                        }
                    }
                    if (!foundForSearch) {
                        System.out.println("Employee not found!");
                    }
                    break;

                case 5:
                    System.out.println("All Employees:");
                    for (Employee emp : employees) {
                        System.out.println(emp);
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
