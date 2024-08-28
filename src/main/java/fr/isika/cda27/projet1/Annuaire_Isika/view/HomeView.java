package fr.isika.cda27.projet1.Annuaire_Isika.view;


import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Footer;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HomeText;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.StudentCard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class HomeView extends BorderPane {

	private Scene scene;

	public HomeView(Scene scene) {
		super();
		this.scene = scene;
		
//		double screenHeight = this.scene.getHeight();
//		double screenWidth = this.scene.getWidth();
		

		HeaderView header = new HeaderView(scene);
//		header.setPrefHeight(screenHeight * 0.2);
//		header.setMinHeight(screenHeight * 0.2);
//		header.setMaxHeight(screenHeight * 0.2);
//		header.setPrefWidth(screenWidth);
		header.setAlignment(Pos.CENTER);

		GridPane body = new GridPane();
//		pageCentrale.setPadding(new Insets(20, 20, 20, 20));
//		pageCentrale.setPrefHeight(screenHeight * 0.6);
//		pageCentrale.setMinHeight(screenHeight * 0.6);
//		pageCentrale.setMaxHeight(screenHeight * 0.6);
//		pageCentrale.setPrefWidth(screenWidth);
		body.setAlignment(Pos.CENTER);
		String imagePath = "/Images/imageCardHome.jpg";
		StudentCard studentCard = new StudentCard(imagePath, "Projet", "Isika", "Architecte Logiciel", "2024", "92");
//		studentCard.setPadding(new Insets(100));
		HomeText homeText = new HomeText(this.scene);
//		homeText.setPadding(new Insets(100));
		homeText.setAlignment(Pos.CENTER);
		
		body.add(studentCard, 1, 1);
		body.add(homeText, 2, 1);
		body.setPadding(new Insets(0, 50, 0, 50));
		body.setHgap(20);

//		HBox.setHgrow(studentCard, Priority.ALWAYS);
//		HBox.setHgrow(homeText, Priority.ALWAYS);
//		studentCard.setMaxWidth(Double.MAX_VALUE);
//		homeText.setMaxWidth(Double.MAX_VALUE);

		Footer footer = new Footer(scene);
		footer.homeViewFooter();

		
		this.setTop(header);
		this.setBottom(footer);
		this.setCenter(body);
		
		scene.setRoot(this);
		scene.getRoot().setStyle("-fx-font-family: 'Futura'");
	}

}
