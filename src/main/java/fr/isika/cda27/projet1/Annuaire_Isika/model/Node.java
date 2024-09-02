package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe représentant un noeud dans l'arbre binaire.
 * Chaque noeud peut avoir un étudiant, un enfant gauche, un enfant droit et un suivant.
 * Les noeuds sont stockés dans un fichier binaire.
 *
 * @author groupe1
 * @version 1.0
 */

public class Node {

    /**
     * L'étudiant associé à ce noeud.
     */
	private Student stud;
	
	  /**
     * L'indice du noeud enfant gauche dans le fichier binaire.
     */
	private int leftChild;
	
	  /**
     * L'indice du noeud enfant droit dans le fichier binaire.
     */
	private int rightChild;
	/**
     * L'indice du noeud suivant dans le fichier binaire.
     */
	private int next;
	
	/**
     * Taille des champs dans le fichier binaire pour les noeuds.
     */
	public final static int NODE_SIZE_OCTET = Student.STUDENT_SIZE_OCTET + 3 * 4;
	
	/**
     * Liste des étudiants en double dans le noeud.
     */
	private ArrayList<Student> doublonFromIndice = new ArrayList<Student>();
	
    /**
     * Le RandomAccessFile pour accéder au fichier binaire.
     */
	private RandomAccessFile raf;

	
	/**
     * Constructeur par défaut. Initialise les champs à -1.
     */
	public Node() {
		super();
	}

	/**
     * Constructeur pour un student sans connaitre encore ses enfants et doublons.
     */
	public Node(Student stud) {
		this.stud = stud;
		this.leftChild = -1;
		this.rightChild = -1;
		this.next = -1;
	}

	/**
     * Constructeur pour un student qui connais ses enfants et doublons.
     */
	public Node(Student stud, int left, int right, int next) {
		this.stud = stud;
		this.leftChild = left;
		this.rightChild = right;
		this.next = next;
	}


	/**
	 * Retourne l'étudiant associé à ce noeud.
	 * 
	 * @return L'étudiant associé à ce noeud.
	 */
	public Student getStud() {
		return stud;
	}


    /**
     * Méthode pour lire les données d'un noeud à partir du fichier binaire.
     *
     * @param raf Le flux de données du fichier binaire.
     * @param indice L'indice du noeud à lire.
     * @return Le noeud lu à partir du fichier binaire.
     * @throws IOException Si une erreur d'entrée/sortie se produit.
     */

	public Node readNode(RandomAccessFile raf, int indice) throws IOException {
		raf.seek((long) indice * Node.NODE_SIZE_OCTET);
		String studentLastName = "";
		for (int i = 0; i < Student.NBCHAR_LASTNAME; i++) {
			studentLastName += raf.readChar();
		}

		String studentFirstName = "";
		for (int i = 0; i < Student.NBCHAR_FIRSTNAME; i++) {
			studentFirstName += raf.readChar();
		}

		String studentLocation = "";
		for (int i = 0; i < Student.NBCHAR_LOCATION; i++) {
			studentLocation += raf.readChar();
		}

		String studentNamePromo = "";
		for (int i = 0; i < Student.NBCHAR_NAMEPROMO; i++) {
			studentNamePromo += raf.readChar();
		}

		int year = raf.readInt();

		int leftChild = raf.readInt();
		int rightChild = raf.readInt();
		int next = raf.readInt();
		Node node = new Node(new Student(studentLastName.trim(), studentFirstName.trim(), studentLocation.trim(),
				studentNamePromo.trim(), year), leftChild, rightChild, next);

		return node;
	}

	
	 /**
     * Méthode pour écrire les données d'un étudiant dans un noeud dans le fichier binaire.
     *
     * @param stud L'étudiant à écrire.
     * @param raf Le flux de données du fichier binaire.
     * @param cursorPointer Le pointeur de curseur dans le fichier binaire.
     */
	public void writeSimpleStudent(Student stud, RandomAccessFile raf, long cursorPointer) {
		try {
			raf.seek(cursorPointer);
			if (stud != null) {
				raf.writeChars(stud.getLastNameLong());
				raf.writeChars(stud.getFirstNameLong());
				raf.writeChars(stud.getLocationLong());
				raf.writeChars(stud.getNamePromoLong());
				raf.writeInt(stud.getYearPromo());
				raf.writeInt(-1);
				raf.writeInt(-1);
				raf.writeInt(-1);
			} else {
				System.out.println("L'étudiant est nul !");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 /**
     * Méthode pour écrire les données d'un étudiant dans un noeud dans le fichier binaire sans renseigner ses enfants ou doublons
     *
     * @param stud L'étudiant à écrire.
     * @param raf Le flux de données du fichier binaire.
     * @param cursorPointer Le pointeur de curseur dans le fichier binaire.
     */
	public void writeStudent(Student stud, RandomAccessFile raf, int indice) {
		try {
			raf.seek((int) indice * NODE_SIZE_OCTET);
			if (stud != null) {
				raf.writeChars(stud.getLastNameLong());
				raf.writeChars(stud.getFirstNameLong());
				raf.writeChars(stud.getLocationLong());
				raf.writeChars(stud.getNamePromoLong());
				raf.writeInt(stud.getYearPromo());

			} else {
				System.out.println("L'étudiant est nul !");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	  /**
     * Méthode pour ajouter un étudiant à l'arbre binaire.
     *
     * @param student L'étudiant à ajouter.
     * @param raf Le flux de données du fichier binaire.
     * @throws IOException Si une erreur d'entrée/sortie se produit.
     */
	public void addNode(Student student, RandomAccessFile raf) throws IOException {
		if (this.stud.getLastName().compareToIgnoreCase(student.getLastName()) > 0) {
			// gauche
			if (this.leftChild == -1) {

				raf.seek(raf.getFilePointer() - 12);
				raf.writeInt((int) raf.length() / NODE_SIZE_OCTET);

				writeSimpleStudent(student, raf, raf.length());

			} else {

				Node leftNode = readNode(raf, this.leftChild);
				leftNode.addNode(student, raf);
			}
		} else if (this.stud.getLastName().compareTo(student.getLastName()) < 0) {

			if (this.rightChild == -1) {
				raf.seek(raf.getFilePointer() - 8);
				raf.writeInt((int) raf.length() / NODE_SIZE_OCTET);

				writeSimpleStudent(student, raf, raf.length());

			} else {

				Node rightNode = readNode(raf, this.rightChild);
				rightNode.addNode(student, raf);
			}
		} else {

			if (this.next == -1) {

				raf.seek(raf.getFilePointer() - 4);
				raf.writeInt((int) raf.length() / NODE_SIZE_OCTET);
				
				writeSimpleStudent(student, raf, raf.length());
				
			} else {
				Node next = readNode(raf, this.next);
				next.addNode(student, raf);
			}
		}

	}


    /**
     * Méthode pour mettre à jour les données d'un étudiant dans l'arbre binaire.
     *
     * @param oldStudent L'ancien étudiant.
     * @param newStudent Le nouveau étudiant.
     * @param raf Le flux de données du fichier binaire.
     * @throws IOException Si une erreur d'entrée/sortie se produit.
     */
	public void updateStudent(Student oldStudent, Student student, RandomAccessFile raf) throws IOException {

		int indice = findStudentPosition(raf, oldStudent.getLastName());

		Node node = new Node();
		node = readNode(raf, indice);

		if (node.stud.equals(oldStudent)) {
			writeStudent(student, raf, indice);
		} else {
			ArrayList<Node> doublons = new ArrayList<Node>();
			doublons = getListNodeDoublonFromIndice(raf, indice, doublons);

			int indicePrecedent = node.next;

			for (Node doublon : doublons) {

				if (doublon.stud.equals(oldStudent)) {
					writeStudent(student, raf, indicePrecedent);
					break;
				} else {
					indicePrecedent = node.next;
				}
			}
		}
	}

	
    /**
     * Méthode pour supprimer un étudiant de l'arbre binaire.
     *
     * @param student L'étudiant à supprimer.
     * @param raf Le flux de données du fichier binaire.
     * @throws IOException Si une erreur d'entrée/sortie se produit.
     */
	public void removeStudent(Student student, RandomAccessFile raf) throws IOException {
		int indice = findStudentPosition(raf, student.getLastName());
		Node nodeToRemove = readNode(raf, indice);


		if (nodeToRemove.leftChild == -1 && nodeToRemove.rightChild == -1 && nodeToRemove.next == -1) {

			removeLeaf(indice, raf);
		}

		if (nodeToRemove.next != -1) {

			int indiceParent = findParent(indice, raf);
			removeStudentDoublons(student, indice, raf, indiceParent);
		}

		if ((nodeToRemove.leftChild != -1 && nodeToRemove.rightChild == -1)
				|| (nodeToRemove.leftChild == -1 && nodeToRemove.rightChild != -1) && nodeToRemove.next == -1) {

			removeNodeWithOneChild(indice, raf, nodeToRemove);

		}

		if (nodeToRemove.leftChild != -1 && nodeToRemove.rightChild != -1 && nodeToRemove.next == -1) {

			removeTwoChildrent(indice, nodeToRemove, raf);

		}

	}
	
	
	
	/**
	 * Méthode pour supprimer un noeud feuille de l'arbre binaire.
	 *
	 * @param indice L'indice du noeud à supprimer.
	 * @param raf Le flux de données du fichier binaire.
	 * @throws IOException Si une erreur d'entrée/sortie se produit.
	 */
	public void removeLeaf(int indice, RandomAccessFile raf) throws IOException {
		
		int indiceParent = findParent(indice, raf);
		
		Node nodeParent = new Node();
		nodeParent = readNode(raf, indiceParent);
		
		if (nodeParent.leftChild == indice) {
			raf.seek(indiceParent * NODE_SIZE_OCTET + Student.STUDENT_SIZE_OCTET);
			raf.writeInt(-1);
		}
		if (nodeParent.rightChild == indice) {
			raf.seek(indiceParent * NODE_SIZE_OCTET + Student.STUDENT_SIZE_OCTET + 4);
			raf.writeInt(-1);
		}
	}

	/**
	 * Méthode pour supprimer un noeud avec un seul enfant de l'arbre binaire.
	 *
	 * @param indice L'indice du noeud à supprimer.
	 * @param raf Le flux de données du fichier binaire.
	 * @param nodeToRemove Le noeud à supprimer.
	 * @throws IOException Si une erreur d'entrée/sortie se produit.
	 */
	public void removeNodeWithOneChild(int indice, RandomAccessFile raf, Node nodeToRemove) throws IOException {
		int indiceParent = findParent(indice, raf);

		
		Node nodeParent = new Node();
		nodeParent = readNode(raf, indiceParent);


		raf.seek(indiceParent * NODE_SIZE_OCTET + Student.STUDENT_SIZE_OCTET);

		if (nodeParent.leftChild == indice) {
			if (nodeToRemove.leftChild != -1) {

				raf.writeInt(nodeToRemove.leftChild);
			} else {
				raf.writeInt(nodeToRemove.rightChild);
			}
		}

		if (nodeParent.rightChild == indice) {
			raf.seek(raf.getFilePointer() + 4);
			if (nodeToRemove.leftChild != -1) {
				raf.writeInt(nodeToRemove.leftChild);
			} else {
				raf.writeInt(nodeToRemove.rightChild);
			}
		}
	}
	
	/**
	 * Méthode pour supprimer un noeud avec deux enfants de l'arbre binaire.
	 *
	 * @param indiceNodetoremove L'indice du noeud à supprimer.
	 * @param nodeToRemove Le noeud à supprimer.
	 * @param raf Le flux de données du fichier binaire.
	 * @throws IOException Si une erreur d'entrée/sortie se produit.
	 */
	public void removeTwoChildrent(int indiceNodetoremove, Node nodeToRemove, RandomAccessFile raf) throws IOException {

		int indiceParent = findParent(indiceNodetoremove, raf);
		Node nodeLeft = readNode(raf, nodeToRemove.leftChild);
		Node nodeRight = readNode(raf, nodeToRemove.rightChild);
		Node nodeParent = readNode(raf, indiceParent);
		int resultleft = nodeLeft.stud.compareTo(nodeParent.stud);
		int resultright = nodeRight.stud.compareTo(nodeParent.stud);
	
		if (nodeParent.leftChild == indiceNodetoremove) {		

			raf.seek(indiceNodetoremove * NODE_SIZE_OCTET);
			writeStudent(nodeRight.stud, raf, indiceNodetoremove);

			if (nodeRight.rightChild == -1 && nodeRight.leftChild == -1) {

				raf.seek(indiceParent * NODE_SIZE_OCTET + Student.STUDENT_SIZE_OCTET + 4);
				raf.write(-1);

			} else {
				removeTwoChildrent(nodeToRemove.rightChild, nodeRight, raf);
			}

		}

	}

	
	/**
	 * Méthode pour supprimer un étudiant en double de l'arbre binaire.
	 *
	 * @param student L'étudiant à supprimer.
	 * @param indice L'indice du noeud à supprimer.
	 * @param raf Le flux de données du fichier binaire.
	 * @param indiceParent L'indice du parent du noeud à supprimer.
	 * @throws IOException Si une erreur d'entrée/sortie se produit.
	 */
	public void removeStudentDoublons(Student student, int indice, RandomAccessFile raf, int indiceParent)
			throws IOException {
		Node node = new Node();
		node = readNode(raf, indice);

		if (node.stud.equals(student)) {

			if (node.leftChild != 1 || node.rightChild != -1) {

				Node nodeNext = readNode(raf, node.next);
				writeStudent(nodeNext.stud, raf, indice);
				raf.seek(raf.getFilePointer() + 8);
				raf.writeInt(nodeNext.next);
			} else {

				raf.seek((indiceParent + 1) * NODE_SIZE_OCTET - 4);

				raf.writeInt(node.next);
			}

		} else if (node.next != -1) {
			
			removeStudentDoublons(student, node.next, raf, indice);
		}
	}

	
	   /**
     * Méthode pour trouver l'indice du parent d'un noeud donné.
     *
     * @param indice L'indice du noeud.
     * @param raf Le flux de données du fichier binaire.
     * @return L'indice du parent du noeud donné.
     */
	public int findParent(int indice, RandomAccessFile raf) {
		int indiceFound = -1;

		try {
			raf.seek(0);
			int indiceIterate = 0;
			while (raf.getFilePointer() < raf.length()) {
				Node node = new Node();
				node = readNode(raf, indiceIterate);
				if (node.leftChild == indice || node.rightChild == indice) {
					indiceFound = (int) raf.getFilePointer() / NODE_SIZE_OCTET - 1;
					break;
				}
				indiceIterate++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return indiceFound;
	}

	
    /**
     * Méthode pour trouver l'indice d'un étudiant donné dans le fichier binaire.
     *
     * @param raf Le flux de données du fichier binaire.
     * @param nameSearch Le nom de l'étudiant à rechercher.
     * @return L'indice de l'étudiant dans le fichier binaire.
     */
	public int findStudentPosition(RandomAccessFile raf, String nameSearch) {

		long indice = -1;
		try {
			raf.seek(0);
			while (raf.getFilePointer() < raf.length()) {
				String nameRead = "";
				for (int i = 0; i < Student.NBCHAR_LASTNAME; i++) {
					nameRead += raf.readChar();
				}

				if (nameRead.trim().equalsIgnoreCase(nameSearch.trim())) {
					raf.seek(raf.getFilePointer() - Student.NBCHAR_LASTNAME * 2);
					indice = raf.getFilePointer() / NODE_SIZE_OCTET;
					break;
				} else {
					raf.seek(raf.getFilePointer() + (NODE_SIZE_OCTET - Student.NBCHAR_LASTNAME * 2));
					indice = raf.getFilePointer() / NODE_SIZE_OCTET;

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return (int) indice;

	}

	
    /**
     * Méthode pour obtenir une liste d'étudiants en double à partir d'un indice donné.
     *
     * @param raf Le flux de données du fichier binaire.
     * @param indice L'indice de départ.
     * @param doublontest La liste des étudiants en double.
     * @return La liste des nodes en double.
     */	
	public ArrayList<Node> getListNodeDoublonFromIndice(RandomAccessFile raf, int indice, ArrayList<Node> doublontest) {
		try {
			raf.seek((indice + 1) * NODE_SIZE_OCTET - 4);
			int next = raf.readInt();
			if (next != -1) {

				Node currentDoublon = new Node();
				currentDoublon = readNode(raf, indice);
				doublontest.add(currentDoublon);

				indice = currentDoublon.next;

				getListNodeDoublonFromIndice(raf, indice, doublontest);
			} else {

				if (doublontest.size() != 0) {
					Node lastCurrentDoublon = new Node();
					lastCurrentDoublon = readNode(raf, indice);
					doublontest.add(lastCurrentDoublon);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return doublontest;
	}
	
	
	  /**
     * Méthode pour obtenir une liste triée d'étudiants à partir d'un indice donné.
     *
     * @param raf Le flux de données du fichier binaire.
     * @param indice L'indice de départ.
     * @param students La liste des étudiants.
     * @return La liste triée d'étudiants.
     * @throws IOException Si une erreur d'entrée/sortie se produit.
     */
	public ArrayList<Student> getListStudentSorted(RandomAccessFile raf, int indice, ArrayList<Student> students)
			throws IOException {
		raf.seek((int) indice * NODE_SIZE_OCTET);
		Node displayStudent = new Node();
		displayStudent = readNode(raf, indice);

		if (displayStudent.leftChild != -1) {
			getListStudentSorted(raf, displayStudent.leftChild, students);
		}

		students.add(displayStudent.stud);
		if (displayStudent.next != -1) {
			getListStudentSorted(raf, displayStudent.next, students);
		}

		if (displayStudent.rightChild != -1) {
			getListStudentSorted(raf, displayStudent.rightChild, students);
		}
		return students;
	}

}
