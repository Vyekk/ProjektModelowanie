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

public class ShowAllOrdersController implements Initializable {
    @FXML
    ListView allOrdersList;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToChangeStatus(ActionEvent event) throws IOException {
        Order selectedOrder = (Order) this.allOrdersList.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("changeStatus.fxml"));
        ChangeStatusController controller = new ChangeStatusController();
        controller.setOrder(selectedOrder);
        loader.setController(controller);
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Order.showOrders(allOrdersList);
        } catch (ClassNotFoundException e) {
            allOrdersList.getItems().add("Nie znaleziono żadnych zamówień");
        }
    }
}