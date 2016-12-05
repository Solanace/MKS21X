import java.util.Iterator;
import java.util.NoSuchElementException;
public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;

    //0
    //constructor make an empty superArray should make size 0, 
    //but the data capacity 10.

    public SuperArray() {
	data = new String[10];
	size = 0;
    }

    public SuperArray(int initialCapacity) {
    if (initialCapacity < 0) {
        throw new IllegalArgumentException();
    }

    data = new String[initialCapacity];
    size = 0;
    }

    public int size() {
	return size;
    }

    //1
    /**add the value n to the next available slot in the superArray.
     *this will change the size. This function should always work
     *And will resize the SuperArray if needed.*/
    public boolean add(String n) {
	if (size == data.length) {
	    grow();
	}
	data[size] = n;
	size += 1;
	return true;
    }

     //2
     /**Resize the data, by making a new array, then copying over elements, use this as your data.
    */

    private void grow() {
	String[] temp = new String[data.length * 2 + 1];
	for (int i = 0; i < data.length; i ++) {
	    temp[i] = data[i];
	}
	data = temp;
    }

    //3
    /**format the super array like this :   [ 1, 3, 6, 8, 23, 99, -4, 5] 
     *commas between... square bracket start/end and no comma at end.*/
    public String toString() {
	String str = "[ ";
	for (int i = 0; i < data.length - 1; i ++ ) {
	    if (i < size) {
		str = str + data[i];
	    }
	    if (i < size - 1) {
	    	str = str + ", ";
	    }
	}
	if (size == data.length) {
	    str = str + data[data.length-1] + "]";
	}
	else {
	    str = str + "]";
	}
	return str;
    }
    
    //4
    /**format the super array like this :   [ 1, 8, 23, 99, -4, 5, _, _, _, _]   
     *(capacity is 10, but only 6 are used)
     *commas between... square bracket start/end and no comma at end.
     *unused slots should be printed as _ (underscores) */
    public String toStringDebug(){
       	String str = "[ ";
	if (data.length == 0) {
	    str += "]";
	    return str;
	}
	for (int i = 0; i < data.length - 1; i ++ ) {
	    if (i < size) {
		str = str + data[i] + ", ";
	    }
	    else {
		str = str + "_, ";
	    }
	}
	if (size == data.length) {
	    str = str + data[data.length-1] + "]";
	}
	else {
	    str = str + "_]";
	}
	return str;
    }

    public String get(int index) {
    if (index < 0 || index >= size()) {
        throw new IndexOutOfBoundsException();
    }
	return data[index];
    }
    
    public void clear() {
	size = 0;
    }

    public boolean isEmpty() {
	if (size == 0) {
	    return true;
	}
	else {
	    return false;
	}
    }

    public String set(int index, String element) {
    if (index < 0 || index >= size()) {
        throw new IndexOutOfBoundsException();
    }
	String temp = data[index];
	data[index] = element;
	return temp;
    }

    public void add(int index, String element) {
    if (index < 0 || index > size()) {
        throw new IndexOutOfBoundsException();
    }
	if (size == data.length) {
	    grow();
	}
	for (int i = size; i > index; i -= 1) {
	    data[i] = data[i-1];
	}
	size += 1;
	data[index] = element;
    }

    public String remove(int index) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	String temp = data[index];
	for (int i = index; i < size-1; i ++) {
	    data[i] = data[i+1];
	}
	size -= 1;
	return temp;
    }

    public String[] toArray() {
	String[] a = new String[size];
	for (int i = 0; i < size; i ++) {
	    a[i] = data[i];
	}
	return a;
    }

    public int indexOf(String s) {
	for (int j = 0; j < size; j ++) {
	    if (s.equals(data[j])) {
		return j;
	    }
	}
	return -1;
    }

    public int lastIndexOf(String s) {
	for (int j = size - 1; j > -1; j -= 1) {
	    if (s.equals(data[j])) {
		return j;
	    }
	}
	return -1;
    }

    public void trimToSize() {
	String[] a = new String[size];
	for (int i = 0; i < size; i ++) {
	    a[i] = data[i];
	}
	data = a;
    }

    public Iterator<String> iterator() {
	return new SuperArrayIterator(this);
    }
}

class SuperArrayIterator implements Iterator<String> {
    private SuperArray array;
    private int element;

    public SuperArrayIterator(SuperArray array) {
	this.array = array;
	element = 0;
    }

    public boolean hasNext() {
	return element < array.size();
    }

    public String next() {
	if (hasNext()){
	    String s = array.get(element);
	    element += 1;
	    return s;
	}

	else throw new NoSuchElementException();
    }
    
    public void remove() {
	throw new UnsupportedOperationException();
    }
}
