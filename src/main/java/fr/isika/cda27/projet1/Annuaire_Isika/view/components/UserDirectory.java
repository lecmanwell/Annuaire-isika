package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class UserDirectory extends GridPane {

	
	public UserDirectory() {
		super();
		this.setPadding(new Insets(20));
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20));
		this.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #ffffff;");

		StudentCard s = new StudentCard();
		StudentCard st = new StudentCard();
		StudentCard stu = new StudentCard();
		StudentCard stud = new StudentCard();
		StudentCard stude = new StudentCard();
		StudentCard studen = new StudentCard();
		StudentCard student = new StudentCard();
		StudentCard student1 = new StudentCard();
		StudentCard student2 = new StudentCard();
		StudentCard student3 = new StudentCard();
		this.add(s, 0, 0);
		this.add(st, 1, 0);
		this.add(stu, 2, 0);
		this.add(stud, 3, 0);
		this.add(stude, 4, 0);
		this.add(studen, 0, 0);
		this.add(student, 1, 1);
		this.add(student1, 2, 1);
		this.add(student2, 3, 1);
		this.add(student3, 4, 1);
		
	}
	
	
	

}
