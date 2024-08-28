package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Footer extends HBox {

	String imgPathLogoQuestion = "/Images/questionMark.png";
	String imgPathLogOut = "/Images/logOut.png";
	ImageView logoQuestion = new ImageView(new Image(getClass().getResourceAsStream(imgPathLogoQuestion)));
	ImageView logoLogOut = new ImageView(new Image(getClass().getResourceAsStream(imgPathLogOut)));
	Scene scene;
	Region region = new Region();
	CustomButton btnGenerateDocumentation = new CustomButton(scene);
	CustomButton btnadminAccess = new CustomButton(scene);
	CustomButton btngoToDirectory = new CustomButton(scene);
	CustomButton btnprintPfd = new CustomButton(scene);
	CustomButton btnlogOut = new CustomButton(scene);
	CustomButton btnback = new CustomButton(scene);


	
	public Footer(Scene scene) {
		super();
		this.scene = scene;
		this.setPadding(new Insets(60, 0, 0, 0));
		logoQuestion.setPreserveRatio(true);
		logoQuestion.setFitWidth(20);
		logoQuestion.setFitHeight(20);
		btnGenerateDocumentation.generateDocumentation();
		btnadminAccess.adminAccess();
		btngoToDirectory.goToDirectory();
		btnprintPfd.printDirectory();
		btnlogOut.logOut();
		btnback.back();
		
		
	}

	public HBox homeViewFooter() {
		HBox homeViewFooter = new HBox();
		homeViewFooter.getChildren().addAll(logoQuestion, btnGenerateDocumentation,btnadminAccess);
		return homeViewFooter;
	}
	public HBox homeLoginAdmin() {
		HBox homeLoginAdmin = new HBox();
		homeLoginAdmin.getChildren().addAll(logoQuestion, btnGenerateDocumentation, btnback);
		return homeLoginAdmin;
	}

	public HBox userViewFooter() {
		HBox userViewFooter = new HBox();
		userViewFooter.getChildren().addAll(logoQuestion, btnGenerateDocumentation, btnprintPfd);
		return userViewFooter;
	}

	public HBox adminViewFooterList() {
		HBox adminViewFooterList = new HBox();
		adminViewFooterList.getChildren().addAll(logoQuestion, btnGenerateDocumentation, logoLogOut, btnprintPfd);
		return adminViewFooterList;
	}

	public HBox admninViewFooterAddStudent() {
		HBox admninViewFooterAddStudent = new HBox();
		admninViewFooterAddStudent.getChildren().addAll(logoQuestion, btnGenerateDocumentation, logoLogOut, btnback);
		return admninViewFooterAddStudent;
	}

}
