package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;

/**
 * Classe représentant une cellule de tableau personnalisée avec un ChoiceBox
 * pour la modification de l'année de promotion d'un étudiant. Cette cellule
 * permet à l'utilisateur de sélectionner une année de promotion à partir d'une
 * liste déroulante et de mettre à jour l'année de promotion de l'étudiant
 * associé.
 */
public class ChoiceBoxTableCell extends TableCell<Student, Integer> {
	private final ChoiceBox<Integer> choiceBox;

	/**
	 * Constructeur de la classe. Initialise le ChoiceBox avec une liste d'années de
	 * promotion et configure les écouteurs d'événements pour l'édition et la
	 * validation des modifications.
	 */
	public ChoiceBoxTableCell() {
		choiceBox = new ChoiceBox<>();
		choiceBox.getItems().addAll(2024, 2023, 2022, 2021, 2020, 2019, 2018, 2017, 2016, 2015, 2014, 2013, 2012, 2011,
				2010, 2009, 2008, 2007, 2006, 2006, 2005, 2004, 2003, 2002);
		choiceBox.setOnAction(e -> commitEdit(choiceBox.getValue()));

		// Écouteur pour désactiver l'édition si on annule
		choiceBox.focusedProperty().addListener((obs, oldVal, newVal) -> {
			if (!newVal) {
				commitEdit(choiceBox.getValue());
			}
		});
	}

	/**
	 * Méthode appelée lorsque l'édition de la cellule commence. Affiche la
	 * ChoiceBox et masque le texte de la cellule.
	 */
	@Override
	public void startEdit() {
		super.startEdit();
		if (isEmpty()) {
			return;
		}
		choiceBox.setValue(getItem());
		setGraphic(choiceBox);
		setText(null);
	}

	/**
	 * Méthode appelée lorsque l'édition de la cellule est annulée. Affiche le texte
	 * de la cellule et masque le ChoiceBox.
	 */
	@Override
	public void cancelEdit() {
		super.cancelEdit();
		setText(String.valueOf(getItem()));
		setGraphic(null);
	}

	/**
	 * Méthode appelée pour mettre à jour la cellule avec une nouvelle valeur.
	 * Affiche le texte de la cellule ou le ChoiceBox en fonction de l'état
	 * d'édition.
	 */
	@Override
	public void updateItem(Integer item, boolean empty) {
		super.updateItem(item, empty);
		if (empty) {
			setText(null);
			setGraphic(null);
		} else {
			if (isEditing()) {
				choiceBox.setValue(item);
				setGraphic(choiceBox);
				setText(null);
			} else {
				setText(String.valueOf(item));
				setGraphic(null);
			}
		}
	}

	/**
	 * Méthode appelée lorsque l'utilisateur sélectionne une nouvelle année de
	 * promotion dans le ChoiceBox. Met à jour l'année de promotion de l'étudiant
	 * associé.
	 */
	@Override
	public void commitEdit(Integer newValue) {
		super.commitEdit(newValue);
		// Mise à jour du modèle sous-jacent (l'objet Student)
		getTableView().getItems().get(getIndex()).setYearPromo(newValue);
	}
}
