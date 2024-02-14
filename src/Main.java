public class Main {
    public static EmployeeBook employeeBook = new EmployeeBook();

    public static void printSeparator() {

        System.out.println("=====================================");
    }

    public static void main(String[] args) {
        printSeparator();
        employeeBook.addEmployee("Иванов Иван Иванович", 1, 240000);
        employeeBook.addEmployee("Петров Петр Семенович", 3, 150000);
        employeeBook.addEmployee("Чупыров Поликарп Антонович", 4, 120000);
        employeeBook.addEmployee("Стамескин Арнольд Трофимович", 4, 80000);
        employeeBook.addEmployee("Поджелудочный Святослав Рувимович", 2, 250000);
        employeeBook.addEmployee("Синяков Филипп Михайлович", 5, 40000);
        employeeBook.addEmployee("Заварушкин Анисим Прохорович", 4, 130000);
        // employeeBook.addEmployee("Троеглазов Насим Артурович", 1, 100000);
        // employeeBook.addEmployee("Иванов Иван Иванович", 5, 120000);
        // employeeBook.addEmployee("Пауков Гаад Васильевич", 3, 300000);
        //employeeBook.addEmployee("Жесткарев Василий Федорович",4,125000);
        // employeeBook.printEmployees();
        printSeparator();
        //Легко
        employeeBook.printEmployees();
        printSeparator();
        System.out.println("Сумма затрат");
        System.out.println(employeeBook.countCosts());
        printSeparator();
        System.out.println("Минимальная з/п:");
        System.out.println(employeeBook.freeMinSalary());
        System.out.println("Максимальная з/п:");
        System.out.println(employeeBook.freeMaxSalary());
        printSeparator();
        System.out.println("Средняя з/п:");
        System.out.println(employeeBook.midSalary());
        printSeparator();
        employeeBook.listEmployees();
        //Сложно
        employeeBook.indexationSalary(15);
        printSeparator();
        System.out.println("Минимальная з/п в отделе:");
        System.out.println(employeeBook.freeMinSalary(4));
        System.out.println("Максимальная з/п в отделе:");
        System.out.println(employeeBook.freeMaxSalary(4));
        System.out.println("Сумма затрат в отделе:");
        System.out.println(employeeBook.countCosts(4));
        System.out.println("Средняя з/п:");
        System.out.println(employeeBook.midSalary(4));
        employeeBook.indexationSalary(4, 10);
        printSeparator();
        employeeBook.listEmployees(4);
        printSeparator();
        employeeBook.printSalaryLess(120000);
        printSeparator();
        employeeBook.printSalaryMore(150000);
        printSeparator();
        employeeBook.delEmployee(3);
        employeeBook.findFullNameById(5);


    }
}