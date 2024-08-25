package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.util.ArrayList;

public class Directory {

	private static Directory instance;
	private ArrayList<Student> studentsList;
	private Tree tree;
	
	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	private Directory() {
		this.studentsList = new ArrayList<Student>();
		this.tree = new Tree();
	}
	
	public static Directory getInstance() {
		  if (instance == null) {
	            instance = new Directory();
	        }
	        return instance;
    }

	public void addStudentToList(Student student) {
		System.out.println("Stagiaire added to list: " + student.getLastName());
		studentsList.add(student);
		

		BinaryWriterReader writer = new BinaryWriterReader();
		writer.writeBinary(student);
	}
	
	public void addStudentToTree(Student student) {
		tree.insert(student);
	}
	
	
	

	public Student findStudent(Student student) {
		return tree.searchFromNode(student, tree.getRoot()).getData();
	}

	public static ArrayList<Student> getStudentsList() {
		return Directory.instance.tree.treeAlphabeticalSorted();
	}

	@Override
	public String toString() {
		
		System.out.println("List of all stagiaire render by alphabetic order-----------");		
		System.out.println("Parcours du Tree");
		
		this.tree.infixeToString(this.tree.getRoot());

		return null;
	}

}
