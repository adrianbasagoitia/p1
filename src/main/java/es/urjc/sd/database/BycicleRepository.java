package es.urjc.sd.database;
/* ********************************************************************* */

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import es.urjc.sd.p1.Bycicle;

/* ********************************************************************* */
/**
 * Interface to make use of the database with Station objects.
 */
public interface BycicleRepository extends JpaRepository<Bycicle, char[]>{
    /**
     * Query to list all the bycicles in the system.
     * @param serial_number The serial number of a bycicle.
     * @return A list with all the bycicles in the system.
     */
    public List<Bycicle> findAll(char[] serial_number);

    /**
     * Query to find if a bycicle in the system.
     * @param serial_number The serial number of the desired bycicle.
     * @return An optional. It can be empty if the bycicle does not exist, in any other case it wil return the optional with the bycicle inside.
     */
    public Optional<Bycicle> findBySerialNumber(char[] serial_number);

    /**
     * Query to find all the bycicles with the same status in the system.
     * @param status The status desired to search.
     * @return A list with all the bycicles in the system with the status required. It can be empty.
     */
    public List<Bycicle> findByStatus(String status);

    /**
     * Query to save a new item in the database or modify/update an existng one.
     * @param serial_number The serial number of a bycicle.
     */
    public void save(char[] serial_number);

} // End BycicleRepository interface
