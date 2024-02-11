public class Employee {
    private String nameFull;
    private int numDepart;
    private int salary;
    private int id;
    static int i = 1;

    public Employee(String nameFull, int numDepart, int salary) {
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

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
    public void setNumDepart(int numDepart){
        validDepart(numDepart);
    }
    public void setSalary(int salary){
        this.salary=salary;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                " Полное имя: " + nameFull +
                ", отдел: " + numDepart +
                ", зарплата сотрудника: " + salary+" руб.";
    }
    public void validDepart(int numDepart){
        if(numDepart<1||numDepart>5){
            throw new IllegalArgumentException("Такого отдела нет. Укажите отдел с 1 по 5.");
        }else {
            this.numDepart = numDepart;
        }
    }
}
