package fr.isika.cda27.projet1.Annuaire_Isika.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HeaderView extends HBox {

	HBox headerBox = new HBox();

	VBox stripesBoxL = new VBox();
	Rectangle blueStripeL = new Rectangle(465,12);
	Rectangle whiteStripeL = new Rectangle(465,12);
	Rectangle orangeStripeL = new Rectangle(465,12);

	VBox stripesBoxR = new VBox();
	Rectangle blueStripeR = new Rectangle(465,12);
	Rectangle whiteStripeR = new Rectangle(465,12);
	Rectangle orangeStripeR = new Rectangle(465,12);

	String imgPathLogo = "/Images/isikalogo.png";

	Label label;

	public HeaderView(Scene scene) {
		
//	double stripeHeightRatio = 0.015;
		
	blueStripeL.setFill(Color.web("#144d65"));
	whiteStripeL.setFill(Color.web("#FFFFFF"));
	orangeStripeL.setFill(Color.web("#db754a"));
	
//	blueStripeL.widthProperty().bind(scene.widthProperty());
//	blueStripeL.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio)); 
//	
//	whiteStripeL.widthProperty().bind(scene.widthProperty());
//	whiteStripeL.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio)); 
//	
//	orangeStripeL.widthProperty().bind(scene.widthProperty());
//	orangeStripeL.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio)); 
	
	
	stripesBoxL.getChildren().addAll(blueStripeL,whiteStripeL,orangeStripeL);
	stripesBoxL.setAlignment(Pos.CENTER);

	
	ImageView imgViewLogo = new ImageView(new Image(getClass().getResourceAsStream(imgPathLogo)));
	imgViewLogo.setFitWidth(150);
	imgViewLogo.setPreserveRatio(true);
	
	blueStripeR.setFill(Color.web("#144d65"));
	whiteStripeR.setFill(Color.web("#FFFFFF"));
	orangeStripeR.setFill(Color.web("#db754a"));
	
	
//	blueStripeR.widthProperty().bind(scene.widthProperty());
//	blueStripeR.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));  
//	
//	whiteStripeR.widthProperty().bind(scene.widthProperty());
//	whiteStripeR.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));  
//	
//	orangeStripeR.widthProperty().bind(scene.widthProperty());
//	orangeStripeR.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));  
	
	
	stripesBoxR.getChildren().addAll(blueStripeR,whiteStripeR,orangeStripeR);
	stripesBoxR.setAlignment(Pos.CENTER);
	
	
	headerBox.getChildren().addAll(stripesBoxL, imgViewLogo, stripesBoxR);
	this.getChildren().addAll(headerBox);

	}

}
