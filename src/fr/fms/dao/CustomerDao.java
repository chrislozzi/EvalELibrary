/**
 * Composant d'accès aux données de la table T_Customers dans la base de données Shop
 * @author El babili - 2022
 * 
 */

package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import fr.fms.entities.Customer;
import fr.fms.entities.Customer;

public class CustomerDao implements Dao<Customer> {

	@Override
	public boolean create(Customer obj) {
		String str = "INSERT INTO T_Customers (LastName,FirstName,Email,address,Phone,Password) VALUES (?,?,?,?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getEmail());
			ps.setString(2, obj.getEmail());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getPassword());			
			ps.setInt(5, obj.getPhone());			
			ps.setString(4, obj.getPassword());			
			if( ps.executeUpdate() == 1)	return true;				
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.log(Level.SEVERE,"pb sql sur la création d'un utilisateur");
		} 				
		return false;
	}

	@Override
	public Customer read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Customers where IdCustomer=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) 
				return new Customer(rs.getInt(1) , rs.getString(2) , rs.getString(3));
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.severe("pb Sql :" + e);
		} 	
		return null;
	}

	@Override
	public boolean update(Customer obj) {
		try (Statement statement = connection.createStatement()){
			String str = "UPDATE T_Customers set Login='" + obj.getLogin() +"' , " +
							                "Password='" 		+ obj.getPwd() +"' , " + " where idCustomer=" + obj.getId() + ";";			
			statement.executeUpdate(str);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 	
		return true;
	}

	@Override
	public boolean delete(Customer obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_Customer where IdCustomer=" + obj.getId() + ";";									
			statement.executeUpdate(str);		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> users = new ArrayList<Customer>();
		String strSql = "SELECT * FROM T_Customers";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsLogin = resultSet.getString(2);
					String rsPassword = resultSet.getString(3);							
					users.add((new Customer(rsId,rsLogin,rsPassword)));						
				}	
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.severe("pb Sql :" + e);
		}			
		return users;
	}
}
