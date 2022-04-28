package fr.fms.dao;


import fr.fms.entities.Book;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;
import fr.fms.entities.Theme;
import fr.fms.entities.ThemeItem;


public class DaoFactory {
	
	public static Dao<Book> getBookDao() {
		return new BookDao();		
	}
	
	public static Dao<Customer> getCustomerDao() {
		return new CustomerDao();
	}
	
 	public static Dao<Theme> getThemeDao() {
 		return new ThemeDao();
 	}
 	
 	public static Dao<ThemeItem> getThemeItemDao() {
 		return new ThemeItemDao();
 	}
 	public static Dao<Order> getOrderDao() {
 		return new OrderDao();
 	}
 	
 	public static Dao<OrderItem> getOrderItemDao() {
 		return new OrderItemDao();
 	}
}
