package es.urjc.sd.database;
/* ********************************************************************* */

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
//import java.util.Arrays;

/* ********************************************************************* */
/**
 * 5 Usuarios
 * 2 Estaciones => 1 con capacidad 5.
 */

/**
 * Class to populate the database on start / restart.
 */
@Component
@Profile("local")
public class DatabasePopulator {
    @PostConstruct
    public void populateDB(){

    }
    
} // End Class DatabasePopulator
