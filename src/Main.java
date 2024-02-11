import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
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
        printEmployees(employees);
        printSeparator();
        System.out.println("Затраты на з/п составляют: " + countCosts(employees) + " руб.");
        printSeparator();
        System.out.println("Минимальная заработная плата у сотрудника: \n" +
                employees[minSalary(employees)]);
        printSeparator();
        System.out.println("Максимальная заработная плата у сотрудника: \n" +
                employees[maxSalary(employees)]);
        printSeparator();
        System.out.println("Средняя заработная плата составляет: " + midSalary(employees));
        printSeparator();
        listEmployees(employees);

        //Mid
        printSeparator();
        indexationSalary(employees, 10);
        printSeparator();
        System.out.println("Минимальная з/п в отделе у сотртудника: " + employees[minSalaryDep(employees, 2)].getNameFull());
        printSeparator();
        System.out.println("Максимальная з/п в отделе у сотртудника: " + employees[maxSalaryDep(employees, 2)].getNameFull());
        printSeparator();
        System.out.println(countCostsDep(employees, 2));
        printSeparator();
        System.out.println(countEmployeeDep(employees, 2));
        System.out.println(midSalaryDep(employees, 2));
        indexationSalaryDep(employees, 2, 20);
    }

    //Easy
    public static void printEmployees(Employee[] employees) {
        for (Employee i : employees) {
            System.out.println(i);
        }
    }

    public static int countCosts(Employee[] employees) {
        int s = 0;
        for (int i = 0; i <= employees.length - 1; i++) {
            s = s + employees[i].getSalary();

        }
        return s;
    }

    public static int minSalary(Employee[] employees) {
        int min = employees[0].getSalary();
        int idx = 0;
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    public static int maxSalary(Employee[] employees) {
        int max = employees[0].getSalary();
        int idx = 0;
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    public static float midSalary(Employee[] employees) {
        return (float) countCosts(employees) / employees.length;
    }

    public static void listEmployees(Employee[] employees) {
        System.out.println("\nПоименный список сотрудников фирмы\n");
        for (Employee i : employees) {

            System.out.println(i.getNameFull());
        }
    }

    public static void printSeparator() {
        System.out.println("=====================================");
    }

    //Mid
    public static void indexationSalary(Employee[] employees, int percent) {
        for (Employee i : employees) {
            i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
        }
    }

    public static int minSalaryDep(Employee[] employees, int dep) {
        int min = employees[0].getSalary();
        int idx = 0;
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i].getSalary() < min && employees[i].getNumDepart() == dep) {
                min = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    public static int maxSalaryDep(Employee[] employees, int dep) {
        int max = employees[0].getSalary();
        int idx = 0;
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i].getSalary() > max && employees[i].getNumDepart() == dep) {
                max = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    public static int countCostsDep(Employee[] employees, int dep) {
        int s = 0;
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i].getNumDepart() == dep) {
                s = s + employees[i].getSalary();
            }
        }
        return s;
    }

    public static float midSalaryDep(Employee[] employees, int dep) {
        return (float) countCostsDep(employees, dep) / countEmployeeDep(employees, dep);
    }

    public static int countEmployeeDep(Employee[] employees, int dep) {
        int count = 0;
        for (Employee i : employees) {
            if (i.getNumDepart() == dep) {
                count++;
            }
        }
        return count;
    }

    public static void indexationSalaryDep(Employee[] employees, int dep, int percent) {
        for (Employee i : employees) {
            if (i.getNumDepart() == dep) {
                i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
            }
        }
    }


}