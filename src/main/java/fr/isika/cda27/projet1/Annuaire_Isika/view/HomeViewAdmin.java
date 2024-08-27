package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Footer;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.LoginAdmin;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.StudentCard;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeViewAdmin extends VBox {

	private Scene scene;

	public HomeViewAdmin(Scene scene) {
		super();
		this.scene = scene;
		
		HeaderView header = new HeaderView(scene);
		
		HBox pageCentrale = new HBox();
		pageCentrale.setPadding(new Insets(20, 20, 20, 20));
		String imagePath = "/Images/imageCardHome.jpg";
		StudentCard studentCard = new StudentCard(imagePath, "Projet", "Isika", "Architecte Logiciel", "2024", "92");
		LoginAdmin loginAdmin = new LoginAdmin();
		
		pageCentrale.getChildren().addAll(studentCard, loginAdmin);
		
		Footer footer = new Footer(scene);
		footer.getChildren().add(footer.homeLoginAdmin());
		
		this.getChildren().addAll(header, pageCentrale, footer);
		scene.setRoot(this);
		
		
		
}
}
