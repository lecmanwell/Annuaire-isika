package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.scene.control.Button;

public class CustomButton extends Button {

	String btnLabel;

	public CustomButton(String btnLabel) {
		super(btnLabel);
		this.btnLabel = btnLabel;
	}

	public CustomButton generateDocumentation() {
		CustomButton btn = new CustomButton(btnLabel);
		return btn;

	}

	public CustomButton adminAccess() {
		CustomButton btn = new CustomButton(btnLabel);
		return btn;

	}

	public CustomButton adminAccessTitle() {
		CustomButton btn = new CustomButton(btnLabel);
		return btn;

	}

	public CustomButton goToDirectory() {
		CustomButton btn = new CustomButton(btnLabel);
		return btn;

	}

	public CustomButton goToDirectoryTitle() {
		CustomButton btn = new CustomButton(btnLabel);
		return btn;

	}

	public CustomButton printDirectory() {
		CustomButton btn = new CustomButton(btnLabel);
		return btn;

	}

	public CustomButton homeButtonTitle() {
		CustomButton btn = new CustomButton(btnLabel);
		return btn;
	}

	public CustomButton logOut() {
		CustomButton btn = new CustomButton(btnLabel);
		return btn;

	}

	public CustomButton modifyStudent() {
		CustomButton btn = new CustomButton(btnLabel);
		return btn;

	}

	public CustomButton deleteStudent() {
		CustomButton btn = new CustomButton(btnLabel);
		return btn;

	}

	public CustomButton addStudent() {
		CustomButton btn = new CustomButton(btnLabel);
		return btn;

	}

}
