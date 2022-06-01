package es.urjc.sd.database;

/* ********************************************************************* */

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.sd.p1.Station;

/* ********************************************************************* */
/**
 * Interface to make use of the database with Station objects.
 */
public interface StationRepository extends JpaRepository<Station, Integer>{
    /**
     * Query to list all the stations in the system.
     * @param identifier Identifier of the staton.
     * @return A list with all the stations in the system.
     */
    List<Station> findAll(int identifier);

    /**
     * Query to search an station by it's identifier.
     * @param identifier Identifier of the desired station.
     * @return An optional. If the station is present, the optional will have the station inside. If not present the optional will be empty.
     */
    Optional<Station> findByIdentifier(int identifier);
    
    /**
     * Query to search an station by it's serial number.
     * @param serial_number Serial number of the desired station.
     * @return An optional. If the station is present, the optional will have the station inside. If not present the optional will be empty.
     */

    Optional<Station> findBySerialNumber(int serial_number);

    /**
     * Query to save a new station in the database, or edit an existiing one.
     * @param identifier Identifier of the station.
     */
    void save(int identifier);

    
    /* QUERY TO FIND ALL THE BYCICLES STORED IN THE STATION */
    /* 
       List<Bycicle> findByStationBycicle(Bycicle station) 
    */
} // End Interface Station Repository
