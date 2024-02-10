public class Main {
    public static void main(String[] args) {
        Employee[] employees=new Employee[10];
        employees[0]=new Employee("Иванов Иван Иванович",1,240000);
        employees[1]=new Employee("Петров Петр Семенович",3,150000);
        employees[2]=new Employee("Чупыров Поликарп Антонович",4,120000);
        employees[3]=new Employee("Стамескин Арнольд Трофимович",4,80000);
        employees[4]=new Employee("Поджелудочный Святослав Рувимович",2,
                250000);
        employees[5]=new Employee("Синяков Филипп Михайлович",5,40000);
        employees[6]=new Employee("Заварушкин Анисим Прохорович",1,
                130000);
        employees[7]=new Employee("Троеглазов Насим Артурович",1,100000);
        employees[8]=new Employee("Иванов Иван Иванович",5,120000);
        employees[9]=new Employee("Пауков Гаад Васильевич",3,300000);
        employees[0].setSalary(150000);
        employees[7].setNumDepart(2);
        for(Employee employee:employees){
            System.out.println(employee.getId()+" "+
                    employee.getNameFull()+" "+employee.getNumDepart()+
                    " "+employee.getSalary());
        }

    }
}