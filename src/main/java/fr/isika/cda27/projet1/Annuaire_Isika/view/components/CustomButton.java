package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Classe représentant un bouton personnalisé pour l'application. Cette classe
 * permet de créer différents boutons avec des styles et actions spécifiques.
 */

public class CustomButton extends Button {
	Scene scene;
	TreeDAO tree;

	/**
	 * Constructeur pour initialiser un bouton personnalisé avec la scène.
	 * 
	 * @param scene La scène dans laquelle le bouton sera utilisé.
	 */

	public CustomButton(Scene scene, TreeDAO tree) {
		super();
		this.scene = scene;
		this.tree = tree;

	}

	/**
	 * Configure le bouton pour générer de la documentation en PDF et l'ouvrir. Le
	 * bouton affiche le texte "Comment fonctionne cet annuaire ?" et ouvre le
	 * fichier PDF lorsqu'il est cliqué.
	 */

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

	/**
	 * Configure le bouton pour accéder à la vue administrateur (HomeViewAdmin). Le
	 * bouton affiche le texte "Accès administrateur" et change la scène pour la vue
	 * administrateur lorsqu'il est cliqué.
	 */

	public void adminAccess() {
		this.setText("Accès administrateur");
		this.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

		this.setOnAction((e) -> {
			scene.setRoot(new HomeViewAdmin(this.scene, this.tree));

		});

	}

	/**
	 * Configure le bouton pour accéder à l'annuaire des utilisateurs
	 * (UserDirectoryView). Le bouton affiche le texte "Accéder à l'annuaire" et
	 * change la scène pour la vue de l'annuaire des utilisateurs lorsqu'il est
	 * cliqué.
	 */

	public void goToDirectory() {
		this.setText("Accéder à l'annuaire");
		this.setStyle("-fx-background-color: #144d65;-fx-padding: 10 20; -fx-text-fill: white;");

		//
		this.setOnAction((e) -> {
			scene.setRoot(new UserDirectoryView(this.scene, this.tree));
		});

	}

	/**
	 * Configure le bouton pour imprimer la liste des étudiants au format PDF. Le
	 * bouton affiche le texte "Imprimer le PDF" et appelle la méthode
	 * {@link #generatePDF(StudentListAdmin)} lorsqu'il est cliqué.
	 * 
	 * @param tableView La vue de la liste des étudiants à imprimer.
	 */

	public void printDirectory(StudentListAdmin tableView) {
		this.setText("Imprimer l'annuaire");
		this.setStyle(
				"-fx-background-color: #144d65; -fx-text-fill: white; -fx-background-radius: 15; -fx-border-radius: 15;");
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

	/**
	 * Configure le bouton pour la déconnexion. Le bouton affiche le texte
	 * "Déconnexion" et change la scène pour la vue d'accueil lorsqu'il est cliqué.
	 */

	public void logOut() {
		this.setText("Deconnexion");
		this.setStyle(
				"-fx-background-color: transparent; -fx-text-fill: black; -fx-border-color: #db754a; -fx-border-radius: 15;");
		this.setPadding(new Insets(3, 20, 3, 20));
		this.setOnMouseEntered((e) -> {
			this.setStyle(
					"-fx-background-color: #db754a; -fx-text-fill: white; -fx-border-color: #db754a; -fx-border-radius: 15; -fx-background-radius: 15;");
		});
		this.setOnMouseExited((e) -> {
			this.setStyle(
					"-fx-background-color: transparent; -fx-text-fill: black; -fx-border-color: #db754a; -fx-border-radius: 15; -fx-background-radius: 15;");
		});
		this.setOnAction((e) -> {
			scene.setRoot(new HomeView(this.scene, this.tree));
		});
	}

	public void modifyStudent() {
		this.setText("Modifier");

	}

	public void addStudent() {
		this.setText("Ajouter un stagiaire");
		this.setStyle("-fx-background-color: #144d65; -fx-text-fill: white;");

	}

	/**
	 * Configure le bouton pour revenir à la vue d'accueil depuis la vue d'accueil
	 * administrateur. Le bouton affiche le texte "Retoura l'accueil" et change la
	 * scène pour la vue d'accueil lorsqu'il est cliqué.
	 */

	public void backToHome() {
		this.setText("Retour a l'accueil");
		this.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

		this.setOnAction((e) -> {
			scene.setRoot(new HomeView(scene, this.tree));
		});

	}

	/**
	 * Configure le bouton pour afficher "Accueil" dans le menu de l'en-tête
	 * général. Le bouton affiche le texte "Accueil" et change la scène pour la vue
	 * d'accueil lorsqu'il est cliqué.
	 */

	public void homeButtonTitle() {
		this.setText("Accueil");
		this.setStyle("-fx-background-color: transparent;");
		this.setFont(Font.font("Futura", FontWeight.BOLD, 14));

		this.setOnMouseEntered((e) -> {
			this.setTextFill(Color.web("#adb6b6"));
		});
		this.setOnMouseExited((e) -> {
			this.setTextFill(Color.web("#333333"));
		});

		this.setOnAction((e) -> {
			scene.setRoot(new HomeView(scene, this.tree));
		});
	}

	/**
	 * Configure le bouton pour afficher "Annuaire" dans le menu de l'en-tête
	 * général. Le bouton affiche le texte "Annuaire" et change la scène pour la vue
	 * de l'annuaire des utilisateurs lorsqu'il est cliqué.
	 */

	public void goToDirectoryTitle() {
		this.setText("Annuaire");
		this.setStyle("-fx-background-color: transparent;");
		this.setFont(Font.font("Futura", FontWeight.BOLD, 14));
		this.setOnMouseEntered((e) -> {
			this.setTextFill(Color.web("#adb6b6"));
		});
		this.setOnMouseExited((e) -> {
			this.setTextFill(Color.web("#333333"));
		});

		this.setOnAction((e) -> {
			scene.setRoot(new UserDirectoryView(scene, this.tree));
		});

	}

	/**
	 * Configure le bouton pour afficher "Administrateur" dans le menu de l'en-tête
	 * général. Le bouton affiche le texte "Administrateur" et change la scène pour
	 * la vue administrateur lorsqu'il est cliqué.
	 */

	public void adminAccessTitle() {
		this.setText("Administrateur");
		this.setStyle("-fx-background-color: transparent;");
		this.setFont(Font.font("Futura", FontWeight.BOLD, 14));
		this.setOnMouseEntered((e) -> {
			this.setTextFill(Color.web("#adb6b6"));
		});
		this.setOnMouseExited((e) -> {
			this.setTextFill(Color.web("#333333"));
		});

		this.setOnAction((e) -> {
			scene.setRoot(new HomeViewAdmin(scene, this.tree));
		});

	}

	/**
	 * Configure le bouton pour valider l'ajout d'un stagiaire depuis les champs de
	 * texte. Le bouton affiche le texte "Valider" et change le style du bouton.
	 * 
	 * @param lastNameTextField  Champ de texte pour le nom de famille.
	 * @param firstNameTextField Champ de texte pour le prénom.
	 * @param locationTextField  Champ de texte pour la localisation.
	 * @param promoTextField     Champ de texte pour la promotion.
	 * @param yearPromoTextField Champ de texte pour l'année de la promotion.
	 */

	public void addStudentFromFields(TextField lastNameTextField, TextField firstNameTextField,
			TextField locationTextField, TextField promoTextField, TextField yearPromoTextField) {
		this.setText("Valider");
		this.setStyle("-fx-background-color: #144d65; -fx-padding: 10 20; -fx-text-fill: white;");
	}

	/**
	 * Génère un fichier PDF contenant la liste des étudiants à partir de la vue
	 * fournie. Le PDF est enregistré sous le nom "stagiaires.pdf" et est ouvert
	 * automatiquement après la création.
	 * 
	 * @param tableView La vue de la liste des étudiants à imprimer.
	 * @throws IOException Si une erreur se produit lors de la création du fichier
	 *                     PDF.
	 */

	private void generatePDF(StudentListAdmin tableView) throws IOException {
		String dest = "stagiaires.pdf";
		
		 // Créer un écrivain PDF
		try {
			PdfWriter writer = new PdfWriter(dest);
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);
			
			// Nombre de colonnes dans la TableView
			int numberOfColumns = 5;
			
			// Ajouter un titre
			document.add(new Paragraph("Liste des Stagiaires"));

			// Créer une table PDF
			Table table = new Table(numberOfColumns);
			table.addCell(new Cell().add(new Paragraph("Nom")));
			table.addCell(new Cell().add(new Paragraph("Prénom")));
			table.addCell(new Cell().add(new Paragraph("Dép.")));
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

	/**
	 * Configure le bouton pour accéder à la vue d'ajout d'un stagiaire. Le bouton
	 * affiche le texte "Ajouter Stagiaire" et change la scène pour la vue d'ajout
	 * d'un stagiaire lorsqu'il est cliqué.
	 */
	public void goToAddStudent() {
		this.setText("Ajouter stagiaire");
		this.setStyle(
				"-fx-background-color: #144d65; -fx-text-fill: white; -fx-background-radius: 15; -fx-border-radius: 15;");
		this.setPrefHeight(200);
		this.setPrefWidth(315);
		this.setPadding(new Insets(3, 20, 3, 20));

		this.setOnAction((e) -> {
			scene.setRoot(new AddStudentView(this.scene, this.tree));
		});

	}

	/**
	 * Configure le bouton pour accéder à l'annuaire administrateur. Le bouton
	 * affiche le texte "Annuaire" et change la scène pour la vue de l'annuaire
	 * administrateur lorsqu'il est cliqué.
	 */

	public void goToDirectoryAdminTitle() {
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
			scene.setRoot(new AdminDirectoryView(scene, this.tree));
		});

	}
//-----------------------------	
	public void searchStudent() {
		 List<Student> searchResult = new ArrayList<Student>();
	this.setStyle("-fx-background-color: #144d65; -fx-text-fill: white; -fx-background-radius: 15; -fx-border-radius: 15;");
	this.setText("Rechercher");
	
	}
	
	public void validAdmin() {
		this.setText("Valider");
		this.setStyle("-fx-background-color: #144d65; -fx-padding: 10 20; -fx-text-fill: white;");
	}
	
	public void setResetFilter() {
		this.setText("Effacer recherche");
		this.setStyle("-fx-background-color: #144d65; -fx-text-fill: white; -fx-background-radius: 15; -fx-border-radius: 15;");
		this.setPrefHeight(200);
		this.setPrefWidth(315);
		this.setPadding(new Insets(3, 20, 3, 20));

	}


}