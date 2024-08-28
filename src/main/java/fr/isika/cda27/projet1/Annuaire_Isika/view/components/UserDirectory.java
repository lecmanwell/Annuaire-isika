package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import java.util.ArrayList;
import java.util.List;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class UserDirectory extends GridPane {

	Scene scene;

	
	public UserDirectory(Scene scene) {
		
		super();
		this.scene = scene;
//		GridPane userDirectory = new GridPane();
		this.setPadding(new Insets(20));
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20));
		this.setStyle("-fx-border-color: #000000; -fx-border-width: 0px; -fx-background-color: #ffffff;");

		StudentCard s = new StudentCard();
		s.setLastNameString("Student1");
		s.setFirstNameString("John");
		s.setFormationString("Java");
		s.setAnneeFormationString("2020");
		s.setLocalisationString("Paris");
		StudentCard st = new StudentCard();
		st.setLastNameString("doe");
		st.setFirstNameString("Jane");
		st.setFormationString("Python");
		st.setAnneeFormationString("2021");
		st.setLocalisationString("London");
		StudentCard stu = new StudentCard();
		stu.setLastNameString("Smith");
		stu.setFirstNameString("Bob");
		stu.setFormationString("C++");
		stu.setAnneeFormationString("2022");
		stu.setLocalisationString("Berlin");
		
		StudentCard stud = new StudentCard();
		stud.setFirstNameString("Payre");
		stud.setLastNameString("André");
		stud.setFormationString("Java");
		stud.setAnneeFormationString("2023");
		stud.setLocalisationString("Paris");
		
		StudentCard stude = new StudentCard();
		stude.setFirstNameString("Lewis");
		stude.setLastNameString("Johnson");
		stude.setFormationString("Python");
		stude.setAnneeFormationString("2024");
		stude.setLocalisationString("London");
		
		StudentCard studen = new StudentCard();
		studen.setFirstNameString("Miller");
		studen.setLastNameString("David");
		studen.setFormationString("C++");
		studen.setAnneeFormationString("2025");
		studen.setLocalisationString("Berlin");

		

		this.add(s, 0, 0);
		this.add(st, 1, 0);
		this.add(stu, 2, 0);
		this.add(stud, 3, 0);
		this.add(stude, 4, 0);
		this.add(studen, 0, 1);

		
	}
	
	
	

}
