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

    public static void insertionSort(int[] data) {
	int tempInt;
	for (int index = 1; index < data.length; index ++) {
	    for (int revIndex = index - 1; revIndex > -1; revIndex --) {
	        if (data[index] > data[revIndex] || revIndex == 0) {
		    System.out.println(index + " is greater than " + revIndex);
		}
	    }
	}
    }
}
