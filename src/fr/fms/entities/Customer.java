/**
 * 
 */
package fr.fms.entities;

/**
 * @author Lozzi 2002
 *
 */
public class Customer {
	private int customerId;
	private String password;
	private String lastName;
	private String firstName;
	private String email;
	private String address;
	private String phone;
	/**
	 * @param customerId
	 * @param password
	 * @param lastName
	 * @param firstName
	 * @param email
	 * @param address
	 * @param phone
	 */
	public Customer(int customerId, String password, String lastName, String firstName, String email, String address,String phone) {
		setCustomerId(customerId);
		setPassword(password);
		setLastName(lastName);
		setFirstName(firstName);
		setEmail(email);
		setAddress(address);
		setPhone(phone);
	}
	
	/**
	 * @param password
	 * @param lastName
	 * @param firstName
	 * @param email
	 * @param address
	 * @param phone
	 */
	public Customer(String password, String lastName, String firstName, String email, String address, String phone) {
		setPassword(password);
		setLastName(lastName);
		setFirstName(firstName);
		setEmail(email);
		setAddress(address);
		setPhone(phone);
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return centerString(String.valueOf(customerId)) + centerString(password) + centerString(lastName) 
			 + centerString(email) + centerString(address)+ centerString(phone);
	}
	
	public static String centerString(String str) {
		if(str.length() >= 20) return str;
		String dest = "                    ";
		int deb = (20 - str.length())/2 ;
		String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
		return data;
	}
}
