package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

public class Footer extends BorderPane {

	String imgPathLogoQuestion = "/Images/questionMark.png";
	String imgPathLogOut = "/Images/logOut.png";
	ImageView iconQuestion = new ImageView(new Image(getClass().getResourceAsStream(imgPathLogoQuestion)));
	ImageView iconLogOut = new ImageView(new Image(getClass().getResourceAsStream(imgPathLogOut)));
	Scene scene;
	Region region = new Region();
	CustomButton btnGenerateDocumentation = new CustomButton(scene);
	CustomButton btnAdminAccess = new CustomButton(scene);
	CustomButton btngoToDirectory = new CustomButton(scene);
	CustomButton btnPrintPfd = new CustomButton(scene);
	CustomButton btnLogOut = new CustomButton(scene);
	CustomButton btnGoHome = new CustomButton(scene);
	HBox iconAndDocBox = new HBox();
	HBox logOutAndPrintBtns = new HBox();

	
	public Footer(Scene scene) {
		super();
		this.scene = scene;
		this.setPadding(new Insets(60, 60, 60, 60));
		
		//Question mark Icon and Documentation button for the use of the app
		iconQuestion.setPreserveRatio(true);
		iconQuestion.setFitWidth(20);
		iconQuestion.setFitHeight(20);
		btnGenerateDocumentation.generateDocumentation();
		iconAndDocBox.getChildren().addAll(iconQuestion, btnGenerateDocumentation);
		iconAndDocBox.setAlignment(Pos.CENTER);
		
		btnAdminAccess.adminAccess();
		btngoToDirectory.goToDirectory();
		btnPrintPfd.printDirectory();
		btnLogOut.logOut();
		btnGoHome.back();
		
		//style for log out icon
		iconLogOut.setPreserveRatio(true);
		iconLogOut.setFitWidth(20);
		iconLogOut.setFitHeight(20);
		
		//
		logOutAndPrintBtns.getChildren().addAll(btnLogOut,btnPrintPfd);
		
	}

	//Footer for HomeView
	public void homeViewFooter() {
		this.setLeft(iconAndDocBox);
		this.setRight(btnAdminAccess);
	}
	
	//Footer for HomeViewAdmin
	public void homeLoginAdmin() {
		this.setLeft(iconAndDocBox);
		this.setRight(btnGoHome);
	}

	//Footer for UserDirectoryView
	public void userViewFooter() {
		this.setLeft(iconAndDocBox);
		this.setRight(btnPrintPfd);
	}

	
	//Footer for AdminDirectoryView
	public void adminViewFooterList() {
		this.setLeft(iconAndDocBox);
		this.setRight(logOutAndPrintBtns);
	}

	//Footer for AddStudentView
	public void adminViewFooterAddStudent() {
		setLeft(iconAndDocBox);
		setRight(btnLogOut);
	}

}
