/**
 * 
 */
package part01;

import java.util.ArrayList;

/**
 * @author Fiona Beattie
 *
 */
public class BookTester {

	public static void main(String[] args) {
		Book b1 = new Book("The Hunger Games", "Suzanne Collins", "140713208", BookType.FICTION, 1,
				"First in the ground-breaking HUNGER GAMES trilogy", 8.90);
		Book b2 = new Book("Java, the Complete Reference", "Herbert Schildt", "126046341", BookType.REFERENCE, 12,
				"The definitive guide to Java programming", 32.20);
		// ArrayList declaration & addition of instances
		ArrayList<Book> data = new ArrayList<Book>();
		data.add(b1);
		data.add(b2);

		System.out.println(b1);
		System.out.println(b2);
		
		System.out.println("Testing displaySummary");
		System.out.println("1. When books are available in the list ...");
		displaySummary(data); // should display all books
		System.out.println("2. When list is null ...");
		displaySummary(null); // null Array List
		System.out.println("3. When list is empty ...");
		displaySummary(new ArrayList<Book>()); // an empty Array List
	}

	public static void displaySummary(ArrayList<Book> books) {
		if (books == null || books.size() == 0) {
			System.out.println("No Books Available.");
		} else {
			for (Book bk : books) {
				System.out.println(bk.getTitle() + ", " + bk.getSummary());
			}
		}
	}
}
