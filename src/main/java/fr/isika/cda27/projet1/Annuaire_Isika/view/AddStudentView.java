package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.view.components.AddStudent;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Footer;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderView;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class AddStudentView extends VBox {
	private Scene scene;

	public AddStudentView(Scene scene) {
		super();
		this.scene = scene;

		double screenHeight = Screen.getPrimary().getBounds().getHeight();
		double screenWidth = Screen.getPrimary().getBounds().getWidth();

		// header
		HeaderView header = new HeaderView(scene);
		header.setPrefHeight(screenHeight * 0.2);
		header.setMinHeight(screenHeight * 0.2);
		header.setMaxHeight(screenHeight * 0.2);
		header.setPrefWidth(screenWidth);
		header.setAlignment(Pos.CENTER);

		// body container
		VBox body = new VBox();
		body.setPrefHeight(screenHeight * 0.6);
		body.setMinHeight(screenHeight * 0.6);
		body.setMaxHeight(screenHeight * 0.6);
		body.setPrefWidth(screenWidth);
		body.setAlignment(Pos.CENTER);
		
		//add student box
		AddStudent addStudent = new AddStudent();
		
		body.getChildren().add(addStudent);
		

		// footer
		Footer footer = new Footer(scene);
//		footer.setPrefHeight(screenHeight * 0.2);
//		footer.setMinHeight(screenHeight * 0.2);
//		footer.setMaxHeight(screenHeight * 0.2);
//		footer.setPrefWidth(screenWidth);
//		footer.setAlignment(Pos.CENTER);
		footer.homeViewFooter();
//		footer.getChildren().add(footer.homeViewFooter());
		
		this.getChildren().addAll(header, body, footer);
		scene.setRoot(this);
		scene.getRoot().setStyle("-fx-font-family: 'Futura'");
	}

}
