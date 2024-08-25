package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.util.LinkedList;
import java.util.Objects;

public class Student implements Comparable<Student> {

	private String lastName;
	private String firstName;
	private String location;
	private String namePromo;
	private int yearPromo;
	private LinkedList<Student> listDoublon;
	private static final int NBCHAR_LASTNAME = 30;
	private static final int NBCHAR_FIRSTNAME = 30;
	private static final int NBCHAR_LOCATION = 3;
	private static final int NBCHAR_NAMEPROMO = 12;

	public Student() {
		super();
	}

	public Student(String lastName, String firstName, String location, String namePromo, int yearPromo, LinkedList<Student> listDoublons) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.location = location;
		this.namePromo = namePromo;
		this.yearPromo = yearPromo;
		if (listDoublons != null) {
			this.listDoublon = listDoublons;
		}
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
				+ namePromo + ", yearPromo=" + yearPromo + ", listDoublon=" + listDoublon + "]";
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

	public String getStudentLastNameLong() {
		String studentLastNameLong = this.getLastName();
		for (int i = studentLastNameLong.length(); i < NBCHAR_LASTNAME; i++) {
			studentLastNameLong += " ";
		}
		return studentLastNameLong;

	}

	public String getStudentFirstNameLong() {
		String studentFIrstNameLong = this.getFirstName();
		for (int i = studentFIrstNameLong.length(); i < NBCHAR_FIRSTNAME; i++) {
			studentFIrstNameLong += " ";
		}
		return studentFIrstNameLong;

	}

	public String getStudentLocationLong() {
		String studentLocationLong = this.getLocation();
		for (int i = studentLocationLong.length(); i < NBCHAR_LOCATION; i++) {
			studentLocationLong += " ";
		}
		return studentLocationLong;

	}

	public String getStudentNamePromoLong() {
		String studentNamePromoLong = this.getNamePromo();
		for (int i = studentNamePromoLong.length(); i < NBCHAR_NAMEPROMO; i++) {
			studentNamePromoLong += " ";
		}
		return studentNamePromoLong;

	}

	public LinkedList<Student> getListDoublon() {
		return listDoublon;
	}

	public void setListDoublon(LinkedList<Student> listDoublon) {
		this.listDoublon = listDoublon;
	}
}
