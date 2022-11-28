public class ex1 {
   public static void main(String[] args) {
      System.out.println("Min (2, 5)= " + new Math(2, 5).min());
      System.out.println("Max (10, 5)= " + new Math(10, 5).max());
      System.out.println("Avg (3, 5)= " + new Math(3, 5).avg());
   }


}

class Math {

   private final int a;
   private final int b;

   public Math(int a, int b) {
      this.a = a;
      this.b = b;
   }

   public int max() {
      return this.a > this.b ? this.a : this.b;
   }

   public int min() {
      return this.a < this.b ? this.a : this.b;
   }

   public float avg() {
      return (this.a + this.b) / 2;
   }

}
