/**
 * 
 */
package fr.fms;


import fr.fms.dao.BookDao;
import fr.fms.dao.ThemeDao;
import fr.fms.entities.Book;
import fr.fms.entities.Theme;

/**
 * @author Stagiaires09
 *
 */
public class Test {
	public static void main(String[] args) {

		

/*******************************************************************************************************/
/**											Test DaoBook										      **/
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
		
/*******************************************************************************************************/
/**											Test DaoTheme										      **/
/*******************************************************************************************************/
		//affichage de tous les thèmes
//		System.out.println(Theme.centerString("Id des thèmes") + Theme.centerString("Nom des thèmes"));
//		new ThemeDao().readAll().forEach(theme -> {			
//			System.out.println(theme)
//			;});
		
		
/*******************************************************************************************************/
/**											Test DaoTheme										      **/
/*******************************************************************************************************/
		//Affichage de tous les thèmes d'un livre
		

	}
	
}
