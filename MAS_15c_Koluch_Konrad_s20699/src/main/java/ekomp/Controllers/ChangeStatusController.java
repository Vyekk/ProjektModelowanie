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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChangeStatusController implements Initializable {
    @FXML
    ListView orderList;
    @FXML
    ChoiceBox statusChoice;
    @FXML
    Label info;
    @FXML
    Button choiceButton, testButton, acceptButton, tryAgainButton;
    @FXML
    PasswordField passwordField;


    Status status;

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
        status = (Status) statusChoice.getValue();
        passwordField.setVisible(true);
        acceptButton.setVisible(true);
        choiceButton.setVisible(false);
        orderList.setVisible(false);
        statusChoice.setVisible(false);
        testButton.setVisible(false);
        info.setText("Potwiedź zmianę statusu poprzez wpisanie hasła");
    }
    @FXML
    public void switchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void acceptPassword() {
        passwordField.setVisible(false);
        acceptButton.setVisible(false);
        if (passwordField.getText().equals("admin")) {
            order.setStatus(status);
            orderList.setVisible(true);
            orderList.refresh();
            info.setText("Wprowadzono zmiany");
        } else {
            info.setText("Nie można zmienić statusu" + System.lineSeparator() + "Powód: Błędne hasło");
            tryAgainButton.setVisible(true);
        }
    }

    @FXML
    public void tryAgain() {
        tryAgainButton.setVisible(false);
        passwordField.setVisible(true);
        acceptButton.setVisible(true);
        info.setText("Potwiedź zmianę statusu poprzez wpisanie hasła");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(order.isEnded()) {
            choiceButton.setVisible(false);
            orderList.setVisible(false);
            statusChoice.setVisible(false);
            testButton.setVisible(false);
            info.setText("Nie można zmienić statusu" + System.lineSeparator() + "Powód: Zamówienie zostało zakończone");
        } else {
            orderList.getItems().add(order);
            statusChoice.getItems().addAll(Status.values());
        }
    }
}
