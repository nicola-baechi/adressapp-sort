package ch.schule.AddressApp;

import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 * AdressModel
 */
public class AdressModel {

    private ArrayList<Person> plist;
    private boolean areContacts;

    public AdressModel(){
        plist = new ArrayList<>();
        areContacts = false;
    }

    public ArrayList<Person> getPlist() {
        return plist;
    }

    public void setPlist(ArrayList<Person> plist) {
        this.plist = plist;
    }

    public boolean getAreContacts() {
        return areContacts;
    }

    public void setAreContacts(boolean areContacts) {
        this.areContacts = areContacts;
    }

    public void addPerson(Person p){
        plist.add(p);
    }
    public void deletePerson(Person p){
        plist.remove(p);
    }
    public ArrayList<Person> getArrayPerson(){
        return plist;
    }

    public void printAllPersons(){
        int counter = 1;
        for(Person p: plist){
            System.out.println(counter + " > " + "Vorname: " + p.getFirstname() + " | " + "Nachname: " + p.getLastname());
            System.out.println("Strasse: " + p.getStreet());
            System.out.println("Stadt: " + p.getCity());
            System.out.println("Postleitzahl: " + p.getPostalcode());
            System.out.println("Geburtstag: " + p.getBirthday());
            System.out.println();
            counter++;
        }
    }

    

}