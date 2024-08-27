package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HeaderView extends HBox {

	HBox headerBox = new HBox();

	VBox stripesBoxL = new VBox();
	Rectangle blueStripeL = new Rectangle();
	Rectangle whiteStripeL = new Rectangle();
	Rectangle orangeStripeL = new Rectangle();

	VBox stripesBoxR = new VBox();
	Rectangle blueStripeR = new Rectangle();
	Rectangle whiteStripeR = new Rectangle();
	Rectangle orangeStripeR = new Rectangle();

	String imgPathLogo = "/Images/isikalogo.png";

	Label label;

	public HeaderView(Scene scene) {

		// ratios for the components of the header
		double stripeHeightRatio = 0.015;
		double stripesBoxWidthRatio = 0.45;
		double logoWidthRatio = 0.1;

		// stripes for the left side
		blueStripeL.setFill(Color.web("#144d65"));
		whiteStripeL.setFill(Color.web("#FFFFFF"));
		orangeStripeL.setFill(Color.web("#db754a"));

		blueStripeL.widthProperty().bind(scene.widthProperty().multiply(stripesBoxWidthRatio));
		blueStripeL.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));

		whiteStripeL.widthProperty().bind(scene.widthProperty().multiply(stripesBoxWidthRatio));
		whiteStripeL.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));

		orangeStripeL.widthProperty().bind(scene.widthProperty().multiply(stripesBoxWidthRatio));
		orangeStripeL.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));

		stripesBoxL.getChildren().addAll(blueStripeL, whiteStripeL, orangeStripeL);
		stripesBoxL.setAlignment(Pos.CENTER);

		// logo
		ImageView imgViewLogo = new ImageView(new Image(getClass().getResourceAsStream(imgPathLogo)));
		imgViewLogo.fitWidthProperty().bind(scene.widthProperty().multiply(logoWidthRatio));
		imgViewLogo.setPreserveRatio(true);

		// stripes for the right side
		blueStripeR.setFill(Color.web("#144d65"));
		whiteStripeR.setFill(Color.web("#FFFFFF"));
		orangeStripeR.setFill(Color.web("#db754a"));

		blueStripeR.widthProperty().bind(scene.widthProperty().multiply(stripesBoxWidthRatio));
		blueStripeR.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));

		whiteStripeR.widthProperty().bind(scene.widthProperty().multiply(stripesBoxWidthRatio));
		whiteStripeR.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));

		orangeStripeR.widthProperty().bind(scene.widthProperty().multiply(stripesBoxWidthRatio));
		orangeStripeR.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));

		stripesBoxR.getChildren().addAll(blueStripeR, whiteStripeR, orangeStripeR);
		stripesBoxR.setAlignment(Pos.CENTER);

		// add components to the header
		headerBox.getChildren().addAll(stripesBoxL, imgViewLogo, stripesBoxR);
		headerBox.setAlignment(Pos.CENTER);
		this.getChildren().addAll(headerBox);

	}

}
