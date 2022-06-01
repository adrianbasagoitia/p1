package es.urjc.sd.p1;
/* ********************************************************************* */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

/* ********************************************************************* */
/**
 * Class to model a log object to store all the transactions in the life cycle of a byicle.
 */
@Entity
public class Log {
    /**
     * A list to store all the transactions of a bycicle.
     */
    @Id
    private ArrayList<Transaction> list;

    /* ********************************************************************* */
    /* Builders */
    /**
     * Necessary builder to load from Database.
     */
    public Log(){
        
    }

    public Log(LocalDate date, String status){
        this.list = new ArrayList<Transaction>();
        Transaction aux = new Transaction(date, status);
        this.getList().add(aux);
        aux = null;
    }

    /* ********************************************************************* */
    /* Get & Set */
    /**
     * Getter for list attribute.
     * @return The list with all the transactions of a bycicle.
     */
    public List<Transaction> getList(){
        return this.list;
    }

    // No setter needer for list attribute, cannot be changed.

    /* ********************************************************************* */
    /* Methods */
}// End class Log;
