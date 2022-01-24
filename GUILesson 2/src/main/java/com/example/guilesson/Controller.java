package com.example.guilesson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class Controller {

    public TextField txtGetName;
    public TextField txtGetQuant;
    public TextField txtGetCost;
    public ListView<Product> productList = new ListView<>();
    public Label lblName;
    public Label lblCost;
    public Label lblQuaint;
    public Button btnPurchase;

    public void addProduct(ActionEvent actionEvent) {
        Product temp = new Product (txtGetName.getText(), Integer.parseInt(txtGetQuant.getText()), Double.parseDouble(txtGetCost.getText()));
        productList.getItems().add(temp);
        txtGetCost.clear();
        txtGetName.clear();
        txtGetQuant.clear();
        btnPurchase.setDisable(true);
    }

    public void displayProduct(MouseEvent mouseEvent) {
        Product temp;
        temp = productList.getSelectionModel().getSelectedItem();
        lblCost.setText(Double.toString(temp.getCost()));
        lblName.setText(temp.name);
        lblQuaint.setText(Integer.toString(temp.getQuantity()));
        btnPurchase.setDisable(false);
    }

    public void purchaseProduct(ActionEvent actionEvent) {
        Product temp;
        temp = productList.getSelectionModel().getSelectedItem();
        temp.purchase();
        lblQuaint.setText(Integer.toString(temp.getQuantity()));
    }
}