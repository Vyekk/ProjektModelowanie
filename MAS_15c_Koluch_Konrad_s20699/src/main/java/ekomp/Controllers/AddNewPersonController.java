package ekomp.Controllers;

import ekomp.Helpers.PersonType;
import ekomp.Models.Adress;
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
    TextField tSalary, tId, tFirstName, tLastName, tCity, tHouseNr, tFlatNr, tZipCode,tStreet;
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
    public void showAdress() {
        if (cClient.isSelected()) {
            tCity.setVisible(true);
            tHouseNr.setVisible(true);
            tFlatNr.setVisible(true);
            tZipCode.setVisible(true);
            tStreet.setVisible(true);
        } else {
            tCity.setVisible(false);
            tHouseNr.setVisible(false);
            tFlatNr.setVisible(false);
            tZipCode.setVisible(false);
            tStreet.setVisible(false);
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
        Person newPerson;
        addPrivilages();
        if(cEmployee.isSelected()) {
            if(!rVendor.isSelected() && !rServiceTechnician.isSelected())
                throw new Exception("Nie wybrano konkretnego pracownika!");
            newPerson = new Person(tFirstName.getText(),tLastName.getText(), employmentDate.getValue(),Float.parseFloat(tSalary.getText()), (ArrayList<PersonType>) privilages);
        } else {
            newPerson = new Person(tFirstName.getText(),tLastName.getText(), (ArrayList<PersonType>) privilages);
        }
        if (cClient.isSelected()) {
            if (tFlatNr.getText() == "") {
                Adress newAdress = new Adress(tStreet.getText(), Integer.parseInt(tHouseNr.getText()), tCity.getText(), tZipCode.getText());
                newPerson.getClient().setAdress(newAdress);
            } else {
                Adress newAdress = new Adress(tStreet.getText(), Integer.parseInt(tHouseNr.getText()), Integer.parseInt(tFlatNr.getText()), tCity.getText(), tZipCode.getText());
                newPerson.getClient().setAdress(newAdress);
            }
        }
        comunicate.setVisible(true);
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
