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
}