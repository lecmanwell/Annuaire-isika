package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * La classe ReaderInitialText est responsable de la lecture d'un fichier texte
 * contenant des informations sur les étudiants, et de leur ajout à un annuaire
 * (Directory).
 */

public class ReaderInitialText {

	/**
	 * Méthode permettant de lire le fichier initial à partir du chemin de fichier
	 * spécifié et d'ajouter les étudiants au répertoire. Cette méthode vérifie
	 * d'abord la présence d'un fichier texte dans le répertoire des ressources, et
	 * le lit ensuite pour ajouter les informations des étudiants à l'annuaire.
	 *
	 * @param filePath Le chemin du fichier à lire.
	 * @throws IOException Si une erreur d'entrée/sortie se produit lors de la
	 *                     lecture du fichier.
	 */

	public void readInitialText(String filePath, TreeDAO tree) throws IOException {

		// test si ficheir de sauvegarde present


		File file = new File("src/main/resources/binarySave.bin");

		// If the text file does not exist, check for a binary file
		if (file.getPath().endsWith(".bin") && file.length() > 0) {

		} else if (file.exists() && file.isFile()) {

			// if file is txt file read it
			if (filePath.endsWith(".txt") || filePath.endsWith(".DON")) {
				readTextFileAndAddStudent(filePath, tree);
			} else {
				System.err.println("lle fichier n'est pas un fichier texte.");
			}
		} else {
			System.err.println("Pas de ficheirs de sauvegarde.");
		}

	}
	

	/**
	 * Méthode permettant de lire un fichier texte à partir du chemin spécifié et
	 * d'ajouter les informations des étudiants au répertoire.
	 *
	 * @param filePath Le chemin du fichier texte à lire.
	 * @throws IOException Si une erreur d'entrée/sortie se produit lors de la
	 *                     lecture du fichier.
	 */

	public void readTextFileAndAddStudent(String filePath, TreeDAO tree) throws IOException {

		Directory dir = new Directory(tree);

		try {
			// Le fichier d'entrée
			File file = new File(filePath);
			// Création de l'objet FileReader
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			Student student = new Student();
			int indice = 0;
			// Lecture ligne par ligne du fichier texte et ajout des informations des
			// étudiants
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

		// Lecture d'un fichier binaire pour les tests
//		Node test = new Node();
//		test.readBinaryTest();
	}
}