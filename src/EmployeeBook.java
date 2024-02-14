public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    //easy-8a Печать содержимого базы
    public void printEmployees() {
        for (Employee i : employees) {
            if (i != null) {
                System.out.println(i);
            }
        }

    }

    //easy-8b Подсчет затрат
//на предприятии
    public float countCosts() {
        float s = 0;

        for (Employee i : employees) {
            if (i != null) {
                s = s + i.getSalary();
            }
        }
        return s;
    }

    //easy-8c Сотрудник с мин. окладом
    public String freeMinSalary() {
        return returnFullName(minSalary());
    }

    //easy-8d Сотрудник с мин. окладом
    public String freeMaxSalary() {
        return returnFullName(maxSalary());
    }

    //индекс сотрудника с минимальным окладом
    private int minSalary() {
        int idx = 0;
        float min = employees[maxSalary()].getSalary();
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i] != null && employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    //индекс сотрудника с максимальным окладом
    private int maxSalary() {
        //float max = employees[0].getSalary();
        float max = 0;
        int idx = 0;
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i] != null && employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    //easy-8e Среднее значение затрат на з/п
    public float midSalary() {
        return countCosts() / employees.length;
    }

    //easy-8f Список сотрудников
    public void listEmployees() {
        System.out.println("\nПоименный список сотрудников фирмы\n");
        for (Employee i : employees) {
            if (i != null) {
                System.out.println(i.getNameFull());
            }
        }
    }

    //mid-1
    public void indexationSalary(int percent) {
        for (Employee i : employees) {
            if (i != null) {
                i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
            }
        }
    }

    //mid-2a Сотрудник с мин. окладом
    public String freeMinSalary(int dep) {
        return returnFullName(minSalary(dep));
    }

    //mid-2b Сотрудник с мин. окладом
    public String freeMaxSalary(int dep) {
        return returnFullName(maxSalary(dep));
    }

    //Минимальная з/п по отделу
    private int minSalary(int dep) {
        float min = employees[maxSalary(dep)].getSalary();
        int idx = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < min && employees[i].getNumDepart() == dep) {
                min = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    //Максимальная з/п по отделу
    private int maxSalary(int dep) {
        float max = 0;
        int idx = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > max && employees[i].getNumDepart() == dep) {
                max = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    //mid-2c затраты по отделу
    public float countCosts(int dep) {
        float s = 0;
        for (Employee i : employees) {
            if (i != null && i.getNumDepart() == dep) {
                s = s + i.getSalary();
            }
        }
        return s;
    }

    //mid-2d Средняя з/п по отделу
    public float midSalary(int dep) {
        return countCosts(dep) / countEmployeeDep(dep);
    }

    //mid-2e Индексация з/п в отделе
    public void indexationSalary(int dep, int percent) {
        for (Employee i : employees) {
            if (i != null && i.getNumDepart() == dep) {
                i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
            }
        }
    }

    //mid-2f
    public void listEmployees(int dep) {
        System.out.println("Список сотрудников отдела " + dep);
        for (Employee i : employees) {
            if (i != null && i.getNumDepart() == dep) {
                System.out.println(i.getId() + " " + i.getNameFull() + " " +
                        i.getSalary());
            }

        }
    }

    //mid-3a Сотрудник с зарплатой меньше, чем...
    public void printSalaryLess(int less) {
        System.out.println("Сотрудники с зарплатой " + less + " руб. и меньше:");
        for (Employee i : employees) {
            if (i != null && i.getSalary() <= less) {
                System.out.println(i.getId() + " " + i.getNameFull() + " " + i.getSalary());
            }
        }
    }

    //mid-3b Сотрудник с зарплатой больше, чем...
    public void printSalaryMore(int more) {
        System.out.println("Сотрудники с зарплатой " + more + " руб. и больше:");
        for (Employee i : employees) {
            if (i != null && i.getSalary() >= more) {
                System.out.println(i.getId() + " " + i.getNameFull() + " " + i.getSalary());
            }
        }
    }

    //hard-4a Добавление нового сотрудника
    public boolean addEmployee(String nameFull, int numDepart, int salary) {
        int idx = findIndexFree();
        if (idx != -1) {
            employees[idx] = new Employee(nameFull, numDepart, salary);
            return true;
        } else {
            System.out.println("База заполнена. Сотрудник не внесен!!!");
            return false;
        }
    }

    //hard-4b Удаление сотрудника
    public void delEmployee(int id) {
        int idx = findIdxById(id);
        if (idx != -1) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getId() == idx) {

                    System.out.println("Сотрудник " + employees[i].getNameFull() +
                            " c id=" + id + " успешно удален");
                    employees[i] = null;
                    return;
                }
            }
        } else {
            System.out.println("Не найден сотрудник c id=" + id);
        }
    }

    //hard-5 Поиск сотрудника по Id
    public String findFullNameById(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && id == employees[i].getId()) {
                System.out.println("Найден сотрудник " + employees[i].getNameFull() + " c id=" + id);
                return employees[i].getNameFull();
            }
        }
        return "Такого Id нет";

    }

    //Поиск id сотрудника по ФИО
    private int findEmployeeId(String nameFull) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getNameFull().equals(nameFull)) {
                return employees[i].getId();
            }
        }
        return -1;
    }


    //Поиск idx сотрудника по id
    private int findIdxById(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }


    //Поиск свободного места
    private int findIndexFree() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return i;
            }
        }
        return -1;
    }


    //Нахождение сотрудника по индексу массива
    private String returnFullName(int idx) {
        if (idx <= employees.length - 1) {
            return employees[idx].getNameFull();
        } else {
            return "Индекс за пределом БД";
        }
    }

    //Зарплата сотрудника
    public float returnSalary(int idx) {
        return employees[idx].getSalary();
    }


    public int countEmployeeDep(int dep) {
        int count = 0;
        for (Employee i : employees) {
            if (i != null && i.getNumDepart() == dep) {
                count++;
            }
        }
        return count;
    }


}
