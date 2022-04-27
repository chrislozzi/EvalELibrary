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
	private int idArticle;
	private int quantity;

	
	/**
	 * @param idOrder
	 * @param idArticle
	 * @param quantity
	 */
	public OrderItem(int idOrder, int idArticle, int quantity) {
		super();
		this.idOrder = idOrder;
		this.idArticle = idArticle;
		this.quantity = quantity;
	}
	/**
	 * @return the idArticle
	 */
	public int getIdArticle() {
		return idArticle;
	}
	/**
	 * @param idArticle the idArticle to set
	 */
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
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
	
	
}
