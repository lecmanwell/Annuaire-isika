package fr.isika.cda27.projet1.Annuaire_Isika.view;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class HeaderViewGeneral extends HBox {

	HBox headerBoxGrl = new HBox();

	//stripes for the header view (general)
	VBox stripesBox = new VBox();
	Rectangle blueStripe = new Rectangle(465, 12);
	Rectangle whiteStripe = new Rectangle(465, 12);
	Rectangle orangeStripe = new Rectangle(465, 12);
	
	//logo image path
	String imgPathLogo = "/Images/isikalogo.png";

	//menu box
	HBox menuBox = new HBox();
	CustomButton btnHome;
	CustomButton btnDirectory;
	CustomButton btnAdmin;
	Separator separatorL = new Separator();
	Separator separatorR = new Separator();

	
	
	//constructor for the header view (general)
	public HeaderViewGeneral(Scene scene) {
		
		ImageView imgViewLogo = new ImageView(new Image(getClass().getResourceAsStream(imgPathLogo)));
		imgViewLogo.setFitWidth(150);
		imgViewLogo.setPreserveRatio(true);
		
		
		blueStripe.setFill(javafx.scene.paint.Color.web("#144d65"));
		whiteStripe.setFill(javafx.scene.paint.Color.web("#FFFFFF"));
		orangeStripe.setFill(javafx.scene.paint.Color.web("#db754a"));
		
		stripesBox.getChildren().addAll(blueStripe, whiteStripe, orangeStripe);
		stripesBox.setAlignment(Pos.CENTER);
		
		//Separator lines
		separatorL.setOrientation(Orientation.VERTICAL);
		separatorL.setMaxHeight(20);
		
		separatorR.setOrientation(Orientation.VERTICAL);
		separatorR.setMaxHeight(20);
		
		//Button Home
		btnHome = new CustomButton("Accueil");
		btnHome.setStyle("-fx-background-color: transparent;");
		System.out.println(btnHome.getStyle());
		
		//Button Directory
		btnDirectory = new CustomButton("Annuaire");
		btnDirectory.setStyle("-fx-background-color: transparent;");
		
		//Buton Admin
		btnAdmin = new CustomButton("Administrateur");
		btnAdmin.setStyle("-fx-background-color: transparent;");
		
		
		menuBox.getChildren().addAll(btnHome, separatorL, btnDirectory, separatorR, btnAdmin);
		menuBox.setAlignment(Pos.CENTER);
		menuBox.setStyle("-fx-font-family: 'Futura'; -fx-font-weight: 700;");
		
		
		this.getChildren().addAll(imgViewLogo, stripesBox, menuBox);
		
	}

}
