package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import fr.isika.cda27.projet1.Annuaire_Isika.view.AddStudentView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.AdminDirectoryView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.HomeView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.HomeViewAdmin;
import fr.isika.cda27.projet1.Annuaire_Isika.view.UserDirectoryView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CustomButton extends Button {  
	Scene scene;
	TreeDAO tree;

	public CustomButton(Scene scene) {
		super();
		this.scene = scene;
		this.tree = tree;

	}

	public void generateDocumentation() {
		this.setText("Comment fonction cet annuaire ?");
		this.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
		this.setOnAction((event) -> {
			File pdfFile = new File("src/main/resources/javafx-generate-pdf.pdf");
			if (pdfFile.exists()) {
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().open(pdfFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("AWT Desktop n'est pas supporté sur ce système");
				}
			} else {
				System.out.println("Le fichier PDF n'existe pas");
			}
		});

	}

	// Button to go to HomeViewAdmin
	public void adminAccess() {
		this.setText("Accès administrateur");
		this.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

		this.setOnAction((e) -> {
			scene.setRoot(new HomeViewAdmin(this.scene));

		});

	}

	// Button to go to UserDirectoryView
	public void goToDirectory() {
		this.setText("Accéder à l'annuaire");
		this.setStyle("-fx-background-color: #144d65; -fx-text-fill: white;");

		//
		this.setOnAction((e) -> {
			scene.setRoot(new UserDirectoryView(this.scene, tree));
		});

	}

	// Button to print to PDF the students
	public void printDirectory(StudentListAdmin tableView) {
		this.setText("Imprimer le PDF");
		this.setStyle("-fx-background-color: #144d65; -fx-text-fill: white; -fx-background-radius: 15; -fx-border-radius: 15;");
		this.setPadding(new Insets(3, 20, 3, 20));
		this.setOnAction((e) -> {
			try {
				this.generatePDF(tableView);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		

	}

	// Button to disconnect from the admin role
	public void logOut() {
		this.setText("Deconnexion");
		this.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-border-color: #db754a; -fx-border-radius: 15;");
		this.setPadding(new Insets(3, 20, 3, 20));
		this.setOnMouseEntered((e) -> {
			this.setStyle("-fx-background-color: #db754a; -fx-text-fill: white; -fx-border-color: #db754a; -fx-border-radius: 15; -fx-background-radius: 15;");
		});
		this.setOnMouseExited((e) -> {
			this.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-border-color: #db754a; -fx-border-radius: 15; -fx-background-radius: 15;");
		});
		this.setOnAction((e) -> {
			scene.setRoot(new HomeView(this.scene));
		});
	}

	public void modifyStudent() {
		this.setText("Modifier");

	}


	public void addStudent() {
		this.setText("Ajouter un stagiaire");
		this.setStyle("-fx-background-color: #144d65; -fx-text-fill: white;");

	}

	// Button to go back to the HomeView from the HomeViewAdmin
	public void backToHome() {
		this.setText("Retour");
		this.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
		
		this.setOnAction((e) -> {
			scene.setRoot(new HomeView(scene));
		});
		

	}

	// Buttons for the menu in HeaderViewGeneral

	public void homeButtonTitle() {
		this.setText("Accueil");
		this.setStyle("-fx-background-color: transparent;");
		this.setFont(Font.font("Futura", FontWeight.BOLD, 14));

		// hover effect
		this.setOnMouseEntered((e) -> {
			this.setTextFill(Color.web("#adb6b6"));
		});
		this.setOnMouseExited((e) -> {
			this.setTextFill(Color.web("#333333"));
		});

		// go to page action
		this.setOnAction((e) -> {
			scene.setRoot(new HomeView(scene));
		});
	}

	public void goToDirectoryTitle() {
		this.setText("Annuaire");
		this.setStyle("-fx-background-color: transparent;");
		this.setFont(Font.font("Futura", FontWeight.BOLD, 14));

		// hover effect
		this.setOnMouseEntered((e) -> {
			this.setTextFill(Color.web("#adb6b6"));
		});
		this.setOnMouseExited((e) -> {
			this.setTextFill(Color.web("#333333"));
		});

		// go to page action
		this.setOnAction((e) -> {
			scene.setRoot(new UserDirectoryView(scene, tree));
		});

	}
	
	

	public void adminAccessTitle() {
		this.setText("Administrateur");
		this.setStyle("-fx-background-color: transparent;");
		this.setFont(Font.font("Futura", FontWeight.BOLD, 14));

		// hover effect
		this.setOnMouseEntered((e) -> {
			this.setTextFill(Color.web("#adb6b6"));
		});
		this.setOnMouseExited((e) -> {
			this.setTextFill(Color.web("#333333"));
		});

		this.setOnAction((e) -> {
			scene.setRoot(new HomeViewAdmin(scene));
		});

	}

	public void addStudentFromFields(TextField lastNameTextField, TextField firstNameTextField,
			TextField locationTextField, TextField promoTextField, TextField yearPromoTextField) {
		this.setText("Valider");
		this.setStyle("-fx-background-color: #144d65; -fx-padding: 10 20; -fx-text-fill: white;");
	}
	
	
	private void generatePDF(StudentListAdmin tableView) throws IOException {
        String dest = "stagiaires.pdf";
        
        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Ajouter un titre
            document.add(new Paragraph("Liste des Stagiaires"));

            // Créer une table PDF
            // Ajouter les en-têtes des colonnes
            Table table = new Table(5);
            table.addCell(new Cell().add(new Paragraph("Nom")));
            table.addCell(new Cell().add(new Paragraph("Prénom")));
            table.addCell(new Cell().add(new Paragraph("Département")));            
            table.addCell(new Cell().add(new Paragraph("Formation")));
            table.addCell(new Cell().add(new Paragraph("Année de Formation")));
            ArrayList<Student> studentsArray = new ArrayList<Student>(tableView.getItems());
            		
            for (Student stagiaire : studentsArray) {
                table.addCell(new Cell().add(new Paragraph(stagiaire.getLastName())));
                table.addCell(new Cell().add(new Paragraph(stagiaire.getFirstName())));
                table.addCell(new Cell().add(new Paragraph(stagiaire.getLocation())));
                table.addCell(new Cell().add(new Paragraph(stagiaire.getNamePromo())));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(stagiaire.getYearPromo()))));
            }

            // Ajouter la table au document
            document.add(table);
            document.close();
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(dest));
            }
            System.out.println("PDF généré avec succès !");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        }
	
	public void goToAddStudent() {
		this.setText("Ajouter Stagiaire");
		this.setStyle("-fx-background-color: #144d65; -fx-text-fill: white; -fx-background-radius: 15; -fx-border-radius: 15;");
		this.setPrefHeight(200);
		this.setPrefWidth(315);
		this.setPadding(new Insets(3, 20, 3, 20));
		
		this.setOnAction((e) -> {
			scene.setRoot(new AddStudentView(scene));
		});

	}
	
	public void goToDirectoryAdmin() {
		this.setText("Annuaire");
		this.setStyle("-fx-background-color: transparent;");
		this.setFont(Font.font("Futura", FontWeight.BOLD, 14));

		// hover effect
		this.setOnMouseEntered((e) -> {
			this.setTextFill(Color.web("#adb6b6"));
		});
		this.setOnMouseExited((e) -> {
			this.setTextFill(Color.web("#333333"));
		});

		// go to page action
		this.setOnAction((e) -> {
			scene.setRoot(new AdminDirectoryView(scene));
		});

	}

}
