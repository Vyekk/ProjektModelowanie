package ekomp.Controllers;

import ekomp.Helpers.PersonType;
import ekomp.Models.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class AddNewPersonController {
    @FXML
    RadioButton rServiceTechnician, rVendor;
    @FXML
    CheckBox cClient, cBoss, cEmployee;
    @FXML
    TextField tSalary, tId, tFirstName, tLastName;
    @FXML
    DatePicker employmentDate;
    @FXML
    Label comunicate;

    private Stage stage;
    private Scene scene;
    private Parent root;
    List<PersonType> privilages = new ArrayList<>();

    @FXML
    public void showDateSalary() {
        if (cEmployee.isSelected()) {
            rServiceTechnician.setVisible(true);
            rVendor.setVisible(true);
            employmentDate.setVisible(true);
            tSalary.setVisible(true);
        } else {
            rServiceTechnician.setVisible(false);
            rVendor.setVisible(false);
            employmentDate.setVisible(false);
            tSalary.setVisible(false);
        }
    }
    @FXML
    public void showId() {
        if (cBoss.isSelected()) {
            tId.setVisible(true);
        } else {
            tId.setVisible(false);
        }
    }

    @FXML
    public void createNewPerson() throws Exception {
        addPrivilages();
        if(cEmployee.isSelected()) {
            if(!rVendor.isSelected() && !rServiceTechnician.isSelected())
                throw new Exception("Nie wybrano konkretnego pracownika!");
            Person lala = new Person(tFirstName.getText(),tLastName.getText(), employmentDate.getValue(),Float.parseFloat(tSalary.getText()), (ArrayList<PersonType>) privilages);
            System.out.println("Stworzono pracownika");
        } else {
            Person lala = new Person(tFirstName.getText(),tLastName.getText(), (ArrayList<PersonType>) privilages);
            comunicate.setVisible(true);
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

    private void addPrivilages() {
        if (cBoss.isSelected() && cClient.isSelected()) {
            privilages.add(PersonType.BOSS);
            privilages.add(PersonType.CLIENT);
        } else if (cBoss.isSelected()) {
            privilages.add(PersonType.BOSS);
        } else if (cClient.isSelected()) {
            privilages.add(PersonType.CLIENT);
        }
        if(cEmployee.isSelected()) {
            if (rVendor.isSelected()) {
                privilages.add(PersonType.VENDOR);
            } else if (rServiceTechnician.isSelected()) {
                privilages.add(PersonType.SERVICETECHNICIAN);
            }
        }
    }
}
