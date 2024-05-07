import java.util.*;
public class companyManagementApplication {
    public static List<Employee> employees = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
   while(exit){
       System.out.println("\n<------ Welcome to System ------>");
       System.out.println("1-) Save Employee");
       System.out.println("2-) Delete Employee");
       System.out.println("3-) View Employees");
       System.out.println("4-) Exit");
       int choice = scanner.nextInt();
       switch (choice){
           case 1:
               save();
               System.out.println("\nEmployee information has been successfully entered into the system.");
               break;
           case 2:
               delete();
               System.out.println("\nEmployee information has been successfully deleted into the system.");
               break;
           case 3:
               view();
               break;
           case 4:
               System.out.println("\nExit the system.... " +
                       "\nHave a good day.");
               exit = false;
               break;
           default:
               System.out.println("\nInvalid Choice");
               break;
       }
   }
   scanner.close();
    }
    public static void save(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Employee's Name: ");
        String name = scanner.nextLine();
        name = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
        System.out.print("Employee's Surname: ");
        String surname = scanner.nextLine();
        surname = surname.substring(0,1).toUpperCase()+surname.substring(1).toLowerCase();
        System.out.print("Unit: ");
        String unit = scanner.nextLine();
        unit = unit.substring(0,1).toUpperCase()+unit.substring(1).toLowerCase();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Days Off(Year): ");
        int daysOff = scanner.nextInt();
        System.out.print("Work Day(Year): ");
        int workDay = scanner.nextInt();
        Employee employee = new Employee(name, surname, salary, unit, daysOff, workDay);
        employees.add(employee);

    }
    public static void delete(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Employee's Name: ");
        String name = scanner.nextLine();
        name = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
        System.out.print("Employee's Surname: ");
        String surname = scanner.nextLine();
        surname = surname.substring(0,1).toUpperCase()+surname.substring(1).toLowerCase();
        System.out.print("Employee's Unit: ");
        String unit = scanner.nextLine();
        unit = unit.substring(0,1).toUpperCase()+unit.substring(1).toLowerCase();
        for(int i = 0; i < employees.size() ; i++){
            if(employees.get(i).getName().equalsIgnoreCase(name) && employees.get(i).getSurname().equalsIgnoreCase(surname)
            && employees.get(i).getUnit().equalsIgnoreCase(unit)){
              employees.remove(i);
            }else {
                System.out.println("Employee not found.");
            }
        }
    }
    public static  void view(){

        if(employees.isEmpty()){
            System.out.println("Employee not found.");
        }else {

            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        }
        }
    }
class Employee{
    private String name;
    private String surname;
    private double salary;
    private String unit;
    private int daysOff;
    private int workDays;
    Employee(String name, String surname, double salary, String unit, int daysOff, int workDays){
        this.name=name;
        this.surname=surname;
        this.salary=salary;
        this.unit=unit;
        this.daysOff=daysOff;
        this.workDays=workDays;
    }
    public String getName() {
        return name =name;
    }

    public String getSurname() {
        return surname;
    }

    public double getSalary() {
        return salary;
    }

    public String getUnit() {
        return unit;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public int getWorkDays() {
        return workDays;
    }
    public String toString(){
        return "\nName: " + name + "\nSurname: " + surname+ "\nSalary: " + salary + "\nUnit: "+unit +"\nDays off: " + daysOff + "\nWork Days: " + workDays;
    }
}