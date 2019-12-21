package ch.schule.AddressApp;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Controller
 */
public class Controller {

    @FXML
    Label firstname, lastname, street, city, postalcode, birthday;

    @FXML
    TextField nfirstname, nlastname, nstreet, ncity, npostalcode, nbirthday; // textfields of newPerson.fxml

    // configuring the table
    @FXML 
    private TableView<Person> table;
    @FXML 
    private TableColumn<Person, String> fnameColumn;
    @FXML 
    private TableColumn<Person, String> lnameColumn;


    AdressModel model = new AdressModel();

    public void handleButtonDelete(ActionEvent event) {
        System.out.println("Test");
    }

    public void handleButtonNew(ActionEvent event) throws Exception {
        System.out.println("creating new contact");
        URL url = new File("src/main/resources/fxml/NewPerson.fxml").toURI().toURL();
        Parent newParent = FXMLLoader.load(url);
        Scene newScene = new Scene(newParent);
        Stage newStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        newStage.setScene(newScene);
        newStage.show();
    }

    public void handleButtonAddNew(ActionEvent event) throws IOException {
        System.out.println("new contact added");
        Person person = new Person(nfirstname.getText(), nlastname.getText(), nstreet.getText(), ncity.getText(), npostalcode.getText(), nbirthday.getText());
        model.addPerson(person);
        model.printAllPersons();
        model.setAreContacts(true);
        URL url = new File("src/main/resources/fxml/PersonOverview.fxml").toURI().toURL();
        Parent overviewParent = FXMLLoader.load(url);
        Scene personOverview = new Scene(overviewParent);
        Stage stageOverview = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageOverview.setScene(personOverview);
        stageOverview.show();
        System.out.println(model.getAreContacts());
    }

        

    public void handleButtonEdit(ActionEvent event){
        
    }

    public ObservableList<Person> getListofPersons(){
        ObservableList<Person> oblist = FXCollections.observableArrayList();
        oblist.add(new Person("a","b","c","d","e", "f"));
        oblist.add(new Person("a","b","c","d","e", "f"));
            //for(Person p: oblist){
            //oblist.add(new Person(p.getFirstname(), p.getLastname()));
            //System.out.println(p.getFirstname() + " " + p.getLastname());
        //}  
        return oblist;
    }

    @FXML
    private void initialize(){
        // setting up columns in the table
        //if(model.getAreContacts()){ 
        fnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstname"));
        lnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastname"));
        table.getItems().addAll(getListofPersons());
        //}
    }
}