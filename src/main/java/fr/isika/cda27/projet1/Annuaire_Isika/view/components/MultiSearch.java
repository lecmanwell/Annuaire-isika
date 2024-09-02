package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Tree;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javafx.geometry.Insets;
import javafx.scene.Scene;

/**
 * Classe représentant un composant de recherche multi-critères dynamique. Cette classe
 * permet de créer des interfaces de recherche pour les utilisateurs et les
 * administrateurs, avec différents champs de saisie et options de filtrage.
 */

public class MultiSearch extends GridPane {
	Scene scene;
	Tree tree;

	TextField lastNameField = new TextField();
	TextField firstNameField = new TextField();
	ComboBox<String> formationComboBox = new ComboBox<String>();
	ComboBox<Integer> anneeFormationComboBox = new ComboBox<Integer>();
	ComboBox<String> departementComboBox = new ComboBox<String>();
	StudentListAdmin studentList;
	
	ArrayList<String> listFormations;

	/**
	 * Constructeur de la classe. Initialise le composant en liant la scène fournie.
	 *
	 * @param scene La scène dans laquelle ce composant sera utilisé.
	 * @param tree  L'arbre contenant la liste des étudiants pour les opérations de recherche.
	 */
	public MultiSearch(Scene scene, Tree tree) {
		super();
		this.scene = scene;
		this.tree = tree;
	}

	/**
	 * Crée et configure les champs de recherche pour les utilisateurs. Les champs
	 * incluent les noms, les prénoms, la formation, l'année de formation et le
	 * département. Ajoute les composants au {@code GridPane} avec des espacements
	 * et des marges définis.
	 * Configure également les boutons pour réinitialiser les filtres et ajouter de nouveaux étudiants si l'utilisateur est un administrateur.
	 * @param studentList La liste des étudiants affichée à l'utilisateur.
	 * @param isAdmin     Un booléen indiquant si l'utilisateur est un administrateur. Si c'est le cas, des fonctionnalités supplémentaires sont activées.
	 */

	public void multiSearch(StudentListAdmin studentList, boolean isAdmin) {
		this.studentList = studentList;

		// Configuration des champs de saisie et des ComboBox
		lastNameField.setPrefHeight(200);
		lastNameField.setPrefWidth(300);
		lastNameField.setPromptText("Nom");

		firstNameField.setPromptText("Prénom");
		firstNameField.setPrefHeight(200);
		firstNameField.setPrefWidth(300);

		formationComboBox.setPromptText("Formation");
		formationComboBox.setPrefHeight(200);
		formationComboBox.setPrefWidth(300);
		formationComboBox.setButtonCell(new ListCell<String>() {
			protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(formationComboBox.getPromptText());
                        } else {
                            setText(item);
                        }
                    }
		});
		
		anneeFormationComboBox.setPromptText("Année de formation");
		anneeFormationComboBox.setPrefHeight(200);
		anneeFormationComboBox.setPrefWidth(300);
		anneeFormationComboBox.setButtonCell(new ListCell<Integer>() {
			protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(anneeFormationComboBox.getPromptText());
                    } else {
                        setText(String.valueOf(item));
                    }
                }
            });
		
		departementComboBox.setPromptText("Département");
		departementComboBox.setPrefHeight(200);
		departementComboBox.setPrefWidth(300);
		departementComboBox.setButtonCell(new ListCell<>() {
		        protected void updateItem(String item, boolean empty) {
		            super.updateItem(item, empty);
		            if (item == null || empty) {
		                setText(departementComboBox.getPromptText());
		            } else {
		                setText(item);
		            }
		        }
		    });
		

		this.add(lastNameField, 0, 0);
		this.add(firstNameField, 0, 1);
		this.add(formationComboBox, 1, 0);
		this.add(anneeFormationComboBox, 1, 1);
		this.add(departementComboBox, 2, 1);
		this.setHgap(40);
		this.setVgap(20);
		this.setPadding(new Insets(0, 0, 20, 5));
		this.setHeight(100);
		this.setMaxHeight(120);
		
		// Configuration du bouton pour réinitialiser les filtres
		CustomButton btnResetFilter = new CustomButton(this.scene, this.tree);
		btnResetFilter.setResetFilter();
		btnResetFilter.setOnAction((e) -> {
			lastNameField.clear();
            firstNameField.clear();
            formationComboBox.setValue(null);
            formationComboBox.setPromptText("Formation");
            
            anneeFormationComboBox.setPromptText("Année de formation");
            anneeFormationComboBox.setValue(null);
            
            departementComboBox.getSelectionModel().clearSelection();
            departementComboBox.setValue(null);
		});
		this.add(btnResetFilter, 3, 0);
		
		// Si l'utilisateur est un administrateur, ajouter un bouton pour accéder à l'interface d'ajout d'étudiant
		if (isAdmin) {
			CustomButton btnGoToAddStudent = new CustomButton(this.scene, this.tree);
			btnGoToAddStudent.goToAddStudent();
			this.add(btnGoToAddStudent, 3, 1);
		}
		
		// Configuration des filtres pour mettre à jour dynamiquement la liste des étudiants affichée
		FilteredList<Student> filteredData = new FilteredList<>(studentList.getMyObservableArrayList(), p -> true);
		lastNameField.textProperty().addListener((observable, olvValue, newValue) -> {
			filteredData.setPredicate(student -> filterStudent(student));
		});
		firstNameField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(student -> filterStudent(student));
		});
		departementComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(student -> filterStudent(student));
		});
		formationComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(student -> filterStudent(student));
		});
		anneeFormationComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(student -> filterStudent(student));
		});
		
		// Mise à jour de la tableView avec les données filtrées
		studentList.refreshList(filteredData);
		this.fillComboBoxWithPossibleValues();
		
	}
		/**
		 * Applique les critères de recherche pour filtrer un étudiant.
		 * <p>
		 * Cette méthode vérifie chaque champ de saisie pour déterminer si un étudiant correspond aux critères de recherche spécifiés.
		 * Si un critère est rempli et qu'un étudiant ne correspond pas à ce critère, la méthode retourne {@code false}, sinon {@code true}.
		 * </p>
		 * 
		 * @param student L'étudiant à évaluer.
		 * @return {@code true} si l'étudiant correspond aux critères de recherche, sinon {@code false}.
		 */
		public boolean filterStudent(Student student) {
			if (!lastNameField.getText().isEmpty()
					&& !student.getLastName().toLowerCase().contains(lastNameField.getText().toLowerCase())) {
				return false;
			}
			if (!firstNameField.getText().isEmpty()
					&& !student.getFirstName().toLowerCase().contains(firstNameField.getText().toLowerCase())) {
				return false;
			}
			if (departementComboBox.getValue() != null && !departementComboBox.getValue().equals(student.getLocation())) {
				return false;
			}
			if (formationComboBox.getValue() != null && !formationComboBox.getValue().equals(student.getNamePromo())) {
				return false;
			}
			if (anneeFormationComboBox.getValue() != null
					&& !anneeFormationComboBox.getValue().equals(student.getYearPromo())) {
				return false;
			}
			return true;
		}




	/**
	 * Remplit les ComboBox avec les valeurs possibles dérivées de la liste
	 * d'étudiants. Cette méthode récupère une liste d'étudiants à partir de l'arbre
	 * (`tree`) et extrait les valeurs possibles pour les promotions, les
	 * localisations, et les années de promotion. Elle trie ensuite ces valeurs et
	 * les assigne aux ComboBox correspondantes pour la formation, le département,
	 * et l'année de formation.
	 */
	public void fillComboBoxWithPossibleValues() {
		
		ArrayList<Student> studentList = this.tree.setAlphaList();

		Set<String> possiblePromo = new HashSet<String>();
		Set<String> possibleLocation = new HashSet<String>();
		Set<Integer> possibleYearPromo = new HashSet<Integer>();

		for (Student student : studentList) {
			if (student.getNamePromo() != null) {
				possiblePromo.add(student.getNamePromo());
			}
			if (student.getLocation() != null) {
				possibleLocation.add(student.getLocation());
			}
			if (student.getYearPromo() > 0) {
				possibleYearPromo.add(student.getYearPromo());
			}
		}

		// Tri des valeurs possibles pour garantir un affichage ordonné dans les ComboBox
		ArrayList<String> sortedPromo = new ArrayList<String>(possiblePromo);
		Collections.sort(sortedPromo);

		ArrayList<String> sortedLocation = new ArrayList<String>(possibleLocation);
		Collections.sort(sortedLocation);

		ArrayList<Integer> sortedYearPromo = new ArrayList<Integer>(possibleYearPromo);
		Collections.sort(sortedYearPromo);

		// Remplissage des ComboBox avec les valeurs triées
		this.formationComboBox.setItems(FXCollections.observableArrayList(sortedPromo));
		this.departementComboBox.setItems(FXCollections.observableArrayList(sortedLocation));
		this.anneeFormationComboBox.setItems(FXCollections.observableArrayList(sortedYearPromo));
	}
}
