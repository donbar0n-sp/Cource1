public class Main {

    public Employee [] employees;

    public Main() {
        employees = new Employee[10];
        employees[0] = new Employee("Иванов Иван Иванович", 55000, 1);
        employees[1] = new Employee("Степанов Степан Степанович", 75000, 3);
        employees[2] = new Employee("Сергеев Сергей Сергеевич", 105000, 5);
        employees[3] = new Employee("Федоров Федор Федорович", 70000, 2);
        employees[4] = new Employee("Максимов Максим Максимович", 90000, 4);
        employees[5] = new Employee("Иванов Степан Сергеевич", 100000, 5);
        employees[6] = new Employee("Степанов Сергей Федорович", 70000, 3);
        employees[7] = new Employee("Сергеев Федор Максимович", 85000, 4);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printEmployee();
        System.out.println("Общая сумма затрат на ЗП в месяц: " + main.calculateSalariesSum());
        System.out.println("Сотрудник с минимальной ЗП: " + main.getMinSalaryEmployee());
        System.out.println("Сотрудник с максимальной ЗП: " + main.getMaxSalaryEmployee());
        System.out.println("Средняя ЗП: " + main.calculateAverageSalary());
        main.printEmployeesNames();
    }

    public void printEmployee() {
        for (Employee employee : employees) {
            if (employee != null) { // Check for non-null employee
                System.out.println(employee);
            }
        }
    }


    public int calculateSalariesSum() {
        int sumSalaries = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sumSalaries += employee.getSalary();
            }
        }
        return sumSalaries;
    }


    public Employee getMinSalaryEmployee() {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        if (minSalaryEmployee == null) {
            throw new IllegalArgumentException("No valid employees to determine the minimum salary.");
        }
        return minSalaryEmployee;
    }


    public Employee getMaxSalaryEmployee() {
        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
                }
            }
        }
        if (maxSalaryEmployee == null) {
            throw new IllegalArgumentException("No valid employees to determine the maximum salary.");
        }
        return maxSalaryEmployee;
    }


    public int calculateAverageSalary() {
        int validEmployeeCount = 0;
        int sumSalaries = calculateSalariesSum();

        for (Employee employee : employees) {
            if (employee != null) {
                validEmployeeCount++;
            }
        }
        if (validEmployeeCount == 0) {
            throw new IllegalArgumentException("No valid employees to calculate average salary.");
        }
        return sumSalaries / validEmployeeCount;
    }


    public void printEmployeesNames() {
        int idCount = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.printf("%d. %s%n", idCount, employee.getName());
                idCount++;
            }
        }
    }
}