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

public class HeaderView extends HBox  {
	
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
		
	blueStripeL.setFill(Color.web("#144d65"));
	whiteStripeL.setFill(Color.web("#FFFFFF"));
	orangeStripeL.setFill(Color.web("#db754a"));
	stripesBoxL.getChildren().addAll(blueStripeL,whiteStripeL,orangeStripeL);
	stripesBoxL.setAlignment(Pos.CENTER);
	
	ImageView imgViewLogo = new ImageView(new Image(getClass().getResourceAsStream(imgPathLogo)));
	imgViewLogo.setFitWidth(150);
	imgViewLogo.setPreserveRatio(true);
	
	blueStripeR.setFill(Color.web("#144d65"));
	whiteStripeR.setFill(Color.web("#FFFFFF"));
	orangeStripeR.setFill(Color.web("#db754a"));
	stripesBoxR.getChildren().addAll(blueStripeR,whiteStripeR,orangeStripeR);
	stripesBoxR.setAlignment(Pos.CENTER);
	
	headerBox.getChildren().addAll(stripesBoxL, imgViewLogo, stripesBoxR);
	this.getChildren().addAll(headerBox);

	}
	



	

}
