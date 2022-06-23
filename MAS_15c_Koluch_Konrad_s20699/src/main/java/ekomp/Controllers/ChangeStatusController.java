package ekomp.Controllers;

import ekomp.Helpers.Status;
import ekomp.Models.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChangeStatusController implements Initializable {
    @FXML
    ListView orderList;
    @FXML
    ChoiceBox statusChoice;

    private Order order;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setOrder(Order order) {
        this.order = order;
    }
    @FXML
    public void switchToComputerTest() {

    }
    @FXML
    public void switchToEnterPassword() {

    }
    @FXML
    public void switchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderList.getItems().add(order);
        statusChoice.getItems().addAll(Status.values());
    }
}
