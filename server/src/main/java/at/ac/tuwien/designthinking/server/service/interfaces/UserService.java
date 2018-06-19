package at.ac.tuwien.designthinking.server.service.interfaces;

import at.ac.tuwien.designthinking.server.dto.Allergen;
import at.ac.tuwien.designthinking.server.dto.Recipe;
import at.ac.tuwien.designthinking.server.dto.RecipeHistory;
import at.ac.tuwien.designthinking.server.dto.UserAccount;
import at.ac.tuwien.designthinking.server.service.exception.ServiceException;

import java.util.List;

/**
 * Created by schurli on 17.06.18.
 */
public interface UserService {

    List<UserAccount> getUsers() throws ServiceException;

    UserAccount getUser(int userId) throws ServiceException;

    List<Allergen>  getUserAllergens(int userId) throws ServiceException;

    List<Allergen>  addUserAllergen(int userId, Allergen allergen) throws ServiceException;

    void  deleteUserAllergen(int userId, int allergenId) throws ServiceException;

    List<RecipeHistory> getUserRecipeHistory(int userId) throws ServiceException;

    List<Recipe> getUserFavoriteRecipes(int userId) throws ServiceException;

    List<Recipe> addUserFavoriteRecipes(int userId) throws ServiceException;

    void deleteUserFavoriteRecipes(int userId) throws ServiceException;

}
