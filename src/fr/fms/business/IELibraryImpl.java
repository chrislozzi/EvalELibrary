/**
 * @author Lozzi - 2022
 * classe d'implémentation de l'interface IELibrairy.class, elle contient le panier et toutes les méthodes de la couche métier 
 */

package fr.fms.business;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import fr.fms.dao.BookDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.entities.Book;
import fr.fms.entities.Theme;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;
import fr.fms.entities.Customer;

public class IELibraryImpl implements IELibrary {	
	private HashMap<Integer,Book> cart;
	private Dao<Book> bookDao = DaoFactory.getBookDao();
	private Dao<Customer> customerDao = DaoFactory.getCustomerDao();
	private Dao<Theme> themeDao = DaoFactory.getThemeDao();
	private Dao<Order> orderDao = DaoFactory.getOrderDao();
	private Dao<OrderItem> orderItemDao = DaoFactory.getOrderItemDao();

	public IELibraryImpl() {
		this.cart = new HashMap<Integer,Book>();
	}

	@Override
	public void addToCart(Book book) {
		Book bk = cart.get(book.getBookId());
		if(bk != null) {
			bk.setQuantity(bk.getQuantity() + 1);
		}
		else cart.put(book.getBookId(), book);
	}

	@Override
	public void rmFromCart(int id) {
		Book book = cart.get(id);
		if(book != null) {
			if(book.getQuantity() == 1)	cart.remove(id);
			else book.setQuantity(book.getQuantity() -1);
		}				
	}

	@Override
	public ArrayList<Book> getCart() {
		return new ArrayList<Book> (cart.values());
	}

	@Override
	public int order(int idCustomer) {	
		if(customerDao.read(idCustomer) != null) {
			double total = getTotal(); 
			Order order = new Order(idCustomer, new Date(), total);
			if(orderDao.create(order)) {	//ajout en base de la commande
				for(Book book : cart.values()) {	//ajout des commandes minifiées associées
					orderItemDao.create(new OrderItem(order.getOrderId(), book.getBookId(), book.getQuantity()));
				}
				return order.getOrderId();
			}
		}
		return 0;
	}

	
	@Override
	public ArrayList<Book> readBooks() {
		return bookDao.readAll();
	}

	
	@Override
	public ArrayList<Theme> readThemes() {
		return themeDao.readAll();
	}

	
	@Override
	public Book readOneBook(int id) {
		return bookDao.read(id);
	}
	
	@Override
	public ArrayList<Book> readBooksByThemeId(int id) {
		return ((BookDao) bookDao).readAllByThemeId(id);
	}

	/**
	 * renvoi le total de la commande en cours
	 * @return total
	 */
	public double getTotal() {
		double [] total = {0};
		cart.values().forEach((a) -> total[0] += a.getUnitaryPrice() * a.getQuantity()); 	
		return total[0];
	}

	/**
	 * méthode qui vérifie si login(email) et pwd correspondent à un utilisateur en base
	 * @param log(email)
	 * @param pwd
	 * @return id de l'utilisateur, 0 si non trouvé
	 */
	public int existCustomer(String log, String pwd) {
		for(Customer customer : customerDao.readAll())
			if(customer.getEmail().equalsIgnoreCase(log) && customer.getPassword().equals(pwd))
				return customer.getCustomerId();
		return 0;
	}
	/**
	 * méthode qui créer un utilisateur en base
	 * @param password
	 * @param lastNameString
	 * @param firstName
	 * @param email
	 * @param address
	 * @param phone
	 * @return id de l'utilisateur, 0 si non créé
	 */
	public int registerCustomer(String password, String lastNameString, String firstName, String email,String address,String phone) {
		customerDao.create(new Customer(password, lastNameString, firstName, email ,address, phone));
		return existCustomer(email, password);
	}
	/**
	 * méthode qui teste si le panier est vide
	 * @return vrai si vide, false sinon
	 */
	public boolean isCartEmpty() {
		return cart.isEmpty();
	}
	/**
	 * méthode qui vide le panier
	 */
	public void clearCart() {
		cart.clear();		
	}
	/**
	 * 
	 * @param id du thème
	 * @return le thème dont l'id correspond
	 */
	public Theme readOneTheme(int id) {
		return themeDao.read(id);
	}
}
