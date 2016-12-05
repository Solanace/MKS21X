import java.util.Iterator;
public class SuperArrayIterator implements Iterator<String> {
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
    
