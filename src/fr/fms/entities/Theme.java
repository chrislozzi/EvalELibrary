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
	 * @param id du thème
	 * @param nom du thème
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
		@Override
		public String toString() {
			return centerString(String.valueOf(idTheme) + centerString(themeName));
		}
		/**
		 * méthode qui formate l'a faire un alignement centré d'une chaine de caractère
		 * @param chaine de caractère
		 * @return chaine de caractère centrée
		 */
		public static String centerString(String str) {
			if(str.length() >= 20) return str;
			String dest = "                    ";
			int deb = (20 - str.length())/2 ;
			String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
			return data;
		}
	
	
}
