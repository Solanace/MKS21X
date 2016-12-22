public class Temperature {
    public static double toF(double t) {
	return t * 9/5 + 32;
    }

    public static double toC(double t) {
	return (t - 32) * 5/9;
    }

    public static void main(String[] args) {
	System.out.println(toF(-40));
	System.out.println(toF(100));
	System.out.println(toC(32));
    }
}
