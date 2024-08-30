package fr.isika.cda27.projet1.Annuaire_Isika.view.login;

public class Admin {
	
	private static String userName;
	private static String password;

	public Admin() {
		Admin.userName = "Admin";
		Admin.password = "admin";
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	//method to compare the value given and the values stocked in this class
	
	public static boolean validateAdmin(String usernameInput, String passwordInput) {
		if ((usernameInput.equals(userName)) && (passwordInput.equals(password))) {
			return true;
		} else {
			System.out.println("user name : " + usernameInput + " pass : " + passwordInput);
			System.err.println("invalid username or password");
			return false;
		}
	}
}
