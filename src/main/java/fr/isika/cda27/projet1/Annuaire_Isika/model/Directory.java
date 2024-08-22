package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.util.ArrayList;

public class Directory {

	private static ArrayList<Student> studentsList = new ArrayList<Student>();
	Tree tree = new Tree();

	public void addStagiaire(Student student) {
		System.out.println("Stagiaire added to list: " + student.getLastName());
		studentsList.add(student);
		Node node = new Node(student, null, null);
		tree.insert(student);

		BinaryWriterReader writer = new BinaryWriterReader();
		writer.writeBinary(student);
	}

	public Student findStudent(Student student) {
		return tree.searchFromNode(student, tree.getRoot()).getData();
	}

	public static ArrayList<Student> getStudentsList() {
		return studentsList;
	}

	@Override
	public String toString() {
		System.out.println("List of all stagiaire-----------");

//		for (Student stag : this.studentsList) {
//			System.out.println(stag.toString()+"\n");
//		}
		tree.infixe(tree.getRoot());

		return null;
	}

}
