public class Driver {
    public static void main(String[] args) {
	System.out.println(Sorts.name());
	int[] ary = {5, 1, 2, 3, 7, 5, 4, 3, -3, 3, 3};
	System.out.print("[");
	for (int i = 0; i < ary.length; i ++) {
	    System.out.print(ary[i]);
	    System.out.print(", ");
	}
	System.out.println("]");
	Sorts.selectionSort(ary);
        System.out.print("[");
	for (int i = 0; i < ary.length; i ++) {
	    System.out.print(ary[i]);
	    System.out.print(", ");
	}
	System.out.println("]");
    }
}
