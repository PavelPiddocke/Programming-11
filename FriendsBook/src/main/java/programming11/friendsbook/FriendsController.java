package programming11.friendsbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class FriendsController implements Initializable {

    @FXML
    public TextArea txtFriendsDetails;

    @FXML
    public TextField txtPhone;

    @FXML
    private TableColumn<Friends, Integer> colAge;

    @FXML
    private TableColumn<Friends, String> colCity;

    @FXML
    private TableColumn<Friends, String> colGender;

    @FXML
    private TableColumn<Friends, String> colPhone;

    @FXML
    private TableColumn<Friends, String> colName;

    @FXML
    private TableView<Friends> tableViewFriends;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtName;



    //initialize method required for PropertyValueFactory for TableView
    public void initialize(URL url, ResourceBundle rb){
        colName.setCellValueFactory(new PropertyValueFactory<Friends, String>("friendName"));
        colAge.setCellValueFactory(new PropertyValueFactory<Friends, Integer>("age"));
        colGender.setCellValueFactory(new PropertyValueFactory<Friends, String>("gender"));
        colCity.setCellValueFactory(new PropertyValueFactory<Friends, String>("city"));
        colPhone.setCellValueFactory(new PropertyValueFactory<Friends, String>("phoneNumber"));

    }

    public ObservableList<Friends> getFriendsList(){
        ObservableList<Friends> friends = FXCollections.observableArrayList();

        return friends;
    }

    //method to check if the Age value is an integer. If not, return a message in the text box
    private boolean isInt(TextField f, String msg)
    {
        try
        {
            Integer.parseInt(f.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            txtFriendsDetails.setText(msg);
            return false;
        }
    }

    //Method to add a friend to the TableView
    public void btnAddFriend(ActionEvent actionEvent) {
        //check if number fields have numbers and if not, return a message in the textbox
        if (isInt(txtAge, "Please enter a number!")){
            //Creates a new friend object based on all the fields and adds it to the friends table
        Friends newFriend = new Friends(txtName.getText(), Integer.parseInt(txtAge.getText()), txtGender.getText(), txtCity.getText(), txtPhone.getText());
        tableViewFriends.getItems().add(newFriend);}
        txtAge.requestFocus();
    }
   
    //Method to remove a friend from the tableview
    public void btnRemoveFriend(ActionEvent actionEvent) {

        ObservableList<Friends> selectedRows, allFriends;
        allFriends = tableViewFriends.getItems();

        //this gives us the rows that were selected
        selectedRows = tableViewFriends.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the friends objects from the table
        for (Friends friend: selectedRows)
        {
            allFriends.remove(friend);
        }

    }

    //Method to show the friends info from the table in the textpane
    public void clkSelectFriend(MouseEvent mouseEvent) {
        ObservableList<Friends> selectedRows, allFriends;
        allFriends = tableViewFriends.getItems();

        //this gives us the rows that were selected
        selectedRows = tableViewFriends.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the friend objects from the table

           for (Friends friend : selectedRows) {
               txtFriendsDetails.setText("Friend Details:\n\n Name:  " + friend.getFriendName() + "\n Age:  " + Integer.toString(friend.getAge()) + "\n Current City:  " + friend.getCity() + "\n Phone:  " + friend.getPhoneNumber());
           }
    }

    public void btnReadFile(ActionEvent actionEvent) throws IOException {
        //use file chooser to open a file load window
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter fileExtension = new FileChooser.ExtensionFilter("select your friends file (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(fileExtension);
        File friendsFile= fileChooser.showOpenDialog(new Stage());
        //pass the chosen files name to the readFriends method
        if (friendsFile != null) {
            readFriends(friendsFile.getName());
        } else {
            System.out.println("Incorrect file");
        }
    }

    public void btnWriteFile(ActionEvent actionEvent) throws IOException {
        String filename = createNewFile();
        ObservableList<Friends> selectedRows, allFriends;
        allFriends = tableViewFriends.getItems();
        //this gives us all the rows
        //write to text file using the custom method
            writeToTextFile(filename, allFriends);
    }

        private static void writeToTextFile(String filename, ObservableList<Friends> allFriends)
            throws IOException {

            FileWriter writer = new FileWriter(filename);
            for (Friends friend : allFriends) {
                writer.write(friend.getFriendName() + "," + friend.getAge() + "," + friend.getGender() + "," + friend.getCity() + "," + friend.getPhoneNumber() + "\n");
            }
            writer.close();
        }

        private void readFriends(String filename)
            throws IOException {
            //method to read from the text file using BufferedReader as shown in the course.
            //open reader to read the file.
            BufferedReader reader = Files.newBufferedReader(Paths.get(filename));
            String line;
            //use line split to split the contents into chunks. Cannot use spaces because the name has spaces.
            //spaces are also allowed in other strings so make it comma separated.
            while ((line = reader.readLine()) != null) {
                List<Friends> allFriends = new ArrayList<>();
                String[] names = line.split(",");
                // Add the friend to the list
                allFriends.add(new Friends(names[0], Integer.parseInt(names[1]), names[2], names[3], names[4]));
                // put it in the tableview
                tableViewFriends.getItems().addAll(allFriends);
            }
        }

        public String createNewFile(){
        //method to create a unique filename and file for each group of friends to store.
            String fileName = "friends.txt";
            String extension = "";
            String name = "";
            //find where teh file extension starts and add 1 to it.
            int idxOfDot = fileName.lastIndexOf('.');
            extension = fileName.substring(idxOfDot + 1);
            name = fileName.substring(0, idxOfDot);

            Path path = Paths.get(fileName);
            int counter = 1;
            File f = null;
            //loop through the files and add an incremented number
            while(Files.exists(path)){
                fileName = name+"("+counter+")."+extension;
                path = Paths.get(fileName);
                counter++;
            }
            //Create a new file with the new name. Return for use.
            f = new File(fileName);
            System.out.println(fileName);
            return fileName;
        }

    }

