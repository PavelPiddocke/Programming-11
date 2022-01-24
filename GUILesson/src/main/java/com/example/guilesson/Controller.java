package com.example.guilesson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public TextField textGetName;

    public Button btnGetName;
    public TextField txtAdd;
    public TextField txtSubtract;
    public Button btnAdd;
    public Button btnSubtract;
    public Label lblTotal;
    public double total = 0;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void printName(ActionEvent actionEvent) {
        String name = textGetName.getText();
        System.out.println(name);
    }

    public void add(ActionEvent actionEvent) {
        double num = Double.parseDouble(txtAdd.getText());
        total += num;
        lblTotal.setText(Double.toString(total));
        txtAdd.clear();

    }

    public void subtract(ActionEvent actionEvent) {
        double num = Double.parseDouble(txtSubtract.getText());
        total -= num;
        lblTotal.setText(Double.toString(total));
        txtSubtract.clear();
    }
}