package fr.isika.cda27.projet1.Annuaire_Isika.view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Footer extends HBox {

	String imgPathLogoQuestion = "/Images/questionMark.png";
	String imgPathLogOut = "/Images/logOut.png";
	ImageView logoQuestion = new ImageView(new Image(getClass().getResourceAsStream(imgPathLogoQuestion)));
	ImageView logoLogOut = new ImageView(new Image(getClass().getResourceAsStream(imgPathLogOut)));
	Button docDirectory = new Button("Comment fonction cet annuaire ?");
	Button imprimerPDF = new Button("Imprimer le PDF");
	Button backToDirectory = new Button("Retourner à l'annuaire");
	Button adminLogIn = new Button("Accès administrateur");
	Scene scene;
	
	public Footer(Scene scene) {
		super();
		this.scene = scene;

	}

	public HBox homeViewFooter() {
		HBox homeViewFooter = new HBox();
		homeViewFooter.getChildren().addAll(logoQuestion, docDirectory, adminLogIn);
		return homeViewFooter;
	}
	public HBox homeLoginAdmin() {
		HBox homeLoginAdmin = new HBox();
		homeLoginAdmin.getChildren().addAll(logoQuestion, docDirectory);
		return homeLoginAdmin;
	}

	public HBox userViewFooter() {
		HBox userViewFooter = new HBox();
		userViewFooter.getChildren().addAll(logoQuestion, docDirectory, imprimerPDF);
		return userViewFooter;
	}

	public HBox adminViewFooterList() {
		HBox adminViewFooterList = new HBox();
		adminViewFooterList.getChildren().addAll(logoQuestion, docDirectory, logoLogOut, imprimerPDF);
		return adminViewFooterList;
	}

	public HBox admninViewFooterAddStudent() {
		HBox admninViewFooterAddStudent = new HBox();
		admninViewFooterAddStudent.getChildren().addAll(logoQuestion, docDirectory, logoLogOut, backToDirectory);
		return admninViewFooterAddStudent;
	}

}
