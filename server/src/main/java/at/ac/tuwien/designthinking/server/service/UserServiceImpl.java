package at.ac.tuwien.designthinking.server.service;

import at.ac.tuwien.designthinking.server.dao.UserDAO;
import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dto.Allergen;
import at.ac.tuwien.designthinking.server.dto.Recipe;
import at.ac.tuwien.designthinking.server.dto.UserAccount;
import at.ac.tuwien.designthinking.server.service.exception.ServiceException;
import at.ac.tuwien.designthinking.server.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by schurli on 17.06.18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl (UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public List<UserAccount> getUsers() throws ServiceException {
           return userDAO.findAll();
    }

    @Override
    public UserAccount getUser(int userId) throws ServiceException {
        try {
            return userDAO.findById(userId);
        } catch (DaoException e) {
           throw new ServiceException(e);
        }
    }

    @Override
    public List<Allergen> getUserAllergens(int userId) throws ServiceException {
        return null; //TODO
    }

    @Override
    public List<Allergen> addUserAllergen(int userId, Allergen allergen) throws ServiceException {
        return null; //TODO
    }

    @Override
    public void deleteUserAllergen(int userId, int allergenId) throws ServiceException {
        //TODO
    }

    @Override
    public List<Recipe> getUserRecipeHistory(int userId) throws ServiceException {
        return null;         //TODO

    }

    @Override
    public List<Recipe> getUserFavoritsRecipes(int userId) throws ServiceException {
        return null; //TODO
    }

    @Override
    public List<Recipe> addUserFavoritsRecipes(int userId) throws ServiceException {
        return null; //TODO
    }

    @Override
    public void deleteUserFavoritsRecipes(int userId) throws ServiceException {
        //TODO
    }
}
