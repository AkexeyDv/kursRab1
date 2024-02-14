import java.util.Objects;

public class Employee {
    private String nameFull;
    private int numDepart;
    private float salary;
    private int id;
    static int i = 1;

    public Employee(String nameFull, int numDepart, float salary) {
        this.nameFull = nameFull;
        validDepart(numDepart);
        this.salary = salary;
        this.id = i++;

    }


    public String getNameFull() {
        return nameFull;
    }

    public int getNumDepart() {
        return numDepart;
    }

    public float getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setNumDepart(int numDepart) {
        validDepart(numDepart);
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id: " + id +
                " Полное имя: " + nameFull +
                ", отдел: " + numDepart +
                ", зарплата сотрудника: " + salary + " руб.";
    }

    public void validDepart(int numDepart) {
        if (numDepart < 1 || numDepart > 5) {
            throw new IllegalArgumentException("Такого отдела нет. Укажите отдел с 1 по 5.");
        } else {
            this.numDepart = numDepart;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(nameFull, employee.nameFull);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameFull, id);
    }
}
