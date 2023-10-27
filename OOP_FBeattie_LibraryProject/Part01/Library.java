/**
 * 
 */
package part01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fiona Beattie
 *
 */
public class Library implements iLibrary {
	private ArrayList<LibraryBook> books; // (an ArrayList) – contains references to all books in the system

	/**
	 * Constructor – initialises a Library instance
	 */
	public Library() {
		books = new ArrayList<LibraryBook>();
	}

	/**
	 * borrow – a request to borrow a book identified by id
	 * 
	 * @param id
	 * @return true if book is borrowed successfully, false otherwise
	 */
	public boolean borrowBook(int id) {
		// calls the search method to search for the book with the given id
		LibraryBook book = search(id);
		// if the book exists and its status is AVAILABLE, it updates the book's status
		// to ON_LOAN, increases the loan count, and returns true
		if (book != null && book.getStatus() == BookStatus.AVAILABLE) {
			book.setStatus(BookStatus.ON_LOAN);
			book.setLoanCount(book.getLoanCount() + 1);
			return true;
		}
		// otherwise, it returns false
		return false;
	}

	/**
	 * return – a request to return a borrowed book (identified by id)
	 * 
	 * @param id
	 * @return
	 */
	public boolean returnBook(int id) {
		LibraryBook book = search(id); // search for the book by id
		if (book != null && book.getStatus() == BookStatus.ON_LOAN) { // if book is found and its status is ON_LOAN
			book.setStatus(BookStatus.AVAILABLE); // set the status of book to AVAILABLE
			return true; // return true as book is successfully returned
		}
		return false; // return false if the book is not found or its status is not ON_LOAN
	}

	/**
	 * list (no parameters) – returns an array of all library book instances
	 * 
	 * @return
	 */
	public LibraryBook[] list() {
		LibraryBook bookData[] = new LibraryBook[books.size()]; // initialise an array with size of books list
		for (int index = 0; index < books.size(); index++) { // iterate over books list
			bookData[index] = books.get(index); // add each book to the array
		}
		return bookData; // return the array of all library book instances
	}

	/**
	 * list (status) – returns an array of all library book instances but includes
	 * only books which match the supplied status
	 * 
	 * @param stat
	 * @return
	 */
	public LibraryBook[] list(BookStatus stat) {
		// Create a new ArrayList to hold the LibraryBook instances that match the
		// supplied status
		List<LibraryBook> bookHasStatus = new ArrayList<>();

		// Iterate over the existing list of LibraryBook instances
		for (LibraryBook book : books) {
			// Check if the book's status matches the supplied status and is not null
			if (book.getStatus() != null && book.getStatus() == stat) {
				// If the status matches, add the book to the list of matching books
				bookHasStatus.add(book);
			}
		}

		// Convert the ArrayList of matching books to an array and return it
		return bookHasStatus.toArray(new LibraryBook[0]);
	}

	/**
	 * mostPopular – returns an array of LibraryBook instances ordered by number of
	 * times borrowed
	 *
	 * @return an array of LibraryBook instances ordered by number of times borrowed
	 */
	public LibraryBook[] mostPopular() {
		ArrayList<LibraryBook> popularBooks = new ArrayList<>(); // create an ArrayList to store popular books
		int highestCount = 0; // initialise highest count to 0

		// loop through books list and find the highest count
		for (LibraryBook book : books) {
			int loanCount = book.getLoanCount();
			if (loanCount > highestCount) {
				highestCount = loanCount;
			}
		}

		// loop through loanCounts array and add books with highest count to
		// popularBooks list
		while (highestCount > 0) {
			for (LibraryBook book : books) {
				if (book.getLoanCount() == highestCount) {
					popularBooks.add(book);
				}
			}
			highestCount--;
		}

		LibraryBook[] mostPopularItems = new LibraryBook[popularBooks.size()]; // create an array to store most popular
		// items
		mostPopularItems = popularBooks.toArray(mostPopularItems); // convert popularBooks ArrayList to array

		bubbleSort(mostPopularItems); // sort the books array using bubble sort

		return mostPopularItems;
	}

	/**
	 * bubbleSort - sorts an array of LibraryBook instances in ascending order using
	 * bubble sort algorithm
	 *
	 * @param books the array of LibraryBook instances to be sorted
	 */
	private static void bubbleSort(LibraryBook[] books) {
		int swaps;
		do {
			swaps = 0; // Set swaps to 0 initially
			for (int i = 0; i < books.length - 1; i++) {
				if (books[i].getLoanCount() < books[i + 1].getLoanCount()) { // If current element is smaller than next
																				// element, swap them
					LibraryBook temp = books[i];
					books[i] = books[i + 1];
					books[i + 1] = temp;
					swaps++; // Increment swaps counter
				}
			}
		} while (swaps > 0); // Keep looping until no more swaps are made
	}

	/**
	 * search – returns a LibraryBook reference for id parameter or null if it does
	 * not exist
	 * 
	 * @param id the id of the book to search for
	 * @return the LibraryBook with the given id or null if it does not exist
	 */
	public LibraryBook search(int id) {
		// loop through each LibraryBook in the books array
		for (LibraryBook book : books) {
			// if the book id matches the given id parameter, return the LibraryBook
			if (book.getId() == id) {
				return book;
			}
		}
		// if the LibraryBook is not found, return null
		return null;
	}

	/**
	 * addBook – adds a LibraryBook instance to the books ArrayList if the following
	 * criteria are met: i) image is not null ii) title & author contain between 10
	 * and 100 characters iii) isbn contains exactly 10 digits (0..9) iv) edition
	 * must be 1 or above v) summary must be between 20 and 150 characters vi) price
	 * must be greater than £0.00
	 * 
	 * @param bk
	 * @return
	 */
	public boolean add(LibraryBook bk) {
		// Check if the LibraryBook meets the specified criteria
		if (// bk.getImage() != null &&
		bk.getTitle().length() >= 10 && bk.getTitle().length() <= 100 && bk.getAuthor().length() >= 10
				&& bk.getAuthor().length() <= 100 && isbnValidateNumber(bk.getIsbn()) && bk.getEdition() >= 1
				&& bk.getSummary().length() >= 20 && bk.getSummary().length() <= 150 && bk.getPrice() > 0.0) {

			// Add the book to the books ArrayList
			books.add(bk);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * isbnValidateNumber - checks if a given ISBN number is valid or not
	 * 
	 * @param number
	 * @return boolean
	 */
	private boolean isbnValidateNumber(String number) {
		boolean ok = false; // initialise boolean variable 'ok' to false
		if (number != null) { // check if ISBN 'number' is not null
			number = number.trim(); // remove leading and trailing white spaces from 'number'
			if (number.length() == 10) { // check if 'number' has a length of 10 characters
				for (int index = 0; index < number.length(); index++) { // iterate through each character of 'number'
					char ch = number.charAt(index); // get the character at current index
					if (!(ch >= '0' && ch <= '9')) { // check if the character is a digit or not
						break; // if not, break the loop
					}
				}
				ok = true; // set 'ok' to true if all characters are digits
			}
		}
		return ok; // return the value of 'ok'
	}

}
