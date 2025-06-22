class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add employee
    public boolean addEmployee(Employee emp) {
        if (size >= employees.length) {
            System.out.println("Array is full. Cannot add employee.");
            return false;
        }
        employees[size++] = emp;
        return true;
    }

    // Search employee by ID
    public Employee searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse all employees
    public void displayEmployees() {
        if (size == 0) {
            System.out.println("No employees found.");
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee by ID
    public boolean deleteEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                // Shift elements to the left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null; // Clean up last reference
                return true;
            }
        }
        return false;
    }
}
