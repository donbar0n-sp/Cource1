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
        employees[8] = new Employee("Федоров Максим Иванович", 60000, 1);
        employees[9] = new Employee("Максимов Иван Степанович", 80000, 4);
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
            System.out.println(employee);
        }
    }

    public int calculateSalariesSum() {
        int sumSalaries = 0;
        for (Employee employee : employees) {
            sumSalaries = sumSalaries + employee.getSalary();
        }
        return sumSalaries;
    }

    public Employee getMinSalaryEmployee() {
        Employee minSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public Employee getMaxSalaryEmployee() {
        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public int calculateAverageSalary() {
        int averageSalary = calculateSalariesSum() / employees.length;
        return averageSalary;
    }

    public void printEmployeesNames() {
        int idCount = 0;
        for (Employee employee : employees) {
            System.out.printf("%d. %s%n", idCount, employee.getName());
            idCount++;
        }
    }
}