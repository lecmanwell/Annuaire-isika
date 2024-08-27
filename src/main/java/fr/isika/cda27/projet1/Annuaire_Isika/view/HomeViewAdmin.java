package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Footer;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HomeText;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.LoginAdmin;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.StudentCard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class HomeViewAdmin extends VBox {

	private Scene scene;

	public HomeViewAdmin(Scene scene) {
		super();
		this.scene = scene;
		
		double screenHeight = Screen.getPrimary().getBounds().getHeight();
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
		
        
        //header
		HeaderView header = new HeaderView(scene);
        header.setPrefHeight(screenHeight * 0.2);
        header.setMinHeight(screenHeight * 0.2);
        header.setMaxHeight(screenHeight * 0.2);
        header.setPrefWidth(screenWidth);
        header.setAlignment(Pos.CENTER);
		
        //body container
        HBox pageCentrale = new HBox();
		pageCentrale.setPrefHeight(screenHeight * 0.6);
		pageCentrale.setMinHeight(screenHeight * 0.6);
		pageCentrale.setMaxHeight(screenHeight * 0.6);
		pageCentrale.setPrefWidth(screenWidth);
		pageCentrale.setAlignment(Pos.CENTER);
		
		//student card
		String imagePath = "/Images/imageCardHome.jpg";
		StudentCard studentCard = new StudentCard(imagePath, "Projet", "Isika", "Architecte Logiciel", "2024", "92");
		studentCard.setPadding(new Insets(100));
		
		
		//admin login box
		LoginAdmin loginAdmin = new LoginAdmin();
		

		pageCentrale.getChildren().addAll(studentCard, loginAdmin);
		
		Footer footer = new Footer(scene);
	       footer.setPrefHeight(screenHeight * 0.2);
	        footer.setMinHeight(screenHeight * 0.2);
	        footer.setMaxHeight(screenHeight * 0.2);
	        footer.setPrefWidth(screenWidth);
	        footer.setAlignment(Pos.CENTER);

		footer.getChildren().add(footer.homeViewFooter());

		this.getChildren().addAll(header, pageCentrale, footer);
		scene.setRoot(this);
		
		
		
}
}
