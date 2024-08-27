package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.IOException;
import java.io.RandomAccessFile;

public class TreeDAO {
	
	private NodeDAO root;
	
	
	public TreeDAO() {
    }
	
	public void addToTree(Student student,RandomAccessFile raf) {
		if (this.root != null ) {
			this.root.insertNodeDAO(student, 0, raf);
		} else {
			this.root = new NodeDAO(student);
			//ecriture du root
			try {
				raf.seek(0);
				raf.writeChars(student.getStudentLastNameLong());
				raf.writeChars(student.getStudentFirstNameLong());
				raf.writeChars(student.getStudentLocationLong());
				raf.writeChars(student.getStudentNamePromoLong());
				raf.writeInt(student.getYearPromo());
				raf.writeInt(-1);
				raf.writeInt(-1);
				raf.writeInt(-1);
				raf.writeInt(-1);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
