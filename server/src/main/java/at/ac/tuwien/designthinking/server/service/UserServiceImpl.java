package at.ac.tuwien.designthinking.server.service;

import at.ac.tuwien.designthinking.server.dao.*;
import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dto.*;
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
    private RecipeHistoryDAO recipeHistoryDAO;

    @Autowired
    private FavoriteRecipeDAO favoriteRecipeDAO;

    @Autowired
    private UserAllergyDAO userAllergyDAO;

    @Autowired
    private UserScaleAssignmentDAO userScaleAssignmentDAO;

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
        try {
            return userAllergyDAO.getUserAllergies(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
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
    public List<RecipeHistory> getUserRecipeHistory(int userId) throws ServiceException {
        try {
            return recipeHistoryDAO.getHistoryByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public List<Recipe> getUserFavoriteRecipes(int userId) throws ServiceException {
        try {
            return favoriteRecipeDAO.findFavoriteRecipesByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Recipe> addUserFavoriteRecipes(int userId) throws ServiceException {
        return null; //TODO
    }

    @Override
    public void deleteUserFavoriteRecipes(int userId) throws ServiceException {
        //TODO
    }

    @Override
    public UserScaleAssignment getUserScaleAssignment(int userId) throws ServiceException{
        try {
            return userScaleAssignmentDAO.getUserScaleAssignmentByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
