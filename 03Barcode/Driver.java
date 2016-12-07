public class Driver {
    public static void main(String[]args) {
	Barcode a = new Barcode("41325");
	Barcode b = new Barcode("33112");
	System.out.println(a);
	System.out.println(a.compareTo(b));
    }
}
