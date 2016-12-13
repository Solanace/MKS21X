public class Sorts {
    public static String name() {
	return "10.Wu.Penn";
    }

    public static void selectionSort(int[] data) {
	int tempPos; // tempPos is the position of the smallest number
	int tempInt; // tempInt is the intermediary between the current index and the smallest number
	for (int index = 0; index < data.length - 1; index ++) {
	    tempPos = index;
	    for (int pos = index; pos < data.length; pos ++) {
		if (data[pos] < data[tempPos]) {
		    tempPos = pos;
		}
	    }
	    tempInt = data[index];
	    data[index] = data[tempPos];
	    data[tempPos] = tempInt;
	}
    }
}
