package ch.schule.AddressApp;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;

/**
 * Controller
 */
public class Controller {

    AdressModel model = new AdressModel();

    

    @FXML
    TextField firstname, lastname, street, city, postalcode, birthday;
    // configuring the table
    @FXML 
    private TableView<Person> table = new TableView<>();
    @FXML 
    private TableColumn<Person, String> fnameColumn = new TableColumn<>();
    @FXML 
    private TableColumn<Person, String> lnameColumn = new TableColumn<>();
    @FXML
    private Button ok;

    public void handleButtonDelete(Event event){
        System.out.println("Test");
    }

    public void handleButtonNew(Event event){
        //TODO
    }

    public void handleButtonEdit(Event event){
        Person p = table.getSelectionModel().getSelectedItem();
        model.setTemp(p);
        System.out.println(p.getLastname());
        firstname.setText(p.getFirstname());
        lastname.setText(p.getLastname());
        street.setText(p.getStreet());
        city.setText(p.getCity());
        postalcode.setText(p.getPostalcode());
        birthday.setText(p.getBirthday());
        ok.setVisible(true);

    }

    public void handleButtonOk(Event event){
        model.deletePerson(model.getTemp());
        model.removeObList(model.getTemp());
        Person p = new Person(firstname.getText(), lastname.getText(), 
        street.getText(), city.getText(), postalcode.getText(), birthday.getText());
        model.addObList(p);
        model.addPerson(p);
        firstname.setText("");
        lastname.setText("");
        street.setText("");
        city.setText("");
        postalcode.setText("");
        birthday.setText("");
        ok.setVisible(false);

    }

    @FXML
    private void initialize(){ 
        ok.setVisible(false);
        fnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstname")); 
        lnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastname"));
        table.setItems(model.getObList());
    }
}