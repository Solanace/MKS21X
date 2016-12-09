public class Driver {
    public static void main(String[] args) {
        Barcode a = new Barcode("11423");
	Barcode b = new Barcode("81442");
	Barcode c = new Barcode("00000");
	
	/*System.out.println(a);
	System.out.println(b);
	System.out.println(c);*/

	/*System.out.println(a.compareTo(b));
	System.out.println(a.compareTo(c));
	System.out.println(b.compareTo(a));
	System.out.println(b.compareTo(c));
	System.out.println(c.compareTo(a));
	System.out.println(c.compareTo(b));*/

	System.out.println(Barcode.toZip(Barcode.toCode("11423")));
    }
}
