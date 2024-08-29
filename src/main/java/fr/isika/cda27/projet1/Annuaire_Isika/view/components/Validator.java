package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import java.time.LocalDate;

public class Validator {
	
	
//	public static boolean containsSpace(String... strings) {
//		for (String text : strings) {
//			if (text.contains(" ")) {
//				return true;
//			}
//		}
//		return false;
//	}
	
//	public static boolean containsNumbers(String... strings) {
//		for (String text : strings) {
//			if (text.matches(".*\\d.*")) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	public static boolean containsSpecialCharacters(String... strings) {
	    for (String text : strings) {
	        if (!text.matches("^[a-zA-Z0-9]+$")) {
	        	return true;
	        }
	    }
	    return false; 
	}
	
	public static boolean isValidName(String... strings) {
		for (String text : strings) {
			if (!text.matches("^[A-Za-z]+([-'][A-Za-z]+)*(\\s[A-Za-z]+([-'][A-Za-z]+)*)*$")) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValidPromo(String string) {
		if(!string.matches("^[A-Za-z0-9]+(\\s[A-Za-z0-9]+)*$")) {
				return false;
			}
		return true;
	}
	
	public static boolean isYear(String text) {
	    if (!text.matches("^\\d{4}$")) {
	        return false;
	    }
	    int year = Integer.parseInt(text);
	    int currentYear = LocalDate.now().getYear();
	    if (year >= 1990 && year <= currentYear) {
	    	return true;
	    }
		return false;
	}
	
	
	public static boolean maxLength(String string, int length) {
		if (string.length() <= length) {
			return true;
		}
		return false;
	}
	
}
