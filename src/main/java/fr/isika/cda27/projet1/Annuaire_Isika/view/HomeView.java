package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Directory;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeView extends VBox {

	private Scene scene;

	public HomeView(Scene scene) {
		super();
		this.scene = scene;

		HeaderView header = new HeaderView(scene);

		HBox pageCentrale = new HBox();
		pageCentrale.setPadding(new Insets(20, 20, 20, 20));
		String imagePath = "/Images/imageCardHome.jpg";
		StudentCard studentCard = new StudentCard(imagePath, "Projet", "Isika", "Architecte Logiciel", "2024", "92");
		HomeText homeText = new HomeText();
		homeText.setAlignment(Pos.CENTER);
		

		HBox.setHgrow(studentCard, Priority.ALWAYS);
		HBox.setHgrow(homeText, Priority.ALWAYS);
		studentCard.setMaxWidth(Double.MAX_VALUE);
		homeText.setMaxWidth(Double.MAX_VALUE);

		pageCentrale.getChildren().addAll(studentCard, homeText);
		
		Footer footer = new Footer(scene);
		footer.getChildren().add(footer.homeViewFooter());

		this.getChildren().addAll(header, pageCentrale, footer);
		scene.setRoot(this);
	}

}
