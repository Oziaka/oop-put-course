public class ex1 {
   public static void main(String[] args) {
      Phone samsungGalaxyS10 = new Phone("Samsung", "Galaxy S10", 500);
      Phone iPhone11 = new Phone("Apple", "IPhone 10", 1000, 3, 64);
   }
}

class Phone {
   String mark;
   //   in z`
   int price;
   String model;
   int ramCapacity;
   int memoryCapacity;

   public Phone(String mark, String model, int price) {
      this.mark = mark;
      this.price = price;
      this.model = model;
   }

   public Phone(String mark, int price, String model, int ramCapacity, int memoryCapacity) {
      this.mark = mark;
      this.price = price;
      this.model = model;
      this.ramCapacity = ramCapacity;
      this.memoryCapacity = memoryCapacity;
   }
}
