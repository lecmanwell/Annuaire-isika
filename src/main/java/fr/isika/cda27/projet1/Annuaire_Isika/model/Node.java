package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;

public class Node {

	private Student stud;
	private int leftChild, rightChild, next;
	public final static int NODE_SIZE_OCTET = Student.STUDENT_SIZE_OCTET + 3 * 4;
	private ArrayList<Student> doublonFromIndice = new ArrayList<Student>();

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

	public Student getStud() {
		return stud;
	}

	public void setStud(Student stud) {
		this.stud = stud;
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

	public void updateStudent(Student oldStudent, Student student, RandomAccessFile raf) throws IOException {
		
		
		

		// on recupere l'indice de la premiere occurence de clé
		int indice = findStudentPosition(raf, oldStudent.getLastName());

		// on compare en entier avec avec le student trouver à l'indice donné
		Node node = new Node();
		node = readNode(raf, indice);
			
		// si egaux, on est sur le bon student et on le modifie
		if (node.stud.equals(oldStudent)) {
			writeStudent(student, raf, indice);
		} else {
			// sinon on recupére tous les doublons et on itére sur cette list pour trouver
			// le bon doublons et son indice
			ArrayList<Node> doublons = new ArrayList<Node>();
			doublons = getListNodeDoublonFromIndice(raf, indice, doublons);
			// le premier de la liste à déjà été check et n'est pas le bon

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

	public void removeStudent(Student student, RandomAccessFile raf) throws IOException {
		int indice = findStudentPosition(raf, student.getLastName());
		Node nodeToRemove = readNode(raf, indice);
	
		// cas feuille trouver son pere et mettre l'enfant à -1
		// aucun child et pas de next
		if (nodeToRemove.leftChild == -1 && nodeToRemove.rightChild == -1 && nodeToRemove.next == -1) {

			removeLeaf(indice, raf);
		}

		// cas doublons
		// on arrive sur le premier des doublons sur l'arbre
		if (nodeToRemove.next != -1) {

			// cas particulier du premier de la liste chainé

			int indiceParent = findParent(indice, raf);
			removeStudentDoublons(student, indice, raf, indiceParent);
		}

		// cas où juste un fils
		if ((nodeToRemove.leftChild != -1 && nodeToRemove.rightChild == -1)
				|| (nodeToRemove.leftChild == -1 && nodeToRemove.rightChild != -1) && nodeToRemove.next == -1) {
			// recuperation indice parent
			
			removeNodeWithOneChild(indice, raf, nodeToRemove);

		}
		
		//cas deux enfants!
//		on recupere le parent, et on compare la valeur clé avec les enfants du node à remove,
		if (nodeToRemove.leftChild != -1 && nodeToRemove.rightChild != -1 && nodeToRemove.next == -1) {
			
			
			removeTwoChildrent(indice, nodeToRemove, raf);
			
		}
		
		
	}
	
	public void removeLeaf(int indice, RandomAccessFile raf) throws IOException {
		// recuperation indice parent
			int indiceParent = findParent(indice, raf);
			// lecture du noeud
			Node nodeParent = new Node();
			nodeParent = readNode(raf, indiceParent);
			// ou est le bon child
			if (nodeParent.leftChild == indice) {
				raf.seek(indiceParent * NODE_SIZE_OCTET + Student.STUDENT_SIZE_OCTET);
				raf.writeInt(-1);
			}
			if (nodeParent.rightChild == indice) {
				raf.seek(indiceParent * NODE_SIZE_OCTET + Student.STUDENT_SIZE_OCTET + 4);
				raf.writeInt(-1);
			}
	}
	
	 public void removeNodeWithOneChild(int indice, RandomAccessFile raf, Node nodeToRemove) throws IOException  {
		 int indiceParent = findParent(indice, raf);

			// lecture du noeud
			Node nodeParent = new Node();
			nodeParent = readNode(raf, indiceParent);

			// on se place sur le parent et on change son fils gauche
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
	
	
	public void removeTwoChildrent(int indiceNodetoremove, Node nodeToRemove, RandomAccessFile raf) throws IOException {
		
		int indiceParent = findParent(indiceNodetoremove, raf);
		Node nodeLeft = readNode(raf, nodeToRemove.leftChild);
		Node nodeRight = readNode(raf, nodeToRemove.rightChild);
		Node nodeParent = readNode(raf, indiceParent);
		int resultleft = nodeLeft.stud.compareTo(nodeParent.stud);
		int resultright = nodeRight.stud.compareTo(nodeParent.stud);

		//cas ou le nodetoremove st l'enfant gauche du parent
		if (nodeParent.leftChild == indiceNodetoremove) {
			//ca ou il le left child prend la place du nodeToremove
			
				raf.seek(indiceNodetoremove * NODE_SIZE_OCTET);
				writeStudent(nodeRight.stud, raf, indiceNodetoremove);
				
				
				if (nodeRight.rightChild == -1 && nodeRight.leftChild == -1) {
					
					raf.seek(indiceParent * NODE_SIZE_OCTET + Student.STUDENT_SIZE_OCTET + 4);
					raf.write(-1);
					
				}
				else {
					removeTwoChildrent(nodeToRemove.rightChild, nodeRight, raf);
				}
			
		}

		
	}

	public void removeStudentDoublons(Student student, int indice, RandomAccessFile raf, int indiceParent)
			throws IOException {
		Node node = new Node();
		node = readNode(raf, indice);

		if (node.stud.equals(student)) {

			// cas doublon avec enfant

			if (node.leftChild != 1 || node.rightChild != -1) {
				// on ecrase ses valeurs apr le node next
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

	public ArrayList<Student> getListDoublonFromIndice(RandomAccessFile raf, int indice,
			ArrayList<Student> doublontest) {
		try {
			raf.seek((indice + 1) * NODE_SIZE_OCTET - 4);
			int next = raf.readInt();
			if (next != -1) {
				// s'il a un next
				// on le rentre dans la list
				Node currentDoublon = new Node();
				currentDoublon = readNode(raf, indice);
				doublontest.add(currentDoublon.stud);
				// on recupere le next
				indice = currentDoublon.next;
				// recursive à partir du next
				getListDoublonFromIndice(raf, indice, doublontest);
			} else {
				// le dernier doublon feuille (pas de next)
				// on regarde la taille du tableau, si elle est pas null on l'ajoute au table
				if (doublontest.size() != 0) {
					Node lastCurrentDoublon = new Node();
					lastCurrentDoublon = readNode(raf, indice);
					doublontest.add(lastCurrentDoublon.stud);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return doublontest;
	}

	public ArrayList<Node> getListNodeDoublonFromIndice(RandomAccessFile raf, int indice, ArrayList<Node> doublontest) {
		try {
			raf.seek((indice + 1) * NODE_SIZE_OCTET - 4);
			int next = raf.readInt();
			if (next != -1) {
				// s'il a un next
				// on le rentre dans la list
				Node currentDoublon = new Node();
				currentDoublon = readNode(raf, indice);
				doublontest.add(currentDoublon);
				// on recupere le next
				indice = currentDoublon.next;
				// recursive à partir du next
				getListNodeDoublonFromIndice(raf, indice, doublontest);
			} else {
				// le dernier doublon feuille (pas de next)
				// on regarde la taille du tableau, si elle est pas null on l'ajoute au table
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

	public ArrayList<Student> displayFromBinary(RandomAccessFile raf, int indice, ArrayList<Student> students)
			throws IOException {
		raf.seek((int) indice * NODE_SIZE_OCTET);
		Node displayStudent = new Node();
		displayStudent = readNode(raf, indice);

		if (displayStudent.leftChild != -1) {
			displayFromBinary(raf, displayStudent.leftChild, students);
		}

		students.add(displayStudent.stud);
		if (displayStudent.next != -1) {
			displayFromBinary(raf, displayStudent.next, students);
		}

		if (displayStudent.rightChild != -1) {
			displayFromBinary(raf, displayStudent.rightChild, students);
		}
		return students;
	}
//	
//	public int findIndiceOfDoublons(RandomAccessFile raf, ArrayList<Student> listDoublons, int indicePrecedent) {
//		int indice = -1;
//		for (Student student : listDoublons) {
//			if (student.equals(indicePrecedent)) {
//				Node node = new Node();
//				
//				node = readNode(raf, indicePrecedent);
//				
//                indice = findStudentPosition(raf, student.getLastName());
//                break;
//            } else {
//                indice = findIndiceOfDoublons(raf, firstOccurence, listDoublons, );
//                break;
//            }
//		}
//		
//	
//		return;
//	}

	public Student readBinaryTest() {

		try {
			RandomAccessFile rafR = new RandomAccessFile("src/main/resources/binarySave.bin", "rw");

			ArrayList<Student> stud = new ArrayList<Student>();
			displayFromBinary(rafR, 0, stud);

//			findStudentPosition(rafR, "Lecocq");
			getListDoublonFromIndice(rafR, 6, stud);
			Student oldStud = new Student("ROIGNANT", "Pierre-Yves", "77", "AI 95", 2015);
			Student newStudent = new Student("ROIGNANT", "Martine", "92", "ATOD 24 CP", 2012);
			updateStudent(oldStud, newStudent, rafR);

			Student studentToRemoveFeuille = new Student("PUCELLE", "David", "75", "ATOD 12", 2011);
			Student studentToRemove1Child = new Student("GARIJO", "Rosie", "75", "AI 79", 2011);
			Student studentToRemove1Child1 = new Student("NOUAR", "Adel", "94", "ATOD 5", 2009);
			Student studentToRemove2Child = new Student("AUGEREAU", "Kévin", "76", "AI 78", 2010);
			removeStudent(studentToRemoveFeuille, rafR);

		
			rafR.seek(0);
			while (rafR.getFilePointer() != rafR.length()) {

				String studentLastName = "";
				for (int i = 0; i < 30; i++) {
					studentLastName += rafR.readChar();
				}

				String studentFirstName = "";
				for (int i = 0; i < 30; i++) {
					studentFirstName += rafR.readChar();
				}
				String studentLocation = "";
				for (int i = 0; i < 3; i++) {
					studentLocation += rafR.readChar();
				}

				String studentNamePromo = "";
				for (int i = 0; i < 12; i++) {
					studentNamePromo += rafR.readChar();
				}

			}

			rafR.close();
		} catch (IOException e) {
			e.printStackTrace();

		}

		return null;
	}

}
