package at.ac.tuwien.designthinking.server.dao.interfaces;

import at.ac.tuwien.designthinking.server.dto.UserAccount;
import org.h2.engine.User;

import java.util.List;

public interface IUserDAO extends IGenericDAO<UserAccount, Integer> {

    /**
     *
     *  Returns the user with the matching name.
     *
     * @param username The username of the user.
     * @return The matching User.
     */
    public UserAccount findUserbyUsername (String username);

    /**
     *
     *  Returns the user with the matching Id.
     *
     * @param id The id of the user.
     * @return The matching User.
     */
    public UserAccount findUserById(Integer id);

    /**
     *
     *  Returns all users.
     */
    public List<UserAccount> findAll();
}
