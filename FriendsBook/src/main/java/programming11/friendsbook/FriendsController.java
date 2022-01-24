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


    public TextArea txtFriendsDetails;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnUpdate;

    @FXML
    public TextField checkIsFriend;

    @FXML
    private TableColumn<Friends, Integer> colAge;

    @FXML
    private TableColumn<Friends, String> colCity;

    @FXML
    private TableColumn<Friends, String> colGender;

    @FXML
    private TableColumn<Friends, String> colIsFriend;

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

    @FXML
    private Label welcomeText;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }

    public void initialize(URL url, ResourceBundle rb){
        colName.setCellValueFactory(new PropertyValueFactory<Friends, String>("friendName"));
        colAge.setCellValueFactory(new PropertyValueFactory<Friends, Integer>("age"));
        colGender.setCellValueFactory(new PropertyValueFactory<Friends, String>("gender"));
        colCity.setCellValueFactory(new PropertyValueFactory<Friends, String>("city"));
        colIsFriend.setCellValueFactory(new PropertyValueFactory<Friends, String>("friendStatus"));
 //load dummy data
        tableViewFriends.setItems(getFriendsList());

    }

    public ObservableList<Friends> getFriendsList(){
        ObservableList<Friends> friends = FXCollections.observableArrayList();

        return friends;
    }


    public void btnAddFriend(ActionEvent actionEvent) {

        Friends newFriend = new Friends(txtName.getText(), Integer.parseInt(txtAge.getText()), txtGender.getText(), txtCity.getText(), checkIsFriend.getText());
        tableViewFriends.getItems().add(newFriend);
    }


   

    public void btnRemoveFriend(ActionEvent actionEvent) {

        ObservableList<Friends> selectedRows, allFriends;
        allFriends = tableViewFriends.getItems();

        //this gives us the rows that were selected
        selectedRows = tableViewFriends.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the Person objects from the table
        for (Friends friend: selectedRows)
        {
            allFriends.remove(friend);
        }
    }

    public void clkSelectFriend(MouseEvent mouseEvent) {
        ObservableList<Friends> selectedRows, allFriends;
        allFriends = tableViewFriends.getItems();

        //this gives us the rows that were selected
        selectedRows = tableViewFriends.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the Person objects from the table
        for (Friends friend: selectedRows)
        {  txtFriendsDetails.setText("Friend Details:\n\n Name:  " + friend.getFriendName() + "\n Age:  " + Integer.toString(friend.getAge()) +"\n Current City:  " + friend.getCity() + "\n My Friend:  " + friend.getFriendStatus());


        }
    }
}
