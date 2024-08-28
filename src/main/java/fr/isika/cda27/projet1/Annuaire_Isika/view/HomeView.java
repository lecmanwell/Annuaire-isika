package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Directory;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Footer;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HomeText;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.StudentCard;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Screen;

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

		GridPane pageCentrale = new GridPane();
//		pageCentrale.setPadding(new Insets(20, 20, 20, 20));
//		pageCentrale.setPrefHeight(screenHeight * 0.6);
//		pageCentrale.setMinHeight(screenHeight * 0.6);
//		pageCentrale.setMaxHeight(screenHeight * 0.6);
//		pageCentrale.setPrefWidth(screenWidth);
		pageCentrale.setAlignment(Pos.CENTER);
		String imagePath = "/Images/imageCardHome.jpg";
		StudentCard studentCard = new StudentCard(imagePath, "Projet", "Isika", "Architecte Logiciel", "2024", "92");
//		studentCard.setPadding(new Insets(100));
		HomeText homeText = new HomeText(this.scene);
//		homeText.setPadding(new Insets(100));
		homeText.setAlignment(Pos.CENTER);
		
		pageCentrale.add(studentCard, 1, 1);
		pageCentrale.add(homeText, 2, 1);
		pageCentrale.setPadding(new Insets(0, 50, 0, 50));
		pageCentrale.setHgap(20);

//		HBox.setHgrow(studentCard, Priority.ALWAYS);
//		HBox.setHgrow(homeText, Priority.ALWAYS);
//		studentCard.setMaxWidth(Double.MAX_VALUE);
//		homeText.setMaxWidth(Double.MAX_VALUE);

		Footer footer = new Footer(scene);
		footer.getChildren().add(footer.homeViewFooter());
//		footer.setPrefHeight(screenHeight * 0.2);
//		footer.setMinHeight(screenHeight * 0.2);
//		footer.setMaxHeight(screenHeight * 0.2);
//		footer.setPrefWidth(screenWidth);
		footer.setAlignment(Pos.CENTER);

		footer.getChildren().add(footer.homeViewFooter());

		this.setTop(header);
		this.setBottom(footer);
		this.setCenter(pageCentrale);
		scene.setRoot(this);
	}

}
