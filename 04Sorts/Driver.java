public class Driver {
    public static void main(String[] args) {
	System.out.println(Sorts.name());
	int[] ary = {0, 1, 2, 3, 4, 5};
	
	System.out.print("[");
	for (int i = 0; i < ary.length; i ++) {
	    System.out.print(ary[i]);
	    System.out.print(", ");
	}
	System.out.println("]");
	
	Sorts.bubbleSort(ary);
        System.out.print("[");
	for (int i = 0; i < ary.length; i ++) {
	    System.out.print(ary[i]);
	    System.out.print(", ");
	}
	System.out.println("]");
    }
}
