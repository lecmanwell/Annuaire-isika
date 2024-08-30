package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * La classe Directory représente un annuaire d'étudiants. Elle contient une
 * liste d'étudiants et permet de gérer l'accès à un fichier binaire pour
 * sauvegarder les données des étudiants.
 */

public class Directory {

	
    /**
     * Liste des étudiants dans l'annuaire.
     */
	private ArrayList<Student> studentsList;
	
	/**
     * Le RandomAccessFile pour accéder au fichier binaire.
     */
	private RandomAccessFile raf;
	
    /**
     * Le TreeDAO pour gérer les opérations sur l'arbre binaire.
     */
	private TreeDAO treeDao;

    /**
     * Constructeur par défaut de la classe Directory.
     * Initialise la liste des étudiants et le DAO pour l'arbre binaire.
     * Initialise également le fichier binaire pour la lecture et l'écriture.
     */

	public Directory() {
		this.studentsList = new ArrayList<Student>();
//		this.tree = new Tree();
		this.treeDao = new TreeDAO();
		try {
			this.raf = new RandomAccessFile("src/main/resources/binarySave.bin", "rw");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    /**
     * Retourne la liste des étudiants.
     * 
     * @return Liste des étudiants.
     */
	
	public ArrayList<Student> getStudentsList() {
		return studentsList;
	}
	
    /**
     * Définit la liste des étudiants.
     * 
     * @param studentsList Liste des étudiants à définir.
     */
	
	public void setStudentsList(ArrayList<Student> studentsList) {
		this.studentsList = studentsList;
	}
	
	
    /**
     * Ajoute un étudiant à la liste des étudiants.
     * Affiche un message de confirmation dans la console.
     * 
     * @param student L'étudiant à ajouter à la liste.
     */

	public void addStudentToList(Student student) {
		System.out.println("Stagiaire added to list: " + student.getLastName());
		studentsList.add(student);

//		BinaryWriterReader writer = new BinaryWriterReader();
//		writer.writeBinary(student);
	}

	
    /**
     * Ajoute un étudiant à l'arbre binaire via le DAO.
     * 
     * @param student L'étudiant à ajouter à l'arbre.
     */
	
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
