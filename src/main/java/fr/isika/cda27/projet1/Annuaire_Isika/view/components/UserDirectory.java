package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import java.util.ArrayList;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Tree;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

/**
 * La classe UserDirectory représente un annuaire d'étudiants pour l'interface
 * utilisateur. Elle affiche les informations des étudiants dans une grille de
 * cartes d'étudiants. La classe utilise le modèle de données fourni par la
 * classe Tree pour récupérer la liste des étudiants.
 * 
 * @author groupe1
 * @version 1.0
 */
public class UserDirectory extends GridPane {

	/**
	 * La scène à laquelle la grille sera ajoutée.
	 */
	Scene scene;

	/**
	 * Constructeur de la classe UserDirectory.
	 *
	 * @param scene La scène à laquelle la grille sera ajoutée.
	 * @param tree  L'arbre binaire contenant la liste des étudiants.
	 */
	public UserDirectory(Scene scene, Tree tree) {

		super();
		this.scene = scene;
		this.setPadding(new Insets(20, 38, 20, 38));
		this.setHgap(30);
		this.setVgap(20);
		this.setStyle("-fx-background-color: #ffffff;");

		/**
		 * Récupère la liste des étudiants triés par ordre alphabétique à partir de
		 * l'arbre binaire.
		 */
		ArrayList<Student> ListStudents = tree.setAlphaList();

		int row = 0;
		int col = 0;
		for (Student student : ListStudents) {

			/**
			 * Crée une carte d'étudiant pour chaque étudiant et l'ajoute à la grille.
			 */

			StudentCard s = new StudentCard(student);
			this.add(s, col, row);

			if (col == 3) {
				col = 0;
				row++;
			} else {
				col++;
			}
		}

		/**
		 * Définit les largeurs des colonnes de la grille pour une disposition égale.
		 */
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(25);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(25);
		ColumnConstraints column3 = new ColumnConstraints();
		column3.setPercentWidth(25);
		ColumnConstraints column4 = new ColumnConstraints();
		column4.setPercentWidth(25);

		this.getColumnConstraints().addAll(column1, column2, column3, column4);

	}

}
