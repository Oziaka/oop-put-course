import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

enum Gender {
   MALE, FEMALE

}

public class ex1 {
   public static void main(String[] args) {
      //Create example employee
      Employee employee = new Employee("Daniel", "Dawid", "Nowak", Gender.MALE, BigDecimal.ZERO, (byte) 30, BigDecimal.valueOf(1000L));
      Employee employee2 = new Employee("Piotr", "Kowalski", Gender.MALE, BigDecimal.ZERO, (byte) 30, BigDecimal.valueOf(2000L));
      List<Employee> employess = Arrays.asList(employee, employee2);

      //Create example employer
      Employer employer = new Employer("Jan", "Madzierski", Gender.MALE, BigDecimal.valueOf(10000L), (byte) 40, BigDecimal.valueOf(3000L));

      Firm firm = new Firm("Microsoft", employess, employer);
   }
}

abstract class Person {
   private final String firstName;
   private final String secondName;
   private final String lastName;
   private final Gender gender;
   private final BigDecimal balance;
   private final byte age;

   public Person(String firstName, String secondName, String lastName, Gender gender, BigDecimal balance, byte age) {
      this.firstName = firstName;
      this.secondName = secondName;
      this.lastName = lastName;
      this.gender = gender;
      this.balance = balance;
      this.age = age;
   }
}

class Employee extends Person {
   private final BigDecimal salary;

   public Employee(String firstName, String secondName, String lastName, Gender gender, BigDecimal balance, byte age, BigDecimal salary) {
      super(firstName, secondName, lastName, gender, balance, age);
      this.salary = salary;
   }

   public Employee(String firstName, String lastName, Gender gender, BigDecimal balance, byte age, BigDecimal salary) {
      super(firstName, null, lastName, gender, balance, age);
      this.salary = salary;
   }


}

class Employer extends Person {

   private final BigDecimal salary;

   public Employer(String firstName, String secondName, String lastName, Gender gender, BigDecimal balance, byte age, BigDecimal salary) {
      super(firstName, secondName, lastName, gender, balance, age);
      this.salary = salary;
   }

   public Employer(String firstName, String lastName, Gender gender, BigDecimal balance, byte age, BigDecimal salary) {
      super(firstName, null, lastName, gender, balance, age);
      this.salary = salary;
   }

}

class Firm {
   private final String name;
   private final List<Employee> employees;
   private Employer employerImpl;

   public Firm(String name, List<Employee> employees, Employer employerImpl) {
      this.name = name;
      this.employees = employees;
      this.employerImpl = employerImpl;
   }

}
