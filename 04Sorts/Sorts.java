public class Sorts {
    public static String name() {
	return "10.Wu.Penn";
    }

    public static void selectionSort(int[] data) {
	int tempPos; // temp is the position of the smallest number
	int temp;
	for (int index = 0; index < data.length - 1; index ++) {
	    tempPos = index;
	    for (int pos = index; pos < data.length; pos ++) {
		if (data[pos] < data[tempPos]) {
		    tempPos = pos;
		}
	    }
	    temp = data[index];
	    data[index] = data[tempPos];
	    data[tempPos] = temp;
	}
    }
}
