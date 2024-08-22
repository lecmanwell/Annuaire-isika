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
			raf.writeChars(student.getLastName());
			raf.writeChars(student.getFirstName());
			raf.writeChars(student.getLocation());
			raf.writeChars(student.getNamePromo());
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
			reader = new FileReader("src/main/resources/binarySave.bin");
			BufferedReader br = new BufferedReader(reader);
			String test;
			while (br.read() != -1) {
				test = br.readLine();
//				System.out.println("---tralala-------" +test);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}
}
