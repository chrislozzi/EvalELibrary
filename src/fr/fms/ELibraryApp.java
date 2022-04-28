/**
 * Application console de vente d'books permettant d'exploiter une couche métier/dao pour créer un panier en ajoutant ou retirant des books
 * puis passer commande à tout instant, cela génère une commande en base avec tous les éléments associés
 * @author El babili - 2022
 * 
 */
package fr.fms;

import java.util.Scanner;

import fr.fms.business.IELibrary;
import fr.fms.business.IELibraryImpl;
import fr.fms.entities.Book;
import fr.fms.entities.Theme;

public class ELibraryApp {
	private static Scanner scan = new Scanner(System.in); 
	private static IELibraryImpl myLibrary = new IELibraryImpl();
	
	private static int idCustomer = 0;
	private static String login = null; 

	public static void main(String[] args) {
		System.out.println("Bonjour et bienvenu dans ma boutique, voici la liste d'books en stock\n");
		displayBooks();
		int choice = 0;
		while(choice != 8) {
			displayMenu();
			choice = scanInt();
			switch(choice) {
			case 1 : addBook();				
			break;					
			case 2 : remBook();
			break;					
			case 3 : displayCart(true);
			break;					
			case 4 : displayBooks();
			break;						
			case 5 : displayThemes();
			break;
			case 6 : displayBooksByThemeId();
			break;
			case 7 : connection();
			break;
			case 8 : System.out.println("à bientôt dans notre boutique :)");
			break;					
			default : System.out.println("veuillez saisir une valeur entre 1 et 8");
			}
		}
	}

	public static void displayMenu() {	
		if(login != null)	System.out.print("Compte : " + login);
		System.out.println("\n" + "Pour réaliser une action, tapez le code correspondant");
		System.out.println("1 : Ajouter un livre au panier");
		System.out.println("2 : Retirer un livre du panier");
		System.out.println("3 : Afficher le contenu de mon panier, le total et passer commande");
		System.out.println("4 : Afficher tous les livres en stock");
		System.out.println("5 : Afficher tous les thèmes");
		System.out.println("6 : Afficher tous les livres d'un thème");
		System.out.println("7 : Connexion à votre compte");
		System.out.println("8 : sortir de l'application");
	}

	public static void displayBooks() { 		
		String titles = Book.centerString("IDENTIFIANT") + Book.centerString("TITRE") + Book.centerString("AUTEUR") + Book.centerString("PRIX");
		System.out.println(titles);
		myLibrary.readBooks().forEach(System.out::println);
	}

	private static void displayBooksByThemeId() {
		System.out.println("saisissez l'id du thème concerné");
		int id = scanInt();
		Theme theme = myLibrary.readOneTheme(id);
		if(theme != null) {
			System.out.println("Thème : " + theme.getThemeName());
			String titles = Book.centerString("IDENTIFIANT") + Book.centerString("TITRE") + Book.centerString("AUTEUR") + Book.centerString("PRIX");
			System.out.println(titles);
			myLibrary.readBooksByThemeId(id).forEach(System.out::println);
		}
		else System.out.println("ce thème n'existe pas !");
	}

	private static void displayThemes() {
		String titles = Theme.centerString("IDENTIFIANT") + Theme.centerString("NOM");
		System.out.println(titles);
		myLibrary.readThemes().forEach(System.out::println);		
	}

	public static void remBook() {
		System.out.println("Selectionner l'id du livre à supprimer du panier");
		int id = scanInt();
		myLibrary.rmFromCart(id);
		displayCart(false);
	}

	public static void addBook() {
		System.out.println("Selectionner l'id du livre à ajouter au panier");
		int id = scanInt();
		Book book = myLibrary.readOneBook(id);
		if(book != null) {
			myLibrary.addToCart(book);
			displayCart(false);
		}
		else System.out.println("le livre que vous souhaitez ajouter n'existe pas, pb de saisi id");
	} 
/**
 * 
 * @param flag
 */
	private static void displayCart(boolean flag) {
		if(myLibrary.isCartEmpty()) 	System.out.println("PANIER VIDE");
		else {
			System.out.println("CONTENU DU PANIER :");
			String titles = Book.centerString("IDENTIFIANT") + Book.centerString("DESCRIPTION") + 
					Book.centerString("MARQUE") + Book.centerString("PRIX") + Book.centerString("QUANTITE");
			System.out.println(titles);
			myLibrary.getCart().forEach(a -> System.out.println(a.toString() + Book.centerString(String.valueOf(a.getQuantity()))));
			if(flag) {
				System.out.println("MONTANT TOTAL : " + myLibrary.getTotal());
				System.out.println("Souhaitez vous passer commande ? Oui/Non :");
				if(scan.next().equalsIgnoreCase("Oui")) {
					if(login == null)	{ 
						System.out.println("Vous devez être connecté pour continuer");
						connection();
					}
					if(login != null) {
						int idOrder = myLibrary.order(idCustomer);
						if(idOrder == 0)	System.out.println("pb lors du passage de commande");
						else {
							System.out.println("Votre commande a bien été validé, voici son numéro : " + idOrder);
							myLibrary.clearCart();
						}
					}
				}
			}
		}
	}
	
	
	private static void connection() {
		if(login != null)	System.out.println("vous êtes déjà connecté");
		else {
			System.out.println("saisissez votre login(email) : ");
			String log = scan.next();
			System.out.println("saisissez votre password : ");
			String pwd = scan.next();

			int id = myLibrary.existCustomer(log,pwd);
			if(id > 0)	{
				login = log;
				idCustomer = id;
			}
			else System.out.println("login ou password incorrect");
		}
	}

	public static int scanInt() {
		while(!scan.hasNextInt()) {
			System.out.println("saisissez une valeur entière svp");
			scan.next();
		}
		return scan.nextInt();
	}
}
