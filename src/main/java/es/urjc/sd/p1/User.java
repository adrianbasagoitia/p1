package es.urjc.sd.p1;

/* ********************************************************************* */
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* ********************************************************************* */
/**
 * A class to model an user of the system.
 */
@Entity
public class User {
    /* Attributes */
    /** 
     * Unique identifier of an user, automatically generated when a new user is created. Integer, maximum number of numbers are 8, so the maximum number of user will be 99.999.999 millions of user, more than enought to the necesities of the system.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identifier;

    /** 
     * A password to access the system. 
     * Alphanumeric attribute of 8 to 16 characters. 
     * The valid characters to introduce will be numbers and letters of the english alphabet.
     * At least a letter (upper or lowercase) and a number must be introduced.
     */
    private String password;
    
    /** 
     * Attribute to contain the full name of an user. Array of String. Due to disparities of alphabets and naming conventions around the globe, it's difficult to "standarize" a naming convention.  
     * The convention that this attribute will follow it's the traditional spanish naming convention: Name and two surnames.
     * But the surnames may be empty or null.
     * The characters allowed will be the letters of the latin alphabet, so the names in different alphabets like russian, chinese, japanese,... must be "translated" into the latin alphabet.
     */
    private String[] name = new String[3];

    /**
     * Attribute to store when an user was registered in the system.
     * Format: YYYY/MM/DD => Year, Month, Day.
     * Will be asignated automatically when the user is registered.
     * It will store the actual date IN THE SERVER.
     */
    private LocalDate register_Date;

    /**
     * Attribute to indicate if an user is active in the system. It will function as a "soft" delete in the system.
     * true: Active User.
     * false: Inactive user a.k.a user "deleted"
     * Set to Active automatically on creation.
     */
    private Boolean status;
    
    /* ********************************************************************* */
    /* Builders */
    /**
     * Necessary builder to load from Database.
     */
    public User(){

    }

    /**
     * Default builder for an object user.
     * @param pass Password of the user.
     * @param n Complete name of the user.
     */
    public User(String pass, String[] n){
        this.password = pass;
        this.name = n;
        this.register_Date = LocalDate.now();
        this.status = true;
    } // End Builder

    /* ********************************************************************* */
    /* Get & Set */
    /**
     * Getter for Identifier attribute.
     * @return the identifier of an user.
     */
    public int getIdentifier(){
        return this.identifier;
    }

    /* No setter for identifier attribute. Not possible to edit. */



    /**
     * Getter for the password attribute.
     * @return the password of an user.
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * Setter for the password attribute.
     * @param pass new password for the user.
     */
    public void setPassword(String pass){
        this.password = pass;
    }



    /**
     * Getter for the name attribute.
     * @return the name of an user.
     */
    public String[] getName(){
        return this.name;
    }

    /**
     * Setter for name attribute.
     * @param n the new name of the user.
     */
    public void setName(String[] n){
        this.name = n;
    }



    /**
     * Getter for register date attribute.
     * @return the date when an user register in the system.
     */
    public LocalDate getRegister_Date(){
        return this.register_Date;
    }

    /* No setter for register date attribute. Not possible to edit. */



    /**
     * Getter for status attribute.
     * @return the status of the user in the system.
     */
    public Boolean getStatus(){
        return this.status;
    }

    /**
     * Setter for status attribute.
     * @param s the new status of the user.
     */
    public void setStatus(boolean s){
        this.status = s;
    }

    /* ********************************************************************* */
    /* Methods / Functionalities */
    /**
     * Either its necessary or an stupidity.
     * Check 3 optionals containing the attributes that can be changed in an user.
     * 
     * @param p The password.
     * @param n The name.
     * @param s The status.
     */
    public void edit_delete(Optional<String>p, Optional<String[]>n, Optional<Boolean>s){
        if(p.isPresent()){
            this.setPassword(p.get());
        }
        if(n.isPresent()){
            this.setName(n.get());
        }
        if(s.isPresent()){
            this.setStatus(s.get());
        }        
    } // End edit_delete

} // End Class User
