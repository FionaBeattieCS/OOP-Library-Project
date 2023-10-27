/**
 * 
 */
package part02;

import part01.LibraryBook;
import part01.BookStatus;
import part01.BookType;
import part01.Library;

/**
 * This application tests class 'Library' from package 'part01'
 * 
 * @author Fiona Beattie
 *
 */
public class TestLibraryApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// methods to test ...

		// 1. 'add(LibraryBook)'
		testAdd();

		// 2. 'LibraryBook[] list()'
		testLibraryBookList();

		// 3. 'LibraryBookByStatus'
		testLibraryBooklistByStatus();

		// 4. 'LibraryBook search'
		testLibraryBookSearch();

		// 5. 'borrowBook()'
		testBorrowBook();

		// 6. 'returnBook()'
		testReturnBook();

		// 7. 'mostPopular()'
		testMostPopular();

	}

	private static void testAdd() {
		// consider different circumstances when 'add' should
		// work (i.e return 'true') and when it should not.

		// Test data ...
		Library libraryQ2 = new Library();
		boolean actual, expected;
		LibraryBook bk;

		// TC1 - testing 'addLibraryBook' with a 'null' parameter
		// This should result in a 'false' return value.
		System.out.println("TC1 - testing 'add(LibraryBook)' with a 'null' parameter");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		bk = null;
		expected = false;
		try {
			actual = libraryQ2.add(bk);
			System.out.println("LibraryBook : " + bk);
			System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
			if (actual == expected) {
				System.out.println("This test has PASSED.");
			} else {
				System.out.println("This test has FAILED.");
			}
		} catch (NullPointerException e) {
			System.out.println("This test has PASSED. An exception occurred: " + e);
		}
		System.out.println("End TC1\n");

		// TC2 - testing 'addLibraryBook' for a LibraryBook
		// where library book is of the correct format and does
		// not already exist in the system.
		// This should result in a 'true' return value.
		System.out.println("TC2 - testing 'add(LibraryBook)' for a correctly formatted library book, "
				+ "which does not already exist.");
		System.out.println(
				"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		bk = new LibraryBook("The Hunger Games", "Suzanne Collins", "1407132080", BookType.FICTION, 1,
				"First in the ground-breaking HUNGER GAMES trilogy", 8.90);
		expected = true;
		actual = libraryQ2.add(bk);
		System.out.println("LibraryBook : " + bk + bk.getId());
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual == expected) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC2\n");

		// TC3 - testing 'addLibraryBook' for a LibraryBook
		// where library book has an invalid title length.
		// This should result in a 'false' return value.
		System.out.println(
				"TC3 - testing 'addLibraryBook' for a LibraryBook where library book has an invalid title length.");
		System.out.println(
				"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		bk = new LibraryBook("Games", "Suzanne Collins", "1407132080", BookType.FICTION, 1,
				"First in the ground-breaking HUNGER GAMES trilogy", 8.90);
		expected = false;
		actual = libraryQ2.add(bk);
		System.out.println("LibraryBook : " + bk);
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual == expected) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC3\n");

		// TC4 - testing 'addLibraryBook' for a LibraryBook
		// where isbn number is in an incorrect format.
		// This should result in a 'false' return value.
		System.out
				.println("TC4 - testing 'add(LibraryBook' for an incorrectly formatted isbn number with a length of 9");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		bk = new LibraryBook("Java, the Complete Reference", "Herbert Schildt", "126046341", BookType.REFERENCE, 12,
				"The definitive guide to Java programming", 32.20);
		expected = false;
		actual = libraryQ2.add(bk);
		System.out.println("LibraryBook : " + bk);
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual == expected) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC4\n");

		// TC5 - testing 'addLibraryBook' for a LibraryBook
		// where isbn number is in an incorrect format.
		// This should result in a 'false' return value.
		System.out.println(
				"TC5 - testing 'add(LibraryBook' for an incorrectly formatted isbn number with a length of 11");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		bk = new LibraryBook("Java, the Complete Reference", "Herbert Schildt", "12604634111", BookType.REFERENCE, 12,
				"The definitive guide to Java programming", 32.20);
		expected = false;
		actual = libraryQ2.add(bk);
		System.out.println("LibraryBook : " + bk);
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual == expected) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC5\n");

		// TC6 - testing 'addLibraryBook' for a LibraryBook
		// where LibraryBook author has an invalid length of 9 characters
		// This should result in a 'false' return value.
		System.out.println("TC6 - testing 'add(LibraryBook' for an invalid author length of 9");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		bk = new LibraryBook("Java, the Complete Reference", "H.Schildt", "1260463410", BookType.REFERENCE, 12,
				"The definitive guide to Java programming", 32.20);
		expected = false;
		actual = libraryQ2.add(bk);
		System.out.println("LibraryBook : " + bk);
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual == expected) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC6\n");

		// TC7 - testing 'addLibraryBook' for a LibraryBook
		// where a LibraryBook cannot be added with an invalid summary length of less
		// than 20 characters
		// This should result in a 'false' return value.
		System.out.println("TC7 - testing 'add(LibraryBook' for an invalid summary length of less than 20 characters");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		bk = new LibraryBook("Java, the Complete Reference", "Herbert Schildt", "1260463410", BookType.REFERENCE, 12,
				"A guide", 32.20);
		expected = false;
		actual = libraryQ2.add(bk);
		System.out.println("LibraryBook : " + bk);
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual == expected) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC7\n");

		// TC8 - testing 'addLibraryBook' for a LibraryBook
		// where a LibraryBook cannot be added with an invalid summary where the field
		// has been left blank.
		// This should result in a 'false' return value.
		System.out.println("TC8 - testing 'add(LibraryBook' for an invalid summary field left blank");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		bk = new LibraryBook("Java, the Complete Reference", "Herbert Schildt", "1260463410", BookType.REFERENCE, 12,
				"", 32.20);
		expected = false;
		actual = libraryQ2.add(bk);
		System.out.println("LibraryBook : " + bk);
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual == expected) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC8\n");

		// TC9 - testing 'addLibraryBook' for a LibraryBook
		// where a LibraryBook cannot be added with an invalid edition number of 0
		// This should result in a 'false' return value.
		System.out.println("TC9 - testing 'add(LibraryBook' for an invalid edition number of 0");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		bk = new LibraryBook("Java, the Complete Reference", "Herbert Schildt", "1260463410", BookType.REFERENCE, 0,
				"The definitive guide to Java programming", 32.20);
		expected = false;
		actual = libraryQ2.add(bk);
		System.out.println("LibraryBook : " + bk);
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual == expected) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC9\n");

		// TC10 - testing 'addLibraryBook' for a LibraryBook
		// where a LibraryBook cannot be added with an invalid price of -1.
		// This should result in a 'false' return value.
		System.out.println("TC10 - testing 'add(LibraryBook' for an invalid price of -1");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		bk = new LibraryBook("Java, the Complete Reference", "Herbert Schildt", "1260463410", BookType.REFERENCE, 12,
				"The definitive guide to Java programming", -1);
		expected = false;
		actual = libraryQ2.add(bk);
		System.out.println("LibraryBook : " + bk);
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual == expected) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC10\n");

	}

	private static void testLibraryBookList() {
		// consider different circumstances when 'LibraryBookList' should
		// work (i.e return a LibraryBook reference) and when it should return 'null'.

		// Test data ...
		Library libraryQ2 = new Library();
		LibraryBook[] actual, expected;

		// TC11 - testing 'LibraryBook[] list()' with a 'null' parameter
		// This should result in a 'null' return value.
		System.out.println("TC11 - testing 'LibraryBook[] list()' with a 'null' parameter");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		libraryQ2 = null;
		expected = null;
		try {
			actual = libraryQ2.list();
			System.out.println("LibraryBook List : " + libraryQ2);
			System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
			if (actual == expected) {
				System.out.println("This test has PASSED.");
			} else {
				System.out.println("This test has FAILED.");
			}
		} catch (NullPointerException e) {
			System.out.println("This test has PASSED. An exception occurred: " + e);
		}
		System.out.println("End TC11\n");

		// Test data ...
		Library libraryQ3 = new Library();
		LibraryBook testBk = new LibraryBook("Java, the Complete Reference", "Herbert Schildt", "1260463410",
				BookType.REFERENCE, 12, "The definitive guide to Java programming", 32.20);
		LibraryBook testBk2 = new LibraryBook("The Hunger Games", "Suzanne Collins", "1407132080", BookType.FICTION, 1,
				"First in the ground-breaking HUNGER GAMES trilogy", 8.90);

		// TC12 - testing 'LibraryBook[] list()' for a LibraryBook that does exist.
		// This should result in all the books stored in libraryQ3 being displayed.
		System.out.println("TC12 - testing 'LibraryBook[] list()' for a list of LibraryBooks that do exist");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		libraryQ3.add(testBk);
		libraryQ3.add(testBk2);

		System.out.println("Test Listing All Books :");
		for (int index = 0; index < libraryQ3.list().length; index++) {
			System.out.println(libraryQ3.list()[index].toString());
		}
		System.out.println("End TC12\n");
	}

	private static void testLibraryBooklistByStatus() {
		// consider different circumstances when 'LibraryBookByStatus' should
		// work (i.e return a LibraryBook reference) and when it should return 'null'.

		// Test data ...
		Library libraryQ2 = new Library();
		LibraryBook[] actual, expected;
		LibraryBook book1 = new LibraryBook("The Lord of the Rings", "J.R.R. Tolkien", "0547928210", BookType.FICTION,
				2, "The classic epic fantasy novel about hobbits, wizards, and a quest to destroy a powerful ring.",
				10.99);
		LibraryBook book2 = new LibraryBook("To Kill a Mockingbird", "Harper Lee", "0060850524", BookType.FICTION, 1,
				"A novel about racial injustice in the deep south during the Great Depression.", 9.99);
		LibraryBook book3 = new LibraryBook("Ready Player One", "Ernest Cline", "0316346627", BookType.FICTION, 3,
				"A science fiction novel set in a virtual reality world.", 12.99);
		LibraryBook book4 = new LibraryBook("The Hunger Games", "Suzanne Collins", "1407132080", BookType.FICTION, 1,
				"First in the ground-breaking HUNGER GAMES trilogy", 8.90);
		LibraryBook book5 = new LibraryBook("Java, the Complete Reference", "Herbert Schildt", "1260463410",
				BookType.REFERENCE, 12, "The definitive guide to Java programming", 32.20);

		// add books to libraryQ2
		libraryQ2.add(book1);
		libraryQ2.add(book2);
		libraryQ2.add(book3);
		libraryQ2.add(book4);
		libraryQ2.add(book5);

		// set status of books
		book3.setStatus(BookStatus.ON_LOAN);
		book4.setStatus(BookStatus.ON_LOAN);
		book5.setStatus(BookStatus.WITHDRAWN);

		// TC13 - testing 'listByStatus' for a LibraryBook that is does exist and is
		// available
		// This should result in a list of books that are available stored in libraryQ2
		// being displayed.
		System.out.println(
				"TC13 - testing 'LibraryBook[] list(BookStatus stat)' for a LibraryBook that does exist and is available");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Test Listing All Available Books :");
		for (int index = 0; index < libraryQ2.list(BookStatus.AVAILABLE).length; index++) {
			System.out.println(libraryQ2.list(BookStatus.AVAILABLE)[index].toString());
		}
		System.out.println("End TC13\n");

		// TC14 - testing 'listByStatus' for a LibraryBook that does exist and is on
		// loan
		// This should result in a list of books on loan stored in libraryQ2 being
		// displayed.
		System.out.println(
				"TC14 - testing 'LibraryBook[] list(BookStatus stat)' for a LibraryBook that does exist and is on loan");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Test Listing All Books on Loan:");
		for (int index = 0; index < libraryQ2.list(BookStatus.ON_LOAN).length; index++) {
			System.out.println(libraryQ2.list(BookStatus.ON_LOAN)[index].toString());
		}
		System.out.println("End TC14\n");

		// TC15 - testing 'listByStatus' for a LibraryBook that is does exist and is
		// withdrawn
		// This should result in a list of books withdrawn stored in libraryQ2 being
		// displayed.
		System.out.println(
				"TC15 - testing 'LibraryBook[] list(BookStatus stat)' for a LibraryBook that does exist and is withdrawn");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Test Listing All Withdrawn Books:");
		for (int index = 0; index < libraryQ2.list(BookStatus.WITHDRAWN).length; index++) {
			System.out.println(libraryQ2.list(BookStatus.WITHDRAWN)[index].toString());
		}
		System.out.println("End TC15\n");

	}

	private static void testLibraryBookSearch() {
		// consider different circumstances when 'LibraryBook search' should
		// work (i.e return a LibraryBook reference) and when it should return 'null'.

		// Test data ...
		Library libraryQ2 = new Library();
		LibraryBook actual, expected;
		int idBook = 300;

		// TC16 - testing 'LibraryBook search' for a LibraryBook that does not exist.
		// This should result in a 'null' return value.
		System.out.println("TC16 - testing 'LibraryBook search' for a LibraryBook that does not exist");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		actual = libraryQ2.search(idBook);
		expected = null;

		System.out.println("Test Book id : " + idBook);
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual == expected) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC16\n");

		// TC17 - testing 'LibraryBook search' for a LibraryBook that does exist.
		// This should result in a LibraryBook reference with the correct LibraryBook id
		// number.
		System.out.println("TC17 - testing 'LibraryBook search' for a LibraryBook that does exist");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int bookId = 17;
		LibraryBook newBook = new LibraryBook("Python for Data Analysis", "Wes McKinney", "1491957662",
				BookType.REFERENCE, 2, "Data analysis tools in Python", 45.50);
		libraryQ2.add(newBook);
		expected = newBook;
		actual = libraryQ2.search(bookId);
		System.out.println("Test Book id : " + newBook.getId());
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual == expected) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC17\n");
	}

	private static void testBorrowBook() {
		// Test data ...
		Library library = new Library();
		Boolean actual, expected;
		LibraryBook book1 = new LibraryBook("The Lord of the Rings", "J.R.R. Tolkien", "0547928210", BookType.FICTION,
				2, "The classic epic fantasy novel about hobbits, wizards, and a quest to destroy a powerful ring.",
				10.99);
		LibraryBook book2 = new LibraryBook("To Kill a Mockingbird", "Harper Lee", "0060850524", BookType.FICTION, 1,
				"A novel about racial injustice in the deep south during the Great Depression.", 9.99);
		LibraryBook book3 = new LibraryBook("Ready Player One", "Ernest Cline", "0316346627", BookType.FICTION, 3,
				"A science fiction novel set in a virtual reality world.", 12.99);

		// TC18 - Test borrowing a book that is available
		// This should result in a 'true' return value.
		System.out.println("TC18 - testing 'borrowBook' for a LibraryBook that does exist and is available");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		library.add(book1);
		actual = library.borrowBook(book1.getId());
		expected = true;

		System.out.println("Test Book borrow id : " + book1.getId());
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual.equals(expected)) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC18\n");

		// TC19 - Test borrowing a book that is not available
		// This should result in a 'false' return value.
		System.out.println("TC19 - testing 'borrowBook' for a LibraryBook that does exist but is not available");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		book2.setStatus(BookStatus.ON_LOAN);
		library.add(book2);
		actual = library.borrowBook(book2.getId());
		expected = false;

		System.out.println("Test Book borrow id : " + book2.getId());
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual.equals(expected)) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC19\n");

		// TC20 - Test borrowing a book that does not exist
		// This should result in a 'null' return value.
		System.out.println("TC20 - testing 'borrowBook' for a LibraryBook that does not exist");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		LibraryBook book4 = null;
		try {
			actual = library.borrowBook(book4.getId());
			expected = false;

			System.out.println("Test Book borrow id : " + book4);
			System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
			if (actual.equals(expected)) {
				System.out.println("This test has PASSED.");
			} else {
				System.out.println("This test has FAILED.");
			}
		} catch (NullPointerException e) {
			System.out.println("This test has PASSED. An exception occurred: " + e);
		}
		System.out.println("End TC20\n");
	}

	private static void testReturnBook() {
		// Test data ...
		Library libraryQ2 = new Library();
		Boolean actual, expected;
		LibraryBook book1 = new LibraryBook("The Lord of the Rings", "J.R.R. Tolkien", "0547928210", BookType.FICTION,
				2, "The classic epic fantasy novel about hobbits, wizards, and a quest to destroy a powerful ring.",
				10.99);
		LibraryBook book2 = new LibraryBook("To Kill a Mockingbird", "Harper Lee", "0060850524", BookType.FICTION, 1,
				"A novel about racial injustice in the deep south during the Great Depression.", 9.99);
		LibraryBook book3 = new LibraryBook("Ready Player One", "Ernest Cline", "0316346627", BookType.FICTION, 3,
				"A science fiction novel set in a virtual reality world.", 12.99);

		// TC21 - testing 'returnBook' for a LibraryBook that does exist.
		// Test returning a book that is on loan and does exist.
		// This should result in a 'true' return value.
		System.out.println("TC21 - testing 'returnBook' for a LibraryBook that does exist");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		libraryQ2.add(book1);
		book1.setStatus(BookStatus.ON_LOAN);
		actual = libraryQ2.returnBook(book1.getId());
		expected = true;

		System.out.println("Test Book return id : " + book1.getId());
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual == expected) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC21\n");

		// TC22 - testing 'returnBook' for a LibraryBook that does exist.
		// Test returning a book that is not on loan and is available.
		// This should result in a 'false' return value.
		System.out.println("TC22 - testing 'returnBook' for a LibraryBook that is not on loan");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		libraryQ2.add(book2);
		actual = libraryQ2.returnBook(book2.getId());
		expected = false;

		System.out.println("Test Book return id : " + book2.getId());
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual == expected) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC22\n");

		// TC23 - testing 'returnBook' for a LibraryBook that does not exist.
		// Test returning a book that does not exist in the library.
		// This should result in a 'false' return value
		System.out.println("TC23 - testing 'returnBook' for a LibraryBook that does not exist");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		actual = libraryQ2.returnBook(123456);
		expected = false;

		System.out.println("Test Book return id : " + "123456");
		System.out.println("Expected Result:" + expected + ", Actual Result:" + actual);
		if (actual == expected) {
			System.out.println("This test has PASSED.");
		} else {
			System.out.println("This test has FAILED.");
		}
		System.out.println("End TC23\n");

	}

	private static void testMostPopular() {
		// Test data ...
		Library libraryQ3 = new Library();

		// Create some books
		LibraryBook book1 = new LibraryBook("The Lord of the Rings", "J.R.R. Tolkien", "0547928210", BookType.FICTION,
				2, "The classic epic fantasy novel about hobbits, wizards, and a quest to destroy a powerful ring.",
				10.99);
		LibraryBook book2 = new LibraryBook("To Kill a Mockingbird", "Harper Lee", "0060850524", BookType.FICTION, 1,
				"A novel about racial injustice in the deep south during the Great Depression.", 9.99);
		LibraryBook book3 = new LibraryBook("Ready Player One", "Ernest Cline", "0316346627", BookType.FICTION, 3,
				"A science fiction novel set in a virtual reality world.", 12.99);

		// Add books to the library
		libraryQ3.add(book1);
		libraryQ3.add(book2);
		libraryQ3.add(book3);

		// Set LibraryBook loan count
		book1.setLoanCount(12);
		book2.setLoanCount(8);
		book3.setLoanCount(5);

		// TC24 - testing 'mostPopular' for the most popular LibraryBooks that have
		// been borrowed.
		// This should result in a list of the most popular books that have been
		// borrowed in libraryQ3 being
		// displayed from most to least borrowed.
		System.out.println("TC24 - testing 'mostPopular' for borrowed LibraryBooks");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		LibraryBook[] mostPopularBooks = libraryQ3.mostPopular();

		System.out.println("List of most popular books (sorted in order of loan counts):");
		for (int i = 0; i < mostPopularBooks.length; i++) {
			System.out.println((i + 1) + ". " + mostPopularBooks[i].getTitle() + " by "
					+ mostPopularBooks[i].getAuthor() + " (Borrowed " + mostPopularBooks[i].getLoanCount() + " times)");
		}
		System.out.println("End TC24\n");
	}

}
