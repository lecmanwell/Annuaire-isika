package fr.isika.cda27.projet1.Annuaire_Isika.model;

public class LinkedStudents {
	
	private Student student;
	private LinkedStudents nextStudent;
	
	
	public LinkedStudents(Student student, LinkedStudents nextStudent) {
		super();
		this.student = student;
		this.nextStudent = nextStudent;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public LinkedStudents getNextStudent() {
		return nextStudent;
	}


	public void setNextStudent(LinkedStudents nextStudent) {
		this.nextStudent = nextStudent;
	}
	
	
	

}
