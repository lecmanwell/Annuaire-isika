package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.util.Objects;

/**
 * La classe Student représente un étudiant avec des informations telles que le
 * nom, le prénom, la localisation, le nom de la promotion et l'année de
 * promotion. Elle implémente l'interface Comparable pour permettre la
 * comparaison des étudiants en fonction de leur nom de famille.
 * 
 * @author groupe1
 * @version 1.0
 */

public class Student implements Comparable<Student> {

	private String lastName;
	private String firstName;
	private String location;
	private String namePromo;
	private int yearPromo;

	// Constantes pour la taille des champs en nombre de caractères
	public static final int NBCHAR_LASTNAME = 30;
	public static final int NBCHAR_FIRSTNAME = 30;
	public static final int NBCHAR_LOCATION = 3;
	public static final int NBCHAR_NAMEPROMO = 12;

	// Taille totale d'un étudiant en octets
	public static final int STUDENT_SIZE_OCTET = NBCHAR_LASTNAME * 2 + NBCHAR_FIRSTNAME * 2 + NBCHAR_LOCATION * 2
			+ NBCHAR_NAMEPROMO * 2 + 4;

	/**
	 * Constructeur de la classe Student avec tous les attributs.
	 *
	 * @param lastName  Le nom de famille de l'étudiant.
	 * @param firstName Le prénom de l'étudiant.
	 * @param location  La localisation de l'étudiant.
	 * @param namePromo Le nom de la promotion de l'étudiant.
	 * @param yearPromo L'année de promotion de l'étudiant.
	 */

	public Student(String lastName, String firstName, String location, String namePromo, int yearPromo) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.location = location;
		this.namePromo = namePromo;
		this.yearPromo = yearPromo;

	}

	/**
	 * Constructeur par défaut de la classe Student.
	 */
	public Student() {
		super();
	}

	// Getters et Setters pour les attributs de la classe
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNamePromo() {
		return namePromo;
	}

	public void setNamePromo(String namePromo) {
		this.namePromo = namePromo;
	}

	public int getYearPromo() {
		return yearPromo;
	}

	public void setYearPromo(int yearPromo) {
		this.yearPromo = yearPromo;
	}

	/**
	 * Retourne une représentation sous forme de chaîne de caractères de l'objet
	 * Student.
	 *
	 * @return Une chaîne de caractères représentant l'étudiant.
	 */

	@Override
	public String toString() {
		return "Student [lastName=" + lastName + ", firstName=" + firstName + ", location=" + location + ", namePromo="
				+ namePromo + ", yearPromo=" + yearPromo + "]";
	}

	/**
	 * Calcule le code de hachage de l'objet Student basé sur ses attributs.
	 *
	 * @return Le code de hachage de l'étudiant.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, location, namePromo, yearPromo);
	}

	/**
	 * Vérifie si cet objet est égal à un autre objet.
	 *
	 * @param obj L'objet à comparer avec cet étudiant.
	 * @return true si les objets sont égaux, sinon false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(location, other.location) && Objects.equals(namePromo, other.namePromo)
				&& yearPromo == other.yearPromo;
	}

	/**
	 * Compare cet étudiant avec un autre étudiant par ordre alphabétique sur le nom
	 * de famille.
	 *
	 * @param o L'étudiant à comparer.
	 * @return Une valeur négative, zéro ou positive selon que ce nom de famille est
	 *         respectivement moins, égal ou supérieur à celui de l'autre étudiant.
	 */

	@Override
	public int compareTo(Student o) {
		return this.getLastName().compareTo(o.getLastName());
	}

	/**
	 * Fournit les attributs de l'étudiant remplis avec des espaces jusqu'à
	 * atteindre les longueurs maximales définies.
	 * 
	 * @return Une chaîne de caractères avec des espaces ajoutés jusqu'à la longueur
	 *         maximale définie pour chaque attribut.
	 */

	public String getLastNameLong() {
		String lastNameLong = this.lastName;
		for (int i = this.lastName.length(); i < NBCHAR_LASTNAME; i++) {
			lastNameLong += " ";
		}
		return lastNameLong;
	}

	public String getFirstNameLong() {
		String firstNameLong = this.firstName;
		for (int i = this.firstName.length(); i < NBCHAR_FIRSTNAME; i++) {
			firstNameLong += " ";
		}
		return firstNameLong;
	}

	public String getLocationLong() {
		String locationLong = this.location;
		for (int i = this.location.length(); i < NBCHAR_LOCATION; i++) {
			locationLong += " ";
		}
		return locationLong;
	}

	public String getNamePromoLong() {
		String namePromoLong = this.namePromo;
		for (int i = this.namePromo.length(); i < NBCHAR_NAMEPROMO; i++) {
			namePromoLong += " ";
		}
		return namePromoLong;
	}

}
