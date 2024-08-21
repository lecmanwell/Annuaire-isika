package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderInitialText {

	public void readInitialText(String filePath) {
		Directory directory = new Directory();

		try {
			// Le fichier d'entrée
			File file = new File(filePath);
			// Créer l'objet File Reader
			FileReader fr = new FileReader(file);
			// Créer l'objet BufferedReader
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			String line;
			Stagiaire stagiaire = new Stagiaire();
			int indice = 0;
			while ((line = br.readLine()) != null) {
				if (indice == 0) {
					stagiaire.setLastName(line);
					indice++;
				} else if (indice == 1) {
					stagiaire.setFirstName(line);
					indice++;
				} else if (indice == 2) {
					stagiaire.setLocation(line);
					indice++;
				} else if (indice == 3) {
					stagiaire.setNamePromo(line);
					indice++;
				} else if (indice == 4) {
					stagiaire.setYearPromo(Integer.parseInt(line));
					indice++;
				} else if (line.equals("*")) {
					indice = 0;
					directory.addStagiaire(stagiaire);
					stagiaire = new Stagiaire();
				}
				// ajoute la ligne au buffer
				sb.append(line);
				sb.append("\n");
			}
			fr.close();
//			System.out.println("Contenu du fichier: ");
//			System.out.println(sb.toString());  
		} catch (IOException e) {
			e.printStackTrace();
			System.err.print("Document : " + filePath + " introuvable.  ");
		}

		directory.toString();
	}

}
