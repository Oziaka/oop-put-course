import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class ex1 {
   public static void main(String[] args) {
      Language polish = new Language("Polish", "PL");
      Language english = new Language("English", "EN");

      Currency zloty = new Currency("Polski złoty", "PLN");
      Currency euro = new Currency("Euro", "€");

      Person janKowalski = new Person("Jan", "Kowlaski", (byte) 30);
      Person danielMadzierski = new Person("Daniel", "Madzierski", (byte) 22);
      Person zuzannaNowak = new Person("Zuzanna", "Nowak", (byte) 25);

      List<Person> actors = Arrays.asList(janKowalski, danielMadzierski);
      List<Person> directions = Arrays.asList(zuzannaNowak);


      Budget budget = new Budget(BigDecimal.ZERO, euro);

      Movie lotr = new Movie(actors, directions, Map.of(polish, "Władca pierścieni", english, "Lord of the Rings"), budget);
   }
}

class Movie {
   private List<Person> actors = new ArrayList<>();
   private List<Person> directions = new ArrayList<>();
   private Map<Language, String> tittle = new HashMap<Language, String>();
   private Budget budget;

   public void addActor(Person actor) {
      if (actors == null)
         this.actors = Arrays.asList(actor);
      else
         this.actors.add(actor);
   }



   public void addDirector(Person director) {
      if (director == null)
         this.actors = Arrays.asList(director);
      else
         this.actors.add(director);
   }

   public Movie(List<Person> actors, List<Person> directions, Map<Language, String> tittle, Budget budget) {
      this.actors = actors;
      this.directions = directions;
      this.tittle = tittle;
      this.budget = budget;
   }

}

class Budget {
   private BigDecimal balance;
   private Currency currency;

   public Budget(BigDecimal balance, Currency currency) {
      this.balance = balance;
      this.currency = currency;
   }
}


class Currency {
   private String name;
   private String sign;

   public Currency(String name, String sign) {
      this.name = name;
      this.sign = sign;
   }
}

class Language {
   private String name;
   private String shortcut;

   public Language(String name, String shortcut) {
      this.name = name;
      this.shortcut = shortcut;
   }
}

class Person {
   private String firstName;
   private String secondName;
   private String lastName;
   private byte age;

   public Person(String firstName, String lastName, byte age) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
   }

   public Person(String firstName, String secondName, String lastName, byte age) {
      this.firstName = firstName;
      this.secondName = secondName;
      this.lastName = lastName;
      this.age = age;
   }
}
