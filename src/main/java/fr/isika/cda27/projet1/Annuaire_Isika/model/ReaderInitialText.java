package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class ReaderInitialText {

	public void readInitialText(String filePath) throws IOException {

		//test presence de fichiers txt ds le fichiers ressource
		//si pas demander de telelcharger un fochier txt avec les students
		
		//test si ficheir de sauvegarde present
		//afficher alert si on affiche ce fichier
		
		readTextFileAndAddStudent(filePath);
		
			
//		Directory.getInstance().toString();
	}
	
	public void readTextFileAndAddStudent(String filePath) throws IOException {
		
		Directory dir = new Directory();
		
		try {
			// Le fichier d'entrée
			File file = new File(filePath);
			// Créer l'objet File Reader
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			Student student = new Student();
			int indice = 0;
			while ((line = br.readLine()) != null) {
				switch (indice) {
				case 0:
					student.setLastName(line);
					indice++;
					break;
					
                case 1:
                	student.setFirstName(line);
                    indice++;
                    break;
                    
                case 2:
                	student.setLocation(line);
                    indice++;
                    break;
                    
                case 3:
                	student.setNamePromo(line);
                    indice++;
                    break;
                    
                case 4:
                	student.setYearPromo(Integer.parseInt(line));
                    indice++;
					break;

				default:
					indice = 0;
					dir.addStudentToList(student);
					dir.addStudentToTree(student);
					student = new Student();
					break;
				}
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.print("Document : " + filePath + " introuvable.  ");
		}
		
		//Lecture fichier binaire pour nos tests
//		Node test = new Node();
//		test.readBinaryTest();
	}
}
