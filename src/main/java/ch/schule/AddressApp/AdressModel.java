package ch.schule.AddressApp;

import java.util.ArrayList;

/**
 * AdressModel
 */
public class AdressModel {

    private ArrayList<Person> plist;

    public AdressModel(){
        plist = new ArrayList<>();
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
            System.out.println(counter + "> " + "Vorname: " + p.getFirstname() + " | " + "Nachname: " + p.getLastname());
            System.out.println("Strasse: " + p.getStreet());
            System.out.println("Stadt: " + p.getCity());
            System.out.println("Postleitzahl: " + p.getPostalcode());
            System.out.println("Geburtstag: " + p.getBirthday());
            System.out.println();
            counter++;
        }
    }
}