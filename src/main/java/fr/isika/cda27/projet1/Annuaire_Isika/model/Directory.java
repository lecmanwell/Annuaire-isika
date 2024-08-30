package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Directory {

	private ArrayList<Student> studentsList;
//	private Tree tree;
	private RandomAccessFile raf;
	private TreeDAO treeDao;
	
////	public Tree getTree() {
//		return tree;
//	}
//
//	public void setTree(Tree tree) {
//		this.tree = tree;
//	}

	public ArrayList<Student> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(ArrayList<Student> studentsList) {
		this.studentsList = studentsList;
	}

	public Directory() {
		this.studentsList = new ArrayList<Student>();
//		this.tree = new Tree();
//		this.treeDao = new	TreeDAO();
		try {
			this.raf = new RandomAccessFile("src/main/resources/binarySave.bin", "rw");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addStudentToList(Student student) {
		System.out.println("Stagiaire added to list: " + student.getLastName());
		studentsList.add(student);
		

//		BinaryWriterReader writer = new BinaryWriterReader();
//		writer.writeBinary(student);
	}
	
	public void addStudentToTree(Student student) {
//		tree.insert(student);
		treeDao.addToTree(student);

	}
	
	
	
//
//	public Student findStudent(Student student) {
//		return tree.searchFromNode(student, tree.getRoot()).getData();
//	}

//	public static ArrayList<Student> getStudentsList() {
//		return Directory.instance.tree.treeAlphabeticalSorted();
//	}
//
//	@Override
//	public String toString() {
//		
//		System.out.println("List of all stagiaire render by alphabetic order-----------");		
//		System.out.println("Parcours du Tree");
//		
//		this.tree.infixeToString(this.tree.getRoot());
//
//		return null;
//	}

}
