package fr.fms.dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import fr.fms.entities.Book;
import fr.fms.entities.Theme;

public class ThemeDao implements Dao<Theme>{

	@Override
	public boolean create(Theme obj) {
		// TODO Auto-generated method stub
		return false;
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
