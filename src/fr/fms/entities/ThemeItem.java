/**
 * 
 */
package fr.fms.entities;

/**
 * @author Lozzi 2022
 *classe créant le lien entre un livre et un thème, représentée en base par une table d'association t_themeitems.
 */
public class ThemeItem {
	private int bookId;
	private int themeId;

	/**
	 * @param bookId id du livre
	 * @param themeId id du thème
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
