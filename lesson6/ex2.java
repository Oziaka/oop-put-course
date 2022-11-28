interface Number {
   double doubleValue();
}

public class ex2 {

   public static void main(String[] args) {
      System.out.println(new Logarithm(0, 10).doubleValue());
   }
}

class Logarithm implements Number {
   private final double base;
   private final double argument;

   public Logarithm(double inputBase, double inputArgument) {
      this.base = inputBase;
      this.argument = inputArgument;
   }

   @Override
   public double doubleValue() {
      try {
         if (base > 1 || base <= 0)
            return java.lang.Math.log(this.argument) / java.lang.Math.log(this.base);
         else
            throw new ArithmeticException();
      } catch (ArithmeticException arithmeticException) {
            throw new IllegalArgumentException("Base of algorithm must be exclusive between 0 and 1 and higher than 1");
      }
   }
}
