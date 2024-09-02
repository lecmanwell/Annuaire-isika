package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * La classe Directory représente un annuaire d'étudiants. Elle contient une
 * liste d'étudiants et permet de gérer l'accès à un fichier binaire pour
 * sauvegarder les données des étudiants.
 * 
 * @author groupe1
 * @version 1.0
 */

public class Directory {
/**
 * Les champs privés de la classe Directory.
 *
 * @param studentsList Une liste ArrayList pour stocker les étudiants.
 * @param raf Un RandomAccessFile pour gérer l'accès au fichier binaire de sauvegarde.
 * @param tree L'arbre binaire associé à Directory pour la gestion des données.
 */
	private ArrayList<Student> studentsList;
	private RandomAccessFile raf;
	private Tree tree;

	/**
	 * Construit une nouvelle instance de Directory avec l'arbre binaire donné.
	 * Initialise une liste ArrayList vide pour studentsList et assigne l'arbre
	 * fourni. Ouvre un RandomAccessFile pour le stockage de données binaires avec
	 * le chemin de fichier "src/main/resources/binarySave.bin" en mode
	 * lecture-écriture. Si le fichier n'existe pas, il sera créé. Si une erreur se
	 * produit lors de l'ouverture du fichier, elle sera interceptée et la trace de
	 * pile sera imprimée.
	 *
	 * @param tree L'arbre binaire à associer à Directory.
	 */
	public Directory(Tree tree) {
		this.studentsList = new ArrayList<Student>();
		this.tree = tree;

		try {
			this.raf = new RandomAccessFile("src/main/resources/binarySave.bin", "rw");
		} catch (FileNotFoundException e) {
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
	 * Ajoute un étudiant à la liste des étudiants. Affiche un message de
	 * confirmation dans la console.
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
