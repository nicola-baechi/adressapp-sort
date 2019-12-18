package ch.schule.AddressApp;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


/**
 * Controller
 */
public class Controller {

    @FXML
    Label firstname, lastname, street, city, postalcode, birthday;

    public void handleButtonDelete(Event event){
        System.out.println("Test");
    }

    public void handleButtonNew(Event event){
        //TODO
    }

    public void handleButtonEdit(Event event){
        //TODO
    }
}