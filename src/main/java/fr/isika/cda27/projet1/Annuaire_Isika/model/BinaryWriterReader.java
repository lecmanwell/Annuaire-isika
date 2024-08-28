package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BinaryWriterReader {
	
// A ajouter dans la classe noeud
	// RAF argument de la méthode
	// RAf instancié dans la classe Tree + dans méthode récursive
	public void writeBinary(Student student) {
		try {

			RandomAccessFile raf = new RandomAccessFile("src/main/resources/binarySave.bin", "rw");
			raf.seek(raf.length());
			raf.writeChars(student.getLastNameLong());
			raf.writeChars(student.getFirstNameLong());
			raf.writeChars(student.getLocationLong());
			raf.writeChars(student.getNamePromoLong());
			raf.writeInt(student.getYearPromo());

			raf.close();
		} catch (Exception e) {
			System.out.println("no file found");
		}
	}

	public Student readBinary() {

		try {
			RandomAccessFile rafR = new RandomAccessFile("src/main/resources/binarySave.bin", "r");

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

				int studentYearPromo = rafR.readInt();
//				System.out.println("Un étudiant : " + studentLastName + " " + studentFirstName + " " + studentLocation
//						+ " " + studentNamePromo + " " + studentYearPromo + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}
	
	public Student readBinaryTest() {

		try {
			RandomAccessFile rafR = new RandomAccessFile("src/main/resources/binarySave.bin", "r");

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

				int studentYearPromo = rafR.readInt();
				int leftChild = rafR.readInt();
				int rightChild = rafR.readInt();
				int doublon = rafR.readInt();
				
				System.out.println("Un étudiant : " + studentLastName + " " + studentFirstName + " " + studentLocation
						+ " " + studentNamePromo + " " + studentYearPromo + " " + leftChild + " " + rightChild + " " + doublon);
			}

		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}
}
