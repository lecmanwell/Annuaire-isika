package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Classe responsable de la gestion des étudiants dans un arbre binaire stocké
 * dans un fichier binaire. Cette classe fournit des méthodes pour ajouter des
 * étudiants à l'arbre et pour lire la liste des étudiants dans un ordre
 * alphabétique.
 */

public class TreeDAO {

	private static RandomAccessFile raf;
	public ArrayList<Student> students;

	/**
	 * Constructeur de la classe TreeDAO. Initialise le fichier binaire pour la
	 * sauvegarde des données et crée une liste d'étudiants vide.
	 */
	public TreeDAO() {
		try {
			students = new ArrayList<Student>();
			raf = new RandomAccessFile("src/main/resources/binarySave.bin", "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Récupère la liste des étudiants stockés en mémoire.
	 * 
	 * @return Une liste des étudiants.
	 */

	public ArrayList<Student> getStudents() {
		return students;
	}

	/**
	 * Récupère le RandomAccessFile utilisé pour la lecture et l'écriture des
	 * données binaires.
	 * 
	 * @return Le fichier RandomAccessFile utilisé pour la sauvegarde.
	 */
	public static RandomAccessFile getRaf() {
		return raf;
	}

	/**
	 * Ajoute un étudiant à l'arbre binaire stocké dans le fichier binaire. Si le
	 * fichier est vide, l'étudiant est écrit comme racine de l'arbre. Sinon,
	 * l'étudiant est ajouté à l'arbre existant.
	 * 
	 * @param student L'étudiant à ajouter à l'arbre.
	 */

	public void addToTree(Student student) {
		try {
			if (raf.length() == 0) {
				// Écrit l'étudiant comme racine
				// raf.seek(0);
				Node racine = new Node(student);
				racine.writeSimpleStudent(student, raf, 0);
			} else {
				Node racine = new Node();

				racine = racine.readNode(raf, 0);

				racine.addNode(student, raf);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Récupère la liste des étudiants dans l'ordre alphabétique en lisant depuis le
	 * fichier binaire. Cette méthode utilise une traversée de l'arbre pour remplir
	 * la liste d'étudiants.
	 * 
	 * @return Une liste des étudiants triés par ordre alphabétique.
	 */

	public ArrayList<Student> setAlphaList() {
		Node node = new Node();
		try {
			node.displayFromBinary(raf, 0, this.students);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.students;
	}
}
