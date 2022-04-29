/**
 * 
 */
package fr.fms.entities;

/**
 * @author Lozzi 2022
 *classe représentant un livre
 */
public class Book {
	private int bookId ;
	private String title;
	private String author;
	private double unitaryPrice;
	private int quantity=1;

	/**
	 * @param id du livre
	 * @param titre du livre
	 * @param auteur du livre
	 * @param prix du livre
	 */
	public Book(int bookId, String title, String author, double unitaryPrice) {
		setBookId(bookId);
		setTitle(title);
		setAuthor(author);
		setUnitaryPrice(unitaryPrice);
	}


	/**
	 * @param titre du livre
	 * @param auteur du livre
	 * @param prix du livre
	 * @override
	 */
	public Book(String title, String author, double unitaryPrice) {
		setTitle(title);
		setAuthor(author);
		setUnitaryPrice(unitaryPrice);
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the unitaryPrice
	 */
	public double getUnitaryPrice() {
		return unitaryPrice;
	}
	/**
	 * @param unitaryPrice the unitaryPrice to set
	 */
	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return centerString(String.valueOf(bookId)) + centerString(title) + centerString(author) + centerString(String.valueOf(unitaryPrice));
	}
	/**
	 * méthode pour faire un alignement centré d'une chaine de caractère
	 * @param chaine de caractère
	 * @return chaine de caractère centrée
	 */
	public static String centerString(String str) {
		if(str.length() >= 30) return str;
		String dest = "                              ";
		int deb = (30 - str.length())/2 ;
		String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
		return data;
	}


}
