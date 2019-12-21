package ch.schule.AddressApp;

import javafx.beans.property.SimpleStringProperty;


/**
 * Person
 */
public class Person {

    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleStringProperty street;
    private SimpleStringProperty city;
    private SimpleStringProperty postalcode;
    private SimpleStringProperty birthday;


    public Person(String firstname, String lastname, String street, String city, String postalcode, String birthday) {
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.street = new SimpleStringProperty(street);
        this.city = new SimpleStringProperty(city);
        this.postalcode = new SimpleStringProperty(postalcode);
        this.birthday = new SimpleStringProperty(birthday);
    }

    public Person(String firstname, String lastname){
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
    }


    /**
     * @return SimpleStringProperty return the firstname
     */
    public String getFirstname() {
        return firstname.get();
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(SimpleStringProperty firstname) {
        this.firstname = firstname;
    }

    /**
     * @return SimpleStringProperty return the lastname
     */
    public String getLastname() {
        return lastname.get();
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(SimpleStringProperty lastname) {
        this.lastname = lastname;
    }

    /**
     * @return SimpleStringProperty return the street
     */
    public String getStreet() {
        return street.get();
    }

    /**
     * @param street the street to set
     */
    public void setStreet(SimpleStringProperty street) {
        this.street = street;
    }

    /**
     * @return SimpleStringProperty return the city
     */
    public String getCity() {
        return city.get();
    }

    /**
     * @param city the city to set
     */
    public void setCity(SimpleStringProperty city) {
        this.city = city;
    }

    /**
     * @return SimpleStringProperty return the postalcode
     */
    public String getPostalcode() {
        return postalcode.get();
    }

    /**
     * @param postalcode the postalcode to set
     */
    public void setPostalcode(SimpleStringProperty postalcode) {
        this.postalcode = postalcode;
    }

    /**
     * @return SimpleStringProperty return the birthday
     */
    public String getBirthday() {
        return birthday.get();
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(SimpleStringProperty birthday) {
        this.birthday = birthday;
    }

}