package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;

import java.util.ArrayList;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Tree;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

/**
 * Classe représentant le pied de page (footer) de l'application. Cette vue est
 * composée de divers boutons et icônes pour la navigation et les actions
 * utilisateur, et est conçue pour s'adapter à différentes vues de
 * l'application.
 */

public class Footer extends BorderPane {

	Scene scene;
	Tree tree;

	CustomButton btnGenerateDocumentation;
	CustomButton btnGoBackHome;
	CustomButton btnAdminAccess;
	CustomButton btnPrintPfd;
	CustomButton btnLogOut;
	StudentListAdmin tableView;

	HBox iconAndDocBox;
	HBox logOutAndPrintBox;

	/**
	 * Constructeur pour initialiser le pied de page avec la scène.
	 * 
	 * @param scene La scène dans laquelle le pied de page sera affiché.
	 */
	public Footer(Scene scene, Tree tree) {
		this.scene = scene;
		this.tree = tree;
		this.setPadding(new Insets(60, 60, 60, 60));
	}

	/**
	 * Constructeur pour initialiser le pied de page avec la scène et une vue de la
	 * liste des étudiants.
	 * 
	 * @param scene     La scène dans laquelle le pied de page sera affiché.
	 * @param tableView La vue de la liste des étudiants pour générer des documents
	 *                  PDF.
	 */
	public Footer(Scene scene, Tree tree, StudentListAdmin tableView) {
		
		this.scene = scene;
		this.tree=tree;
		this.setPadding(new Insets(60, 60, 60, 60));
		this.tableView = tableView;
	}

	/**
	 * Méthode pour créer la partie gauche du pied de page contenant l'icône et le
	 * bouton pour générer la documentation.
	 * 
	 * @return Une boîte horizontale contenant l'icône et le bouton de
	 *         documentation.
	 */

	public HBox createIconAndDocBox() {
		String imgPathIconQuestion = "/Images/questionMark1.png";
		ImageView iconQuestion = new ImageView(new Image(getClass().getResourceAsStream(imgPathIconQuestion)));
		iconQuestion.setPreserveRatio(true);
		iconQuestion.setFitWidth(17);
		iconQuestion.setFitHeight(17);

		btnGenerateDocumentation = new CustomButton(scene, this.tree);
		btnGenerateDocumentation.generateDocumentation();

		iconAndDocBox = new HBox();
		iconAndDocBox.getChildren().addAll(iconQuestion, btnGenerateDocumentation);
		iconAndDocBox.setAlignment(Pos.CENTER);

		return iconAndDocBox;
	}

	/**
	 * Méthode pour créer la partie droite du pied de page contenant les boutons de
	 * déconnexion et d'impression.
	 * 
	 * @return Une boîte horizontale contenant les boutons de déconnexion et
	 *         d'impression.
	 */
	public HBox createLogOutAndPrintBox() {

		btnLogOut = new CustomButton(scene, this.tree);
		btnLogOut.logOut();

		btnPrintPfd = new CustomButton(scene, this.tree);
		btnPrintPfd.printDirectory(tableView);

		logOutAndPrintBox = new HBox(10);
		logOutAndPrintBox.getChildren().addAll(btnLogOut, btnPrintPfd);

		return logOutAndPrintBox;
	}

	/**
	 * Méthode pour configurer le pied de page pour la vue d'accueil de
	 * l'application (HomeView).
	 * 
	 * Ajoute une boîte contenant l'icône et le bouton de documentation à gauche, et
	 * un bouton d'accès administrateur à droite.
	 */
	public void footerHomeView() {
		BorderPane footerHomeView = new BorderPane();

		btnAdminAccess = new CustomButton(scene, this.tree);
		btnAdminAccess.adminAccess();

		HBox iconAndDocBox = createIconAndDocBox();

		footerHomeView.setLeft(iconAndDocBox);
		footerHomeView.setRight(btnAdminAccess);

		this.setBottom(footerHomeView);

	}

	/**
	 * Méthode pour configurer le pied de page pour la vue d'accueil de
	 * l'administrateur (HomeViewAdmin).
	 * 
	 * Ajoute une boîte contenant l'icône et le bouton de documentation à gauche, et
	 * un bouton de retour à l'accueil à droite.
	 */

	public void footerHomeViewAdmin() {
		BorderPane footerHomeViewAdmin = new BorderPane();

		btnGoBackHome = new CustomButton(scene, this.tree);
		btnGoBackHome.backToHome();

		HBox iconAndDocBox = createIconAndDocBox();

		footerHomeViewAdmin.setLeft(iconAndDocBox);
		footerHomeViewAdmin.setRight(btnGoBackHome);

		this.setBottom(footerHomeViewAdmin);

	}

	/**
	 * Méthode pour configurer le pied de page pour la vue de l'annuaire utilisateur
	 * (UserDirectoryView).
	 * 
	 * Ajoute une boîte contenant l'icône et le bouton d'impression à gauche, et un
	 * bouton d'impression à droite.
	 */

	public void footerUserDirectoryView() {
		BorderPane footerUserDirectoryView = new BorderPane();

		btnPrintPfd = new CustomButton(scene, this.tree);
		btnPrintPfd.printDirectory(this.tableView);

		HBox iconAndDocBox = createIconAndDocBox();

		footerUserDirectoryView.setLeft(iconAndDocBox);
		footerUserDirectoryView.setRight(btnPrintPfd);

		this.setBottom(footerUserDirectoryView);

	}

	/**
	 * Méthode pour configurer le pied de page pour la vue d'ajout d'étudiant
	 * (AddStudentView).
	 * 
	 * Ajoute une boîte contenant l'icône et le bouton de déconnexion à gauche.
	 */

	public void footerAddStudentView() {
		BorderPane footerAddStudentView = new BorderPane();

		btnLogOut = new CustomButton(scene, this.tree);
		btnLogOut.logOut();

		HBox iconAndDocBox = createIconAndDocBox();

		footerAddStudentView.setLeft(iconAndDocBox);
		footerAddStudentView.setRight(btnLogOut);

		this.setBottom(footerAddStudentView);

	}

	/**
	 * Méthode pour configurer le pied de page pour la vue d'annuaire administrateur
	 * (AdminDirectoryView).
	 * 
	 * Ajoute une boîte contenant l'icône et le bouton de documentation à gauche, et
	 * une boîte contenant les boutons de déconnexion et d'impression à droite.
	 */

	public void footerAdminDirectoryView() {
		BorderPane footerAdminDirectoryView = new BorderPane();

		HBox iconAndDocBox = createIconAndDocBox();
		footerAdminDirectoryView.setLeft(iconAndDocBox);

		HBox logOutAndPrintBox = createLogOutAndPrintBox();

		footerAdminDirectoryView.setLeft(iconAndDocBox);
		footerAdminDirectoryView.setRight(logOutAndPrintBox);
		this.setBottom(footerAdminDirectoryView);
	}

}