/**
 * Composant d'accès aux données de la table T_OrederItems dans la base de données ELibrary
 * @author LOZZI - 2022
 * 
 */
package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.OrderItem;

public class OrderItemDao implements Dao<OrderItem> {

	@Override
	public boolean create(OrderItem obj) {
		String str = "INSERT INTO T_OrderItems (IdOrder, IdBook, Quantity) VALUES (?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){	
			ps.setInt(1, obj.getOrderId());
			ps.setInt(2, obj.getBookId());
			ps.setInt(3, obj.getQuantity());			
			
			ps.executeUpdate();			
			return true;
		} catch (SQLException e) {
			//e.printStackTrace();
			//logger.log(Level.SEVERE,"pb sql sur la création d'un orderItem");
			logger.severe("pb Sql :" + e);
		}
		return false;
	}

	@Override
	public OrderItem read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(OrderItem obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(OrderItem obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<OrderItem> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
