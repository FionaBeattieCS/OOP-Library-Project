/**
 * 
 */
package part01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Fiona Beattie
 *
 */
public class QUBLibrary {

	private static Library libraryQ1 = new Library();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String options[] = { "List All Books", "List Books by Status", "Add a Book", "Remove a Book", "Borrow a Book",
				"Return a Book", "Display Ranked List", "Exit" };

		Menu sysMenu = new Menu("QUBLibrary", options);

		do {
			int choice = sysMenu.getUserChoice();
			processUserChoice(choice);
		} while (true);
	}

	/**
	 * 
	 * @param choice
	 */
	public static void processUserChoice(int choice) {

		switch (choice) {
		case 1:// List all books
			listAllBooks();
			break;
		case 2: // List books by status
			listBooksByStatus();
			break;
		case 3:// Add a Book
			addBook();
			break;
		case 4: // Remove a Book
			removeBook();
			break;
		case 5: // Borrow a Book
			borrowBook();
			break;
		case 6: // Return a Book
			returnBook();
			break;
		case 7: // Display Ranked List
			displayRankedBookList();
			break;
		case 8: // Quit
			System.out.println("Goodbye!\n");
			System.exit(1);
		default:
			System.out.println("Invalid option, please try again!\n");
		}

	}

	/**
	 * This method lists all books in the library. It calls the `list` method of the
	 * `Library` class instance `libraryQ1`. This method does not take any input
	 * parameters. It prints the list of books to the console.
	 */
	private static void listAllBooks() {
		System.out.println("\nListing All Books:");
		LibraryBook[] bookList = libraryQ1.list();
		if (bookList.length == 0) {
			System.out.println("No books in the library.\n");// output message if no books have been added
		} else {
			for (int index = 0; index < libraryQ1.list().length; index++) {
				System.out.println(libraryQ1.list()[index].toString());
			}
		}
	}

	/**
	 * This method allows the user to list books based on their status (Available,
	 * On Loan, Withdrawn). It prompts the user to enter the status and then uses a
	 * switch statement to determine which case to execute based on the input.
	 * 
	 * @param No parameters
	 * @return No return value
	 */
	private static void listBooksByStatus() {
		   // Check if there are any books in the library
	    if (libraryQ1.list().length == 0) {
	        System.out.println("Error - There are no books in the library.\n");
	        return;
	    }

		// Prompts the user to enter book status
		System.out.print("Please enter book status as (Available, On Loan, Withdrawn): ");
		String strStatus = scanner.nextLine();
		strStatus.trim(); // removes whitespace

		// Switch statement to determine which case to execute based on the input
		switch (strStatus.toUpperCase()) {
		// If input is "AVAILABLE", list all books that are available
		case "AVAILABLE":
			System.out.println("\nBooks with " + strStatus + " status:");
			for (int index = 0; index < libraryQ1.list(BookStatus.AVAILABLE).length; index++) {
				System.out.println(libraryQ1.list(BookStatus.AVAILABLE)[index].toString());
			}
			break;
		// If input is "ON LOAN", list all books that are on loan
		case "ON LOAN":
			System.out.println("\nBooks with " + strStatus + " status:");
			for (int index = 0; index < libraryQ1.list(BookStatus.ON_LOAN).length; index++) {
				System.out.println(libraryQ1.list(BookStatus.ON_LOAN)[index].toString());
			}
			break;
		// If input is "WITHDRAWN", list all books that are withdrawn
		case "WITHDRAWN":
			System.out.println("\nBooks with " + strStatus + " status:");
			for (int index = 0; index < libraryQ1.list(BookStatus.WITHDRAWN).length; index++) {
				System.out.println(libraryQ1.list(BookStatus.WITHDRAWN)[index].toString());
			}
			break;
		// If input is not recognised, print an error message
		default:
			System.out.println("Invalid status.\n");
			break;
		}
	}

	/**
	 * This method prompts the user to enter book details and creates a new
	 * LibraryBook object with the user input
	 */
	private static void addBook() {
		// Prompt the user to enter book details
		System.out.println("Enter book details below:");

		// Initialise variables for each book attribute
		String strTitle = "";
		String strAuthor = "";
		String strSummary = "";
		String strIsbn = "";
		BookType strType = null; // set strType default value to null
		int iEdition = 0;
		double dPrice = 0.0;

		// Prompt the user to enter a valid book title
		do {
			System.out.print("Title: ");
			strTitle = scanner.nextLine();
			if (strTitle.trim().isEmpty()) {
				System.out.println("Error - Title cannot be empty, try again\n");
			}
		} while (strTitle.trim().isEmpty()); // repeat until user enters a valid title

		// Prompt the user to enter a valid book author
		do {
			System.out.print("Author: ");
			strAuthor = scanner.nextLine();
			if (strAuthor.trim().isEmpty()) {
				System.out.println("Error - Author cannot be empty, try again\n");
			}
		} while (strAuthor.trim().isEmpty()); // repeat until user enters a valid author

		// Prompt the user to enter a valid ISBN of length 10 characters
		do {
			System.out.print("ISBN (10 characters): ");
			strIsbn = scanner.nextLine();
			if (strIsbn.trim().isEmpty() || strIsbn.length() != 10) {
				System.out.println("Error - ISBN must be 10 characters, try again\n");
			}
		} while (strIsbn.trim().isEmpty() || strIsbn.length() != 10); // repeat until user enters a valid ISBN

		// Prompt the user to enter a valid book type
		do {
			System.out.print("Type (FICTION, NONFICTION, REFERENCE): ");
			try {
				// Convert the user input to an enum value
				strType = BookType.valueOf(scanner.nextLine().toUpperCase());
			} catch (IllegalArgumentException ex) {
				System.out.println("Error - Invalid Book Type entered, try again\n");
			}
		} while (strType == null); // repeat until user enters a valid book type

		// Prompt the user to enter a valid book edition
		do {
			System.out.print("Edition: ");
			try {
				// get the edition of the book
				iEdition = scanner.nextInt();
				if (iEdition <= 0) {
					System.out.println("Error - Invalid Edition number entered, try again\n");
				}
			} catch (InputMismatchException ex) {
				System.out.println("Error - Invalid Book Edition entered, try again\n");
				scanner.nextLine();
			}
		} while (iEdition <= 0); // repeat until user enters a valid edition

		scanner.nextLine();// clear the scanner

		// Prompt the user to enter a valid book summary
		do {
			System.out.print("Summary: ");
			strSummary = scanner.nextLine();
			if (strSummary.trim().isEmpty()) {
				System.out.println("Error - Summary cannot be empty, try again\n");
			}
		} while (strSummary.trim().isEmpty()); // repeat until user enters a valid summary

		// Prompt the user to enter a valid book price
		do {
			System.out.print("Price: ");
			try {
				// Get the price of the book
				dPrice = scanner.nextDouble();
			} catch (Exception ex) {
				System.out.println("Error - Invalid Book Price entered, try again\n");
				scanner.nextLine();
			}
		} while (dPrice == 0.0); // repeat until user enters a valid price
		scanner.nextLine();

		// Create a new LibraryBook object with the user input
		LibraryBook tempBook = new LibraryBook(strTitle, strAuthor, strIsbn, strType, iEdition, strSummary, dPrice);

		// Attempt to add the book to the library and display a message based on the
		// result
		if (libraryQ1.add(tempBook)) {
			System.out.println("Book added successfully\n");
		} else {
			System.out.println("Error - Book not added\n");
		}
	}

	/**
	 * This method removes a book from the library by setting its status to
	 * "Withdrawn".
	 */
	private static void removeBook() {
		// Display message to inform user of their selection
		System.out.println("You have chosen to remove a book");
		
		// Prompt the user to enter the ID of the book to be removed
		int removeBookId = 0;
		while (true) {
			System.out.print("Enter ID of book to remove: ");
			try {
				removeBookId = scanner.nextInt();
				scanner.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input - please enter a number.\n");
				scanner.nextLine();
			}
		}

		// Search for the book in the library
		LibraryBook book = libraryQ1.search(removeBookId);

		// Check if the book is found or not and display an error message accordingly
		if (book == null) {
			System.out.println("Error removing book - book not found\n");
		} else if (book.getStatus() == BookStatus.WITHDRAWN || book.getStatus() == BookStatus.ON_LOAN) {
			System.out.println("Error removing book - book cannot be withdrawn\n");
		} else {
			// If the book is found and not already withdrawn, set its status to withdrawn
			book.setStatus(BookStatus.WITHDRAWN);
			System.out.println("Book removed successfully\n");
		}
	}

	/**
	 * This method allows a user to borrow a book by entering the book's ID. It
	 * calls the borrowBook() method in the Library class to handle the actual
	 * borrowing process.
	 */
	private static void borrowBook() {
		// Display message to inform user of their selection
		System.out.println("You have chosen to borrow a book");

		// Prompt the user to enter the ID of the book they want to borrow
		int borrowBookId = 0;
		while (true) {
			System.out.print("Please enter the ID of the book to borrow: ");
			try {
				borrowBookId = scanner.nextInt();
				scanner.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input - please enter a number.\n");
				scanner.nextLine();
			}
		}

		// Call the borrowBook() method in the Library class to attempt to borrow the
		// book
		boolean success = libraryQ1.borrowBook(borrowBookId);

		// If the borrowBook() method returned true, print a success message
		if (success) {
			System.out.println("Book borrowed successfully\n");
		}
		// Otherwise, print an error message indicating that the book is not available
		else {
			System.out.println("Book not available\n");
		}
	}

	/**
	 * This method handles the process of returning a book by allowing a user to
	 * return a book by entering the book's ID.
	 */
	private static void returnBook() {
		// Display message to inform user of their selection
		System.out.println("You have chosen to return a Book");

		// Read the user input for book ID
		int returnBookId = 0;
		while (true) {
			System.out.print("Enter the ID of the book to return: ");
			try {
				returnBookId = scanner.nextInt();
				scanner.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input - please enter a number.\n");
				scanner.nextLine();
			}
		}

		// Call the returnBook() method of the library to attempt returning the book
		boolean bookReturned = libraryQ1.returnBook(returnBookId);

		// Check if the book was returned successfully and display appropriate message
		if (bookReturned) {
			System.out.println("Book returned successfully\n");
		} else {
			System.out.println("Error - book cannot be returned or book not found.\n");
		}
	}

	/**
	 * This method displays a list of books sorted by their popularity rank. It
	 * first prints a header message, then retrieves an array of LibraryBook objects
	 * sorted by their number of loan counts from the libraryQ1 instance variable.
	 * If there are no books in the library, it prints a message and returns.
	 * Otherwise, it iterates over the array of LibraryBook objects, printing each
	 * book's title, author, and loan count along with its popularity rank in the
	 * list. The rank of the first book in the list is 1, and it increments by 1 for
	 * each subsequent book
	 */
	private static void displayRankedBookList() {
		System.out.println("\nDisplaying Books Listed By Rank:");
		LibraryBook[] books = libraryQ1.mostPopular();
		if (books.length == 0) {
			System.out.println("No books in library.\n");
			return;
		}
		int rank = 1;
		for (LibraryBook book : books) {
			System.out.println(rank + ". " + book.getTitle() + " by " + book.getAuthor() + " (Borrowed "
					+ book.getLoanCount() + " times)");
			rank++;
		}
		System.out.println();
	}
}
