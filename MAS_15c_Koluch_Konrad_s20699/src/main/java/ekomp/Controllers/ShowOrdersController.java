package ekomp.Controllers;

import ekomp.Models.Order;
import ekomp.Models.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowOrdersController implements Initializable {
    private Person person;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    ListView<Order> orderList;

    public void setPerson(Person newPerson) {
        person = newPerson;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (person != null) {
            if (!person.getClient().getOrders().isEmpty()) {
                orderList.getItems().addAll(person.getClient().getOrders());
            }
        }
    }

    @FXML
    public void switchToSeeAll(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("seeAll.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
