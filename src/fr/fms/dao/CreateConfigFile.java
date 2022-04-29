package fr.fms.dao;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * programme permettant de regénérer le fichier de configuration, ici paramétré pour une implémentation des drivers jdbc
 *  pour le sgbd mariadb et un compte adminisatrateur de la base ELibrairy.
 *  
 * @author Lozzi - 2022
 * 
 */
public class CreateConfigFile {
	public static void main(String[] args) {
		try (OutputStream ops = new FileOutputStream("files/config.properties")) {		
			Properties properties = new Properties();	
			properties.setProperty("db.driver", "org.mariadb.jdbc.Driver");
			properties.setProperty("db.url", "jdbc:mariadb://localhost:3306/ELibrary");
			properties.setProperty("db.login", "chrisadmin");
			properties.setProperty("db.password", "000");			
			properties.store(ops , null);
		}
		 catch (IOException io) {
	            io.printStackTrace();
		}
	}

}
