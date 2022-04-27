/**
 * 
 */
package fr.fms.entities;

/**
 * @author Stagiaires09
 *
 */
public class ThemeItem {
	private int bookId;
	private int themeId;
	
	
	/**
	 * @param bookId
	 * @param themeId
	 */
	public ThemeItem(int bookId, int themeId) {
		setBookId(bookId);
		setThemeId(themeId);
	}
	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the themeId
	 */
	public int getThemeId() {
		return themeId;
	}
	/**
	 * @param themeId the themeId to set
	 */
	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}
	
	
}
