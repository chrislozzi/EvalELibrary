/**
 * @author Lozzi - 2022
 * 
 */

package fr.fms.business;

import java.util.ArrayList;
import fr.fms.entities.Book;
import fr.fms.entities.Theme;
/**
 * interface de la couche métier de l'application ELibrary
 *
 */
public interface IELibrary {	
	/**
	 * méthode qui ajoute un livre au panier
	 * @param book livre à ajouter
	 */
	public void addToCart(Book book);		
	
	/**
	 * méthode qui retire un livre du panier s'il est dedans
	 * @param id du livre à retirer
	 */
	public void rmFromCart(int id);		
	
	/**
	 * méthode qui renvoi sous la forme d'une liste tous les livres du panier (gestion en mémoire)
	 * @return Liste des livres présents dans le panier
	 */
	public ArrayList<Book> getCart();	
	
	/**
	 * méthode qui réalise la commande en base avec l'idCustomer + total de la commande en cours + date du jour + contenu du panier :
	 * - la méthode va céer une commande en base -> idOrder + amount + date + idCustomer
	 * - puis va ajouter autant de commande minifiée associée : orderItem ->  idOrder + idBook + Quantity 
	 * @param idCustomer est l'identifiant du client qui a passé commande
	 * @return 1 si la commande est créée, 0 sinon 
	 */
	public int order(int idCustomer);		
	
	/**
	 * méthode qui renvoi tous les books de la table t_books en bdd
	 * @return Liste des livres en base
	 */
	public ArrayList<Book> readBooks();	
	
	/**
	 * méthode renvoie le livre correspondant à l'id
	 * @param id de du livre à renvoyer
	 * @return livre correspondant si trouvé, null sinon
	 */
	public Book readOneBook(int id);	
	
	/**
	 * méthode qui renvoi tous les thèmes de la table t_thèmes en bdd
	 * @return Liste des thèmes en base
	 */
	public ArrayList<Theme> readThemes();
	
	/**
	 * méthode qui renvoi tous les livres d'un thème
	 * @param idTheme id du thème
	 * @return Liste de livre
	 */
	public ArrayList<Book> readBooksByThemeId(int idTheme);
}
