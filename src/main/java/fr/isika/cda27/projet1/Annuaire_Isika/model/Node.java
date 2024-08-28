package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class Node {

	private Student stud;
	private int parent, leftChild, rightChild, next;
	public final static int NODE_SIZE_OCTET = Student.STUDENT_SIZE_OCTET + 3 * 4;

//	private static final int NBCHAR_LASTNAME = 30;
//	private static final int NBCHAR_FIRSTNAME = 30;
//	private static final int NBCHAR_LOCATION = 3;
//	private static final int NBCHAR_NAMEPROMO = 12;
	// private int yearPromo;

	public Node(Student stud) {
		this.stud = stud;
		this.leftChild = -1;
		this.rightChild = -1;
		this.next = -1;
	}

	public Node() {
		super();
	}

	public Node(Student stud, int left, int right, int next) {
		this.stud = stud;
		this.leftChild = left;
		this.rightChild = right;
		this.next = next;
	}

	private Node findLastDuplicateNode(RandomAccessFile raf) throws IOException {
		// Find the last duplicate node in the tree
		Node currentNode = this;
		while (currentNode.next != -1) {
			currentNode = new Node();
			currentNode.readNode(raf, currentNode.next);
		}
		return currentNode;
	}

	public Node readNode(RandomAccessFile raf, int indice) throws IOException {
		// Read the data of a node from the binary file
		raf.seek((long) indice * Node.NODE_SIZE_OCTET);
//        this.stud = new Student();
		String studentLastName = "";
		for (int i = 0; i < Student.NBCHAR_LASTNAME; i++) {
			studentLastName += raf.readChar();
		}
//		this.stud.setStudentLastNameLong(studentLastName);

		String studentFirstName = "";
		for (int i = 0; i < Student.NBCHAR_FIRSTNAME; i++) {
			studentFirstName += raf.readChar();
		}
//		this.stud.setStudentFirstNameLong(studentFirstName);

		String studentLocation = "";
		for (int i = 0; i < Student.NBCHAR_LOCATION; i++) {
			studentLocation += raf.readChar();
		}
//		this.stud.setStudentLocationLong(studentLocation);

		String studentNamePromo = "";
		for (int i = 0; i < Student.NBCHAR_NAMEPROMO; i++) {
			studentNamePromo += raf.readChar();
		}
//		this.stud.setStudentNamePromoLong(studentNamePromo);      

		int year = raf.readInt();

		int leftChild = raf.readInt();
		int rightChild = raf.readInt();
		int next = raf.readInt();
		Node node = new Node(new Student(studentLastName.trim(), studentFirstName.trim(), studentLocation.trim(),
				studentNamePromo.trim(), year), leftChild, rightChild, next);

		return node;
	}

	// ecrire un noeud
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

	public void addNode(Student student, RandomAccessFile raf) throws IOException {
		if (this.stud.getLastName().compareToIgnoreCase(student.getLastName()) > 0) {
			// gauche
			if (this.leftChild == -1) {
				// emplacement d'ajout
				// je modifie l'indewx dans le noued courant
				raf.seek(raf.getFilePointer() - 12);
				raf.writeInt((int) raf.length() / NODE_SIZE_OCTET);
				// on ecrit le noeud à la fin du fichier
				writeSimpleStudent(student, raf, raf.length());
			} else {
				Node leftNode = readNode(raf, this.leftChild);
				leftNode.addNode(student, raf);
			}
		} else if (this.stud.getLastName().compareTo(student.getLastName()) < 0) {
			// droite
			if (this.rightChild == -1) {
				raf.seek(raf.getFilePointer() - 8);
				raf.writeInt((int) raf.length() / NODE_SIZE_OCTET);
				writeSimpleStudent(student, raf, raf.length());
			} else {
				Node rightNode = readNode(raf, this.rightChild);
				rightNode.addNode(student, raf);
			}
		} else {
			// doublon
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

	private String readStringFromFile(RandomAccessFile raf, int length) throws IOException {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(raf.readChar());
		}
		return sb.toString().trim();
	}

	private int readIntFromFile(RandomAccessFile raf, int offset) throws IOException {
		raf.seek(offset);
		return raf.readInt();
	}

	public int getIndex(RandomAccessFile raf) throws IOException {
		// Calculate the index of the current node
		// The index is calculated by dividing the current file pointer position by the
		// size of each node
		// and then subtracting 1 (since the index starts from 0)
		int currentIndex = (int) (raf.getFilePointer() / 170) - 1;
		return currentIndex;
	}

	public Node insertNodeDAO(Student student, int indice, RandomAccessFile raf) {

		// je lis à l'inex donné si il y a qqcch

		// test gauche ou doite

		// est ce que j'ai de la place pour ecrire ( = -1)
		// si == -1

		// on remplace -1 par le dernier indice libre et on ecrit le noeud à l'indice
		// libre

		// sinon on rappel al meme methode en changeant l'indice

//		if (node == null) {
//			this.writeSimpleStudent(student, raf, cursorPosition);
//			return new NodeDAO(student);
//		}

		int result = this.stud.compareTo(student);

		if (result < 0) {
			// on vérifie la valeur de leftChild du noeud courant
			// pour ceci on doit recuperer la position du student ds le fichier

//			long newCursorPosition = readLeftChildFromBinary(cursorPosition, raf) * 170;

			// Si il n'y a pas de fils gauche, c'est donc que l'information sur le fichier
			// binaire vaut -1

//			if (newCursorPosition < 0) {
//				
//			}

			int valueLeft = -1;

			try {
				valueLeft = raf.readInt();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// si leftChild est vide, on écrit l'indice du student à cette position
			if (valueLeft == -1) {
//				this.writeIntInBinary(valueLeft, newCursorPosition, raf);
//				node.insertNodeDAO(student, node, newCursorPosition, raf);

			} else {

				// recuperation indice du node à ajouter
//				long pointer = raf.getFilePointer();
//				int  indice = (int) Math.floor(pointer / 170);

				// on se place à l'indice puis on rajoute 158 pour etre au debut du leftchild
//				raf.seek(indice * 170 + 158);

//				raf.writeInt(value)
//			}
//			
//			if (this.leftChild == null) {
//				this.leftChild = new Node(student, null, null);
//			} else {
//				// Le noeud courant possède un fils gauche
//				// donc on refait l'appel récursif
//				// mais en partant du fils gauche
//				this.leftChild.inserer(student);
//			}
			}
		}
		// Si la valeur du noeud qu'on veut insérer
		// est plus grande (ou égale) que la valeur du noeud courant
//		else if (result > 0) {
//			if (rightChild == null) {
//				// Le noeud courant n'a pas de fils droit
//				this.rightChild = new Node(student, null, null);
//			} else {
//				// Le noeud courant possède un fils droit
//				// donc on refait l'appel récursif
//				// mais en partant du fils droit
//				this.rightChild.inserer(student);
//			}
//		}
//
//		else if (result == 0) {
//			if (this.getListDoublon() == null) {
//				this.listDoublon = new LinkedList<Student>();
//				this.listDoublon.add(student);
//				this.data.setListDoublon(new LinkedList<Student>());
//				this.data.getListDoublon().add(student);
//				
//			} else {
//				this.listDoublon.add(student);
//				this.data.getListDoublon().add(student);
//			}
//			System.out.println("Ajout Doublon:" +this.listDoublon.toString());
//		}
		return null;

	}

	public Student getStud() {
		return stud;
	}

	public void setStud(Student stud) {
		this.stud = stud;
	}

	public void updateStudent(Student student, RandomAccessFile raf, int indice) {

		try {
			raf.seek((int) indice * 170);

			writeSimpleStudent(student, raf, indice);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double findStudentPosition(Student student, RandomAccessFile raf) {
		double indice = -1;
		try {
			raf.seek(0);
			String name = "";

			while (raf.getFilePointer() < raf.length()) {

				for (int i = 0; i < Student.NBCHAR_LASTNAME; i++) {
					name += raf.readChar();
				}

				if (student.getLastNameLong() == name) {
					indice = Math.floor(raf.getFilePointer() / 170);

				} else {
					raf.seek(raf.getFilePointer() + 140);
				}

				if (indice != -1) {
					break;
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return indice;

	}

	public int readLeftChildFromBinary(long cursorPosition, RandomAccessFile raf) {
		cursorPosition += 170;
		int leftChildInt = -1;
		try {
			raf.seek(cursorPosition);
			leftChildInt = raf.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return leftChildInt;
	}

	public void writeIntInBinary(int twinOrChild, long cursorPosition, RandomAccessFile raf) {

		try {
			raf.seek(cursorPosition);
			raf.writeInt(twinOrChild);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
