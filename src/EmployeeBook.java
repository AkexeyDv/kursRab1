public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    //Добавление нового сотрудника
    public void addEmployee(String nameFull, int numDepart, int salary) {
        int idx = findIndexFree();
        if (idx != -1) {
            employees[idx] = new Employee(nameFull, numDepart, salary);
        } else {
            System.out.println("База заполнена. Сотрудник не внесен!!!");
        }
    }
    //Удаление сотрудника
    public void delEmployee(String nameFull){
        int idx=findEmployeeId(nameFull);
        if(idx!=-1){
            for(int i=0;i<employees.length;i++){
                if(employees[i].getId()==idx){
                    employees[i]=null;
                    System.out.println("Сотрудник " +nameFull+" успешно удален");
                    return;
                }
            }
        }else {
            System.out.println("Не найден сотрудник "+nameFull);
        }
    }
    //Поиск индекса сотрудника по ФИО
    public int findEmployeeId(String nameFull){
        for(int i=0;i<employees.length;i++){
            if( employees[i]!=null&&employees[i].getNameFull().equals(nameFull))
            {
                return employees[i].getId();
            }
        }
        return -1;
    }


    //Поиск свободного места
    public int findIndexFree() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public String findFullNameById(int id){
        for (int i=0;i<employees.length;i++){
            if(employees[i]!=null&&id==employees[i].getId()){
                return employees[i].getNameFull();
            }
        }
        return "Такого Id нет";

    }

    //Печать содержимого базы
    public void printEmployees() {
        for (Employee i : employees) {
            if (i != null) {
                System.out.println(i);
            }
        }

    }

    public float countCosts() {
        float s = 0;

        for (Employee i : employees) {
            s = s + i.getSalary();
        }
        return s;
    }

    public String returnFullName(int idx) {
        return employees[idx].getNameFull();
    }

    public float returnSalary(int idx) {
        return employees[idx].getSalary();
    }

    public int minSalary() {

        float min = employees[0].getSalary();
        int idx = 0;

        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                idx = i;
            }
        }

        return idx;
    }

    public int maxSalary() {
        float max = employees[0].getSalary();
        int idx = 0;
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    public float midSalary() {
        return countCosts() / employees.length;
    }

    public void listEmployees() {
        System.out.println("\nПоименный список сотрудников фирмы\n");
        for (Employee i : employees) {

            System.out.println(i.getNameFull());
        }
    }


    //Mid
    public void indexationSalary(int percent) {
        for (Employee i : employees) {
            i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
        }
    }

    public int minSalaryDep(int dep) {
        float min = employees[0].getSalary();
        int idx = 0;
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i].getSalary() < min && employees[i].getNumDepart() == dep) {
                min = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    public int maxSalaryDep(int dep) {
        float max = employees[0].getSalary();
        int idx = 0;
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i].getSalary() > max && employees[i].getNumDepart() == dep) {
                max = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    public float countCostsDep(int dep) {
        float s = 0;
        for (Employee i : employees) {
            if (i.getNumDepart() == dep) {
                s = s + i.getSalary();
            }
        }
        return s;
    }

    public float midSalaryDep(int dep) {
        return countCostsDep(dep) / countEmployeeDep(dep);
    }

    public int countEmployeeDep(int dep) {
        int count = 0;
        for (Employee i : employees) {
            if (i.getNumDepart() == dep) {
                count++;
            }
        }
        return count;
    }

    public void indexationSalaryDep(int dep, int percent) {
        for (Employee i : employees) {
            if (i.getNumDepart() == dep) {
                i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
            }
        }
    }

    public void printEmployeesDep(int dep) {
        System.out.println("Список сотрудников отдела " + dep);
        for (Employee i : employees) {
            if (i.getNumDepart() == dep) {
                System.out.println(i.getId() + " " + i.getNameFull() + " " +
                        i.getSalary());
            }

        }
    }

    public void printSalaryLess(int less) {
        System.out.println("Сотрудники с зарплатой " + less + " руб. и меньше:");
        for (Employee i : employees) {
            if (i.getSalary() <= less) {
                System.out.println(i.getId() + " " + i.getNameFull() + " " + i.getSalary());
            }
        }
    }

    public void printSalaryMore(int more) {
        System.out.println("Сотрудники с зарплатой " + more + " руб. и больше:");
        for (Employee i : employees) {
            if (i.getSalary() >= more) {
                System.out.println(i.getId() + " " + i.getNameFull() + " " + i.getSalary());
            }
        }
    }

}
