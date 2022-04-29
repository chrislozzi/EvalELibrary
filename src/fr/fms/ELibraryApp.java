/**
 * Application console, de vente de livres, permettant d'exploiter une couche métier/dao, pour créer un panier en ajoutant ou retirant des livres
 * puis passer commande à tout instant, cela génère une commande en base avec tous les éléments associés
 * @author Lozzi- 2022
 * @version 1.0
 */
package fr.fms;


import java.util.Scanner;
import java.util.regex.Pattern;

import fr.fms.business.IELibraryImpl;
import fr.fms.entities.Book;
import fr.fms.entities.Theme;

public class ELibraryApp {
	private static final String EMAIL_PATTERN = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z][a-z]+$";
	private static final String PHONE_PATTERN = "^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$";
	private static final String NAME_PATTERN = "\\p{L}*(-\\p{L}*)*";
	private static final String ADDRESS_PATTERN = "[0-9]{1,3}(?:(?:[,. ]?){1,2}[-a-zA-Zàâäéèêëïîôöùûüç]+)+";

	private static Scanner scan = new Scanner(System.in); 
	private static IELibraryImpl myLibrary = new IELibraryImpl();	
	private static int customerId = 0;
	private static String login = null; 

	/**
	 * méthode main qui ne gère aucun argument, elle permet d'afficher un message de bienvenue, la liste des livres et le menu principal
	 */
	public static void main(String[] args) {
		welcome();
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
			case 3 : cartMenu(true);
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

		System.out.format("%-4s%-30s%-30s%-10s \n","+----", "+------------------------------", "+------------------------------+", "----------+");
		System.out.format("|%-4s|%-30s|%-30s|%-10s|\n","Id", "Titre", "Auteur", "Prix");
		System.out.format("%-4s%-30s%-30s%-10s \n","+----", "+------------------------------", "+------------------------------+", "----------+");

		myLibrary.readBooks().forEach(book -> {			
			System.out.format("|%-4d|%-30s|%-30s|%-10.2f|\n",book.getBookId(), book.getTitle(),	book.getAuthor(), book.getUnitaryPrice())
			;});

		System.out.format("%-4s%-30s%-30s%-10s \n","+----", "+------------------------------", "+------------------------------+", "----------+");
	}

	private static void displayBooksByThemeId() {
		System.out.println("saisissez l'id du thème concerné");
		int id = scanInt();
		Theme theme = myLibrary.readOneTheme(id);
		System.out.format("%-4s%-30s%-30s%-10s \n","+----", "-------------------------------", "--------------------------------", "----------+");
		System.out.format("|%-7s%-69s|\n","THEME : ", theme.getThemeName());
		System.out.format("%-4s%-30s%-30s%-10s \n","+----", "-------------------------------", "--------------------------------", "----------+");
		System.out.format("|%-4s|%-30s|%-30s|%-10s|\n","Id", "Titre", "Auteur", "Prix");
		System.out.format("%-4s%-30s%-30s%-10s \n","+----", "+------------------------------", "+------------------------------+", "----------+");

		myLibrary.readBooksByThemeId(id) .forEach(book -> {			
			System.out.format("|%-4d|%-30s|%-30s|%-10.2f|\n",book.getBookId(), book.getTitle(),	book.getAuthor(), book.getUnitaryPrice())
			;});

		System.out.format("%-4s%-30s%-30s%-10s \n","+----", "+------------------------------", "+------------------------------+", "----------+");
	}
	/**
	 * méthode qui affiche tous les thèmes
	 */
	private static void displayThemes() {
		System.out.format("%-4s%-20s \n","+----", "+--------------------+");
		System.out.format("|%-4s|%-20s|\n","Id", "Nom");
		System.out.format("%-4s%-20s \n","+----", "+--------------------+");
		myLibrary.readThemes().forEach(theme -> {			
			System.out.format("|%-4d|%-20s|\n",theme.getIdTheme(), theme.getThemeName())
			;});
		System.out.format("%-4s%-20s \n","+----", "+--------------------+");
	}

	/**
	 * méthode qui supprime un livre du panier
	 */
	public static void remBook() {
		System.out.println("Selectionner l'id du livre à supprimer du panier");
		int id = scanInt();
		myLibrary.rmFromCart(id);
		cartMenu(false);
	}
	/**
	 * méthode qui ajoute un livre au panier
	 */
	public static void addBook() {
		System.out.println("Selectionner l'id du livre à ajouter au panier");
		int id = scanInt();
		Book book = myLibrary.readOneBook(id);
		if(book != null) {
			myLibrary.addToCart(book);
			cartMenu(false);
		}
		else System.out.println("le livre que vous souhaitez ajouter n'existe pas, pb de saisi id");
	} 
	/**
	 * méthode qui affiche le sous menu du panier, le totale et permet de passer la commande 
	 * @param flag
	 */
	private static void cartMenu(boolean flag) {
		if(myLibrary.isCartEmpty()) emptyCart();
		else {
			displayCart();
			if(flag) {
				System.out.println("MONTANT TOTAL : " + myLibrary.getTotal());
				System.out.println("Souhaitez vous passer commande ? Oui/Non :");
				if(scan.next().equalsIgnoreCase("Oui")) {
					if(login == null)	{ 						
						System.out.println("Vous devez être connecté pour continuer");
						System.out.println("1: Se connecter");
						System.out.println("2: Créer un compte");
						//A revoir ugly code
						int choix =scanInt();
						if(choix ==1)connection();
						if(choix ==2) newCustomer();							

					}
					if(login != null) {
						int orderId = myLibrary.order(customerId);
						if(orderId == 0)	System.out.println("pb lors du passage de commande");
						else {
							System.out.println("Votre commande a bien été validé, voici son numéro : " + orderId);
							myLibrary.clearCart();
						}
					}
				}
			}
		}
	}
	/**
	 * méthode qui affiche le contenu du panier
	 */
	public static void displayCart() {
		System.out.format("%-4s%-30s%-30s%-10s%-8s \n","+----", "+------------------------------", "+------------------------------+", "----------+","--------+");
		System.out.format("|%-4s|%-30s|%-30s|%-10s|%-8s|\n","Id", "Titre", "Auteur", "Prix", "Quantité");
		System.out.format("%-4s%-30s%-30s%-10s%-8s \n","+----", "+------------------------------", "+------------------------------+", "----------+","--------+");

		myLibrary.getCart().forEach(article -> {			
			System.out.format("|%-4d|%-30s|%-30s|%-10.2f|%-8d|\n",article.getBookId(), article.getTitle(), article.getAuthor(),  
					article.getUnitaryPrice(), article.getQuantity())
			;});

		System.out.format("%-4s%-30s%-30s%-10s%-8s \n","+----", "+------------------------------", "+------------------------------+", "----------+","--------+");
	}
	/**
	 * méthode qui affiche un message de bienvenue
	 */
	private static void welcome() {
		System.out.println();
		System.out.println("********************************************");
		System.out.println("    BIENVENU DANS MA LIBRAIRIE EN LIGNE     ");
		System.out.println("********************************************");		
		System.out.println();
	}

	private static void emptyCart() {
		System.out.println();
		System.out.println("********************************************");
		System.out.println("          VOTRE PANIER EST VIDE             ");
		System.out.println("********************************************");		
		System.out.println();
	}

	/**
	 * méthode qui permet à un nouvel utilisateur de s'enregistrer 
	 */
	private static void newCustomer() {
		if(login != null)	System.out.println("vous êtes déjà connecté");
		else {
			System.out.println("Saisissez votre mot de passe:");
			
			String password = scan.next();
			System.out.println("Saisissez votre Nom:");
			
			while(!Pattern.matches(NAME_PATTERN,scan.next())) 			
				System.out.println("Veuillez saisir un nom valide");
			String lastName= scan.nextLine();
			
			System.out.println("Saisissez votre prénom:");
			while(!Pattern.matches(NAME_PATTERN,scan.next())) 			
				System.out.println("Veuillez saisir un prénom valide");
			String firstName= scan.nextLine();
			
			System.out.println("Saisissez votre email:");
			while(!Pattern.matches(EMAIL_PATTERN,scan.next())) 			
				System.out.println("Veuillez saisir un email valide");			
			String email= scan.nextLine();
			
			System.out.println("Saisissez votre address:");
			scan.nextLine();
			while(!Pattern.matches(ADDRESS_PATTERN,scan.next())) 			
				System.out.println("Veuillez saisir une adresse valide");			
			String address = scan.nextLine();
			
			System.out.println("Saisissez votre numéro de téléphone:");
			while(!Pattern.matches(PHONE_PATTERN,scan.next())) 			
				System.out.println("Veuillez saisir un Nom valide");
			String phone= scan.nextLine();

			myLibrary.registerCustomer(password, lastName, firstName, email, address, phone);
			int id = myLibrary.existCustomer(email,password);
			login = email;
			customerId = id;
		}

	}

	/**
	 * méthode qui permet à un utilisateur de se connecter 
	 */
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
				customerId = id;
			}
			else System.out.println("login ou password incorrect");
		}
	}
	/**
	 * méthode qui permet le contrôle de la saisie, affiche un message si la valeur saisie n'est pas un entier
	 * @return l'entier saisie
	 */
	public static int scanInt() {

		while(!scan.hasNextInt()) {
			System.out.println("saisissez une valeur entière svp");
			scan.next();
		}
		return scan.nextInt();
	}

}
