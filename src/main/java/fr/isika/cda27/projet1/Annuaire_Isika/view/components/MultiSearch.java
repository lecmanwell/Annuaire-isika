package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javafx.geometry.Insets;
import javafx.scene.Scene;

/**
 * Classe représentant un composant de recherche multi-critères. Cette classe
 * permet de créer des interfaces de recherche pour les utilisateurs et les
 * administrateurs, avec différents champs de saisie et options de filtrage.
 */

public class MultiSearch extends GridPane {
//--------------------
	public TextField getLastNameField() {
		return lastNameField;
	}

	public void setLastNameField(TextField lastNameField) {
		this.lastNameField = lastNameField;
	}

	public TextField getFirstNameField() {
		return firstNameField;
	}

	public void setFirstNameField(TextField firstNameField) {
		this.firstNameField = firstNameField;
	}

	public ComboBox<String> getFormationComboBox() {
		return formationComboBox;
	}

	public void setFormationComboBox(ComboBox<String> formationComboBox) {
		this.formationComboBox = formationComboBox;
	}

	public ComboBox<Integer> getAnneeFormationComboBox() {
		return anneeFormationComboBox;
	}

	public void setAnneeFormationComboBox(ComboBox<Integer> anneeFormationComboBox) {
		this.anneeFormationComboBox = anneeFormationComboBox;
	}

	public ComboBox<String> getDepartementChoiceBox() {
		return departementComboBox;
	}

	public void setDepartementChoiceBox(ComboBox<String> departementChoiceBox) {
		this.departementComboBox = departementChoiceBox;
	}
//	-------------------

	Scene scene;
	TreeDAO tree;

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
	 */

	public MultiSearch(Scene scene, TreeDAO tree) {
		super();
		this.scene = scene;
		this.tree = tree;
		this.listFormations = this.getFormations();

		this.fillComboBoxWithPossibleValues();
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
		ArrayList<Student> studentList = this.tree.getStudents();

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

		ArrayList<String> sortedPromo = new ArrayList<String>(possiblePromo);
		Collections.sort(sortedPromo);

		ArrayList<String> sortedLocation = new ArrayList<String>(possibleLocation);
		Collections.sort(sortedLocation);

		ArrayList<Integer> sortedYearPromo = new ArrayList<Integer>(possibleYearPromo);
		Collections.sort(sortedYearPromo);

		formationComboBox.setItems(FXCollections.observableArrayList(sortedPromo));
		departementComboBox.setItems(FXCollections.observableArrayList(sortedLocation));
		anneeFormationComboBox.setItems(FXCollections.observableArrayList(sortedYearPromo));

	}

	/**
	 * Crée et configure les champs de recherche pour les utilisateurs. Les champs
	 * incluent les noms, les prénoms, la formation, l'année de formation et le
	 * département. Ajoute les composants au {@code GridPane} avec des espacements
	 * et des marges définis.
	 */

	public void multiSearch(StudentListAdmin studentList, boolean isAdmin) {
		this.studentList = studentList;

		lastNameField.setPrefHeight(200);
		lastNameField.setPrefWidth(300);
		lastNameField.setPromptText("Nom");

		firstNameField.setPromptText("Prénom");
		firstNameField.setPrefHeight(200);
		firstNameField.setPrefWidth(300);

		formationComboBox.setPromptText("Formation");
		formationComboBox.setPrefHeight(200);
		formationComboBox.setPrefWidth(300);

		anneeFormationComboBox.setPromptText("Année de formation");
		anneeFormationComboBox.setPrefHeight(200);
		anneeFormationComboBox.setPrefWidth(300);

		departementComboBox.setPromptText("Département");
		departementComboBox.setPrefHeight(200);
		departementComboBox.setPrefWidth(300);

		this.add(lastNameField, 0, 0);
		this.add(firstNameField, 0, 1);
		this.add(formationComboBox, 1, 0);
		this.add(anneeFormationComboBox, 1, 1);
		this.add(departementComboBox, 2, 1);
		this.setHgap(70);
		this.setVgap(20);
		this.setPadding(new Insets(0, 0, 20, 5));
		this.setHeight(100);
		this.setMaxHeight(120);

		if (isAdmin) {
			CustomButton btnGoToAddStudent = new CustomButton(scene, tree);
			btnGoToAddStudent.goToAddStudent();
			this.add(btnGoToAddStudent, 3, 1);
		}

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
//        ((TableView) studentList.getItems()).setItems(filteredData);
		studentList.refreshList(filteredData);

	}

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
	 * Crée et configure les champs de recherche pour les administrateurs. Les
	 * champs incluent les noms, les prénoms, la formation, l'année de formation, et
	 * le département. Ajoute un bouton pour accéder à l'ajout de nouveaux
	 * étudiants. Les composants sont ajoutés au {@code GridPane} avec des
	 * espacements et des marges définis.
	 */

//	public void multiSearchAdmin(StudentListAdmin studentList) {
////			GridPane multisearchAdmin = new GridPane();
//
//		TextField lastNameField = new TextField("Nom");
//		lastNameField.setPrefHeight(200);
//		lastNameField.setPrefWidth(300);
//		lastNameField.setOnMouseClicked(event -> {
//			lastNameField.clear();
//		});
//
//		lastNameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
//			if (!newValue && lastNameField.getText().isEmpty()) {
//				lastNameField.setText("Nom");
//			}
//		});
//
//		TextField firstNameField = new TextField("Prénom");
//		firstNameField.setPrefHeight(200);
//		firstNameField.setPrefWidth(300);
//		firstNameField.setOnMouseClicked(event -> {
//			firstNameField.clear();
//
//		});
//
//		firstNameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
//			if (!newValue && firstNameField.getText().isEmpty()) {
//				firstNameField.setText("Prénom");
//			}
//		});
//
//		ComboBox<String> formationComboBox = new ComboBox<String>();
//		formationComboBox.setPromptText("Formation");
//		formationComboBox.setPrefHeight(200);
//		formationComboBox.setPrefWidth(300);
//		formationComboBox.setItems(FXCollections.observableArrayList(getFormations()));
//
//		ComboBox<String> anneeFormationComboBox = new ComboBox<String>();
//		anneeFormationComboBox.setPromptText("Année de formation");
//		anneeFormationComboBox.setPrefHeight(200);
//		anneeFormationComboBox.setPrefWidth(300);
//
//		ComboBox<String> departementChoiceBox = new ComboBox<String>();
//		departementChoiceBox.setPromptText("Département");
//		departementChoiceBox.setPrefHeight(200);
//		departementChoiceBox.setPrefWidth(300);
//
//		CustomButton btnGoToAddStudent = new CustomButton(scene, this.tree);
//		btnGoToAddStudent.goToAddStudent();
//
//		this.add(lastNameField, 0, 0);
//		this.add(firstNameField, 0, 1);
//		this.add(formationComboBox, 1, 0);
//		this.add(anneeFormationComboBox, 1, 1);
//		this.add(departementChoiceBox, 2, 1);
//		this.add(btnGoToAddStudent, 3, 1);
//		this.setHgap(70);
//		this.setVgap(20);
//		this.setPadding(new Insets(0, 0, 20, 5));
////			return this;
//	}

	public ArrayList<String> getFormations() {

		ArrayList<Student> listStudent = this.tree.getStudents();
		for (Student stud : listStudent) {
//			this.listFormations.add(stud.getNamePromo());
//			System.out.println(stud.getNamePromo());
		}

		return this.listFormations;

	}

}
