public abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;

    public LibraryBook(String a, String t, String I, String call) {
        super(a, t, I);
	callNumber = call;
    }

    public String getCallNumber() {
	return callNumber;
    }

    public void setCallNumber(String call) {
	callNumber = call;
    }

    abstract void checkout(String patron, String due);

    abstract void returned();

    abstract String circulationStatus();

    public int compareTo(LibraryBook l) {
	return callNumber.compareTo(l.getCallNumber());
    }

    public String toString() {
	return super.toString() + ", " + circulationStatus() + ", " + callNumber;
    }
}
