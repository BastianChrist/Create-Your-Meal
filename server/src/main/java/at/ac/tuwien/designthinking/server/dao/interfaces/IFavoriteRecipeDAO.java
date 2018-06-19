package at.ac.tuwien.designthinking.server.dao.interfaces;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dto.FavoriteRecipe;
import at.ac.tuwien.designthinking.server.dto.Recipe;

import java.util.List;

public interface IFavoriteRecipeDAO extends IGenericDAO<FavoriteRecipe, Integer> {

    public List<Recipe> findFavoriteRecipesByUserId(Integer userId) throws DaoException;


}
