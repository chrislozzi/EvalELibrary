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
		String str = "INSERT INTO T_Customers (Password,LastName,FirstName,Email,Address,Phone) VALUES (?,?,?,?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getPassword());	
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getFirstName());
			ps.setString(4, obj.getEmail());
			ps.setString(5, obj.getAddress());			
			ps.setString(6, obj.getPhone());			
					
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
				return new Customer(rs.getInt(1) , rs.getString(2) , rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.severe("pb Sql :" + e);
		} 	
		return null;
	}

	@Override
	public boolean update(Customer obj) {
		boolean isUpdated = false;
		String str = "UPDATE T_Customers set Password = ? ,LastName = ? ,FirstName = ? ,Email = ? ,Address = ?,Phone = ?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(6, obj.getPassword());	
			ps.setString(1, obj.getLastName());
			ps.setString(2, obj.getFirstName());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getPassword());			
			ps.setString(5, obj.getPhone());					
			if( ps.executeUpdate() == 1) isUpdated = true;			
		} catch (SQLException e) {
			e.printStackTrace();
			return isUpdated;
		} 	
		return true;
	}

	@Override
	public boolean delete(Customer obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_Customer where IdCustomer=" + obj.getCustomerId() + ";";									
			statement.executeUpdate(str);		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String strSql = "SELECT * FROM T_Customers";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsIdCustomer = resultSet.getInt(1);	
					String rsPassword = resultSet.getString(2);
					String rsLastName = resultSet.getString(3);							
					String rsFirstName = resultSet.getString(4);							
					String rsEmail = resultSet.getString(5);							
					String rsAddress = resultSet.getString(6);							
					String rsPhone = resultSet.getString(7);											
					customers.add((new Customer(rsIdCustomer,rsPassword,rsLastName,rsFirstName,rsEmail,rsAddress,rsPhone)));						
				}	
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.severe("pb Sql :" + e);
		}			
		return customers;
	}
}
