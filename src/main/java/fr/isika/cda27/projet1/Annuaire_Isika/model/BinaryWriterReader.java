package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BinaryWriterReader {

	private File file;

	public void writeBinary(Student student) {
		try {

			RandomAccessFile raf = new RandomAccessFile("src/main/resources/binarySave.bin", "rw");
			raf.seek(raf.length());
			raf.writeChars(student.getStudentLastNameLong());
			raf.writeChars(student.getStudentFirstNameLong());
			raf.writeChars(student.getStudentLocationLong());
			raf.writeChars(student.getStudentNamePromoLong());
			raf.writeInt(student.getYearPromo());

			raf.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("no file found");
		}
	}

	public Student readBinary() {

		FileReader reader;
		try {
			RandomAccessFile rafR = new RandomAccessFile("src/main/resources/binarySave.bin", "r");

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
			System.out.println("+++++++++++++++++++++" + studentLastName + " " + studentFirstName + " "
					+ studentLocation + " " + studentNamePromo + " " + studentYearPromo);

		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}
}
