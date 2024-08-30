package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import java.util.ArrayList;
import java.util.List;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class UserDirectory extends GridPane {

	Scene scene;

	
	public UserDirectory(Scene scene, TreeDAO tree) {
		
		super();
		this.scene = scene;
//		this.setPadding(new Insets(20));
//		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20, 38, 20,38));
		this.setHgap(30);
		this.setVgap(20);
		this.setStyle("-fx-background-color: #ffffff;");
		
		ArrayList<Student> ListStudents = tree.setAlphaList();

		int row = 0;
		int col = 0;
		for (Student student : ListStudents) {
			
            StudentCard s = new StudentCard(student);
            this.add(s, col, row);
            
            if(col == 3) {
                col = 0;
                row++;
            } else {
                col++;
            }
		}
		

		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(25);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(25);
		ColumnConstraints column3 = new ColumnConstraints();
		column3.setPercentWidth(25);
		ColumnConstraints column4 = new ColumnConstraints();
		column4.setPercentWidth(25);
//		ColumnConstraints column5 = new ColumnConstraints();
//		column5.setPercentWidth(20);
		
		this.getColumnConstraints().addAll(column1, column2, column3, column4);
		


		
	}
	
	
	

}
