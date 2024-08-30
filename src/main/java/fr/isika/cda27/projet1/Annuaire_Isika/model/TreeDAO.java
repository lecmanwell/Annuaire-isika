package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class TreeDAO {

	private static RandomAccessFile raf;
	public ArrayList<Student> students;

	public TreeDAO() {
		try {
			students = new ArrayList<Student>();
			raf = new RandomAccessFile("src/main/resources/binarySave.bin", "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public static RandomAccessFile getRaf() {
		return raf;
	}

	public void addToTree(Student student) {
		try {
			if (raf.length() == 0) {
				// ecrit le student comme racine
				// raf.seek(0);
				Node racine = new Node(student);
				racine.writeSimpleStudent(student, raf, 0);
			} else {
				Node racine = new Node();

				racine = racine.readNode(raf, 0);

				racine.addNode(student, raf);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
