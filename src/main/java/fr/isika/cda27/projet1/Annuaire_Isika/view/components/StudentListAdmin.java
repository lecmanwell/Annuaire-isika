package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class StudentListAdmin extends TableView {

	public ObservableList<Student> myObservableArrayList;
	Scene scene;

	
	public ObservableList<Student> getMyObservableArrayList() {
		return myObservableArrayList;
	}


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
//		colYear.setCellFactory(ChoiceBoxTableCell.<Student>forTableColumn(colYear));

		colYear.setPrefWidth(138);
		
		TableColumn<Student, Void> colAction = new TableColumn<>("Actions");
		colAction.setPrefWidth(65);
//		Button btnModify = new Button("Modifier");
//		Button btnDelete = new Button("Supprimer");
//		VBox buttonBox = new VBox(btnModify, btnDelete);
//		buttonBox.setVisible(false);
//		this.setOnMouseEntered(event -> buttonBox.setVisible(true));
//        this.setOnMouseExited(event -> buttonBox.setVisible(false));
//        buttonBox.getChildren().addAll(btnModify, btnDelete);

		// On ajoute les colonnes à la tableView
		this.getColumns().addAll(colNom, colPrenom, colLocation, colNamePromo, colYear, colAction);
		this.setEditable(true);
		
	}
	
//	private void generatePDF() {
//        String dest = "stagiaires.pdf";
//
//        try {
//            PdfWriter writer = new PdfWriter(dest);
//            PdfDocument pdf = new PdfDocument(writer);
//            Document document = new Document(pdf);
//
//            // Ajouter un titre
//            document.add(new Paragraph("Liste des Stagiaires"));
//
//            // Créer une table PDF
//            // Ajouter les en-têtes des colonnes
//            Table table = new Table(5);
//            table.addCell(new Cell().add(new Paragraph("Nom")));
//            table.addCell(new Cell().add(new Paragraph("Prénom")));
//            table.addCell(new Cell().add(new Paragraph("Département")));            
//            table.addCell(new Cell().add(new Paragraph("Formation")));
//            table.addCell(new Cell().add(new Paragraph("Année de Formation")));
//           
//            ArrayList<Student> studentsArray = new ArrayList<Student>();
//            		studentsArray = (ArrayList<Student>) this.getItems();
//            for (Student stagiaire : studentsArray) {
//                table.addCell(new Cell().add(new Paragraph(stagiaire.getLastName())));
//                table.addCell(new Cell().add(new Paragraph(stagiaire.getFirstName())));
//                table.addCell(new Cell().add(new Paragraph(stagiaire.getLocation())));
//                table.addCell(new Cell().add(new Paragraph(stagiaire.getNamePromo())));
//                table.addCell(new Cell().add(new Paragraph(String.valueOf(stagiaire.getYearPromo()))));
//            }
//
//            // Ajouter la table au document
//            document.add(table);
//
//            document.close();
//            System.out.println("PDF généré avec succès !");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        }
}
