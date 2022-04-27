/**
 * 
 */
package fr.fms.entities;

import java.util.Date;

/**
 * @author Stagiaires09
 *
 */
public class Order {
	private int idOrder;
	private int idCustomer;
	private Date date;
	private double amount;
	
	
	
	/**
	 * @param idOrder
	 * @param idCustomer
	 * @param date
	 * @param amount
	 */
	public Order(int idOrder, int idCustomer, Date date, double amount) {
		setIdOrder(idOrder);
		setIdCustomer(idCustomer);
		setDate(date);
		setAmount(amount);
		
	}
	/**
	 * @param idCustomer
	 * @param date
	 * @param amount
	 */
	public Order(int idCustomer, Date date, double amount) {
		setIdCustomer(idCustomer);
		setDate(date);
		setAmount(amount);
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
	 * @return the idCustomer
	 */
	public int getIdCustomer() {
		return idCustomer;
	}
	/**
	 * @param idCustomer the idCustomer to set
	 */
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
