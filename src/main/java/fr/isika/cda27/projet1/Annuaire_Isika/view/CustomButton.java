package fr.isika.cda27.projet1.Annuaire_Isika.view;

<<<<<<< HEAD
public class Button {

	String btnLabel;

	public Button(String btnLabel) {
		super();
		this.btnLabel = btnLabel;
	}

	public Button generateDocumentation() {
		Button btn = new Button(btnLabel);
=======
import javafx.scene.control.Button;

public class CustomButton extends Button {

	String btnLabel;

	public CustomButton(String btnLabel) {
		super(btnLabel);
		this.btnLabel = btnLabel;
	}

	public CustomButton generateDocumentation() {
		CustomButton btn = new CustomButton(btnLabel);
>>>>>>> 90559712bd72b13ed652c3813c9d913ccdcb11e7
		return btn;

	}

<<<<<<< HEAD
	public Button adminAccess() {
		Button btn = new Button(btnLabel);
=======
	public CustomButton adminAccess() {
		CustomButton btn = new CustomButton(btnLabel);
>>>>>>> 90559712bd72b13ed652c3813c9d913ccdcb11e7
		return btn;

	}

<<<<<<< HEAD
	public Button adminAccessTitle() {
		Button btn = new Button(btnLabel);
=======
	public CustomButton adminAccessTitle() {
		CustomButton btn = new CustomButton(btnLabel);
>>>>>>> 90559712bd72b13ed652c3813c9d913ccdcb11e7
		return btn;

	}

<<<<<<< HEAD
	public Button goToDirectory() {
		Button btn = new Button(btnLabel);
=======
	public CustomButton goToDirectory() {
		CustomButton btn = new CustomButton(btnLabel);
>>>>>>> 90559712bd72b13ed652c3813c9d913ccdcb11e7
		return btn;

	}

<<<<<<< HEAD
	public Button goToDirectoryTitle() {
		Button btn = new Button(btnLabel);
=======
	public CustomButton goToDirectoryTitle() {
		CustomButton btn = new CustomButton(btnLabel);
>>>>>>> 90559712bd72b13ed652c3813c9d913ccdcb11e7
		return btn;

	}

<<<<<<< HEAD
	public Button printDirectory() {
		Button btn = new Button(btnLabel);
=======
	public CustomButton printDirectory() {
		CustomButton btn = new CustomButton(btnLabel);
>>>>>>> 90559712bd72b13ed652c3813c9d913ccdcb11e7
		return btn;

	}

<<<<<<< HEAD
	public Button homeButtonTitle() {
		Button btn = new Button(btnLabel);
=======
	public CustomButton homeButtonTitle() {
		CustomButton btn = new CustomButton(btnLabel);
		return btn;
	}

	public CustomButton logOut() {
		CustomButton btn = new CustomButton(btnLabel);
>>>>>>> 90559712bd72b13ed652c3813c9d913ccdcb11e7
		return btn;

	}

<<<<<<< HEAD
	public Button logOut() {
		Button btn = new Button(btnLabel);
=======
	public CustomButton modifyStudent() {
		CustomButton btn = new CustomButton(btnLabel);
>>>>>>> 90559712bd72b13ed652c3813c9d913ccdcb11e7
		return btn;

	}

<<<<<<< HEAD
	public Button modifyStudent() {
		Button btn = new Button(btnLabel);
=======
	public CustomButton deleteStudent() {
		CustomButton btn = new CustomButton(btnLabel);
>>>>>>> 90559712bd72b13ed652c3813c9d913ccdcb11e7
		return btn;

	}

<<<<<<< HEAD
	public Button deleteStudent() {
		Button btn = new Button(btnLabel);
		return btn;

	}

	public Button addStudent() {
		Button btn = new Button(btnLabel);
=======
	public CustomButton addStudent() {
		CustomButton btn = new CustomButton(btnLabel);
>>>>>>> 90559712bd72b13ed652c3813c9d913ccdcb11e7
		return btn;

	}

}
