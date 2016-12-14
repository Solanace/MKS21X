public class Driver {
    public static void main(String[] args) {
	System.out.println(Sorts.name());
	int[] ary = {10, 9, 8, 7, 6, 5, -4, 3, 2, 1, 0};
	
	System.out.print("[");
	for (int i = 0; i < ary.length; i ++) {
	    System.out.print(ary[i]);
	    System.out.print(", ");
	}
	System.out.println("]");
	
	Sorts.insertionSort(ary);
        System.out.print("[");
	for (int i = 0; i < ary.length; i ++) {
	    System.out.print(ary[i]);
	    System.out.print(", ");
	}
	System.out.println("]");
    }
}
