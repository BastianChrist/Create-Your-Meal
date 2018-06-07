package at.ac.tuwien.designthinking.server.persistence;

import at.ac.tuwien.designthinking.server.dto.User;

import java.util.List;

/**
 * Created by Georg Edlinger on 02.06.18.
 */
public interface UserDAO {

    public List<User> readUserAccounts() throws PersistenceException;
}
