package fr.fms.dao;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import fr.fms.entities.Book;
import fr.fms.entities.Theme;
import fr.fms.entities.ThemeItem;

public class ThemeItemDao implements Dao<ThemeItem>{

	@Override
	public boolean create(ThemeItem obj) {
		boolean isCreated = false;
		String str = "INSERT INTO T_ThemeItem (IdBook, IdTheme) VALUES (?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, obj.getBookId());
			ps.setInt(2, obj.getThemeId());		
			if( ps.executeUpdate() == 1) isCreated = true;
		} catch (SQLException e) {
			logger.log(Level.SEVERE,"pb sql sur l'affectation d'un thème à un livre");
		}
		return isCreated; 		
	}

	@Override
	public ThemeItem read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(ThemeItem obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ThemeItem obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ThemeItem> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}