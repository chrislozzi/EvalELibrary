/**
 * Composant d'accès aux données de la table T_Themes dans la base de données ELibrary
 * @author LOZZI - 2022
 * 
 */
package fr.fms.dao;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import fr.fms.entities.Theme;

public class ThemeDao implements Dao<Theme>{

	@Override
	public boolean create(Theme obj) {
		boolean isCreated = false;
		String str = "INSERT INTO T_Themes (IdTheme, ThemeName) VALUES (?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, obj.getIdTheme());
			ps.setString(2, obj.getThemeName());		
			if( ps.executeUpdate() == 1) isCreated = true;
		} catch (SQLException e) {
			logger.log(Level.SEVERE,"pb sql sur la création d'un livre");
		}
		return isCreated; 		
	}

	@Override
	public Theme read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Themes where IdTheme=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Theme(rs.getInt(1) , rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return null;
	}

	@Override
	public boolean update(Theme obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Theme obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Theme> readAll() {
		ArrayList<Theme> themes = new ArrayList<Theme>();
		String sql = "select * from T_Themes";
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(sql)){
				while(resultSet.next()) {
					themes.add(new Theme(resultSet.getInt(1), resultSet.getString(2)));
				}
				return themes;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
}
