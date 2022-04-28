/**
 * @author Lozzi - 2022
 * 
 */

package fr.fms.business;

import java.util.ArrayList;
import fr.fms.entities.Book;
import fr.fms.entities.Theme;

public interface IELibrary {	
	/**
	 * méthode qui ajoute un book au panier
	 * @param book à ajouter
	 */
	public void addToCart(Book book);		
	
	/**
	 * méthode qui retire un book au panier s'il est dedans
	 * @param id de l'book à retirer
	 */
	public void rmFromCart(int id);		
	
	/**
	 * méthode qui renvoi sous la forme d'une liste tous les éléments du panier (gestion en mémoire)
	 * @return Liste d'books du panier
	 */
	public ArrayList<Book> getCart();	
	
	/**
	 * méthode qui réalise la commande en base avec l'idCustomer + total de la commande en cours + date du jour + contenu du panier :
	 * - la méthode va céer une commande en base -> idOrder + montant + date + idCustomer
	 * - puis va ajouter autant de commande minifiée associée : orderItem -> idOrderItem + idBook + Quantity + UnitaryPrice + idOrder
	 * @param idCustomer est l'identifiant du client qui est passé commande
	 * @return 1 si tout est ok 0 si pb 
	 */
	public int order(int idCustomer);		
	
	/**
	 * méthode qui renvoi tous les books de la table t_books en bdd
	 * @return Liste d'books en base
	 */
	public ArrayList<Book> readBooks();	
	
	/**
	 * méthode renvoie le livre correspondant à l'id
	 * @param id de du livre à renvoyer
	 * @return livre correspondant si trouvé, null sinon
	 */
	public Book readOneBook(int id);	
	
	/**
	 * méthode qui renvoi toutes les catégories de la table t_catégories en bdd
	 * @return Liste des thèmes en base
	 */
	public ArrayList<Theme> readThemes();
	
	/**
	 * méthode qui renvoi tous les livres d'un thème
	 * @param id du thème
	 * @return Liste d'books
	 */
	public ArrayList<Book> readBooksByThemeId(int idTheme);
}
