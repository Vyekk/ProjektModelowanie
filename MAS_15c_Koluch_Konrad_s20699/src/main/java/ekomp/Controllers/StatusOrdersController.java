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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StatusOrdersController implements Initializable {

    @FXML
    ListView ordersList;
    @FXML
    TextField orderNr;
    @FXML
    Label info, or;
    @FXML
    Button searchOrderBt, selectOrderBt;

    private Person person;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToChangeStatusList(ActionEvent event) throws IOException {
        Order selectedOrder = (Order) this.ordersList.getSelectionModel().getSelectedItem();
        switchToChangeStatus(event, selectedOrder);
    }
    @FXML
    public void switchToChangeStatusField(ActionEvent event) throws IOException, ClassNotFoundException {
        if (Order.searchOrder(Integer.parseInt(orderNr.getText()))) {
            Order selectedOrder = Order.getOrderByNr(Integer.parseInt(orderNr.getText()));
            switchToChangeStatus(event, selectedOrder);
        } else {
            showError("Zły numer zamówienia");
        }
    }

    public void switchToChangeStatus(ActionEvent event, Order selectedOrder) throws IOException {
        if (selectedOrder.isEnded()) {
            showError("Zamówienie zakończone");
        } else {
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
    }

    public void showError(String errorMessage) {
        ordersList.setVisible(false);
        searchOrderBt.setVisible(false);
        selectOrderBt.setVisible(false);
        or.setVisible(false);
        orderNr.setVisible(false);
        info.setText("Nie można zmienić statusu" + System.lineSeparator() + "Powód: " + errorMessage);
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
        try {
            Order.showOrders(ordersList);
        } catch (ClassNotFoundException e) {
            ordersList.getItems().add("Nie znaleziono żadnych zamówień");
        }
    }
}
