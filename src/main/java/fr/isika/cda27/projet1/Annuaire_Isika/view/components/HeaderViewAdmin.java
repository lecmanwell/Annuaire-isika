package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class HeaderViewAdmin extends HBox {

	HBox headerBoxGrl = new HBox();
	Scene scene;

	//stripes for the header view (general)
	VBox stripesBox = new VBox();
	Rectangle blueStripe = new Rectangle();
	Rectangle whiteStripe = new Rectangle();
	Rectangle orangeStripe = new Rectangle();
	
	//logo image path
	String imgPathLogo = "/Images/isikalogo.png";

	//menu box
	HBox menuBox = new HBox();
	CustomButton btnHome;
	CustomButton btnDirectory;
	CustomButton btnAdmin;
	Separator separatorL = new Separator();
	Separator separatorR = new Separator();

	public HeaderViewAdmin(Scene scene) {
		super();
		this.scene = scene;
		
		double stripeHeightRatio = 0.015;
		double stripesBoxWidthRatio = 0.48;
		double logoWidthRatio = 0.16;
		
		ImageView imgViewLogo = new ImageView(new Image(getClass().getResourceAsStream(imgPathLogo)));
		imgViewLogo.fitWidthProperty().bind(scene.widthProperty().multiply(logoWidthRatio));
		imgViewLogo.setPreserveRatio(true);
		
		
		blueStripe.setFill(javafx.scene.paint.Color.web("#144d65"));
		whiteStripe.setFill(javafx.scene.paint.Color.web("#FFFFFF"));
		orangeStripe.setFill(javafx.scene.paint.Color.web("#db754a"));
		
		blueStripe.widthProperty().bind(scene.widthProperty().multiply(stripesBoxWidthRatio));
		blueStripe.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));

		whiteStripe.widthProperty().bind(scene.widthProperty().multiply(stripesBoxWidthRatio));
		whiteStripe.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));

		orangeStripe.widthProperty().bind(scene.widthProperty().multiply(stripesBoxWidthRatio));
		orangeStripe.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));
		
		
		stripesBox.getChildren().addAll(blueStripe, whiteStripe, orangeStripe);
		stripesBox.setAlignment(Pos.CENTER);
		
		//Separator lines
		separatorL.setOrientation(Orientation.VERTICAL);
		separatorL.setMaxHeight(20);
		
		separatorR.setOrientation(Orientation.VERTICAL);
		separatorR.setMaxHeight(20);
		
		//Button Home
		btnHome = new CustomButton(scene);
		btnHome.homeButtonTitle();
		
		//Button Directory
		btnDirectory = new CustomButton(scene);
		btnDirectory.goToDirectoryAdmin();
		
		//Buton Admin
		btnAdmin = new CustomButton(scene);
		btnAdmin.adminAccessTitle();
		
		
		menuBox.getChildren().addAll(btnHome, separatorL, btnDirectory, separatorR, btnAdmin);
		menuBox.setAlignment(Pos.CENTER);
		menuBox.setStyle("-fx-font-family: 'Futura';");
		
		this.getChildren().addAll(imgViewLogo, stripesBox, menuBox);
		
	}

}
