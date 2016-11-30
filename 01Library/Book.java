public class Book {
    private String author, title, ISBN;
    
    public Book() {
	author = "John Doe";
	title = "Lorem Ipsum";
	ISBN = "0-1-1-2-3-5-7-9";
    }

    public Book(String a, String t, String I) {
	author = a;
	title = t;
	ISBN = I;
    }

    public String getAuthor() {
	return author;
    }

    public void setAuthor(String a) {
	author = a;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String t) {
	title = t;
    }

    public String getISBN() {
	return ISBN;
    }

    public void setISBN(String I) {
	ISBN = I;
    }

    public String toString() {
	return title + ", " + author + ", " + ISBN;
    }
}
