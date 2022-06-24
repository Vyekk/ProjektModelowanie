package ekomp.Controllers;

import ekomp.Helpers.ObjectPlus;
import ekomp.Helpers.PersonType;
import ekomp.Helpers.Status;
import ekomp.Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddNewOrderController implements Initializable {

    @FXML
    ListView clientList, vendorList, computerList;
    @FXML
    CheckBox cVendor, cShippingCost;
    @FXML
    RadioButton rToHome, rToParcelLocker;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void addNewOrder() {
        Order newOrder;
        float fullCost;
        Computer computer = (Computer) computerList.getSelectionModel().getSelectedItem();
        Person clientPerson = (Person) clientList.getSelectionModel().getSelectedItem();
        Client client = clientPerson.getClient();
        int size;
        if (ObjectPlus.allExtents.get(Order.class) == null) {
            size = 0;
        } else {
            size = ObjectPlus.allExtents.get(Order.class).size();
        }
        Vendor vendor;
        if (!cShippingCost.isSelected()) {
            fullCost = computer.getServiceCost() + computer.getComputerCost();
            newOrder = new Order(size+1, Status.ROZPOCZETE, LocalDate.now(),fullCost,client,computer);
            if (cVendor.isSelected()) {
                vendor = (Vendor) vendorList.getSelectionModel().getSelectedItem();
                newOrder.setVendor(vendor);
            }
        } else {
            fullCost = computer.getServiceCost() + computer.getComputerCost();
            float shippingCost = 0;
            if (rToParcelLocker.isSelected()) {
                shippingCost += 10;
            } else {
                shippingCost += 20;
            }
            newOrder = new Order(size+1, Status.ROZPOCZETE, LocalDate.now(),shippingCost,fullCost,client,computer);
            if (cVendor.isSelected()) {
                vendor = (Vendor) vendorList.getSelectionModel().getSelectedItem();
                newOrder.setVendor(vendor);
            }
        }
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
    public void showVendors() {
        if (cVendor.isSelected()) {
            vendorList.setVisible(true);
        } else {
            vendorList.setVisible(false);
        }
    }
    @FXML
    public void showShippingOptions() {
        if (cShippingCost.isSelected()) {
            rToHome.setVisible(true);
            rToParcelLocker.setVisible(true);
        } else {
            rToParcelLocker.setVisible(false);
            rToHome.setVisible(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addToList(clientList,PersonType.CLIENT);
        addToList(vendorList,PersonType.VENDOR);
        try {
            Computer.showOfferts(computerList);
        } catch (ClassNotFoundException e) {
            computerList.getItems().add("Nie znaleziono komputerów!");
        }
    }

    public void addToList(ListView personList, PersonType type) {
        try {
            Iterable<Person> extent = ObjectPlus.getExtent(Person.class);
            for(var person : extent) {
                if (type.equals(PersonType.CLIENT)) {
                    if (person.getClient() != null)
                        personList.getItems().add(person);
                } else if (type.equals(PersonType.VENDOR)) {
                    if (person.getEmployee() != null) {
                        if (person.getEmployee().getClass() == Vendor.class)
                            personList.getItems().add(person);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            personList.getItems().add("Nie znaleziono nikogo!");
        }
    }
}
