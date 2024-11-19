import java.util.Objects;

public class Employee {
    private final String name;
    private int salary;
    private int department;
    private final int id;
    private static int idCount = 0;

    public Employee(String name, int salary, int department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.id = idCount++;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null || other.getClass() != getClass()) return false;
        Employee otherEmployee = (Employee) other;
        return name.equals(otherEmployee.name) &&
                salary == otherEmployee.salary &&
                department == otherEmployee.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, department);
    }

    @Override
    public String toString() {
        return "Employee " + "ID " + "'" + id + "' " +
                "(Name='" + name  +
                ", salary=" + salary +
                ", department=" + department +
                ')';
    }

}
