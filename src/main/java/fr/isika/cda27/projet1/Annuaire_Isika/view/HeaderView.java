package fr.isika.cda27.projet1.Annuaire_Isika.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HeaderView extends HBox  {
	
	
	//Stripes container
    private VBox stripesBox;
    private HBox blueStripe;
    private HBox whiteStripe;
    private HBox orangeStripe;
	
	
	Label headerLbl;
	
	public HeaderView(Scene scene) {
		headerLbl = new Label("hello header");
		this.getChildren().add(headerLbl);
	}

}
