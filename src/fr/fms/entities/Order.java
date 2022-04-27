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
	private int idUser;
	private Date date;
	private double amount;
	
	/**
	 * @param idOrder
	 * @param idUser
	 * @param date
	 * @param amount
	 */
	public Order(int idOrder, int idUser, Date date, double amount) {
		this.idOrder = idOrder;
		this.idUser = idUser;
		this.date = date;
		this.amount = amount;
	}

	/**
	 * @param idUser
	 * @param date
	 * @param amount
	 */
	public Order(int idUser, Date date, double amount) {
		this.idUser = idUser;
		this.date = date;
		this.amount = amount;
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
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}
	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
