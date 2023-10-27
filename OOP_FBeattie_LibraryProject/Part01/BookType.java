/**
 * 
 */
package part01;

/**
 * @author Fiona Beattie
 *
 */
public enum BookType {
	  FICTION("Stories from the imagination"), 
	   NON_FICTION("Factual, real-life experiences"), 
	   REFERENCE("Theories, Philosophies and common knowledge");
	   private String info;
	   private BookType(String str) {
	      info = str;
	   }
	   public String toString() {
	      return info;
	   }
}
