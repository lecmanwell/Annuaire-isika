package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * La classe ReaderInitialText est responsable de la lecture d'un fichier texte
 * contenant des informations sur les étudiants, et de leur ajout à un annuaire
 * (Directory).
 * 
 * @author groupe1
 * @version 1.0
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

	public void readInitialText(String filePath, Tree tree) throws IOException {

		File file = new File("src/main/resources/binarySave.bin");

		if (file.getPath().endsWith(".bin") && file.length() > 0) {
			// Si un fichier de sauvegarde binaire existe et n'est pas vide, aucune action
			// n'est effectuée.
		} else if (file.exists() && file.isFile()) {
			// Si le fichier spécifié par le chemin de fichier existe et est un fichier,
			// vérifie si le fichier est un fichier texte (avec l'extension .txt ou .DON).

			if (filePath.endsWith(".txt") || filePath.endsWith(".DON")) {
				readTextFileAndAddStudent(filePath, tree);
			} else {
				System.err.println("Le fichier n'est pas un fichier texte.");
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

	public void readTextFileAndAddStudent(String filePath, Tree tree) throws IOException {

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

	}
}