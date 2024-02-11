public class Main {
    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Иванов Иван Иванович", 1, 240000);
        employees[1] = new Employee("Петров Петр Семенович", 3, 150000);
        employees[2] = new Employee("Чупыров Поликарп Антонович", 4, 120000);
        employees[3] = new Employee("Стамескин Арнольд Трофимович", 4, 80000);
        employees[4] = new Employee("Поджелудочный Святослав Рувимович", 2,
                250000);
        employees[5] = new Employee("Синяков Филипп Михайлович", 5, 40000);
        employees[6] = new Employee("Заварушкин Анисим Прохорович", 1,
                130000);
        employees[7] = new Employee("Троеглазов Насим Артурович", 1, 100000);
        employees[8] = new Employee("Иванов Иван Иванович", 5, 120000);
        employees[9] = new Employee("Пауков Гаад Васильевич", 3, 300000);
        employees[0].setSalary(150000);
        employees[7].setNumDepart(2);
//Easy
        printEmployees();
        printSeparator();
        System.out.println("Затраты на з/п составляют: " + countCosts() + " руб.");
        printSeparator();
        System.out.println("Минимальная заработная плата у сотрудника: \n" +
                employees[minSalary()].getNameFull()+" "+employees[minSalary()].getSalary()+" .руб.");
        printSeparator();
        System.out.println("Максимальная заработная плата у сотрудника: \n" +
                employees[maxSalary()].getNameFull()+" "+employees[maxSalary()].getSalary()+" .руб.");
        printSeparator();
        System.out.println("Средняя заработная плата составляет: " + midSalary());
        printSeparator();
        listEmployees();

        //Mid
        printSeparator();
        indexationSalary(10);
        printSeparator();
        System.out.println("Минимальная з/п в отделе у сотртудника: " +
                employees[minSalaryDep(2)].getNameFull()+" "+
                employees[minSalaryDep(2)].getSalary()+" .руб.");
        printSeparator();
        System.out.println("Максимальная з/п в отделе у сотртудника: " +
                employees[maxSalaryDep(2)].getNameFull()+" "+
                employees[maxSalaryDep(2)].getSalary()+" .руб.");
        printSeparator();
        System.out.println("Затраты на з/п отдела: " + countCostsDep(2));
        printSeparator();
        System.out.println("Средняя зарплата в отделе: " + midSalaryDep(2));
        printSeparator();
        indexationSalaryDep(2, 20);
        printEmployeesDep(2);
        printSeparator();
        printSalaryLess(100000);
        printSeparator();
        printSalaryMore(100000);
    }

    //Easy
    public static void printEmployees() {
        for (Employee i : employees) {
            System.out.println(i);
        }
    }

    public static float countCosts() {
        float s = 0;
        for (Employee i : employees) {
            s = s + i.getSalary();

        }
        return s;
    }

    public static int minSalary() {
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

    public static int maxSalary() {
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

    public static float midSalary() {
        return countCosts() / employees.length;
    }

    public static void listEmployees() {
        System.out.println("\nПоименный список сотрудников фирмы\n");
        for (Employee i : employees) {

            System.out.println(i.getNameFull());
        }
    }

    public static void printSeparator() {
        System.out.println("=====================================");
    }

    //Mid
    public static void indexationSalary(int percent) {
        for (Employee i : employees) {
            i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
        }
    }

    public static int minSalaryDep(int dep) {
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

    public static int maxSalaryDep(int dep) {
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

    public static float countCostsDep(int dep) {
        float s = 0;
        for (Employee i : employees) {
            if (i.getNumDepart() == dep) {
                s = s + i.getSalary();
            }
        }
        return s;
    }

    public static float midSalaryDep(int dep) {
        return countCostsDep(dep) / countEmployeeDep(dep);
    }

    public static int countEmployeeDep(int dep) {
        int count = 0;
        for (Employee i : employees) {
            if (i.getNumDepart() == dep) {
                count++;
            }
        }
        return count;
    }

    public static void indexationSalaryDep(int dep, int percent) {
        for (Employee i : employees) {
            if (i.getNumDepart() == dep) {
                i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
            }
        }
    }
    public static void printEmployeesDep(int dep){
        System.out.println("Список сотрудников отдела "+dep);
        for(Employee i:employees){
            if(i.getNumDepart()==dep){
                System.out.println(i.getId()+" "+i.getNameFull()+" "+
                        i.getSalary());
            }

        }
    }
    public static void printSalaryLess(int less){
        System.out.println("Сотрудники с зарплатой "+ less +" руб. и меньше:");
        for(Employee i:employees){
            if(i.getSalary()<=less){
                System.out.println(i.getId()+" "+i.getNameFull()+" "+i.getSalary());
            }
        }
    }
    public static void printSalaryMore(int more){
        System.out.println("Сотрудники с зарплатой "+ more +" руб. и больше:");
        for(Employee i:employees){
            if(i.getSalary()>=more){
                System.out.println(i.getId()+" "+i.getNameFull()+" "+i.getSalary());
            }
        }
    }

}