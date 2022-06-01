package es.urjc.sd.p1;

/* ********************************************************************* */

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* ********************************************************************* */
/**
 * A class to model an object Bycicle.
 */
@Entity
public class Bycicle {
    /**
     * Botched job, i know, but it is the only way i know to do it.<p>
     * Unique identifier of a bycicle.<p>
     * Autogenerated on creation.<p>
     * Maximum length of 16 characters.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private char[] serial_number = new char[16];

    /**
     * Model of the bycicle.<p>
     * Examples: Shimano A4, Schwinn Mountain-21.
     */
    private String model;

    /**
     * Attribute to store when a bycicle was registered in the system.<p>
     * Format: YYYY/MM/DD => Year, Month, Day.<p>
     * Will be asignated automatically when the bycicle is registered.<p>
     * It will store the actual date IN THE SERVER.
     */
    private LocalDate register_Date;

    /**
     * Status of a bycicle within the system.<p>
     * It's an String but will function as a "boolean of four posibilities":<p>
     * - No-Base: true.<p>
     * - In-Base: "IB-" plus the Identifier of the base where the bycicle is stored. Example: IB-458156.<p>
     * - Reserved: "R-" plus the Identifier of the user who reserved the bycicle. Example: R-7122586346.<p>
     * - Discharged: false.<p>
     * 
     * In this way with only checking the first char of the string, we can now in which state it's the bycicle in the moment.
     */
    private String status;

    private Log log;

    /* ********************************************************************* */
    /* Builders */
    /**
     * Necessary builder to load from Database.
     */

    public Bycicle(){

    }

    /**
     * Default builder for a Bycicle object
     * @param m Model of the bycicle.
     */
    public Bycicle(String m){
        this.model = m;
        this.register_Date = LocalDate.now();
        this.status = "true";
        this.log = new Log(this.getRegisterDate(), "true");
    }

    /* ********************************************************************* */
    /* Get & Set */
    /**
     * Getter for serial number attribute.
     * @return The serial number of a bycicle.
     */
    public char[] getSerialNumber(){
        return this.serial_number;
    }

    // No setter for serial number attribute, can not be changed.


    /**
     * Getter for model attribute.
     * @return The bodel of the bycicle.
     */
    public String getModel(){
        return this.model;
    }

    /**
     * Setter for the model attribute.
     * @param m
     */
    public void setModel(String m){
        this.model = m;
    }


    /**
     * Getter for the register date attribute.
     * @return The date when a bycicle was registered in the system.
     */
    public LocalDate getRegisterDate(){
        return this.register_Date;
    }

    // No setter for register_date attribute, can not be changed.


    /**
     * Getter for status attribute.
     * @return the status of a bycicle within the system.
     */
    public String getStatus(){
        return this.status;
    }
    
    /**
     * Setter for the status attribute.
     * @param s New status for the bycicle.
     */
    public void setStatus(String s){
        this.status = s;
    }


    /**
     * Getter for the log attribute.
     * @return The log with the transisitons of a bycicle.
     */
    public Log getLog(){
        return this.log;
    }

    // No setter for Log attribute, can not be changed.

    /* ********************************************************************* */
    /* Methods */

    
} // End class Bycicle.