package es.urjc.sd.database;

/* ********************************************************************* */

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import es.urjc.sd.p1.User;

/* ********************************************************************* */
/**
 * Interface to make use of the database with User objects
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Query to search all the users in the database.
     * @param identifier Primary key of the table in the database.
     * @return A list with all the users inside.
     */
    List<User> findAll(int identifier);

    /**
     * Query to find an user by it's Identifier field.
     * @param identifier Primary key of the table in the database.
     * @return An user object.
     */
    User findByIdentifier(int identifier);

    /**
     * Query to add a new user or modify an existing one in the database.
     * This query will be used when we want to "delete" an user, in fact it's only a modification of the field status.
     * @param identifier Primary key of the table in the database.
     */
    void save(int identifier); // Maybe the argument must be an user not an identifier or both.
    // void save(int identifier, User u);

} // End Interface UserRepository
