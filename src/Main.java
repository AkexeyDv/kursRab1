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


    }

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

}