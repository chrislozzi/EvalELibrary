package fr.fms.dao;


import fr.fms.entities.Book;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;
import fr.fms.entities.Theme;


public class DaoFactory {
	
	public static Dao<Book> getBookDao() {
		return new BookDao();		
	}
	
	public static Dao<Customer> getUserDao() {
		return new CustomerDao();
	}
	
 	public static Dao<Theme> getCategoryDao() {
 		return new ThemeDao();
 	}
 	
 	public static Dao<Order> getOrderDao() {
 		return new OrderDao();
 	}
 	
 	public static Dao<OrderItem> getOrderItemDao() {
 		return new OrderItemDao();
 	}
}
