package at.ac.tuwien.designthinking.server.service;

import at.ac.tuwien.designthinking.server.dto.User;

import java.util.List;

/**
 * Created by schurli on 17.06.18.
 */
public interface UserService {

    List<User> getUsers() throws ServiceException;

    User getUser(int userId) throws ServiceException;
}
