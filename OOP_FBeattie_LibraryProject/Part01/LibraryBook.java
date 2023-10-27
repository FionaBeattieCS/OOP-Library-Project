/**
 * 
 */
package part01;

import javax.swing.ImageIcon;

/**
 * @author Fiona Beattie
 *
 */
public class LibraryBook extends Book implements Lendable, iLibraryBook {
	private int id; // a unique identifier for a LibraryBook instance
	private static int nextId; // next usable identifier, to be used when assigning id above
	private BookStatus status; // determines the status of a book (available to borrow, on loan, book
								// withdrawn)
	private ImageIcon image; // an image of the book cover
	private int loanCount; // number of times the book has been borrowed

	/**
	 * Constructor – parameters (in order): title, author, isbn, type, edition,
	 * summary, price
	 * 
	 * @param title   - book title
	 * @param author  - book author
	 * @param isbn    - book isbn number
	 * @param type    - type of book
	 * @param edition - book edition
	 * @param summary - book summary
	 * @param price   - price of book
	 */
	public LibraryBook(String title, String author, String isbn, BookType type, int edition, String summary,
			double price) {

		super(title, author, isbn, type, edition, summary, price);
		this.id = ++nextId;
		this.status = BookStatus.AVAILABLE;
		// this.image = new ImageIcon();
		this.loanCount = 0;
	}

	/**
	 * toString – returns a String detailing all book attributes (on a single line)
	 */
	public String toString() {
		String res = "";
		res += this.getTitle() + " by " + this.getAuthor() + " ," + "ISBN: " + this.getIsbn() + " ," + "Type: "
				+ this.getType() + " ," + "Edition: " + this.getEdition() + " ," + "Summary: " + this.getSummary()
				+ " ," + "Price: " + String.format("£%.2f", this.getPrice()) + ".\n";
		return res;
	}

	/**
	 * getStatus – returns status of the book
	 * 
	 * @return
	 */
	public BookStatus getStatus() {
		return this.status;
	}

	/**
	 * setStatus – sets the status of the book
	 * 
	 * @param st
	 * @return
	 */
	public void setStatus(BookStatus st) {
		this.status = st;
	}

	/**
	 * Implements the checkout method of the Lendable interface
	 * 
	 * @return true if the book is successfully checked out, false otherwise
	 */
	@Override
	public boolean checkout() {
		if (this.status == BookStatus.AVAILABLE) {
			this.status = BookStatus.ON_LOAN;
			this.loanCount++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Implements the checkIn method of the Lendable interface
	 * 
	 * @return true if the book is successfully checked in, false otherwise
	 */
	@Override
	public boolean checkIn() {
		if (this.status == BookStatus.ON_LOAN) {
			this.status = BookStatus.AVAILABLE;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method returns the image field of the LibraryBook object as an ImageIcon
	 * object
	 * 
	 * @return
	 */
	public ImageIcon getImage() {
		return this.image;
	}

	/**
	 * This method sets the image field of the LibraryBook object to the ImageIcon
	 * object passed as a parameter and returns the same ImageIcon object.
	 * 
	 * @param icon
	 * @return
	 */
	public void setImage(String strPath) {
		this.image = new ImageIcon(strPath);
	}

	/**
	 * This method returns the loanCount field of the LibraryBook object as an
	 * integer value.
	 * 
	 * @return
	 */
	public int getLoanCount() {
		return this.loanCount;
	}

	/**
	 * This method sets the loanCount field of the LibraryBook object to the integer
	 * value passed as a parameter and returns the same integer value.
	 * 
	 * @param lCount
	 * @return
	 */
	public void setLoanCount(int lCount) {
		this.loanCount = lCount;
	}

	/**
	 * This method returns the id field of the LibraryBook object as an integer
	 * value.
	 * 
	 * @return
	 */
	public int getId() {
		return this.id;
	}

}
