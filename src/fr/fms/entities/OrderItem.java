/**
 * 
 */
package fr.fms.entities;

/**
 * @author Stagiaires09
 *
 */
public class OrderItem {
	private int idOrder;
	private int idBook;
	private int quantity;

	
	/**
	 * @param idOrder
	 * @param idArticle
	 * @param quantity
	 */
	public OrderItem(int idOrder, int idBook, int quantity) {
		setIdOrder(idOrder);
		setIdArticle(idBook);
		setQuantity(quantity);
		
	}
	/**
	 * @return the idArticle
	 */
	public int getIdBook() {
		return idBook;
	}
	/**
	 * @param idArticle the idArticle to set
	 */
	public void setIdArticle(int idBook) {
		this.idBook = idBook;
	}
	/**
	 * @return the idOrder
	 */
	public int getIdOrder() {
		return idOrder;
	}
	/**
	 * @param idOrder the idOrder to set
	 */
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
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
		return "OrderItem [idOrder=" + idOrder + ", idBook=" + idBook + ", quantity=" + quantity + "]";
	}
	
	
}
