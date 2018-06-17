package at.ac.tuwien.designthinking.server.service;

import at.ac.tuwien.designthinking.server.dto.Allergen;
import at.ac.tuwien.designthinking.server.dto.Recipe;
import at.ac.tuwien.designthinking.server.dto.User;

import java.util.List;

/**
 * Created by schurli on 17.06.18.
 */
public interface UserService {

    List<User> getUsers() throws ServiceException;

    User getUser(int userId) throws ServiceException;

    List<Allergen>  getUserAllergens(int userId) throws ServiceException;
    List<Allergen>  addUserAllergen(int userId, Allergen allergen) throws ServiceException;

    void  deleteUserAllergen(int userId, int allergenId) throws ServiceException;

    List<Recipe> getUserRecipeHistory(int userId) throws ServiceException;

    List<Recipe> getUserFavoritsRecipes(int userId) throws ServiceException;

    List<Recipe> addUserFavoritsRecipes(int userId) throws ServiceException;

    void deleteUserFavoritsRecipes(int userId) throws ServiceException;

}
