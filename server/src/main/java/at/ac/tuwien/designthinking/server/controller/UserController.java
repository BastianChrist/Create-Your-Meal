package at.ac.tuwien.designthinking.server.controller;

import at.ac.tuwien.designthinking.server.domain.User;
import at.ac.tuwien.designthinking.server.domain.UserToken;
import at.ac.tuwien.designthinking.server.persistence.PersistenceException;
import at.ac.tuwien.designthinking.server.persistence.UserDAO;
import at.ac.tuwien.designthinking.server.persistence.h2.UserDAOH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Georg Edlinger on 31.05.18.
 */
@RestController
public class UserController {

    private UserDAO userDAO;
    @Autowired
    public UserController (UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @PostMapping("/login")
    public UserToken login(@RequestBody User user)
    {
        return new UserToken(user.getFirstName());
    }


    @GetMapping("/users")
    public List<User> users(){

        try {
            return userDAO.readUserAccounts();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return null;
    }
}
