package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Directory;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class StudentListAdmin extends TableView {

	public ObservableList<Student> myObservableArrayList;
	Scene scene;

	// On instancie une TableView que l'on bind à notre liste observable
	public StudentListAdmin(Scene scene) {
		super();
		this.scene = scene;
		System.out.println(TreeDAO.getStudents());
		myObservableArrayList = FXCollections.observableArrayList(TreeDAO.getStudents());
	
		this.setItems(myObservableArrayList);

		// On créé la première colonne qui va afficher le nom des stagiaires
		TableColumn<Student, String> colNom = new TableColumn<>("Nom");
		colNom.setCellValueFactory(new PropertyValueFactory<>("lastName"));

		// On créé la première colonne qui va afficher le nom des stagiaires
		TableColumn<Student, String> colPrenom = new TableColumn<>("Prenom");
		colPrenom.setCellValueFactory(new PropertyValueFactory<>("firstName"));

		TableColumn<Student, String> colLocation = new TableColumn<>("Département");
		colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));

		TableColumn<Student, String> colNamePromo = new TableColumn<>("Formation");
		colNamePromo.setCellValueFactory(new PropertyValueFactory<>("namePromo"));

		TableColumn<Student, Integer> colYear = new TableColumn<>("Année de formation");
		colYear.setCellValueFactory(new PropertyValueFactory<>("yearPromo"));
		
//		TableColumn<Student, Void> colAction = new TableColumn<>("Actions");
//		Button btnModify = new Button("Modifier");
//		Button btnDelete = new Button("Supprimer");
//		VBox buttonBox = new VBox(btnModify, btnDelete);
//		buttonBox.setVisible(false);
//		this.setOnMouseEntered(event -> buttonBox.setVisible(true));
//        this.setOnMouseExited(event -> buttonBox.setVisible(false));

		// On ajoute les colonnes à la tableView
		this.getColumns().addAll(colNom, colPrenom, colLocation, colNamePromo, colYear);
		
	}
}
