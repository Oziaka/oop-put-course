import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

enum Gender {
   MALE, FEMALE

}

interface Employee {

   EmployeeImpl getSalaryAsEmployee();

}

interface Employer {

   EmployerImpl takeSalaryToEmployee();

}

interface Firm {

   void paySalary();

}

public class ex1 {
   public static void main(String[] args) {
      //Create example employee
      EmployeeImpl employee = new EmployeeImpl("Daniel", "Dawid", "Nowak", Gender.MALE, BigDecimal.ZERO, (byte) 30, BigDecimal.valueOf(1000L));
      EmployeeImpl employee2 = new EmployeeImpl("Piotr", "Kowalski", Gender.MALE, BigDecimal.ZERO, (byte) 30, BigDecimal.valueOf(2000L));
      List<EmployeeImpl> employess = Arrays.asList(employee, employee2);

      //Create example Employer
      EmployerImpl employer = new EmployerImpl("Jan", "Madzierski", Gender.MALE, BigDecimal.valueOf(10000L), (byte) 40, BigDecimal.valueOf(3000L));

      FirmImpl firm = new FirmImpl("Microsoft", employess, employer);
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

   public String getFirstName() {
      return firstName;
   }

   public String getSecondName() {
      return secondName;
   }

   public String getLastName() {
      return lastName;
   }

   public Gender getGender() {
      return gender;
   }

   public BigDecimal getBalance() {
      return balance;
   }

   public byte getAge() {
      return age;
   }
}

class EmployeeImpl extends Person implements Employee {
   private final BigDecimal salary;

   public EmployeeImpl(String firstName, String secondName, String lastName, Gender gender, BigDecimal balance, byte age, BigDecimal salary) {
      super(firstName, secondName, lastName, gender, balance, age);
      this.salary = salary;
   }

   public EmployeeImpl(String firstName, String lastName, Gender gender, BigDecimal balance, byte age, BigDecimal salary) {
      super(firstName, null, lastName, gender, balance, age);
      this.salary = salary;
   }

   public EmployeeImpl getSalaryAsEmployee() {
      return new EmployeeImpl(super.getFirstName(), super.getSecondName(), super.getLastName(), super.getGender(), super.getBalance().add(salary), super.getAge(), this.salary);
   }


}

class EmployerImpl extends Person implements Employer {

   private final BigDecimal employeesSalary;

   public EmployerImpl(String firstName, String secondName, String lastName, Gender gender, BigDecimal balance, byte age, BigDecimal employeesSalary) {
      super(firstName, secondName, lastName, gender, balance, age);
      this.employeesSalary = employeesSalary;
   }

   public EmployerImpl(String firstName, String lastName, Gender gender, BigDecimal balance, byte age, BigDecimal employeesSalary) {
      super(firstName, null, lastName, gender, balance, age);
      this.employeesSalary = employeesSalary;
   }

   public EmployerImpl takeSalaryToEmployee() {
      return new EmployerImpl(super.getFirstName(), super.getSecondName(), super.getLastName(), super.getGender(), super.getBalance().subtract(employeesSalary), super.getAge(), this.employeesSalary);
   }
}

class FirmImpl {
   private final String name;
   private final List<EmployeeImpl> employeeImpls;
   private EmployerImpl employerImpl;

   public FirmImpl(String name, List<EmployeeImpl> employeeImpls, EmployerImpl employerImpl) {
      this.name = name;
      this.employeeImpls = employeeImpls;
      this.employerImpl = employerImpl;
   }

   void paySalary() {
      this.employeeImpls.replaceAll(EmployeeImpl::getSalaryAsEmployee);
      this.employerImpl = employerImpl.takeSalaryToEmployee();
   }
}
