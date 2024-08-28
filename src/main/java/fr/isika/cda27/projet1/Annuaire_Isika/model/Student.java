package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.util.LinkedList;
import java.util.Objects;

public class Student implements Comparable<Student> {

	private String lastName;
	private String firstName;
	private String location;
	private String namePromo;
	private int yearPromo;
	public static final int NBCHAR_LASTNAME = 30;
	public static final int NBCHAR_FIRSTNAME = 30;
	public static final int NBCHAR_LOCATION = 3;
	public static final int NBCHAR_NAMEPROMO = 12;
	public static final int STUDENT_SIZE_OCTET = NBCHAR_LASTNAME*2 + NBCHAR_FIRSTNAME*2 + NBCHAR_LOCATION*2 + NBCHAR_NAMEPROMO*2 + 4;
	
	public Student(String lastName, String firstName, String location, String namePromo, int yearPromo) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.location = location;
		this.namePromo = namePromo;
		this.yearPromo = yearPromo;
		
	}
	public Student() {
		super();
	}
	
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
	
	@Override
	public String toString() {
		return "Student [lastName=" + lastName + ", firstName=" + firstName + ", location=" + location + ", namePromo="
				+ namePromo + ", yearPromo=" + yearPromo + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, location, namePromo, yearPromo);
	}
	
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
	
	@Override
	public int compareTo(Student o) {
		return this.getLastName().compareTo(o.getLastName());
	}

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
