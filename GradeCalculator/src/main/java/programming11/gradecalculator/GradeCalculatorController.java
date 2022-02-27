package programming11.gradecalculator;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class GradeCalculatorController implements Initializable {
    @FXML
    public TableView<Percentage> tableViewAssignments;
    public TextField txtAssignment;
    public TextField txtGrade;
    public TextField txtWeight;
    public TableColumn<Percentage, String> colAssignment;
    public TableColumn<Percentage, Double> colGrade;
    public TableColumn<Percentage, Double> colWeight;
    public TableView<Letter> tableViewLetAssignments;
    public TableColumn<Letter, String>  colLetAssignment;
    public TableColumn<Letter, String>  colLetGrade;
    public TableColumn<Letter, Double>  colLetWeight;
    public TextField txtLetWeight;
    public TextField txtLetAssignment;
    @FXML
    public Button closeButton;
    public ChoiceBox<String> choiceGrade;
    public TextField txtGPAAssignment;
    public TextField txtGPAGrade;
    public TextField txtGPAWeight;
    public TableView<GPA> tableViewGPAAssignments;
    public TableColumn<GPA, String> colGPAAssignment;
    public TableColumn<GPA, Double> colGPAGrade;
    public TableColumn<GPA, Double> colGPAWeight;
    public Label txtGPAGradeResult;
    public Label txtLGradeResult;
    public Label txtPGradeResult;
    private String[] letterGrades = {"A+","A","B+","B","C+","C","D","F"};
    @FXML
    private Label welcomeText;

    public void initialize(URL url, ResourceBundle rb){

        //initialize all three tabs
        colAssignment.setCellValueFactory(new PropertyValueFactory<Percentage, String>("assignment"));
        colGrade.setCellValueFactory(new PropertyValueFactory<Percentage, Double>("grade"));
        colWeight.setCellValueFactory(new PropertyValueFactory<Percentage, Double>("weight"));
        colLetAssignment.setCellValueFactory(new PropertyValueFactory<Letter, String>("letAssignment"));
        colLetGrade.setCellValueFactory(new PropertyValueFactory<Letter, String>("letGrade"));
        colLetWeight.setCellValueFactory(new PropertyValueFactory<Letter, Double>("letWeight"));
        choiceGrade.getItems().addAll(letterGrades);
        choiceGrade.setOnAction(this::getLetterGrades);
        colGPAAssignment.setCellValueFactory(new PropertyValueFactory<GPA, String>("gPAAssignment"));
        colGPAGrade.setCellValueFactory(new PropertyValueFactory<GPA, Double>("gPAGrade"));
        colGPAWeight.setCellValueFactory(new PropertyValueFactory<GPA, Double>("gPAWeight"));

    }

    //Percentage Tab Methods and calculations
    //Button to add up all grades and weights and calculate a final grade
    public void calculatePercentGrade(ActionEvent actionEvent) {
        double calculatedGrade = 0.00;
        double totalGrade = 0.00;
        for (int i= 0; i<tableViewAssignments.getItems().size(); i++){
            double grd = tableViewAssignments.getItems().get(i).getGrade();
            double wgt = tableViewAssignments.getItems().get(i).getWeight();
            calculatedGrade = grd * wgt;
            totalGrade += calculatedGrade;
        }
        totalGrade = totalGrade/100;
        String result = String.format("%1.2f", totalGrade);
        txtPGradeResult.setText(result);

    }
    //Method to add an assignment with grades to the TableView
    public void btnAddAssignment(ActionEvent actionEvent) {
        //check if number fields have numbers and if not, return a message in the textbox
        if (isNum(txtGrade, "Please enter a number in the grade field!") || isNum(txtWeight, "Please enter a number in the weight field!")){
            //Creates a new Percentage object based on all the fields and adds it to the friends table
            Percentage newPercentage = new Percentage(txtAssignment.getText(), Double.parseDouble(txtGrade.getText()), Double.parseDouble(txtWeight.getText()));
            tableViewAssignments.getItems().add(newPercentage);
        }
    }


    // Letter Grade Tab methods
    // calculate letter grade - uses two helper methods below to convert values
    public void calculateLetterGrade(ActionEvent actionEvent) {
        double calculatedGrade = 0.00;
        double totalGrade = 0.00;
        String result = "D";
        for (int i= 0; i<tableViewLetAssignments.getItems().size(); i++){
            double grd = convertGrade(tableViewLetAssignments.getItems().get(i).getLetGrade());
            double wgt = tableViewLetAssignments.getItems().get(i).getLetWeight();
            calculatedGrade = grd * wgt;
            totalGrade += calculatedGrade;
        }
        totalGrade = totalGrade/100;
        result = generateLetter(totalGrade);
        txtLGradeResult.setText(result);

    }

    //Method to add an assignment with letter grades to the TableView
    public void btnAddLetAssignment(ActionEvent actionEvent) {
        // if (isNum(txtLetWeight, "Please enter a number in the weight field!")) {
        //Creates a new Letter object based on all the fields and adds it to the friends table
        Letter newLetter = new Letter(txtLetAssignment.getText(), choiceGrade.getValue(), Double.parseDouble(txtLetWeight.getText()));
        tableViewLetAssignments.getItems().add(newLetter);
        // }
    }
    //Generate a GPA from a letter
    //Requires: String
    //Modifies: This
    //Effects: converts letter grade to GPA - this helps calculate the final grade.
    public static double convertGrade(String letterGrade){

        double grade;

        if (Objects.equals(letterGrade, "A+"))
            grade = 4;
        else if (Objects.equals(letterGrade, "A"))
            grade = 3.7;
        else if (Objects.equals(letterGrade, "B+"))
            grade = 3.3;
        else if (Objects.equals(letterGrade, "B"))
            grade = 3;
        else if (Objects.equals(letterGrade, "C+"))
            grade = 2.3;
        else if (Objects.equals(letterGrade, "C"))
            grade = 2;
        else if (Objects.equals(letterGrade, "D"))
            grade = 1;
        else
            grade = 0;


        return grade;

    }
    // generate a letter from a GPA
    //Requires: double
    //Modifies: this
    //Effects: Converts numerical GPA to letter grade. This helps display the calculated grade.
    private String generateLetter(double totalGrade) {
        String letterGrade;

        if (totalGrade >= 3.91)
            letterGrade = "A+";
        else if ((totalGrade >= 3.6)&&(totalGrade < 3.9))
            letterGrade = "A";
        else if ((totalGrade >= 3.3)&&(totalGrade < 3.6))
            letterGrade = "B+";
        else if ((totalGrade >= 3)&&(totalGrade < 3.3))
            letterGrade = "B";
        else if ((totalGrade >= 2.3)&&(totalGrade < 3))
            letterGrade = "C+";
        else if ((totalGrade >= 1.7)&&(totalGrade < 2.3))
            letterGrade = "C";
        else if ((totalGrade >= 1)&&(totalGrade < 1.6))
            letterGrade = "D";
        else
            letterGrade = "F";

        return letterGrade;

    }

    public  void getLetterGrades(ActionEvent event){
        String letterGrades = choiceGrade.getValue();

    }


    // Letter Grade Tab methods
    // calculate letter grade - uses two helper methods below to convert values
    public void calculateGPAGrade(ActionEvent actionEvent) {
        double calculatedGrade = 0.00;
        double totalGrade = 0.00;
        String result = "D";
        for (int i= 0; i<tableViewGPAAssignments.getItems().size(); i++){
            double grd = tableViewGPAAssignments.getItems().get(i).getGPAGrade();
            double wgt = tableViewGPAAssignments.getItems().get(i).getGPAWeight();
            calculatedGrade = grd * wgt;
            totalGrade += calculatedGrade;
        }
        totalGrade = totalGrade/100;
        txtGPAGradeResult.setText(String.valueOf(totalGrade));
    }

    //Method to add an assignment with letter grades to the TableView
    public void btnAddGPAAssignment(ActionEvent actionEvent) {
        // if (isNum(txtLetWeight, "Please enter a number in the weight field!")) {
        //Creates a new Letter object based on all the fields and adds it to the friends table
        GPA newGPA = new GPA(txtGPAAssignment.getText(), Double.parseDouble(txtGPAGrade.getText()), Double.parseDouble(txtGPAWeight.getText()));
        tableViewGPAAssignments.getItems().add(newGPA);
        // }
    }


    //MENU methods here. Includes Open file, save file, etc.
    public void menuOpenFile(ActionEvent actionEvent) throws IOException {

        //use file chooser to open a file load window
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("comma separated file", "*.csv"), new FileChooser.ExtensionFilter("text file","*.txt"));
        File assignmentFile= fileChooser.showOpenDialog(new Stage());
        //pass the chosen files name to the readAssignments method
        if (assignmentFile != null) {
            readAssignments(assignmentFile.getPath());
        } else {
            popUp("Incorrect file or no file chosen");
        }
    }

    //Method to close the program from the menu.
    public void menuCloseAction(ActionEvent actionEvent) {
        GradeCalculatorApplication.primaryStage.close();
    }

    //method to read from the text file using BufferedReader as shown in the course.
    private void readAssignments(String filename)
            throws IOException {
        //open reader to read the file.
        BufferedReader reader = Files.newBufferedReader(Paths.get(filename));
        String line;
        //use line split to split the contents into chunks. Cannot use spaces because the name has spaces.
        //spaces are also allowed in other strings so make it comma separated.
        while ((line = reader.readLine()) != null) {
            List<Percentage> allAssignments = new ArrayList<>();
            String[] assign = line.split(",");
            // Add the friend to the list
            allAssignments.add(new Percentage(assign[0], Double.parseDouble(assign[1]), Double.parseDouble(assign[2])));
            // put assignments in tableview
            tableViewAssignments.getItems().addAll(allAssignments);
        }
    }



    //Helper Methods for all tabs

    // Method to remove lines from the table if you make a mistake.
    public void btnRemoveAssignment(ActionEvent actionEvent) {

        tableViewAssignments.getItems().removeAll(tableViewAssignments.getSelectionModel().getSelectedItem());
    }
    public void btnRemoveLetAssignment(ActionEvent actionEvent) {

        tableViewLetAssignments.getItems().removeAll(tableViewLetAssignments.getSelectionModel().getSelectedItem());
    }

    public void btnRemoveGPAAssignment(ActionEvent actionEvent) {

        tableViewGPAAssignments.getItems().removeAll(tableViewGPAAssignments.getSelectionModel().getSelectedItem());
    }


    public void menuSaveAs(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Dialog");
        fileChooser.setInitialFileName("Assignments.csv");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("comma separated file", "*.csv"), new FileChooser.ExtensionFilter("text file","*.txt"));

        File assignmentFile= fileChooser.showSaveDialog(new Stage());
        //pass the chosen files name to the readAssignments method
        ObservableList<Percentage> selectedRows, allAssignments;
        allAssignments = tableViewAssignments.getItems();
            FileWriter writer = new FileWriter(assignmentFile);
            for (Percentage assignments : allAssignments) {
                writer.write(assignments.getAssignment() + "," + assignments.getGrade() + "," + assignments.getWeight() + "\n");
            }
            writer.close();
        }



    //error handling methods including checks and popup
    public static void popUp(String msg){
        Stage newStage = new Stage();
        Button closeButton = new Button("Close");
        VBox vbox = new VBox(new Text(msg), closeButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));

        newStage.setScene(new Scene(vbox));
        newStage.show();

        closeButton.setOnAction( e -> newStage.close() );
    }

    //method to check if the Weight and grade are numbers. If not, return a message in a popup - calls popUp.
    private boolean isNum(TextField f, String msg){
        String text = f.getText();

        try
        {
            Double.parseDouble(text);
            return true;
        }
        catch (NumberFormatException e)
        {
            popUp(msg);
            return false;
        }
    }

    public void menuAbout(ActionEvent actionEvent) {
        popUp("Pavel's grade calculator. Calculate your grade by percentage, \n letter, or GPA. Enter your grades and click calculate");
    }

}

