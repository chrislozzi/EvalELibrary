/**
 * 
 */
package fr.fms.entities;

/**
 * @author Stagiaires09
 *
 */
public class Book {
	private int idBook ;
	private String title;
	private String author;
	private double unitaryPrice;
	
	
	/**
	 * @param idBook
	 * @param title
	 * @param author
	 * @param unitaryPrice
	 */
	public Book(int idBook, String title, String author, double unitaryPrice) {
		setIdBook(idBook);
		setTitle(title);
		setAuthor(author);
		setUnitaryPrice(unitaryPrice);
	}
	
	
	/**
	 * @param title
	 * @param author
	 * @param unitaryPrice
	 * @override
	 */
	public Book(String title, String author, double unitaryPrice) {
		setTitle(title);
		setAuthor(author);
		setUnitaryPrice(unitaryPrice);
	}


	/**
	 * @return the idBook
	 */
	public int getIdBook() {
		return idBook;
	}
	/**
	 * @param idBook the idBook to set
	 */
	public void setIdBook(int idBook) {
		this.idBook = idBook;
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


	@Override
	public String toString() {
		return centerString(String.valueOf(idBook)) + String.valueOf(centerString(title)) + String.valueOf(centerString(author)) + centerString(String.valueOf(unitaryPrice));
	}
	
	public static String centerString(String str) {
		if(str.length() >= 20) return str;
		String dest = "                    ";
		int deb = (20 - str.length())/2 ;
		String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
		return data;
	}
	
	
}
