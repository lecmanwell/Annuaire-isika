package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import java.io.IOException;
import java.util.ArrayList;
import javafx.util.Callback;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Tree;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 * La classe `StudentListAdmin` est une extension de `TableView` utilisée pour
 * afficher une liste d'étudiants dans une interface utilisateur JavaFX. Cette
 * classe permet aux administrateurs de gérer les informations des étudiants, y
 * compris l'édition et la suppression.
 * 
 * @param <Student> Le type d'objet représentant un étudiant dans le tableau.
 * 
 * @author groupe1
 * @version 1.0
 */

public class StudentListAdmin extends TableView {

	Student previous;

	/**
	 * Liste observable des étudiants, utilisée pour mettre à jour dynamiquement la
	 * table.
	 */
	public ObservableList<Student> myObservableArrayList;

	/**
	 * Référence à la scène JavaFX actuelle.
	 */
	Scene scene;
	/**
	 * Arbre de données contenant la structure des étudiants.
	 */
	Tree tree;
	/**
	 * Chemin vers l'icône utilisée pour supprimer un étudiant (corbeille).
	 */
	String iconPath = "/Images/trashIcon.png";
	/**
	 * Indique si l'utilisateur actuel est un administrateur.
	 */
	boolean isAdmin;

	/**
	 * Retourne la liste observable des étudiants.
	 * 
	 * @return Liste observable des étudiants.
	 */
	public ObservableList<Student> getMyObservableArrayList() {
		return this.myObservableArrayList;
	}

	/**
	 * Constructeur de la classe `StudentListAdmin`. Initialise la table avec les
	 * données des étudiants et configure les colonnes selon les droits
	 * administratifs.
	 * 
	 * @param scene   La scène JavaFX associée à cette vue.
	 * @param tree    L'arbre de données contenant les étudiants.
	 * @param isAdmin Indique si l'utilisateur est un administrateur.
	 */
	@SuppressWarnings("unchecked")
	public StudentListAdmin(Scene scene, Tree tree, boolean isAdmin) {
		super();
		this.scene = scene;
		this.tree = tree;
		this.isAdmin = isAdmin;

		// Initialisation de la liste observable avec les données de l'arbre.
		ArrayList<Student> list = this.tree.setAlphaList();
		myObservableArrayList = FXCollections.observableArrayList(list);
		this.setItems(myObservableArrayList);

		// Configuration des colonnes pour chaque attribut des étudiants.
		TableColumn<Student, String> colNom = new TableColumn<>("Nom");
		colNom.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		colNom.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
		colNom.setPrefWidth(this.isAdmin ? 163 : 180);

		TableColumn<Student, String> colPrenom = new TableColumn<>("Prenom");
		colPrenom.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		colPrenom.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
		colPrenom.setPrefWidth(this.isAdmin ? 162 : 174);

		TableColumn<Student, String> colLocation = new TableColumn<>("Département");
		colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
		colLocation.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
		colLocation.setPrefWidth(100);

		TableColumn<Student, String> colNamePromo = new TableColumn<>("Formation");
		colNamePromo.setCellValueFactory(new PropertyValueFactory<>("namePromo"));
		colNamePromo.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
		colNamePromo.setPrefWidth(this.isAdmin ? 138 : 150);

		TableColumn<Student, Integer> colYear = new TableColumn<>("Année de formation");
		colYear.setCellValueFactory(new PropertyValueFactory<>("yearPromo"));
		colYear.setCellFactory(column -> new ChoiceBoxTableCell());
		colYear.setPrefWidth(138);

		TableColumn<Student, Void> colAction = new TableColumn<>("");
		ImageView trashIcon = new ImageView(new Image(getClass().getResourceAsStream(iconPath)));
		trashIcon.setFitHeight(15);
		trashIcon.setFitWidth(15);
		colAction.setPrefWidth(this.isAdmin ? 40 : 0);

		if (this.isAdmin) {
			// Ajoute un bouton de suppression pour chaque ligne si l'utilisateur est un
			// administrateur.
			colAction.setCellFactory(new Callback<>() {
				@Override
				public TableCell<Student, Void> call(final TableColumn<Student, Void> param) {
					return new TableCell<>() {
						private final Button deleteButton = new Button();
						{
							deleteButton.setGraphic(trashIcon);
							deleteButton.setOnAction((e) -> {
								Student student = getTableView().getItems().get(getIndex());
								myObservableArrayList.remove(student);
								try {
									tree.deleteStudent(student);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							});
						}

						@Override
						protected void updateItem(Void item, boolean empty) {
							super.updateItem(item, empty);
							if (empty) {
								setGraphic(null);
							} else {
								if (getTableView().getSelectionModel().isSelected(getIndex())) {
									setGraphic(deleteButton);
								} else {
									setGraphic(null);
								}
							}
						}

					};
				}
			});
		}

		// Rafraîchit la table lors du changement de sélection.
		this.getSelectionModel().selectedIndexProperty().addListener((obs, oldSelection, newSelection) -> {
			this.refresh();
		});

		// Ajoute les colonnes à la table en fonction du rôle (admin ou non).
		if (this.isAdmin) {

			this.getColumns().addAll(colNom, colPrenom, colLocation, colNamePromo, colYear, colAction);
		} else {

			this.getColumns().addAll(colNom, colPrenom, colLocation, colNamePromo, colYear);
		}
		if (this.isAdmin) {

			this.setEditable(true);

			this.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {

				@Override
				public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
					if (newValue != null) {
						colNom.setOnEditCommit((e) -> {
							newValue.setLastName(e.getNewValue());
						});
						colPrenom.setOnEditCommit((e) -> {
							newValue.setFirstName(e.getNewValue());
						});
						colNamePromo.setOnEditCommit((e) -> {
							newValue.setNamePromo(e.getNewValue());
						});
						colLocation.setOnEditCommit((e) -> {
							newValue.setLocation(e.getNewValue());
						});

					}

					if (oldValue != null) {
						try {
							tree.upDateStudent(previous, oldValue);

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					if (newValue != null) {
						previous = new Student(newValue.getLastName(), newValue.getFirstName(), newValue.getLocation(),
								newValue.getNamePromo(), newValue.getYearPromo());
					}
				}

			});
		}

	}

	/**
	 * Rafraîchit la liste affichée dans la table avec une liste filtrée
	 * d'étudiants.
	 * 
	 * @param list La liste filtrée des étudiants à afficher.
	 */
	public void refreshList(FilteredList<Student> list) {
		this.setItems(list);
	}

}
