package programming11.friendsbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class FriendsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FriendsApplication.class.getResource("friends-view.fxml"));

        TableView table = new TableView<Friends>();
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Pavel's Friends Book 0.1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}