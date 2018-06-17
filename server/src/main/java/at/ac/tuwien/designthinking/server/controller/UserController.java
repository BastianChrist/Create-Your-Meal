package at.ac.tuwien.designthinking.server.controller;

import at.ac.tuwien.designthinking.server.dto.User;
import at.ac.tuwien.designthinking.server.dto.UserToken;
import at.ac.tuwien.designthinking.server.persistence.PersistenceException;
import at.ac.tuwien.designthinking.server.persistence.UserDAO;
import at.ac.tuwien.designthinking.server.service.ServiceException;
import at.ac.tuwien.designthinking.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Georg Edlinger on 31.05.18.
 */
@RestController
public class UserController {

    private UserService userService;
    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public UserToken login(@RequestBody User user)
    {
        return new UserToken(user.getFirstName());
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        try {
            return userService.getUsers();
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO: Exception Mechanismus für UI festlegen
        }
        return null;
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable("userId") int userId){
        try {
            return userService.getUser(userId);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO: Exception Mechanismus für UI festlegen
        }
        return null;
    }




}
