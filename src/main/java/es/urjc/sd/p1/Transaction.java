package es.urjc.sd.p1;

/* ********************************************************************* */

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* ********************************************************************* */
/**
 * A class to model a transaction in the life cycle of a bycicle.
 */
public class Transaction {
    /**
     * Attribute to index the transaction in the life cycle of a bycicle.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int index;
    
    /**
     * Date when the transaction happened.
     */
    private LocalDate date;

    /**
     * The NEW status of the bycicle.
     */
    private String status; 

    /* ********************************************************************* */
    /* Builders */
    /**
     * Necessary builder to load from Database.
     */
    public Transaction(){
        
    }

    /**
     * Default builder for a transaction object.
     * @param d The date when the transaction happened
     * @param s The new status of the bycicle.
     */
    public Transaction(LocalDate d, String s){
        this.date = d;
        this.status = s;
    }

    /* ********************************************************************* */
    /**
     * Getter for date attribute.
     * @return the date when the transaction happened.
     */
    public LocalDate getDate(){
        return this.date;
    }

    // No setter needed for date attribute, can not be changed.


    /**
     * Getter for status attribute.
     * @return the new status of the bycicle.
     */
    public String getStatus(){
        return this.status;
    }

    /* ********************************************************************* */
    /* Methods */

} // End class Transaction
