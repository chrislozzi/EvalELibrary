/**
 * Composant d'accès aux données de la table T_Books dans la base de données Shop
 * @author LOZZI - 2022
 * 
 */

package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import fr.fms.entities.Book;

public class BookDao implements Dao<Book> {

	
//	public boolean create(Book book) {
//		try (Statement statement = connection.createStatement()){
//			String str = "INSERT INTO T_Books (Title, Author, UnitaryPrice)"
//					+ " VALUES ('"+ book.getTitle()+"' ,'" + book.getAuthor() + "',"+ book.getUnitaryPrice() +" );";			
//			int row = statement.executeUpdate(str);
//			if(row == 1)		return true;
//		} catch (SQLException e) {
//			logger.log(Level.SEVERE,"pb sql sur la création d'un article");
//		} 		
//		return false;
//	}

	//exemple d'insertion avec preparedStatement -> évite les attaques par injection sql
	@Override
	public boolean create(Book obj) {
		boolean isCreated = false;
		String str = "INSERT INTO T_Books (Title, Author, UnitaryPrice) VALUES (?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getTitle());
			ps.setString(2, obj.getAuthor());
			ps.setDouble(3, obj.getUnitaryPrice());			
			if( ps.executeUpdate() == 1) isCreated = true;
		} catch (SQLException e) {
			logger.log(Level.SEVERE,"pb sql sur la création d'un livre");
		}
		return isCreated; 		
	}

	@Override
	public Book read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Books where IdBook=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Book( rs.getInt(1),rs.getString(2) , rs.getString(3) , rs.getDouble(4));
		} catch (SQLException e) {
			logger.log(Level.SEVERE,"pb sql lors de la lecture d'un livre");
		} 	
		return null;
	}

	@Override
	public boolean update(Book obj) {
		boolean isUpdated = false;
		String str = "UPDATE T_Books SET Title = ?, Author = ?, UnitaryPrice =? WHERE IdBook = ?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){	
			ps.setString(1, obj.getTitle());
			ps.setString(2, obj.getAuthor());
			ps.setDouble(3, obj.getUnitaryPrice());	
			ps.setInt(4, obj.getIdBook());
			if(ps.executeUpdate()==1) isUpdated = true;
			return true;
		} catch (SQLException e) {
			logger.log(Level.SEVERE,"pb sql sur la mise a jour d'un livre");
		} 	
		return isUpdated;
	}

	@Override
	public boolean delete(Book obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_Books where IdBook=" + obj.getIdBook() + ";";									
			statement.executeUpdate(str);		
			return true;
		} catch (SQLException|NullPointerException e) {
			logger.log(Level.SEVERE,"pb sql lors de la suppression d'un livre");
		} 	
		return false;
	}

	@Override
	public ArrayList<Book> readAll() {
		ArrayList<Book> articles = new ArrayList<Book>();
		String strSql = "SELECT * FROM T_Books";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int   rsIdBook = resultSet.getInt(1);
					String rsTitle = resultSet.getString(2);
					String rsAuthor = resultSet.getString(3);
					double rsUnitaryPrice = resultSet.getDouble(4);		
					articles.add((new Book(rsIdBook,rsTitle,rsAuthor,rsUnitaryPrice)));						
				}	
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE,"pb sql lors de la lecture de la liste de livres");
		}			
		return articles;
	}

	public ArrayList<Book> readAllByThemId(int id) {
		ArrayList<Book> articles = new ArrayList<Book>();
		String str = "SELECT * FROM T_Books where idTheme=" + id;		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(str)){ 			
				while(resultSet.next()) {
					int   rsIdBook = resultSet.getInt(1);
					String rsTitle = resultSet.getString(2);
					String rsAuthor = resultSet.getString(3);
					double rsUnitaryPrice = resultSet.getDouble(4);		
					articles.add((new Book(rsIdBook,rsTitle,rsAuthor,rsUnitaryPrice)));						
				}	
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE,"pb sql lors de la lecture de la liste des livres d'une catégorie");
		}			
		return articles;
	}
}
