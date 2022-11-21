package pl;

import java.math.BigDecimal;
import java.util.HashMap;

interface Currency {
   Currency addedCurrency(float value, String currency);

   Currency subtractedCurrency(float value, String currency);

   String abbreviation();

   String symbol();

   String balance();

   float toDollarExchangeRate();
}

public class ex1 {
   public static void main(String[] args) {
      Currency euro = new Euro();
      System.out.println(euro.balance());

      Currency euro2 = new Euro(20000.1);
      System.out.println(euro2.addedCurrency(2000, "USD").balance());
   }
}

class Euro implements Currency {
   public static final String symbol = "€";
   private final FakeCantor fakeCantor;
   private final BigDecimal balance;
   private final String abbreviation = "EUR";

   public Euro() {
      this.balance = BigDecimal.ZERO;
      this.fakeCantor = new FakeCantor();
   }

   public Euro(BigDecimal balance) {
      this.balance = balance;
      this.fakeCantor = new FakeCantor();
   }

   public Euro(float balance) {
      this.balance = BigDecimal.valueOf(balance);
      this.fakeCantor = new FakeCantor();
   }

   public Euro(double balance) {
      this.balance = BigDecimal.valueOf(balance);
      this.fakeCantor = new FakeCantor();
   }

   public Euro(int balance) {
      this.balance = BigDecimal.valueOf(balance);
      this.fakeCantor = new FakeCantor();
   }

   public Euro(long balance) {
      this.balance = BigDecimal.valueOf(balance);
      this.fakeCantor = new FakeCantor();
   }

   @Override
   public Currency addedCurrency(float value, String currency) {
      float euroToRate = fakeCantor.euroToRate(currency);
      return new Euro(this.balance.add(BigDecimal.valueOf(value * euroToRate)));
   }

   @Override
   public Currency subtractedCurrency(float value, String currency) {
      float euroToRate = fakeCantor.euroToRate(currency);
      return new Euro(this.balance.subtract(BigDecimal.valueOf(value * euroToRate)));

   }

   @Override
   public String abbreviation() {
      return abbreviation;
   }

   @Override
   public String symbol() {
      return symbol;
   }

   @Override
   public String balance() {
      return balance.toString();
   }

   @Override
   public float toDollarExchangeRate() {
      return fakeCantor.euroToRate("USD");
   }
}

class FakeCantor {
   private final HashMap<String, Float> rates = new HashMap<>() {{
      put("USD", 1.0366f);
      put("GBP", 0.87063f);
      put("CHF", 0.9881f);
      put("JPY", 145.12f);
   }};

   public float euroToRate(String currency) {
      return this.rates.get(currency);
   }

}

