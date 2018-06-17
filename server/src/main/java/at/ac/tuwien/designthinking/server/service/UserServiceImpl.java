package at.ac.tuwien.designthinking.server.service;

import at.ac.tuwien.designthinking.server.dto.User;
import at.ac.tuwien.designthinking.server.persistence.PersistenceException;
import at.ac.tuwien.designthinking.server.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by schurli on 17.06.18.
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    @Autowired
    public UserServiceImpl (UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getUsers() throws ServiceException {
        try {
           return userDAO.readUserAccounts();
        } catch (PersistenceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public User getUser(int userId) throws ServiceException {
        return null; //TODO
    }
}
