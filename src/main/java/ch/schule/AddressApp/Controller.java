package ch.schule.AddressApp;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
/**
 * Controller
 */
public class Controller {

    AdressModel model = new AdressModel();

    @FXML
    private Label label;
    @FXML
    private TextField firstname, lastname, street, city, postalcode, birthday, filterField;
    // configuring the table
    @FXML 
    private TableView<Person> table = new TableView<>();
    @FXML 
    private TableColumn<Person, String> fnameColumn = new TableColumn<>();
    @FXML 
    private TableColumn<Person, String> lnameColumn = new TableColumn<>();
    @FXML
    private Button ok, okNew, cancel, sortLname, sortFname;

    public void handleButtonDelete(Event event){
        Person p = table.getSelectionModel().getSelectedItem();
        model.deletePerson(p);
        model.removeObList(p);
        table.setItems(model.getObList());
        clearFields();
    }

    public void handleButtonNew(Event event){
        clearFields();
        okNew.setVisible(true);
        cancel.setVisible(true);
        if(firstname.isEditable() == false){
            changeEditable();
        }
    }

    public void handleButtonOkNew(Event event){
        if(firstname.getText().isEmpty() || lastname.getText().isEmpty() 
        || street.getText().isEmpty() || city.getText().isEmpty() 
        || postalcode.getText().isEmpty() || birthday.getText().isEmpty()){
            label.setText("Füllen Sie bitte alle Felder aus um den Vorgang abzuschliessen");
        }
        else{
            Person p = new Person(firstname.getText(), lastname.getText(), 
            street.getText(), city.getText(), postalcode.getText(), birthday.getText());
            model.addObList(p);
            model.addPerson(p);
            clearFields();
            label.setText("");
            model.clearTempOblist();
            model.copyList();
            model.removeAllOblist();
            model.refill();
            table.setItems(model.getObList());
            okNew.setVisible(false);
            cancel.setVisible(false);
        }
    }
    
    public void handleButtonSortFirstname(Event event){
        table.getSortOrder().add(fnameColumn);
    }

    public void handleButtonSortLastname(Event event){
        table.getSortOrder().add(lnameColumn);
    }

    public void onEnter(Event e){
        FilteredList<Person> filteredData = new FilteredList<>(model.getObList(), p -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (person.getFirstname().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (person.getLastname().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.

            });
        });
        
        SortedList<Person> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    @FXML
    public void fillPersonData(MouseEvent event){
        Person p = table.getSelectionModel().getSelectedItem();
        model.setTemp(p);
        changeEditable();
        firstname.setText(p.getFirstname());
        lastname.setText(p.getLastname());
        street.setText(p.getStreet());
        city.setText(p.getCity());
        postalcode.setText(p.getPostalcode());
        birthday.setText(p.getBirthday());
    }

    public void handleButtonEdit(Event event){
        if(table.getSelectionModel().isEmpty()){
            label.setText("Sie müssen eine Person aus der Tabelle auswählen um sie zu bearbeiten");
        }
        Person p = table.getSelectionModel().getSelectedItem();
        model.setTemp(p);
        changeEditable();
        firstname.setText(p.getFirstname());
        lastname.setText(p.getLastname());
        street.setText(p.getStreet());
        city.setText(p.getCity());
        postalcode.setText(p.getPostalcode());
        birthday.setText(p.getBirthday());
        ok.setVisible(true);
        cancel.setVisible(true);
    }

    public void handleButtonOk(Event event){
        model.deletePerson(model.getTemp());
        model.removeObList(model.getTemp());
        Person p = new Person(firstname.getText(), lastname.getText(), 
        street.getText(), city.getText(), postalcode.getText(), birthday.getText());
        model.addObList(p);
        model.addPerson(p);
        clearFields();
        ok.setVisible(false);
        cancel.setVisible(false);

    }

    public void handleButtonCancel(Event event){
        clearFields();
        cancel.setVisible(false);
        if(ok.isVisible()){
            ok.setVisible(false);
        }
        if(okNew.isVisible()){
            okNew.setVisible(false);
        }
    }

    public void clearFields(){
        firstname.setText("");
        lastname.setText("");
        street.setText("");
        city.setText("");
        postalcode.setText("");
        birthday.setText("");
    }

    public void changeEditable(){
        if(firstname.isEditable() ==  true){
            firstname.setEditable(false);
            lastname.setEditable(false);
            street.setEditable(false);
            city.setEditable(false);
            postalcode.setEditable(false);
            birthday.setEditable(false);
        }
        else{
            firstname.setEditable(true);
            lastname.setEditable(true);
            street.setEditable(true);
            city.setEditable(true);
            postalcode.setEditable(true);
            birthday.setEditable(true);
        }
    }

    @FXML
    private void initialize(){
        changeEditable();
        ok.setVisible(false);
        okNew.setVisible(false);
        cancel.setVisible(false);
        fnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstname")); 
        lnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastname"));
        table.setItems(model.getObList());
    }
}