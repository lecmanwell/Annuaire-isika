package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Footer;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HomeText;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.LoginAdmin;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.StudentCard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class HomeViewAdmin extends BorderPane {

	private Scene scene;

	public HomeViewAdmin(Scene scene) {
		super();
		this.scene = scene;

		// header
		HeaderView header = new HeaderView(scene);
//        header.setPrefHeight(screenHeight * 0.2);
//        header.setMinHeight(screenHeight * 0.2);
//        header.setMaxHeight(screenHeight * 0.2);
//        header.setPrefWidth(screenWidth);
		header.setAlignment(Pos.CENTER);

		// body container
		GridPane pageCentrale = new GridPane();
//		pageCentrale.setPrefHeight(screenHeight * 0.6);
//		pageCentrale.setMinHeight(screenHeight * 0.6);
//		pageCentrale.setMaxHeight(screenHeight * 0.6);
//		pageCentrale.setPrefWidth(screenWidth);
		pageCentrale.setAlignment(Pos.CENTER);

		// student card
		String imagePath = "/Images/imageCardHome.jpg";
		StudentCard studentCard = new StudentCard(imagePath, "Projet", "Isika", "Architecte Logiciel", "2024", "92");

		// admin login box
		LoginAdmin loginAdmin = new LoginAdmin(scene);
		loginAdmin.setAlignment(Pos.CENTER);

		pageCentrale.add(studentCard, 1, 1);
		pageCentrale.add(loginAdmin, 2, 1);
		pageCentrale.setPadding(new Insets(0, 30, 0, 30));
		pageCentrale.setHgap(20);

		Footer footer = new Footer(scene);
//	       footer.setPrefHeight(screenHeight * 0.2);
//	        footer.setMinHeight(screenHeight * 0.2);
//	        footer.setMaxHeight(screenHeight * 0.2);
//	        footer.setPrefWidth(screenWidth);
		footer.setAlignment(Pos.CENTER);
		

//		footer.getChildren().add(footer.homeViewFooter());
		footer.homeViewFooter();

		this.setTop(header);
		this.setBottom(footer);
		this.setCenter(pageCentrale);

		scene.setRoot(this);
		scene.getRoot().setStyle("-fx-font-family: 'Futura'");

	}
}
