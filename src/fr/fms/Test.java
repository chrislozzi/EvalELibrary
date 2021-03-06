/**
 * 
 */
package fr.fms;


import java.util.Date;
import java.util.Scanner;

import fr.fms.dao.BookDao;
import fr.fms.dao.CustomerDao;
import fr.fms.dao.OrderDao;
import fr.fms.dao.OrderItemDao;
import fr.fms.dao.ThemeDao;
import fr.fms.entities.Book;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;
import fr.fms.entities.Theme;

/**
 * @author Lozzi 2022
 *
 */
public class Test {

	public static void main(String[] args) {
		

/*******************************************************************************************************/
/**											Test CustomerDao									      **/
/*******************************************************************************************************/			
		//Affichage de tous les utilisateurs
		
//		 new CustomerDao().readAll().forEach(customer -> { System.out.println(customer) ;});
		 
		
		//Créer un utilisateur
//		new CustomerDao().create(new Customer("246","Chris","Laotsi","chris.laotsi@vert.efr",
//											  "4 rue de la pie qui boit, Saint Malot","7953125"));
		
		//Affichage d'un utilisateur
//		System.out.println(new CustomerDao().read(3));
		
/*******************************************************************************************************/
/**											Test BookDao										      **/
/*******************************************************************************************************/	
		//affichage de tous les livres
//		new BookDao().readAll().forEach(book -> {			
//			System.out.println(book)
//			;});
		
		
		//Affichage d'un livre
		//System.out.println(new BookDao().read(10));
		
		
		//Création d'un livre en base
		//new BookDao().create( new Book("Tintin au Tibet","Herge",25.00));
		
		
		//Mise à jour d'un livre
//		Book book = new BookDao().read(10);
//		book.setTitle("L ame du mal");
//		new BookDao().update(book);
		

		//Suppression d'un livre de la base
//		new BookDao().delete(new BookDao().read(11));
//		System.out.println(new BookDao().read(11));
		
		//Affichage de tous les livres d'un thème
//		new BookDao().readAllByThemeId(10).forEach(book -> {			
//			System.out.println(book)
//			;});
		
/*******************************************************************************************************/
/**											Test ThemeDao										      **/
/*******************************************************************************************************/
		//affichage de tous les thèmes
//		System.out.println(Theme.centerString("Id des thèmes") + Theme.centerString("Nom des thèmes"));
//		new ThemeDao().readAll().forEach(theme -> {			
//			System.out.println(theme)
//			;});
		
		//Affiche un thème
//		System.out.println(new ThemeDao().read(1));
		
		
		
/*******************************************************************************************************/
/**											Test ThemeItemDao									      **/
/*******************************************************************************************************/
		//Affichage de tous les livres d'un thème
//		new BookDao().readAllByThemeId(10).forEach(book -> {			
//			System.out.println(book)
//			;});
		
/*******************************************************************************************************/
/**											Test OrderDao   									      **/
/*******************************************************************************************************/		
		//Créer une commande
//		new OrderDao().create(new Order(1, new Date(),500.00));

		
		
/*******************************************************************************************************/
/**											Test OrderItemDao   									      **/
/*******************************************************************************************************/	
		//Créer une commande minifiée
//		new OrderItemDao().create(new OrderItem(1,1,1));
		
		
	}
	
}
