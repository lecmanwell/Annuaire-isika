package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Header extends HBox {

	private Scene scene;
	private TreeDAO tree;

	private String imgPathLogo = "/Images/isikalogo.png";

	private double stripeHeightRatio = 0.015;
	private double stripesBoxWidthRatio;
	private double logoWidthRatio = 0.16;;

	// container pour le menu de navigation
	HBox menuBoxAdmin = new HBox();
	HBox menuBoxUser = new HBox();
	private CustomButton btnHome;
	private CustomButton btnDirectory;
	private CustomButton btnAdmin;
	private Separator separatorL;
	private Separator separatorR;

	public Header(Scene scene, TreeDAO tree) {
		this.scene = scene;
		this.tree = tree;
	}

	public VBox createStripesBox(double widthRatio) {

		VBox stripesBox = new VBox();

		Rectangle blueStripe = new Rectangle();
		Rectangle whiteStripe = new Rectangle();
		Rectangle orangeStripe = new Rectangle();

		// Set colors for stripes
		blueStripe.setFill(Color.web("#144d65"));
		whiteStripe.setFill(Color.web("#FFFFFF"));
		orangeStripe.setFill(Color.web("#db754a"));

		// Bind sizes to scene properties
		blueStripe.widthProperty().bind(scene.widthProperty().multiply(widthRatio));
		blueStripe.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));
		whiteStripe.widthProperty().bind(scene.widthProperty().multiply(widthRatio));
		whiteStripe.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));
		orangeStripe.widthProperty().bind(scene.widthProperty().multiply(widthRatio));
		orangeStripe.heightProperty().bind(scene.heightProperty().multiply(stripeHeightRatio));

		stripesBox.getChildren().addAll(blueStripe, whiteStripe, orangeStripe);
		stripesBox.setAlignment(Pos.CENTER);

		return stripesBox;

	}

	public ImageView createLogo(double logoWidthRatio) {

		ImageView imgViewLogo = new ImageView(new Image(getClass().getResourceAsStream(imgPathLogo)));
		imgViewLogo.fitWidthProperty().bind(scene.widthProperty().multiply(logoWidthRatio));
		imgViewLogo.setPreserveRatio(true);
		return imgViewLogo;

	}

	public Separator createSeparator() {
		Separator separator = new Separator();
		separator.setOrientation(Orientation.VERTICAL);
		separator.setMaxHeight(20);
		return separator;
	}

	public HBox createMenuUser() {

		// Création des boutons de navigation
		btnHome = new CustomButton(scene, this.tree);
		btnHome.homeButtonTitle();

//		btnDirectory = new CustomButton(scene, this.tree);
//		btnDirectory.goToDirectoryTitle();

		btnAdmin = new CustomButton(scene, this.tree);
		btnAdmin.adminAccessTitle();

		/// Création des séparateurs
		separatorL = createSeparator();
//		separatorR = createSeparator();

//		menuBoxUser.getChildren().addAll(btnHome, separatorL, btnDirectory, separatorR, btnAdmin);
		menuBoxUser.getChildren().addAll(btnHome, separatorL, btnAdmin);
		menuBoxUser.setAlignment(Pos.CENTER);
		menuBoxUser.setStyle("-fx-font-family: 'Futura';");
		return menuBoxUser;
	}

	public HBox createMenuAdmin() {
		// Création des boutons de navigation
		btnHome = new CustomButton(scene, this.tree);
		btnHome.homeButtonTitle();

		btnDirectory = new CustomButton(scene, this.tree);
		btnDirectory.goToDirectoryAdminTitle();
		
		separatorL = createSeparator();
		
		menuBoxAdmin.getChildren().addAll(btnHome, separatorL, btnDirectory);
		menuBoxAdmin.setAlignment(Pos.CENTER);
		menuBoxAdmin.setStyle("-fx-font-family: 'Futura';");
		return menuBoxAdmin;
	}

	public void headerSimple() {
		stripesBoxWidthRatio = 0.40;

		VBox leftStripes = createStripesBox(stripesBoxWidthRatio);
		ImageView logo = createLogo(logoWidthRatio);
		VBox rightStripes = createStripesBox(stripesBoxWidthRatio);
		HBox headerBox = new HBox();
		headerBox.getChildren().addAll(leftStripes, logo, rightStripes);

		this.getChildren().add(headerBox);
	}

	public void headerUserDirectoryView() {

		stripesBoxWidthRatio = 0.48;

		ImageView logo = createLogo(logoWidthRatio);

		VBox stripes = createStripesBox(stripesBoxWidthRatio);

		HBox menuBoxUser = createMenuUser();
		HBox headerBox = new HBox();
		headerBox.getChildren().addAll(logo, stripes, menuBoxUser);
		
		this.getChildren().add(headerBox);
		
		return;
	}

	public void headerAdminView() {
		stripesBoxWidthRatio = 0.62;

		ImageView logo = createLogo(logoWidthRatio);

		VBox stripes = createStripesBox(stripesBoxWidthRatio);

		HBox menuBoxAdmin = createMenuAdmin();
		HBox headerBox = new HBox();
		headerBox.getChildren().addAll(logo, stripes, menuBoxAdmin);
		
		this.getChildren().add(headerBox);
		
		return;
	}
}
