public class CirculatingBook extends LibraryBook {
    private String currentHolder, dueDate;

    public CirculatingBook(String a, String t, String I, String call) {
	super(a, t, I, call);
	currentHolder = null;
	dueDate = null;
    }

    public void checkout(String patron, String due) {
	currentHolder = patron;
	dueDate = due;
    }

    public void returned() {
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus() {
	if (currentHolder == null && dueDate == null) {
	    return "book available on shelves";
	}
	else return "checked out by " + currentHolder + " and due on " + dueDate;
    }

    public String toString() {
	if (currentHolder == null && dueDate == null) {
	    return super.toString() + ", " + currentHolder + ", " + dueDate;
	}
	else return super.toString();
    }
}
