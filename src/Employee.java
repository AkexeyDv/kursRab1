public class Employee {
    private String nameFull;
    private int numDepart;
    private int salary;
    private int id;
    static int i = 1;

    public Employee(String nameFull, int numDepart, int salary) {
        this.nameFull = nameFull;
        this.numDepart = numDepart;
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
        this.numDepart=numDepart;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }
}
