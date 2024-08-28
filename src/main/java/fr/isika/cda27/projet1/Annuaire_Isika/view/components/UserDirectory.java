package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import java.util.ArrayList;
import java.util.List;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class UserDirectory extends GridPane {

	Scene scene;

	
	public UserDirectory(Scene scene) {
		
		super();
		this.scene = scene;
//		GridPane userDirectory = new GridPane();
//		this.setPadding(new Insets(20));
//		this.setAlignment(Pos.CENTER);
//		this.setPadding(new Insets(20));
//		this.setHgap(10);
//		this.setVgap(10);
		this.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #ffffff;");

		StudentCard s = new StudentCard("Student1", "John","2020", "Java", "Paris");
//		s.setLastNameString("Student1");
//		s.setFirstNameString("John");
//		s.setFormationString("Java");
//		s.setAnneeFormationString("2020");
//		s.setLocalisationString("Paris");
		
		System.out.println(s.toString());
		StudentCard s2 = new StudentCard("Student","John","2020", "Java", "Paris");
		StudentCard s3 = new StudentCard("john","rambo","java", "2020", "paris");
		StudentCard s4 = new StudentCard("john","doe","java", "2020", "paris");
		StudentCard s5 = new StudentCard("john","doe","java", "2020", "paris");
		StudentCard s6 = new StudentCard("john","doe","java", "2020", "paris");
		StudentCard s7 = new StudentCard("john","doe","java", "2020", "paris");
		StudentCard s8 = new StudentCard("john","doe","java", "2020", "paris");
		StudentCard s9 = new StudentCard("john","rambo","java", "2020", "paris");
		StudentCard s10 = new StudentCard("john","doe","java", "2020", "paris");
		StudentCard s11 = new StudentCard("john","doe","java", "2020", "paris");
		StudentCard s12 = new StudentCard("john","doe","java", "2020", "paris");
		StudentCard s13 = new StudentCard("john","doe","java", "2020", "paris");
		StudentCard s14 = new StudentCard("john","doe","java", "2020", "paris");
		StudentCard s15 = new StudentCard("john","rambo","java", "2020", "paris");
		StudentCard s16 = new StudentCard("john","doe","java", "2020", "paris");
		StudentCard s17 = new StudentCard("john","doe","java", "2020", "paris");
		StudentCard s18 = new StudentCard("john","doe","java", "2020", "paris");
		StudentCard s19 = new StudentCard("john","doe","java", "2020", "paris");
		StudentCard s20 = new StudentCard("john","doe","java", "2020", "paris");
		
		
//		StudentCard st = new StudentCard();
//		st.setLastNameString("doe");
//		st.setFirstNameString("Jane");
//		st.setFormationString("Python");
//		st.setAnneeFormationString("2021");
//		st.setLocalisationString("London");
//		
//		StudentCard stu = new StudentCard();
//		stu.setLastNameString("Smith");
//		stu.setFirstNameString("Bob");
//		stu.setFormationString("C++");
//		stu.setAnneeFormationString("2022");
//		stu.setLocalisationString("Berlin");
//		
//		StudentCard stud = new StudentCard();
//		stud.setFirstNameString("Payre");
//		stud.setLastNameString("André");
//		stud.setFormationString("Java");
//		stud.setAnneeFormationString("2023");
//		stud.setLocalisationString("Paris");
//		
//		StudentCard stude = new StudentCard();
//		stude.setFirstNameString("Lewis");
//		stude.setLastNameString("Johnson");
//		stude.setFormationString("Python");
//		stude.setAnneeFormationString("2024");
//		stude.setLocalisationString("London");
//		
//		StudentCard studen = new StudentCard();
//		studen.setFirstNameString("Miller");
//		studen.setLastNameString("David");
//		studen.setFormationString("C++");
//		studen.setAnneeFormationString("2025");
//		studen.setLocalisationString("Berlin");
		this.add(s, 0, 0);
		this.add(s2, 1, 0);
		this.add(s3, 2, 0);
		this.add(s4, 3, 0);
		this.add(s5, 4, 0);
		this.add(s6, 0, 1);
		this.add(s7, 1, 1);
		this.add(s8, 2, 1);
		this.add(s9, 3, 1);
		this.add(s10, 4, 1);
		this.add(s11, 0, 2);
		this.add(s12, 1, 2);
		this.add(s13, 2, 2);
		this.add(s14, 3, 2);
		this.add(s15, 4, 2);
		this.add(s16, 0, 3);
		this.add(s17, 1, 3);
		this.add(s18, 2, 3);
		this.add(s19, 3, 3);
		this.add(s20, 4, 3);
		

		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(20);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(20);
		ColumnConstraints column3 = new ColumnConstraints();
		column2.setPercentWidth(20);
		ColumnConstraints column4 = new ColumnConstraints();
		column2.setPercentWidth(20);
		ColumnConstraints column5 = new ColumnConstraints();
		column2.setPercentWidth(20);
		
		this.getColumnConstraints().addAll(column1, column2, column3, column4, column5);


		
	}
	
	
	

}
