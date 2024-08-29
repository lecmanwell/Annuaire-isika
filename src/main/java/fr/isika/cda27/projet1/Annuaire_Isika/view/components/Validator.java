package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

public class Validator {
	
	
	public static boolean containsSpace(String... strings) {
		for (String text : strings) {
			if (text.contains(" ")) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean containsNumbers(String... strings) {
		for (String text : strings) {
			if (text.matches(".*\\d.*")) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean containsSpecialCharacters(String... strings) {
	    for (String text : strings) {
	        if (!text.matches("^[a-zA-Z0-9]+$")) {
	        	return true;
	        }
	    }
	    return false; 
	}
	
//	public boolean isYear(String text) {
//		return;
//	}
//	
//	
//	public boolean maxLength() {
//		return;
//	}
	
	
	
}
