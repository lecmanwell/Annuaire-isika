package fr.isika.cda27.projet1.Annuaire_Isika.helpers;

/**
 * Classe représentant un administrateur avec des informations de connexion
 * statiques. Cette classe fournit des méthodes pour obtenir le nom
 * d'utilisateur et le mot de passe de l'administrateur, ainsi que pour valider
 * les informations de connexion fournies par l'utilisateur.
 * 
 * @author groupe1
 * @version 1.0
 */
public class Admin {

	private static String userName;
	private static String password;

	/**
	 * Constructeur de la classe. Initialise le nom d'utilisateur et le mot de passe
	 * de l'administrateur avec des valeurs par défaut.
	 */
	public Admin() {
		Admin.userName = "Admin";
		Admin.password = "admin";
	}

	// Getters de l'administrateur et password
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * Valide les informations de connexion fournies par l'utilisateur en les
	 * comparant avec les valeurs stockées.
	 * 
	 * @param usernameInput Nom d'utilisateur fourni par l'utilisateur.
	 * @param passwordInput Mot de passe fourni par l'utilisateur.
	 * @return {@code true} si le nom d'utilisateur et le mot de passe correspondent
	 *         aux valeurs stockées, {@code false} sinon.
	 */
	public static boolean validateAdmin(String usernameInput, String passwordInput) {
		if ((usernameInput.equals(userName)) && (passwordInput.equals(password))) {
			return true;
		} else {
			return false;
		}
	}
}
