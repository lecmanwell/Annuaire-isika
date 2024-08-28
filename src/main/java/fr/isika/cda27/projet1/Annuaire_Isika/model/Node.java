package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;

public class Node {

	private Student stud;
	private int parent, leftChild, rightChild, next;
	public final static int NODE_SIZE_OCTET = Student.STUDENT_SIZE_OCTET + 3 * 4;

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

	public Student getStud() {
		return stud;
	}

	public void setStud(Student stud) {
		this.stud = stud;
	}

//	public void updateStudent(Student student, RandomAccessFile raf, int indice) {
//
//		try {
//			raf.seek((int) indice * 170);
//
//			writeSimpleStudent(student, raf, indice);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

//	public double findStudentPosition(Student student, RandomAccessFile raf) {
//		double indice = -1;
//		try {
//			raf.seek(0);
//			String name = "";
//
//			while (raf.getFilePointer() < raf.length()) {
//
//				for (int i = 0; i < Student.NBCHAR_LASTNAME; i++) {
//					name += raf.readChar();
//				}
//
//				if (student.getLastNameLong() == name) {
//					indice = Math.floor(raf.getFilePointer() / 170);
//
//				} else {
//					raf.seek(raf.getFilePointer() + 140);
//				}
//
//				if (indice != -1) {
//					break;
//				}
//
//			}
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return indice;
//
//	}

//	public int readLeftChildFromBinary(long cursorPosition, RandomAccessFile raf) {
//		cursorPosition += 170;
//		int leftChildInt = -1;
//		try {
//			raf.seek(cursorPosition);
//			leftChildInt = raf.readInt();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return leftChildInt;
//	}

//	public void writeIntInBinary(int twinOrChild, long cursorPosition, RandomAccessFile raf) {
//
//		try {
//			raf.seek(cursorPosition);
//			raf.writeInt(twinOrChild);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	public ArrayList<Student> displayFromBinary(RandomAccessFile raf, int indice, ArrayList<Student> stud) throws IOException {
		raf.seek((int) indice * NODE_SIZE_OCTET);
		Node displayStudent = new Node();
		displayStudent = readNode(raf, indice);
		
		if (displayStudent.leftChild != -1) {
			displayFromBinary(raf, displayStudent.leftChild, stud);
		}
		
		stud.add(displayStudent.stud);
		if (displayStudent.next != -1 ) {
			displayFromBinary(raf, displayStudent.next, stud);
		}
		
		if (displayStudent.rightChild != -1) {
			displayFromBinary(raf, displayStudent.rightChild, stud);
		}
		return stud;

	}

	public Student readBinaryTest() {

		try {
			RandomAccessFile rafR = new RandomAccessFile("src/main/resources/binarySave.bin", "r");

			ArrayList<Student> stud = new ArrayList<Student>();
			displayFromBinary(rafR, 0, stud);
			for (Student student : stud) {
				System.out.println(" ArrayList depuis le fichier binaire" + student);
			}

//			while (rafR.getFilePointer() != rafR.length()) {
//
//				String studentLastName = "";
//				for (int i = 0; i < 30; i++) {
//					studentLastName += rafR.readChar();
//				}
//
//				String studentFirstName = "";
//				for (int i = 0; i < 30; i++) {
//					studentFirstName += rafR.readChar();
//				}
//				String studentLocation = "";
//				for (int i = 0; i < 3; i++) {
//					studentLocation += rafR.readChar();
//				}
//
//				String studentNamePromo = "";
//				for (int i = 0; i < 12; i++) {
//					studentNamePromo += rafR.readChar();
//				}
//
//				int studentYearPromo = rafR.readInt();
//				int leftChild = rafR.readInt();
//				int rightChild = rafR.readInt();
//				int doublon = rafR.readInt();
//				
//				System.out.println("Un étudiant : " + studentLastName + " " + studentFirstName + " " + studentLocation
//						+ " " + studentNamePromo + " " + studentYearPromo + " " + leftChild + " " + rightChild + " " + doublon);
//			}

		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}
}
