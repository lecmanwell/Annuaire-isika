package fr.isika.cda27.projet1.Annuaire_Isika.helpers;

import java.time.LocalDate;

/**
 * Classe utilitaire pour valider divers aspects des chaînes de caractères et
 * des données dans le contexte de l'annuaire. Elle fournit des méthodes
 * statiques pour vérifier les caractères spéciaux, la validité des noms, des
 * promotions, des années et des longueurs de chaînes.
 * 
 * @author groupe1
 * @version 1.0
 */

public class Validator {

	/**
	 * Vérifie si l'une des chaînes de caractères fournies contient des caractères
	 * spéciaux (tout autre chose que des lettres et des chiffres).
	 * 
	 * @param strings Les chaînes de caractères à vérifier.
	 * @return true si l'une des chaînes contient des caractères spéciaux, false
	 *         sinon.
	 */
	public static boolean containsSpecialCharacters(String... strings) {
		for (String text : strings) {
			if (!text.matches("^[a-zA-Z0-9]+$")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Vérifie si toutes les chaînes de caractères fournies sont des noms valides.
	 * Un nom valide est constitué uniquement de lettres et peut contenir des
	 * tirets, des apostrophes et des espaces.
	 * 
	 * @param strings Les chaînes de caractères à vérifier.
	 * @return true si toutes les chaînes sont des noms valides, false sinon.
	 */
	public static boolean isValidName(String... strings) {
		for (String text : strings) {
			if (!text.matches("^[A-Za-z]+([-'][A-Za-z]+)*(\\s[A-Za-z]+([-'][A-Za-z]+)*)*$")) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Vérifie si la chaîne de caractères fournie est un nom de promotion valide. Un
	 * nom de promotion valide est constitué uniquement de lettres et de chiffres,
	 * et peut contenir des espaces.
	 * 
	 * @param string La chaîne de caractères à vérifier.
	 * @return true si la chaîne est un nom de promotion valide, false sinon.
	 */
	public static boolean isValidPromo(String string) {
		if (!string.matches("^[A-Za-z0-9]+(\\s[A-Za-z0-9]+)*$")) {
			return false;
		}
		return true;
	}

	/**
	 * Vérifie si la chaîne de caractères fournie représente une année valide. Une
	 * année valide est un nombre à 4 chiffres entre 1990 et l'année en cours.
	 * 
	 * @param text La chaîne de caractères à vérifier.
	 * @return true si la chaîne représente une année valide, false sinon.
	 */
	public static boolean isYear(String text) {
		if (!text.matches("^\\d{4}$")) {
			return false;
		}
		int year = Integer.parseInt(text);
		int currentYear = (LocalDate.now().getYear() + 1);
		if (year >= 1990 && year <= currentYear) {
			return true;
		}
		return false;
	}

	/**
	 * Vérifie si la longueur de la chaîne de caractères fournie est inférieure ou
	 * égale à la longueur maximale spécifiée.
	 * 
	 * @param string La chaîne de caractères à vérifier.
	 * @param length La longueur maximale autorisée.
	 * @return true si la longueur de la chaîne est inférieure ou égale à la
	 *         longueur maximale, false sinon.
	 */
	public static boolean maxLength(String string, int length) {
		if (string.length() <= length) {
			return true;
		}
		return false;
	}

}
