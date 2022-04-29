/**
 * 
 */
package fr.fms.entities;

import java.util.Date;

/**
 * @author Lozzi - 2022
 *classe servant à créer la commande -> id de la commande + id de l'utilisateur + date + montant totale de la commande
 */
public class Order {
	private int OrderId;
	private int customerId;
	private Date date;
	private double amount;
		
	/**
	 * @param id de la commande
	 * @param id de l'utilisateur
	 * @param date de la commande
	 * @param montant total de la commande
	 */
	public Order(int OrderId, int customerId, Date date, double amount) {
		setOrderId(OrderId);
		setCustomerId(customerId);
		setDate(date);
		setAmount(amount);
		
	}
	/**
	 * @param id de l'utilisateur
	 * @param date de la commande
	 * @param montant total de la commande
	 */
	public Order(int customerId, Date date, double amount) {
		setCustomerId(customerId);
		setDate(date);
		setAmount(amount);
	}
	/**
	 * @return the OrderId
	 */
	public int getOrderId() {
		return OrderId;
	}
	/**
	 * @param OrderId the OrderId to set
	 */
	public void setOrderId(int OrderId) {
		this.OrderId = OrderId;
	}
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	@Override
	public String toString() {
		return "Order [OrderId=" + OrderId + ", customerId=" + customerId + ", date=" + date + ", amount=" + amount	+ "]";
	}
	
	
}
