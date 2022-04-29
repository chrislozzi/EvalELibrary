/**
 * 
 */
package fr.fms.entities;

/**
 * @author Lozzi - 2022
 *classe servant à créer les commandes minifiées -> id de la commande + id du livre + quantité
 *
 */
public class OrderItem {
	private int orderId;
	private int bookId;
	private int quantity;

	
	/**
	 * @param id de la commande
	 * @param id du livre
	 * @param quantité
	 */
	public OrderItem(int orderId, int bookId, int quantity) {
		setOrderId(orderId);
		setIdArticle(bookId);
		setQuantity(quantity);
		
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
	public void setIdArticle(int bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
		return "OrderItem [orderId=" + orderId + ", bookId=" + bookId + ", quantity=" + quantity + "]";
	}
	
	
}
