package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;

public class ChoiceBoxTableCell extends TableCell<Student, Integer> {
    private final ChoiceBox<Integer> choiceBox;

    public ChoiceBoxTableCell() {
        choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(2024, 2023, 2022, 2021, 2020, 2019, 2018, 2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2006, 2005, 2004, 2003, 2002);
        choiceBox.setOnAction(e -> commitEdit(choiceBox.getValue()));

        // Écouteur pour désactiver l'édition si on annule
        choiceBox.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) {
                commitEdit(choiceBox.getValue());
            }
        });
    }

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

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText(String.valueOf(getItem()));
        setGraphic(null);
    }

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
    @Override
    public void commitEdit(Integer newValue) {
        super.commitEdit(newValue);
        // Mise à jour du modèle sous-jacent (l'objet Student)
        getTableView().getItems().get(getIndex()).setYearPromo(newValue);
    }
}
