/**
 * 
 */
package fr.fms.entities;

/**
 * @author Stagiaires09
 *
 */
public class Theme {
	private int idTheme;
	private String themeName;
	
	/**
	 * @param idTheme
	 * @param themeName
	 */
	public Theme(int idTheme, String themeName) {
		setIdTheme(idTheme);
		setThemeName(themeName);
	}
	/**
	 * @return the idTheme
	 */
	public int getIdTheme() {
		return idTheme;
	}
	/**
	 * @param idTheme the idTheme to set
	 */
	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}
	/**
	 * @return the themeName
	 */
	public String getThemeName() {
		return themeName;
	}
	/**
	 * @param themeName the themeName to set
	 */
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	
	
}
