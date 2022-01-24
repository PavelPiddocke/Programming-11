package com.example.gameofchance;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    public TextField txtBetAmount;
    public Label dice1Result;
    public Label diceTotal;
    public Label resultTxt;
    public Label betBalance;
    public Label dice2Result;
    public Button btnRoll;
    public Button betOver;
    public Button betUnder;
    public Button btnTryAgain;

    @FXML
    private Label welcomeText;
    int balance = 100;
    public ImageView diceImage;
    @FXML
    protected void onButtonClick() {
        welcomeText.setText("Welcome to The Game of Chance!");
    }

    private void checkBalance() {
        int bal = Integer.parseInt(betBalance.getText());
        String balText = betBalance.getText();
        if (bal <= 0) {
            txtBetAmount.setText("BUSTED");
            betOver.setDisable(true);
            betUnder.setDisable(true);
            btnTryAgain.setDisable(true);
        }
    }
    public void placeBet(ActionEvent actionEvent) {
        int bet = Integer.parseInt(txtBetAmount.getText());
        int roll = getRoll();
        if (txtBetAmount.getText() == "BUSTED"){
            btnRoll.setDisable(true);
        }
        else {
            dice1Result.setText(Integer.toString(roll));
            btnRoll.setDisable(true);
            betOver.setDisable(false);
            betUnder.setDisable(false);
            btnTryAgain.setDisable(true);
        }
    }

    public void betOverRoll(ActionEvent actionEvent) {
        int bet = Integer.parseInt(txtBetAmount.getText());
        int roll = getRoll();
        checkBalance();
            dice2Result.setText(Integer.toString(roll));

            if (roll > Integer.parseInt(dice1Result.getText())) {
                resultTxt.setText("You Win!");
                balance = balance + bet;
                betBalance.setText(Integer.toString(balance));
            } else if (roll == Integer.parseInt(dice1Result.getText())) {
                resultTxt.setText("Tie, You Lose!");
                balance = balance - bet;
                betBalance.setText(Integer.toString(balance));
            } else {
                resultTxt.setText("You Lose!");
                balance = balance - bet;
                betBalance.setText(Integer.toString(balance));
            }
            betOver.setDisable(true);
            betUnder.setDisable(true);
            btnTryAgain.setDisable(false);
        checkBalance();

    }

    public void betUnderRoll(ActionEvent actionEvent) {
        int roll = getRoll();
        int bet = Integer.parseInt(txtBetAmount.getText());
        checkBalance();
            dice2Result.setText(Integer.toString(roll));
            if (roll < Integer.parseInt(dice1Result.getText())) {
                resultTxt.setText("You Win!");
                balance = balance + bet;
                betBalance.setText(Integer.toString(balance));
            } else if (roll == Integer.parseInt(dice1Result.getText())) {
                resultTxt.setText("Tie, You Lose!");
                balance = balance - bet;
                betBalance.setText(Integer.toString(balance));
            } else {
                resultTxt.setText("You Lose!");
                balance = balance - bet;
                betBalance.setText(Integer.toString(balance));
            }
            betOver.setDisable(true);
            betUnder.setDisable(true);
            btnTryAgain.setDisable(false);
        checkBalance();

    }

    private static int getRoll() {
        int a = (int) (Math.random() * 6) + 1;
        return a;

    }

    public void endProgram(ActionEvent actionEvent) {
        System.exit(0);
    }


    public void tryAgain(ActionEvent actionEvent) {
        btnRoll.setDisable(false);
        btnTryAgain.setDisable(true);
    }
}