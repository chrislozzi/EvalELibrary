/**
 * Application console de vente d'books permettant d'exploiter une couche métier/dao pour créer un panier en ajoutant ou retirant des books
 * puis passer commande à tout instant, cela génère une commande en base avec tous les éléments associés
 * @author El babili - 2022
 * 
 */
package fr.fms;



import java.util.Scanner;
import fr.fms.business.IELibraryImpl;
import fr.fms.entities.Book;
import fr.fms.entities.Theme;

public class ELibraryApp {
	private static Scanner scan = new Scanner(System.in); 
	private static IELibraryImpl myLibrary = new IELibraryImpl();
	
	private static int idCustomer = 0;
	private static String login = null; 

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
			System.out.format("|%-4d|%-30s|%-30s|%-10.2f|\n",book.getIdBook(), book.getTitle(),	book.getAuthor(), book.getUnitaryPrice())
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
			System.out.format("|%-4d|%-30s|%-30s|%-10.2f|\n",book.getIdBook(), book.getTitle(),	book.getAuthor(), book.getUnitaryPrice())
			;});

		System.out.format("%-4s%-30s%-30s%-10s \n","+----", "+------------------------------", "+------------------------------+", "----------+");
	}
	
	private static void displayThemes() {
		System.out.format("%-4s%-20s \n","+----", "+--------------------+");
		System.out.format("|%-4s|%-20s|\n","Id", "Nom");
		System.out.format("%-4s%-20s \n","+----", "+--------------------+");
		myLibrary.readThemes().forEach(theme -> {			
			System.out.format("|%-4d|%-20s|\n",theme.getIdTheme(), theme.getThemeName())
			;});
		System.out.format("%-4s%-20s \n","+----", "+--------------------+");
	}
	

	public static void remBook() {
		System.out.println("Selectionner l'id du livre à supprimer du panier");
		int id = scanInt();
		myLibrary.rmFromCart(id);
		cartMenu(false);
	}

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
 * 
 * @param flag
 */
	private static void cartMenu(boolean flag) {
		if(myLibrary.isCartEmpty()) System.out.println("*****PANIER VIDE*****");
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
	public static void displayCart() {
		System.out.format("%-4s%-30s%-30s%-10s%-8s \n","+----", "+------------------------------", "+------------------------------+", "----------+","--------+");
		System.out.format("|%-4s|%-30s|%-30s|%-10s|%-8s|\n","Id", "Titre", "Auteur", "Prix", "Quantité");
		System.out.format("%-4s%-30s%-30s%-10s%-8s \n","+----", "+------------------------------", "+------------------------------+", "----------+","--------+");

		myLibrary.getCart().forEach(article -> {			
			System.out.format("|%-4d|%-30s|%-30s|%-10.2f|%-8d|\n",article.getIdBook(), article.getTitle(), article.getAuthor(),  
					article.getUnitaryPrice(), article.getQuantity())
			;});

		System.out.format("%-4s%-30s%-30s%-10s%-8s \n","+----", "+------------------------------", "+------------------------------+", "----------+","--------+");
	}
	/**
	 * Message de bienvenue
	 */
	private static void welcome() {
		System.out.println();
		System.out.println("********************************************");
		System.out.println("    BIENVENU DANS MA LIBRAIRIE EN LIGNE     ");
		System.out.println("********************************************");		
		System.out.println();
	}
	
	private static void newCustomer() {
		if(login != null)	System.out.println("vous êtes déjà connecté");
		else {
		System.out.println("Saisissez votre mot de passe:");
		String password = scan.next();
		System.out.println("Saisissez votre Nom:");
		String lastName= scan.next();
		System.out.println("Saisissez votre prénom:");
		String firstName= scan.next();
		System.out.println("Saisissez votre email:");
		String email= scan.next();
		System.out.println("Saisissez votre address:");
		scan.nextLine();
		String address = scan.nextLine();
		System.out.println("Saisissez votre numéro de téléphone:");
		String phone= scan.next();
		
		myLibrary.registerCustomer(password, lastName, firstName, email, address, phone);
		int id = myLibrary.existCustomer(email,password);
		login = email;
		idCustomer = id;
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
