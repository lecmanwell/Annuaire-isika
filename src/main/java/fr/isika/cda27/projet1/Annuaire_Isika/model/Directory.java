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
	private TreeDAO tree;

    /**
     * Constructeur par défaut de la classe Directory.
     * Initialise la liste des étudiants et le DAO pour l'arbre binaire.
     * Initialise également le fichier binaire pour la lecture et l'écriture.
     */

	public Directory(TreeDAO tree) {
		this.studentsList = new ArrayList<Student>();
		this.tree = tree;
//		this.treeDao = new	TreeDAO();

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
		studentsList.add(student);

	}

	
    /**
     * Ajoute un étudiant à l'arbre binaire via le DAO.
     * 
     * @param student L'étudiant à ajouter à l'arbre.
     */
	
	public void addStudentToTree(Student student) {
		this.tree.addToTree(student);

	}

}
