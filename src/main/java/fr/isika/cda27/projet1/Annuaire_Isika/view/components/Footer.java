package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;

import java.util.ArrayList;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

public class Footer extends BorderPane {
	
	Scene scene;
	
	CustomButton btnGenerateDocumentation;
	CustomButton btnGoBackHome;
	CustomButton btnAdminAccess;
	CustomButton btnPrintPfd;
	CustomButton btnLogOut;
	StudentListAdmin tableView;
	
//	CustomButton btnGoToDirectory;
	
	HBox iconAndDocBox;
	HBox logOutAndPrintBox;
	
	
	public Footer(Scene scene) {
		this.scene = scene;
		this.setPadding(new Insets(60, 60, 60, 60));
	}
	public Footer(Scene scene,  StudentListAdmin tableView) {
		this.scene = scene;
		this.setPadding(new Insets(60, 60, 60, 60));
		this.tableView = tableView;
	}
	//method to create the left part of the footer: the icon and the buton for doc
	
	public HBox createIconAndDocBox() {
	String imgPathIconQuestion = "/Images/questionMark.png";
	ImageView iconQuestion = new ImageView(new Image(getClass().getResourceAsStream(imgPathIconQuestion)));
	iconQuestion.setPreserveRatio(true);
	iconQuestion.setFitWidth(20);
	iconQuestion.setFitHeight(20);
	
	btnGenerateDocumentation = new CustomButton(scene);
	btnGenerateDocumentation.generateDocumentation();
	
	iconAndDocBox = new HBox(10);
	iconAndDocBox.getChildren().addAll(iconQuestion, btnGenerateDocumentation);
	iconAndDocBox.setAlignment(Pos.CENTER);
	
	return iconAndDocBox;
	}
	
	
	//method to create the right box of footer: btnLogOut and printPdf
	public HBox createLogOutAndPrintBox() {
		
		btnLogOut = new CustomButton(scene);
		btnLogOut.logOut();
		
		btnPrintPfd = new CustomButton(scene);
		btnPrintPfd.printDirectory(tableView);
		
		logOutAndPrintBox = new HBox(10);
		logOutAndPrintBox.getChildren().addAll(btnLogOut,btnPrintPfd);
		
		return logOutAndPrintBox;
	}
	
	
	public void footerHomeView() {
		BorderPane footerHomeView = new BorderPane();
		
		btnAdminAccess = new CustomButton(scene);
		btnAdminAccess.adminAccess();
		
		HBox iconAndDocBox = createIconAndDocBox();
		
		footerHomeView.setLeft(iconAndDocBox);
		footerHomeView.setRight(btnAdminAccess);
		
		this.setBottom(footerHomeView);
		
	}
	
	
	public void footerHomeViewAdmin () {
		BorderPane footerHomeViewAdmin = new BorderPane();
		
		btnGoBackHome = new CustomButton(scene);
		btnGoBackHome.backToHome();
		
		HBox iconAndDocBox = createIconAndDocBox();
		
		footerHomeViewAdmin.setLeft(iconAndDocBox);
		footerHomeViewAdmin.setRight(btnGoBackHome);
		
		this.setBottom(footerHomeViewAdmin);
		
	}
	
	public void footerUserDirectoryView() {
		BorderPane footerUserDirectoryView = new BorderPane();
		
		btnPrintPfd = new CustomButton(scene);
		btnPrintPfd.printDirectory(this.tableView);
		
		HBox iconAndDocBox = createIconAndDocBox();
		
		footerUserDirectoryView.setLeft(iconAndDocBox);
		footerUserDirectoryView.setRight(btnPrintPfd);
		
		this.setBottom(footerUserDirectoryView);

		
	}
	
	public void footerAddStudentView() {
		BorderPane footerAddStudentView = new BorderPane();
		
		btnLogOut = new CustomButton(scene);
		btnLogOut.logOut();
		
		HBox iconAndDocBox = createIconAndDocBox();
		
		footerAddStudentView.setLeft(iconAndDocBox);
		footerAddStudentView.setRight(btnLogOut);
		
		this.setBottom(footerAddStudentView);
		
	}
	
	
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