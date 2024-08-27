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
	CustomButton btn = new CustomButton(scene);

	Button generateDocumentation = btn.generateDocumentation();
	Button adminAccess = btn.adminAccess();
	Button goToDirectory = btn.goToDirectory();
	Button printPfd = btn.printDirectory();
	Button logOut = btn.logOut();
	Button back = btn.back();
	
	public Footer(Scene scene) {
		super();
		this.scene = scene;
		this.setPadding(new Insets(60, 0, 0, 0));
		logoQuestion.setPreserveRatio(true);
		logoQuestion.setFitWidth(20);
		logoQuestion.setFitHeight(20);
		
	}

	public HBox homeViewFooter() {
		HBox homeViewFooter = new HBox();
		homeViewFooter.getChildren().addAll(logoQuestion, generateDocumentation, adminAccess);
		return homeViewFooter;
	}
	public HBox homeLoginAdmin() {
		HBox homeLoginAdmin = new HBox();
		homeLoginAdmin.getChildren().addAll(logoQuestion, generateDocumentation, back);
		return homeLoginAdmin;
	}

	public HBox userViewFooter() {
		HBox userViewFooter = new HBox();
		userViewFooter.getChildren().addAll(logoQuestion, generateDocumentation, printPfd);
		return userViewFooter;
	}

	public HBox adminViewFooterList() {
		HBox adminViewFooterList = new HBox();
		adminViewFooterList.getChildren().addAll(logoQuestion, generateDocumentation, logoLogOut, printPfd);
		return adminViewFooterList;
	}

	public HBox admninViewFooterAddStudent() {
		HBox admninViewFooterAddStudent = new HBox();
		admninViewFooterAddStudent.getChildren().addAll(logoQuestion, generateDocumentation, logoLogOut, back);
		return admninViewFooterAddStudent;
	}

}
