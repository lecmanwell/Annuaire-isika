package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Footer;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderViewAdmin;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderViewGeneral;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.MultiSearch;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.StudentListAdmin;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.UserDirectory;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AdminDirectoryView extends BorderPane {
	
private Scene scene;
	TreeDAO tree;
	
	public AdminDirectoryView(Scene scene, TreeDAO tree) {
		super();
		this.scene = scene;
		this.tree = tree;
		
		HeaderViewAdmin header = new HeaderViewAdmin(scene);
		
		VBox pageCentrale = new VBox();
		pageCentrale.setPadding(new Insets(20, 20, 0, 20));
		
		MultiSearch multiSearch = new MultiSearch(scene);
		multiSearch.multiSearchUser();
//		multiSearch.getChildren().add(multiSearch.multiSearchUser());
		
		StudentListAdmin userDirectory = new StudentListAdmin(scene, tree);
		ScrollPane scrollpane = new ScrollPane();
		userDirectory.setMinWidth(scrollpane.getWidth());
		scrollpane.setContent(userDirectory);
		scrollpane.setFitToWidth(true);
		scrollpane.setFitToHeight(true);
		scrollpane.setMinHeight(290);
		
		pageCentrale.getChildren().addAll(multiSearch, scrollpane);
		
		Footer footer = new Footer(scene, userDirectory);
		footer.footerAdminDirectoryView();
//		footer.adminViewFooterList();
		
		
		
		this.setTop(header);
		this.setBottom(footer);
		this.setCenter(pageCentrale);
		scene.setRoot(this);
		scene.getRoot().setStyle("-fx-font-family: 'Futura'");
		
	}

}
