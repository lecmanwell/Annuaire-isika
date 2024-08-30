package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import java.io.FileNotFoundException;
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

public class StudentListAdmin extends TableView {

	public ObservableList<Student> myObservableArrayList;
	Scene scene;
	TreeDAO tree;
	String iconPath = "/Images/trashIcon.png";

	public ObservableList<Student> getMyObservableArrayList() {
		return myObservableArrayList;
	}


	// On instancie une TableView que l'on bind à notre liste observable
	@SuppressWarnings("unchecked")
	public StudentListAdmin(Scene scene, TreeDAO tree) {
		super();
		this.scene = scene;
		this.tree = tree;
		ArrayList<Student> list = tree.setAlphaList(); 
		System.out.println(tree.getStudents());
		myObservableArrayList = FXCollections.observableArrayList(list);
	
		this.setItems(myObservableArrayList);

		// On créé la première colonne qui va afficher le nom des stagiaires
		TableColumn<Student, String> colNom = new TableColumn<>("Nom");
		colNom.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		colNom.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
		colNom.setPrefWidth(150);
		
		TableColumn<Student, String> colPrenom = new TableColumn<>("Prenom");
		colPrenom.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		colPrenom.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
		colPrenom.setPrefWidth(150);


		TableColumn<Student, String> colLocation = new TableColumn<>("Département");
		colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
		colLocation.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
		colLocation.setPrefWidth(100);


		TableColumn<Student, String> colNamePromo = new TableColumn<>("Formation");
		colNamePromo.setCellValueFactory(new PropertyValueFactory<>("namePromo"));
		colNamePromo.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
		colNamePromo.setPrefWidth(138);


		TableColumn<Student, Integer> colYear = new TableColumn<>("Année de formation");
		colYear.setCellValueFactory(new PropertyValueFactory<>("yearPromo"));
		colYear.setCellFactory(column -> new ChoiceBoxTableCell());
//		colYear.setCellFactory(ChoiceBoxTableCell.<Student>forTableColumn(colYear));
		colYear.setPrefWidth(138);

	
		TableColumn<Student, Void> colAction = new TableColumn<>("");
		ImageView trashIcon = new ImageView(new Image(getClass().getResourceAsStream(iconPath)));
		trashIcon.setFitHeight(15);
		trashIcon.setFitWidth(15);

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
						});
					}

					@Override
					protected void updateItem(Void item, boolean empty) {
						  super.updateItem(item, empty);
	                        if (empty) {
	                            setGraphic(null);
	                        } else {
	                            // Afficher le bouton uniquement sur la ligne sélectionnée
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
        // Ajouter un écouteur pour rafraîchir la table lorsque la sélection change
        this.getSelectionModel().selectedIndexProperty().addListener((obs, oldSelection, newSelection) -> {
            this.refresh(); // Rafraîchir la table pour mettre à jour l'affichage des boutons
        });
			
			
			

	
		
		 


		colAction.setPrefWidth(65);


		// On ajoute les colonnes à la tableView
		this.getColumns().addAll(colNom, colPrenom, colLocation, colNamePromo, colYear, colAction);
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
			}				
			
		});
		
		

	}
	
}
