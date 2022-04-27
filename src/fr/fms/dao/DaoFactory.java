package fr.fms.dao;


import fr.fms.entities.Book;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;


public class DaoFactory {
	
	public static Dao<Book> getBookDao() {
		return new BookDao();		
	}
	
	public static Dao<User> getUserDao() {
		return new UserDao();
	}
	
 	public static Dao<Category> getCategoryDao() {
 		return new CategoryDao();
 	}
 	
 	public static Dao<Order> getOrderDao() {
 		return new OrderDao();
 	}
 	
 	public static Dao<OrderItem> getOrderItemDao() {
 		return new OrderItemDao();
 	}
}
