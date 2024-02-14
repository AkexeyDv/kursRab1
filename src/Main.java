public class Main {
public static EmployeeBook employeeBook=new EmployeeBook();
    public static void printSeparator() {

        System.out.println("=====================================");
    }
    public static void main(String[] args) {
        printSeparator();
        employeeBook.addEmployee("Иванов Иван Иванович", 1, 240000);
        employeeBook.addEmployee("Петров Петр Семенович", 3, 150000);
        employeeBook.addEmployee("Чупыров Поликарп Антонович", 4, 120000);
        employeeBook.addEmployee("Стамескин Арнольд Трофимович", 4, 80000);
        employeeBook.addEmployee("Поджелудочный Святослав Рувимович", 2,250000);
        employeeBook.addEmployee("Синяков Филипп Михайлович", 5, 40000);
        employeeBook.addEmployee("Заварушкин Анисим Прохорович", 1,130000);
       // employeeBook.addEmployee("Троеглазов Насим Артурович", 1, 100000);
       // employeeBook.addEmployee("Иванов Иван Иванович", 5, 120000);
       // employeeBook.addEmployee("Пауков Гаад Васильевич", 3, 300000);
        //employeeBook.addEmployee("Жесткарев Василий Федорович",4,125000);
       // employeeBook.printEmployees();
        printSeparator();
        System.out.println(employeeBook.findEmployeeId("Петров Петр Семенович"));
        printSeparator();
        employeeBook.delEmployee(10);
        employeeBook.addEmployee("Жесткарев Василий Федорович",3,280000);
        printSeparator();
        employeeBook.printEmployees();
        printSeparator();
        System.out.println(employeeBook.findFullNameById(12));
        System.out.println(employeeBook.findFullNameById(3));
        printSeparator();
        System.out.println("Подсчет затрат на з/п");
        System.out.println("на предприятии");
        System.out.println(employeeBook.countCosts());
        System.out.println("по отделу");
        System.out.println(employeeBook.countCosts(3));
        printSeparator();
        System.out.println(employeeBook.returnFullName(25));
        printSeparator();
        System.out.println("Сотрудник с минимальным окладом");
        System.out.println(employeeBook.freeMinSalary());
        System.out.println("Сотрудник с максимальным окладом");
        System.out.println(employeeBook.freeMaxSalary());
        printSeparator();
        System.out.println(employeeBook.midSalary());
        employeeBook.listEmployees();
        printSeparator();
        employeeBook.indexationSalary(10);
        System.out.println("Сотрудник с минимальным окладом в отделе");
        System.out.println(employeeBook.freeMinSalary(4));
        System.out.println("Сотрудник с максимальным окладом в отделе");
        System.out.println(employeeBook.freeMaxSalary(4));
        printSeparator();
        System.out.println(employeeBook.midSalary(4));


        /*
        employees[0].setSalary(150000);
        employees[7].setNumDepart(2);
        */

//Easy
        /*printEmployees();
        printSeparator();
        System.out.println("Затраты на з/п составляют: " + countCosts() + " руб.");
        printSeparator();
        System.out.println("Минимальная заработная плата у сотрудника: \n" +
                employees[minSalary()].getNameFull() + " " + employees[minSalary()].getSalary() + " .руб.");
        printSeparator();
        System.out.println("Максимальная заработная плата у сотрудника: \n" +
                employees[maxSalary()].getNameFull() + " " + employees[maxSalary()].getSalary() + " .руб.");
        printSeparator();
        System.out.println("Средняя заработная плата составляет: " + midSalary());
        printSeparator();
        listEmployees();

        //Mid
        printSeparator();
        indexationSalary(10);
        printSeparator();
        System.out.println("Минимальная з/п в отделе у сотртудника: " +
                employees[minSalaryDep(2)].getNameFull() + " " +
                employees[minSalaryDep(2)].getSalary() + " .руб.");
        printSeparator();
        System.out.println("Максимальная з/п в отделе у сотртудника: " +
                employees[maxSalaryDep(2)].getNameFull() + " " +
                employees[maxSalaryDep(2)].getSalary() + " .руб.");
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
    /*
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

    public static void printEmployeesDep(int dep) {
        System.out.println("Список сотрудников отдела " + dep);
        for (Employee i : employees) {
            if (i.getNumDepart() == dep) {
                System.out.println(i.getId() + " " + i.getNameFull() + " " +
                        i.getSalary());
            }

        }
    }

    public static void printSalaryLess(int less) {
        System.out.println("Сотрудники с зарплатой " + less + " руб. и меньше:");
        for (Employee i : employees) {
            if (i.getSalary() <= less) {
                System.out.println(i.getId() + " " + i.getNameFull() + " " + i.getSalary());
            }
        }
    }

    public static void printSalaryMore(int more) {
        System.out.println("Сотрудники с зарплатой " + more + " руб. и больше:");
        for (Employee i : employees) {
            if (i.getSalary() >= more) {
                System.out.println(i.getId() + " " + i.getNameFull() + " " + i.getSalary());
            }
        }
    }*/

}}