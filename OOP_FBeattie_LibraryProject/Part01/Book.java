/**
 * 
 */
package part01;

/**
 * This is the Book class which defines the attributes and methods of a book
 * object
 * 
 * @author Fiona Beattie
 *
 */
public class Book implements iBook {
	private String title;// book title
	private String author;// book author
	private String isbn;// book isbn number
	private BookType type;// type of book
	private int edition;// book edition
	private String summary;// book summary
	private double price;// price of book

	/**
	 * Constructor for initialising the values of book attributes
	 * @param title
	 * @param author
	 * @param isbn
	 * @param bType
	 * @param edition
	 * @param summary
	 * @param price
	 */
	public Book(String title, String author, String isbn, BookType bType, int edition, String summary, double price) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.type = bType;
		this.edition = edition;
		this.summary = summary;
		this.price = price;
	}

	// Getter methods to access the private book attributes
	
	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public BookType getType() {
		return this.type;
	}

	public int getEdition() {
		return this.edition;
	}

	public String getSummary() {
		return this.summary;
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * toString() - returns a string of the book object, including
	 * its title, author, ISBN, type, edition, summary, and price. It formats the
	 * price property to two decimal places and includes a pound sign before the
	 * price.
	 */
	public String toString() {
		String res = "";
		res += this.title + " by " + this.author + "\n";
		res += "ISBN: " + this.getIsbn() + "\n";
		res += "Type: " + this.getType() + "\n";
		res += "Edition: " + this.getEdition() + "\n";
		res += "Summary: " + this.getSummary() + "\n";
		res += "Price: " + String.format("£%.2f", this.getPrice()) + "\n";
		return res;
	}
}
