package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Classe représentant l'en-tête général de l'application. Cet en-tête est
 * composé de bandes colorées, d'un logo centré et d'un menu de navigation.
 */

public class HeaderViewGeneral extends HBox {

	HBox headerBoxGrl = new HBox();
	Scene scene;

	// Bandes pour l'en-tête général
	VBox stripesBox = new VBox();
	Rectangle blueStripe = new Rectangle();
	Rectangle whiteStripe = new Rectangle();
	Rectangle orangeStripe = new Rectangle();

	// Chemin de l'image du logo
	String imgPathLogo = "/Images/isikalogo.png";

	// container pour le menu de navigation
	HBox menuBox = new HBox();
	CustomButton btnHome;
	CustomButton btnDirectory;
	CustomButton btnAdmin;
	Separator separatorL = new Separator();
	Separator separatorR = new Separator();

	/**
	 * Constructeur de la classe. Initialise l'en-tête général en créant les bandes
	 * colorées, le logo et le menu de navigation.
	 *
	 * @param scene La scène à laquelle cet en-tête est attaché.
	 */

	public HeaderViewGeneral(Scene scene) {
		super();
		this.scene = scene;

		// Ratios pour les composants de l'en-tête'
		double stripeHeightRatio = 0.015;
		double stripesBoxWidthRatio = 0.48;
		double logoWidthRatio = 0.16;

		// Création du logo
		ImageView imgViewLogo = new ImageView(new Image(getClass().getResourceAsStream(imgPathLogo)));
		imgViewLogo.fitWidthProperty().bind(scene.widthProperty().multiply(logoWidthRatio));
		imgViewLogo.setPreserveRatio(true);

		// Création des bandes colorées
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

		/// Création des séparateurs
		separatorL.setOrientation(Orientation.VERTICAL);
		separatorL.setMaxHeight(20);

		separatorR.setOrientation(Orientation.VERTICAL);
		separatorR.setMaxHeight(20);

		// Création des boutons de navigation
		btnHome = new CustomButton(scene);
		btnHome.homeButtonTitle();

		btnDirectory = new CustomButton(scene);
		btnDirectory.goToDirectoryTitle();

		btnAdmin = new CustomButton(scene);
		btnAdmin.adminAccessTitle();

		menuBox.getChildren().addAll(btnHome, separatorL, btnDirectory, separatorR, btnAdmin);
		menuBox.setAlignment(Pos.CENTER);
		menuBox.setStyle("-fx-font-family: 'Futura';");

		// Ajout des composants à l'en-tête
		this.getChildren().addAll(imgViewLogo, stripesBox, menuBox);

	}

}
