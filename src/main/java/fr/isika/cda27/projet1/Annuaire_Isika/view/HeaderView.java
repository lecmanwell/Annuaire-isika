package fr.isika.cda27.projet1.Annuaire_Isika.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HeaderView extends HBox  {
	
	HBox headerBox = new HBox();
	
	VBox stripesBoxL = new VBox();
	Rectangle blueStripeL = new Rectangle(640, 200);
	HBox whiteStripeL = new HBox();
	HBox orangeStripeL = new HBox();
	
	VBox stripesBoxR = new VBox();
	HBox blueStripeR = new HBox();
	HBox whiteStripeR = new HBox();
	HBox orangeStripeR = new HBox();
	
	Label label;
	
	public HeaderView(Scene scene) {
//	blueStripeL.setStyle("-fx-background-color: #144d65");
	blueStripeL.setFill(Color.BLACK);
	whiteStripeL.setStyle("-fx-background-color: #FFFFFF");
	orangeStripeL.setStyle("-fx-background-color: #db754a");
	stripesBoxL.getChildren().addAll(blueStripeL,whiteStripeL,orangeStripeL);
	
	label = new Label("testtetsts");
//	Image imgLogo = new Image("file:///Users/filabaca/EnvDev/EclipseWorkspaces/WorkspaceProjet/Annuaire-isika/src/main/resources/Images/isikalogo.png", true);
//	ImageView imgViewLogo = new ImageView(imgLogo);
	
	blueStripeR.setStyle("-fx-background-color: #144d65");
	whiteStripeR.setStyle("-fx-background-color: #FFFFFF");
	orangeStripeR.setStyle("-fx-background-color: #db754a");
	stripesBoxR.getChildren().addAll(blueStripeR,whiteStripeR,orangeStripeR);
	
	headerBox.getChildren().addAll(stripesBoxL, label, stripesBoxR);
	this.getChildren().addAll(headerBox);

	}
	



	

}
