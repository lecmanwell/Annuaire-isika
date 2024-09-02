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

public class Tree {

	private RandomAccessFile raf;
	public ArrayList<Student> students;

	/**
	 * Constructeur de la classe TreeDAO. Initialise le fichier binaire pour la
	 * sauvegarde des données et crée une liste d'étudiants vide.
	 */
	public Tree() {
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
	public RandomAccessFile getRaf() {
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
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			node.getListStudentSorted(raf, 0, list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Méthode pour mettre à jour un étudiant dans l'arbre binaire stocké dans le
	 * fichier binaire. Cette méthode vérifie si l'étudiant à mettre à jour est
	 * différent de l'ancien étudiant. Si c'est le cas, elle utilise une instance de
	 * la classe Node pour mettre à jour l'étudiant dans l'arbre.
	 *
	 * @param oldStudent L'ancien étudiant.
	 * @param student    Le nouveau étudiant.
	 * @throws IOException Si une erreur d'entrée/sortie se produit.
	 */
	public void upDateStudent(Student oldStudent, Student student) throws IOException {

		if (!oldStudent.equals(student)) {
			Node node = new Node();
			node.updateStudent(oldStudent, student, this.raf);
		}
	}

	/**
	 * Méthode pour supprimer un étudiant de l'arbre binaire stocké dans le fichier
	 * binaire. Cette méthode utilise une instance de la classe Node pour supprimer
	 * l'étudiant de l'arbre.
	 *
	 * @param student L'étudiant à supprimer.
	 * @throws IOException Si une erreur d'entrée/sortie se produit.
	 */
	public void deleteStudent(Student student) throws IOException {

		Node node = new Node();
		node.removeStudent(student, this.raf);
	}
}
