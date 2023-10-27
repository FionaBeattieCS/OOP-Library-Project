/**
 * 
 */
package part03;

import java.awt.Color;
import java.awt.Font;
import console.Console;
import java.util.InputMismatchException;

import javax.swing.ImageIcon;

import part01.BookStatus;
import part01.BookType;
import part01.Library;
import part01.LibraryBook;

/**
 * @author Fiona Beattie
 *
 */
public class QUBLibraryUpdated {

	private static Library libraryQ1 = new Library();

	public static void main(String[] args) {

		// This will create a new Console instance
		// - a value of 'true' enables keyboard input
		Console console = new Console(true);

		// Set the width and height for the console
		console.setSize(600, 600);

		// Make sure the console is visible to the user
		console.setVisible(true);

		// You can modify the Font and Colour
		console.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		console.setColour(Color.blue);

		String options[] = { "List All Books", "List Books by Status", "Add a Book", "Remove a Book", "Borrow a Book",
				"Return a Book", "Display Ranked List", "Exit" };

		Menu sysMenu = new Menu("QUBLibrary", options, console);

		do {
			int choice = sysMenu.getUserChoice();
			processUserChoice(choice, console);
		} while (true);
	}

	/**
	 *
	 * @param choice
	 */
	public static void processUserChoice(int choice, Console console) {

		switch (choice) {
		case 1:// List all books
			listAllBooks(console);
			break;
		case 2: // List books by status
			listBooksByStatus(console);
			break;
		case 3:// Add a Book
			addBook(console);
			break;
		case 4: // Remove a Book
			removeBook(console);
			break;
		case 5: // Borrow a Book
			borrowBook(console);
			break;
		case 6: // Return a Book
			returnBook(console);
			break;
		case 7: // Display Ranked List
			displayRankedBookList(console);
			break;
		case 8: // Quit
			console.println("Goodbye!\n");
			System.exit(1);
		default:
			console.setColour(Color.RED); // set font colour to red
			console.println("Invalid option, please try again!\n");
			console.setColour(Color.BLUE); // set colour back to blue
		}

	}

	/**
	 * This method lists all books in the library. It calls the `list` method of the
	 * `Library` class instance `libraryQ1`. This method does not take any input
	 * parameters. It prints the list of books to the console.
	 * 
	 * @param console
	 */
	private static void listAllBooks(Console console) {
		console.setColour(Color.MAGENTA); //set colour to magenta
		console.println("\nListing All Books:");
		LibraryBook[] books = libraryQ1.list();
		if (books.length == 0) {
			console.setColour(Color.RED); // set font colour to red
			console.println("There are no books in the library.\n");
		} else {
			for (int index = 0; index < books.length; index++) {
				console.print(books[index].toString() + "\n");
				console.println(libraryQ1.list()[index].getImage());
			}
		}
		console.setColour(Color.BLUE); // set colour back to blue
	}

	/**
	 * This method allows the user to list books based on their status (Available,
	 * On Loan, Withdrawn). It prompts the user to enter the status and then uses a
	 * switch statement to determine which case to execute based on the input.
	 * 
	 * @param console
	 *
	 */
	private static void listBooksByStatus(Console console) {
		if (console == null) {
			System.err.println("Console not available.\n");
			System.exit(1);
		}

		// Check if there are any books in the library
		if (libraryQ1.list().length == 0) {
			console.setColour(Color.RED);
			console.println("Error - There are no books in the library.\n");
			console.setColour(Color.BLUE);
			return;
		}

		// Prompts the user to enter book status
		console.print("Please enter book status as (Available, On Loan, Withdrawn): ");
		String strStatus = console.readLn();
		strStatus.trim(); // removes whitespace

		// Switch statement to determine which case to execute based on the input
		switch (strStatus.toUpperCase()) {
		// If input is "AVAILABLE", list all books that are available
		case "AVAILABLE":
			console.println("\nBooks with " + strStatus + " status:");
			for (int index = 0; index < libraryQ1.list(BookStatus.AVAILABLE).length; index++) {
				console.println(libraryQ1.list(BookStatus.AVAILABLE)[index].toString());
			}
			break;
		// If input is "ON LOAN", list all books that are on loan
		case "ON LOAN":
			console.println("\nBooks with " + strStatus + " status:");
			for (int index = 0; index < libraryQ1.list(BookStatus.ON_LOAN).length; index++) {
				console.println(libraryQ1.list(BookStatus.ON_LOAN)[index].toString());
			}
			break;
		// If input is "WITHDRAWN", list all books that are withdrawn
		case "WITHDRAWN":
			console.println("\nBooks with " + strStatus + " status:");
			for (int index = 0; index < libraryQ1.list(BookStatus.WITHDRAWN).length; index++) {
				console.println(libraryQ1.list(BookStatus.WITHDRAWN)[index].toString());
			}
			break;
		// If the input is not one of the above, print an error message
		default:
			console.setColour(Color.RED); // set font colour to red
			console.println("Invalid status, please try again!\n");
			console.setColour(Color.BLUE); // set colour back to blue
		}
	}

	/**
	 * This method prompts the user to enter book details and creates a new
	 * LibraryBook object with the user input
	 * 
	 * @param console
	 */
	private static void addBook(Console console) {

		if (console == null) {
			System.err.println("No console.\n");
			System.exit(1);
		}
		// Prompt the user to enter book details
		console.println("Enter book details below:");

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
			console.print("Title: ");
			strTitle = console.readLn();
			if (strTitle.trim().isEmpty()) {
				console.setColour(Color.RED); // set font to red
				console.println("Error - Title cannot be empty, try again\n");
				console.setColour(Color.BLUE); // set back to blue
			}
		} while (strTitle.trim().isEmpty()); // repeat until user enters a valid title

		// Prompt the user to enter a valid book author
		do {
			console.print("Author: ");
			strAuthor = console.readLn();
			if (strAuthor.trim().isEmpty()) {
				console.setColour(Color.RED); // set font to red
				console.println("Error - Author cannot be empty, try again\n");
				console.setColour(Color.BLUE); // set back to blue
			}
		} while (strAuthor.trim().isEmpty()); // repeat until user enters a valid author

		// Prompt the user to enter a valid ISBN of length 10 characters
		do {
			console.print("ISBN (10 characters): ");
			strIsbn = console.readLn();
			if (strIsbn.trim().isEmpty() || strIsbn.length() != 10) {
				console.setColour(Color.RED); // set font to red
				console.println("Error - ISBN must be 10 characters, try again\n");
				console.setColour(Color.BLUE); // set back to blue
			}
		} while (strIsbn.trim().isEmpty() || strIsbn.length() != 10); // repeat until user enters a valid ISBN

		// Prompt the user to enter a valid book type
		do {
			console.print("Type (FICTION, NONFICTION, REFERENCE): ");
			try {
				// Convert the user input to an enum value
				strType = BookType.valueOf(console.readLn().toUpperCase());
			} catch (IllegalArgumentException ex) {
				console.setColour(Color.RED); // set font to red
				console.println("Error - Invalid Book Type entered, try again\n");
				console.setColour(Color.BLUE); // set back to blue
			}
		} while (strType == null); // repeat until user enters a valid book type

		// Prompt the user to enter a valid book edition
		do {
			console.print("Edition: ");
			try {
				// get the edition of the book
				iEdition = Integer.parseInt(console.readLn());
				if (iEdition <= 0) {
					console.setColour(Color.RED); // set font to red
					console.println("Error - Invalid Book Edition entered, try again\n");
					console.setColour(Color.BLUE); // set back to blue
				}
			} catch (NumberFormatException ex) {
				console.setColour(Color.RED); // set font to red
				console.println("Error - Invalid Book Edition entered, try again\n");
				console.setColour(Color.BLUE); // set back to blue
			}
		} while (iEdition <= 0);

		// Prompt the user to enter a valid book summary
		do {
			console.print("Summary: ");
			strSummary = console.readLn();
			if (strSummary.trim().isEmpty()) {
				console.setColour(Color.RED); // set font to red
				console.println("Error - Summary cannot be empty, try again\n");
				console.setColour(Color.BLUE); // set back to blue

			}
		} while (strSummary.trim().isEmpty()); // repeat until user enters a valid summary

		// Prompt the user to enter a valid book price
		do {
			console.print("Price: ");
			String strPriceInput = console.readLn();
			try {
				// get the price of the book
				dPrice = Double.parseDouble(strPriceInput);
			} catch (NumberFormatException ex) {
				console.setColour(Color.RED); // set font to red
				console.println("Error - Invalid Book Price entered, try again\n");
				console.setColour(Color.BLUE); // set back to blue
			}
		} while (dPrice < 0);
		
		int imageNumber = 0;
		
		do {

			console.print("please enter the number for the image youd like to set: ");

			for (int i = 1; i <= 10; i++) {

			console.print("image: " + i);

			console.print(new ImageIcon("Images/SampleImages/b" + i + ".jpg"));

			console.print("\n");

			}

			try {

			imageNumber = Integer.parseInt(console.readLn());

			if (imageNumber >= 1 && imageNumber <= 10) {

			break;

			} else {

			console.setColour(Color.RED);

			console.print("invalid image number");

			console.print("\n");

			console.setColour(Color.BLUE);

			}

			} catch (Exception ex) {

			console.setColour(Color.RED);

			console.print("invalid image number");

			console.print("\n");

			console.setColour(Color.BLUE);

			}

			} while (true);

		// Create a new LibraryBook object with the user input
		LibraryBook tempBook = new LibraryBook(strTitle, strAuthor, strIsbn, strType, iEdition, strSummary, dPrice);
		tempBook.setImage("Images/SampleImages/b" + imageNumber + ".jpg"); // book object
		console.print("\n");
		// Attempt to add the book to the library and display a message based on the
		// result
		if (libraryQ1.add(tempBook)) {
			console.setColour(Color.GREEN); // set colour to green
			console.println("\nBook added successfully!\n");
			console.setColour(Color.BLUE); // set colour back to blue
		} else {
			console.setColour(Color.RED); // set colour to red
			console.println("Error - Book not added\n");
			console.setColour(Color.BLUE); // set colour back to blue
		}

	}

	/**
	 * This method removes a book from the library by setting its status to
	 * "Withdrawn".
	 */
	private static void removeBook(Console console) {
		// Display message to inform user of their selection
		console.println("You have chosen to remove a book");

		// Read the user input for book ID
		int removeBookId = 0;
		while (true) {
			console.print("Enter the ID of the book to remove: ");
			try {
				removeBookId = Integer.parseInt(console.readLn());
				break;
			} catch (NumberFormatException e) {
				console.setColour(Color.RED);
				console.println("Invalid input - please enter a number.\n");
				console.setColour(Color.BLUE);
			}
		}
		// Search for the book in the library
		LibraryBook book = libraryQ1.search(removeBookId);

		// Check if the book is found or not and display an error message accordingly
		if (book == null) {
			console.setColour(Color.RED); // set font to red
			console.println("Error removing book - book not found\n");
			console.setColour(Color.BLUE); // set back to blue

		} else if (book.getStatus() == BookStatus.WITHDRAWN || book.getStatus() == BookStatus.ON_LOAN) {
			console.setColour(Color.RED); // set font to red
			console.println("Error removing book - book cannot be withdrawn\n");
			console.setColour(Color.BLUE); // set back to blue

		} else {
			// If the book is found and not already withdrawn, set its status to withdrawn
			book.setStatus(BookStatus.WITHDRAWN);
			console.setColour(Color.GREEN); // set colour to green
			console.println("Book removed successfully\n");
			console.setColour(Color.BLUE); // set colour back to blue

		}
	}

	/**
	 * This method allows a user to borrow a book by entering the book's ID. It
	 * calls the borrowBook() method in the Library class to handle the actual
	 * borrowing process.
	 */
	private static void borrowBook(Console console) {
		// Display message to inform user of their selection
		console.println("You have chosen to borrow a book");

		// Prompt the user to enter the ID of the book they want to borrow
		console.print("Please enter the ID of the book to borrow: ");
		int borrowBookId = 0;
		while (true) {
			console.print("Please enter the ID of the book to borrow: ");
			try {
				borrowBookId = Integer.parseInt(console.readLn());
				break;
			} catch (NumberFormatException e) {
				console.setColour(Color.RED);
				console.println("Invalid input - please enter a number.\n");
				console.setColour(Color.BLUE);
			}
		}

		// Call the borrowBook() method in the Library class to attempt to borrow the
		// book
		boolean success = libraryQ1.borrowBook(borrowBookId);

		// If the borrowBook() method returned true, print a success message
		if (success) {
			console.setColour(Color.GREEN); // set colour to green
			console.println("Book borrowed successfully\n");
			console.setColour(Color.BLUE); // set colour back to blue
		}
		// Otherwise, print an error message indicating that the book is not available
		else {
			console.setColour(Color.RED); // set font to red
			console.println("Book not available\n");
			console.setColour(Color.BLUE); // set back to blue

		}
	}

	/**
	 * This method handles the process of returning a book by allowing a user to
	 * return a book by entering the book's ID.
	 */
	private static void returnBook(Console console) {
		// Display message to inform user of their selection
		console.println("You have chosen to return a Book");

		// Read the user input for book ID
		int returnBookId = 0;
		while (true) {
			console.print("Enter the ID of the book to return: ");
			try {
				returnBookId = Integer.parseInt(console.readLn());
				break;
			} catch (NumberFormatException e) {
				console.setColour(Color.RED);
				console.println("Invalid input - please enter a number.\n");
				console.setColour(Color.BLUE);
			}
		}
		// Call the returnBook() method of the library to attempt returning the book
		boolean bookReturned = libraryQ1.returnBook(returnBookId);

		// Check if the book was returned successfully and display appropriate message
		if (bookReturned) {
			console.setColour(Color.GREEN); // set colour to green
			console.println("Book returned successfully\n");
			console.setColour(Color.BLUE); // set colour back to blue
		} else {
			console.setColour(Color.RED); // set font to red
			console.println("Error - book cannot be returned or book not found\n");
			console.setColour(Color.BLUE); // set back to blue
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
	private static void displayRankedBookList(Console console) {
		console.setColour(Color.MAGENTA); // set colour to magenta
		console.println("\nDisplaying Books Listed By Rank:");
		LibraryBook[] books = libraryQ1.mostPopular();
		if (books.length == 0) {
			console.setColour(Color.RED);
			console.println("No books in library.\n");
			console.setColour(Color.BLUE);
			return;
		}
		int rank = 1;
		for (LibraryBook book : books) {
			console.println(rank + ". " + book.getTitle() + " by " + book.getAuthor() + " (Borrowed "
					+ book.getLoanCount() + " times)");
			rank++;
		}
		console.setColour(Color.BLUE); // set colour back to blue
		console.println();
	}

}
