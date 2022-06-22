package ekomp.Controllers;

import ekomp.Helpers.ObjectPlus;
import ekomp.Helpers.PersonType;
import ekomp.Models.Person;
import ekomp.Models.Vendor;
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

public class SeeAllController implements Initializable {

    @FXML
    ListView<Person> clientList, bossList, employeeList;

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
    public void switchToShowOrders(ActionEvent event) throws IOException {
        Person selectedPerson = (Person) this.clientList.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("showOrders.fxml"));
        showOrdersController controller = new showOrdersController();
        controller.setPerson(selectedPerson);
        loader.setController(controller);
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addToList(clientList,PersonType.CLIENT);
        addToList(bossList,PersonType.BOSS);
        addToList(employeeList,PersonType.VENDOR);
    }

    public void addToList(ListView personList, PersonType type) {
        try {
            Iterable<Person> extent = ObjectPlus.getExtent(Person.class);
            for(var person : extent) {
                if (type.equals(PersonType.CLIENT)) {
                    if (person.getClient() != null)
                        personList.getItems().add(person);
                } else if (type.equals(PersonType.BOSS)) {
                    if (person.getBoss() != null)
                        personList.getItems().add(person);
                } else {
                    if (person.getEmployee() != null)
                        personList.getItems().add(person);
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Nie znaleziono nikogo!");
        }
    }
}
