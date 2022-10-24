public class ex2() {
   public static void main(String[] args) {
      UsbDevice Pendrive = new UsbDevice(true, 0.02, 3.2)
      UsbDevice usbLamp = new UsbDevice(false, 0.2, 2.0, true, false)
   }
}

class UsbDevice {
   boolean hasPlugAndPlay;
   double ampreage;
   double usbVersion;
   boolean isConnected;
   boolean isItClean;

   public void clean() {
      isItClean = true;
   }

   public void drop() {
      isItClean = false;
   }

   public void plug() {
      if (!isConnected)
         if (isItClean)
            isConnected = true;
   }

   public void unPlug() {
      isConnected = false;
   }

   public void countPowerconsumption() {
      return ampreage * 5;
   }

   public UsbDevice(boolean hasPlugAndPlay, double ampreage, double usbVersion, boolean isConnected, boolean isItClean) {
      this.hasPlugAndPlay = hasPlugAndPlay;
      this.ampreage = ampreage;
      this.usbVersion = usbVersion;
      this.isConnected = isConnected;
      this.isItClean = isItClean;
   }

   public UsbDevice(boolean hasPlugAndPlay, double ampreage, double usbVersion) {
      this.hasPlugAndPlay = hasPlugAndPlay;
      this.ampreage = ampreage;
      this.usbVersion = usbVersion;
      this.isConnected = false;
      this.isItClean = false;
   }
}
