package fr.isika.cda27.projet1.Annuaire_Isika.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class UserDirectoryView extends VBox {
	
	private Scene scene;

	public UserDirectoryView(Scene scene) {
		super();
		this.scene = scene;
		
		HeaderView header = new HeaderView(scene);
		
		VBox pageCentrale = new VBox();
		pageCentrale.setPadding(new Insets(20, 20, 20, 20));
		MultiSearch multiSearch = new MultiSearch(scene);
		multiSearch.getChildren().add(multiSearch.multiSearchUser());
		UserDirectory userDirectory = new UserDirectory();
		
		pageCentrale.getChildren().addAll(multiSearch, userDirectory);
		
		Footer footer = new Footer(scene);
		footer.getChildren().add(footer.homeLoginAdmin());
		
		this.getChildren().addAll(header, pageCentrale, footer);
		scene.setRoot(this);
		
	}
	
	

}
