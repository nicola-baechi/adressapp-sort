package ch.schule.AddressApp;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

/**
 * Controller
 */
public class Controller {

    @FXML
    Label firstname, lastname, street, city, postalcode, birthday;
    
    @FXML
    TextField nfirstname, nlastname, nstreet, ncity, npostalcode, nbirthday; // textfields of newPerson.fxml

    AdressModel model = new AdressModel();

    public void handleButtonDelete(ActionEvent event){
        System.out.println("Test");
    }

    public void handleButtonNew(ActionEvent event) throws Exception{
        System.out.println("creating new contact");
        URL url = new File("src/main/resources/fxml/NewPerson.fxml").toURI().toURL();
        Parent newParent = FXMLLoader.load(url);
        Scene newScene = new Scene(newParent);
        Stage newStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        newStage.setScene(newScene);
        newStage.show();
    }

    public void handleButtonAddNew(ActionEvent event){
        System.out.println("new contact added");
        Person person = new Person(nfirstname.getText(), nlastname.getText(), nstreet.getText(), ncity.getText(), npostalcode.getText(), nbirthday.getText());
        model.addPerson(person);
        model.printAllPersons();
    }

        

    public void handleButtonEdit(ActionEvent event){
        //TODO
    }

    @FXML
    private void initialize(){
        
    }
}