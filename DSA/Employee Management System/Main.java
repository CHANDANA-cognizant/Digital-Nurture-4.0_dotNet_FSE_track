public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        ems.addEmployee(new Employee(101, "Alice", "Manager", 75000));
        ems.addEmployee(new Employee(102, "Bob", "Developer", 60000));
        ems.addEmployee(new Employee(103, "Charlie", "Tester", 50000));

        System.out.println("\nAll Employees:");
        ems.displayEmployees();

        System.out.println("\nSearching for employee with ID 102:");
        Employee emp = ems.searchEmployee(102);
        System.out.println(emp != null ? emp : "Employee not found");

        System.out.println("\nDeleting employee with ID 102:");
        boolean deleted = ems.deleteEmployee(102);
        System.out.println(deleted ? "Deleted successfully" : "Employee not found");

        System.out.println("\nEmployees after deletion:");
        ems.displayEmployees();
    }
}
