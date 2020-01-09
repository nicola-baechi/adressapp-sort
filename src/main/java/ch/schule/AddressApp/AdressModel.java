package ch.schule.AddressApp;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 * AdressModel
 */
public class AdressModel {

    private ArrayList<Person> plist;
    private ObservableList<Person> oblist = FXCollections.observableArrayList();
    private Person temp;

    private Person dummy1 = new Person("Nicola", "Baechi", "Harossenstrasse 21", "Brütten", "8311", "03.10.02");;
    private Person dummy2 = new Person("Oliver", "Thoma", "Harossenstrasse 21", "Brütten", "8311", "03.10.02");;

    public AdressModel(){
        plist = new ArrayList<>();
        // loading in a dummy person to check 
        this.oblist.add(dummy1);
        this.oblist.add(dummy2);
    }
    // ArrayList
    public void addPerson(Person p){
        plist.add(p);
    }

    public ArrayList<Person> getArrayPerson(){
        return plist;
    }

    // Observable List
    public ObservableList<Person> getObList(){  
        return oblist;
    }

    public void printObList(){
        for(Person p: oblist){
            System.out.println(p.getFirstname() + " " + p.getLastname());
        }
    }

    public void addObList(Person p){
        this.oblist.add(p);
    }

    public void removeObList(Person p){
        this.oblist.remove(p);
    }
    public void deletePerson(Person p){
        plist.remove(p);
    }


    /**
     * @return ArrayList<Person> return the plist
     */
    public ArrayList<Person> getPlist() {
        return plist;
    }

    /**
     * @param plist the plist to set
     */
    public void setPlist(ArrayList<Person> plist) {
        this.plist = plist;
    }

    /**
     * @return Person return the temp
     */
    public Person getTemp() {
        return temp;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(Person temp) {
        this.temp = temp;
    }

}