public class Driver {
    public static void main(String[] args) {
	System.out.println(Sorts.name());
	int[] ary = {5, 1, 3, 3, 2, -55, 1, 22, -14, 4, 76, -1};
	
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
