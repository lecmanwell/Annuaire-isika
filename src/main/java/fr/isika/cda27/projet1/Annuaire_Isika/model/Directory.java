package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.util.ArrayList;

public class Directory {

	private ArrayList<Student> listStagiaires = new ArrayList<Student>();

	public void addStagiaire(Student student) {
		System.out.println("Stagiaire added to list: " + student.getLastName());
		listStagiaires.add(student);

	}

	@Override
	public String toString() {
		System.out.println("List of all stagiaire-----------");

		for (Student stag : this.listStagiaires) {
			System.out.println(stag.toString());
		}
		return null;
	}

}
