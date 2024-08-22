package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Directory;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class HomeView extends VBox {

	private Scene scene;
	public ObservableList<Student> myObservableArrayList;

	public HomeView(Scene scene) {
		super();
		this.scene = scene;

		myObservableArrayList = FXCollections.observableArrayList(Directory.getStudentsList());
		System.out.println("-------------------" + myObservableArrayList.toString());

//		 for (Student stud : myObservableArrayList) {
//			 Label lastNameLbl = new Label(stud.getLastName());
//			 Label firstNameLbl = new Label(stud.getFirstName());
//			 this.getChildren().addAll(lastNameLbl, firstNameLbl);
//			 
//		 }

		// On instancie une TableView que l'on bind à notre liste observable
		TableView<Student> tableView = new TableView<Student>(myObservableArrayList);

		// On créé la première colonne qui va afficher le nom des stagiaires
		TableColumn<Student, String> colNom = new TableColumn<Student, String>("Nom");
		colNom.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));

		// On créé la première colonne qui va afficher le nom des stagiaires
		TableColumn<Student, String> colPrenom = new TableColumn<Student, String>("Prenom");
		colPrenom.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));

		TableColumn<Student, String> colLocation = new TableColumn<Student, String>("Location");
		colLocation.setCellValueFactory(new PropertyValueFactory<Student, String>("location"));

		TableColumn<Student, String> colNamePromo = new TableColumn<Student, String>("Name Promo");
		colNamePromo.setCellValueFactory(new PropertyValueFactory<Student, String>("namePromo"));

		TableColumn<Student, Integer> colYear = new TableColumn<>("year");
		colYear.setCellValueFactory(new PropertyValueFactory<Student, Integer>("yearPromo"));

		// On ajoute les colonnes à la tableView
		tableView.getColumns().addAll(colNom, colPrenom, colLocation, colNamePromo, colYear);
		this.getChildren().add(tableView);
		scene.setRoot(this);
	}

}
