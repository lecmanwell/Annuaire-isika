package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Footer;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderViewGeneral;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.MultiSearch;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.UserDirectory;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class UserDirectoryView extends VBox {
	
	private Scene scene;
	
	public UserDirectoryView(Scene scene) {
		super();
		System.out.println(scene);
		this.scene = scene;
		
		HeaderViewGeneral header = new HeaderViewGeneral(scene);
		
		VBox pageCentrale = new VBox();
		pageCentrale.setPadding(new Insets(20, 20, 20, 20));
		
		MultiSearch multiSearch = new MultiSearch(scene);
		multiSearch.getChildren().add(multiSearch.multiSearchUser());
		
		UserDirectory userDirectory = new UserDirectory(scene);
		
		pageCentrale.getChildren().addAll(multiSearch, userDirectory);
		
		Footer footer = new Footer(scene);
		footer.getChildren().add(footer.userViewFooter());
		this.getChildren().addAll(header, pageCentrale, footer);
		scene.setRoot(this);
		
	}
	
	

}
