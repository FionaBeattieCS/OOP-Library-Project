/**
 * 
 */
package part01;

/**
 * @author Fiona Beattie
 *
 */
public interface iLibrary {
	public boolean borrowBook(int id);
	public boolean returnBook(int id);
	public LibraryBook[] list();
	public LibraryBook[] list(BookStatus stat);
	public LibraryBook[] mostPopular();
	public LibraryBook search(int id);
	public boolean add(LibraryBook bk);
}
