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
    private ObservableList<Person> tempOblist = FXCollections.observableArrayList();
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

    public void copyList(){
        for(Person p: oblist){
            tempOblist.add(p);
        }
    }

    public void clearTempOblist(){
        for(Person p: tempOblist){
            tempOblist.remove(p);
        }
    }

    public void refill(){
        for(Person p: tempOblist){
            oblist.add(p);
        }
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

    public void removeAllOblist(){
        this.oblist.removeAll(this.oblist);
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


    /**
     * @return ObservableList<Person> return the oblist
     */
    public ObservableList<Person> getOblist() {
        return oblist;
    }

    /**
     * @param oblist the oblist to set
     */
    public void setOblist(ObservableList<Person> oblist) {
        this.oblist = oblist;
    }

    /**
     * @return ObservableList<Person> return the tempOblist
     */
    public ObservableList<Person> getTempOblist() {
        return tempOblist;
    }

    /**
     * @param tempOblist the tempOblist to set
     */
    public void setTempOblist(ObservableList<Person> tempOblist) {
        this.tempOblist = tempOblist;
    }

    /**
     * @return Person return the dummy1
     */
    public Person getDummy1() {
        return dummy1;
    }

    /**
     * @param dummy1 the dummy1 to set
     */
    public void setDummy1(Person dummy1) {
        this.dummy1 = dummy1;
    }

    /**
     * @return Person return the dummy2
     */
    public Person getDummy2() {
        return dummy2;
    }

    /**
     * @param dummy2 the dummy2 to set
     */
    public void setDummy2(Person dummy2) {
        this.dummy2 = dummy2;
    }

}