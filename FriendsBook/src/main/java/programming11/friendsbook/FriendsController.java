package programming11.friendsbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.net.URL;
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
}
