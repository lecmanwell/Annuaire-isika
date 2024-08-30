package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.AddStudent;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Footer;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderViewAdmin;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderViewGeneral;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class AddStudentView extends BorderPane {
	private Scene scene;
	private TreeDAO tree;

	public AddStudentView(Scene scene, TreeDAO tree) {
		super();
		this.scene = scene;
		this.tree = tree;

		double screenHeight = Screen.getPrimary().getBounds().getHeight();
		double screenWidth = Screen.getPrimary().getBounds().getWidth();

		// header
		HeaderViewAdmin header = new HeaderViewAdmin(scene);
		header.setPrefHeight(screenHeight * 0.15);
		header.setMinHeight(screenHeight * 0.15);
		header.setMaxHeight(screenHeight * 0.15);
		header.setPrefWidth(screenWidth);
		header.setAlignment(Pos.CENTER);

		// body container
		HBox body = new HBox();
		AddStudent addStudent = new AddStudent(tree);
		body.getChildren().add(addStudent);
		body.setAlignment(Pos.CENTER);

		// footer
		Footer footer = new Footer(scene);
//		footer.setPrefHeight(screenHeight * 0.2);
//		footer.setMinHeight(screenHeight * 0.2);
//		footer.setMaxHeight(screenHeight * 0.2);
//		footer.setPrefWidth(screenWidth);
		footer.footerAddStudentView();
		
//		footer.setAlignment(Pos.CENTER);
//		footer.getChildren().add(footer.homeViewFooter());

		//set gridpane structure
		this.setTop(header);
		this.setCenter(body);
		this.setBottom(footer);
		
		scene.setRoot(this);
		scene.getRoot().setStyle("-fx-font-family: 'Futura'");
	}

}
