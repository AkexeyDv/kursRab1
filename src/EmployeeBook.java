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
    //Поиск id сотрудника по ФИО
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
//Поиск сотрудника по Id
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
//Подсчет затрат
    //на предприятии
    public float countCosts() {
        float s = 0;

        for (Employee i : employees) {
            if(i!=null) {
                s = s + i.getSalary();
            }
        }
        return s;
    }
    //затраты по отделу
    public float countCosts(int dep) {
        float s = 0;
        for (Employee i : employees) {
            if (i!=null&&i.getNumDepart() == dep) {
                s = s + i.getSalary();
            }
        }
        return s;
    }

//Нахождение сотрудника по индексу массива
    public String returnFullName(int idx) {
        if(idx<=employees.length-1) {
            return employees[idx].getNameFull();
        }else{
            return "Индекс за пределом БД";
        }
    }
//Зарплата сотрудника
    public float returnSalary(int idx) {
        return employees[idx].getSalary();
    }

    public int minSalary() {
        int idx = 0;

        //float min = employees[0].getSalary();
        float min=employees[maxSalary()].getSalary();
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i]!=null&&employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                idx = i;
            }
        }

        return idx;
    }
//индекс сотрудника с минимальным окладом
    public int maxSalary() {
        //float max = employees[0].getSalary();
        float max=0;
        int idx = 0;
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i]!=null&&employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }
//индекс сотрудника с максимальным окладом
    public float midSalary() {
        return countCosts() / employees.length;
    }

    public void listEmployees() {
        System.out.println("\nПоименный список сотрудников фирмы\n");
        for (Employee i : employees) {
            if(i!=null) {
                System.out.println(i.getNameFull());
            }
        }
    }


    //Mid
    public void indexationSalary(int percent) {
        for (Employee i : employees) {
            if(i!=null) {
                i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
            }
        }
    }
//Минимальная з/п по отделу
    public int minSalary(int dep) {
        float min = employees[maxSalary(dep)].getSalary();
        int idx = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i]!=null&&employees[i].getSalary() < min && employees[i].getNumDepart() == dep) {
                min = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }
//Максимальная з/п по отделу
    public int maxSalary(int dep) {
        float max = 0;
        int idx = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i]!=null&&employees[i].getSalary() > max && employees[i].getNumDepart() == dep) {
                max = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

//Средняя по отделу

    public float midSalaryDep(int dep) {
        return countCosts(dep) / countEmployeeDep(dep);
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
