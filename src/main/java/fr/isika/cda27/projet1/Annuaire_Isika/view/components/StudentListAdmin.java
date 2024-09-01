package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.util.Callback;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
 * Classe représentant une table affichant la liste des étudiants avec des
 * options d'édition et de suppression. Cette table est utilisée dans le
 * contexte de l'administration des étudiants.
 */
public class StudentListAdmin extends TableView {

	Student previous;

	/** Liste observable contenant les étudiants affichés dans la table. */
	public ObservableList<Student> myObservableArrayList;
	
	Scene scene;
	TreeDAO tree;
	String iconPath = "/Images/trashIcon.png";
	boolean isAdmin;

	/**
	 * Retourne la liste observable des étudiants.
	 *
	 * @return La liste observable des étudiants.
	 */
	public ObservableList<Student> getMyObservableArrayList() {
		return myObservableArrayList;
	}

	/**
	 * Constructeur de la classe. Initialise la table des étudiants en créant et en
	 * configurant les colonnes, et en liant les données des étudiants.
	 *
	 * @param scene La scène à laquelle cette table est attachée.
	 * @param tree  L'objet {@code TreeDAO} utilisé pour accéder aux données des
	 *              étudiants.
	 */
	@SuppressWarnings("unchecked")
	public StudentListAdmin(Scene scene, TreeDAO tree, boolean isAdmin) {
		super();
		this.scene = scene;
		this.tree = tree;
		this.isAdmin = isAdmin;

		// Chargement des données des étudiants à partir de {@code TreeDAO}
		ArrayList<Student> list = tree.setAlphaList();
//		System.out.println(tree.getStudents());
		myObservableArrayList = FXCollections.observableArrayList(list);
		this.setItems(myObservableArrayList);

		// Création et configuration des colonnes
		TableColumn<Student, String> colNom = new TableColumn<>("Nom");
		colNom.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		colNom.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
		colNom.setPrefWidth(this.isAdmin? 150 : 180);

		TableColumn<Student, String> colPrenom = new TableColumn<>("Prenom");
		colPrenom.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		colPrenom.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
		colPrenom.setPrefWidth(this.isAdmin? 150 : 174);

		TableColumn<Student, String> colLocation = new TableColumn<>("Département");
		colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
		colLocation.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
		colLocation.setPrefWidth(100);

		TableColumn<Student, String> colNamePromo = new TableColumn<>("Formation");
		colNamePromo.setCellValueFactory(new PropertyValueFactory<>("namePromo"));
		colNamePromo.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
		colNamePromo.setPrefWidth(this.isAdmin? 138 : 150);

		TableColumn<Student, Integer> colYear = new TableColumn<>("Année de formation");
		colYear.setCellValueFactory(new PropertyValueFactory<>("yearPromo"));
		colYear.setCellFactory(column -> new ChoiceBoxTableCell());
//		colYear.setCellFactory(ChoiceBoxTableCell.<Student>forTableColumn(colYear));
		colYear.setPrefWidth(138);

		TableColumn<Student, Void> colAction = new TableColumn<>("");
		ImageView trashIcon = new ImageView(new Image(getClass().getResourceAsStream(iconPath)));
		trashIcon.setFitHeight(15);
		trashIcon.setFitWidth(15);

		if (this.isAdmin) {
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
									// TODO Auto-generated catch block
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
								// Afficher le bouton uniquement lorsque la ligne est sélectionnée
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

		// Ajouter un écouteur pour rafraîchir la table lorsque la sélection change
		this.getSelectionModel().selectedIndexProperty().addListener((obs, oldSelection, newSelection) -> {
			this.refresh(); // Rafraîchir la table pour mettre à jour l'affichage des boutons
		});

		
		colAction.setPrefWidth(this.isAdmin? 65 : 0);

		// Ajout des colonnes à la table
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
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					previous = new Student(newValue.getLastName(), newValue.getFirstName(), newValue.getLocation(),
							newValue.getNamePromo(), newValue.getYearPromo());

				}

			});
		}
	
	}

}
