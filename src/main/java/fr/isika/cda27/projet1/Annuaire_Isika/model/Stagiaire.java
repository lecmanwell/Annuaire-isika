	package fr.isika.cda27.projet1.Annuaire_Isika.model;
	
	import java.util.Objects;
	
	public class Stagiaire {
		
		private String lastName;
		private String firstName;
		private String location;
		private String namePromo;
		private int yearPromo;
		
		
		public Stagiaire(String lastName, String firstName, String location, String namePromo, int yearPromo) {
			super();
			this.lastName = lastName;
			this.firstName = firstName;
			this.location = location;
			this.namePromo = namePromo;
			this.yearPromo = yearPromo;
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
			return "Stagiaire [lastName=" + lastName + ", firstName=" + firstName + ", location=" + location
					+ ", namePromo=" + namePromo + ", yearPromo=" + yearPromo + "]";
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
			Stagiaire other = (Stagiaire) obj;
			return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
					&& Objects.equals(location, other.location) && Objects.equals(namePromo, other.namePromo)
					&& yearPromo == other.yearPromo;
		}
		
		
		
		
	
	}
