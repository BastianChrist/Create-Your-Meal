package at.ac.tuwien.designthinking.server.dao.interfaces;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dto.Context;
import at.ac.tuwien.designthinking.server.dto.Ingredient;
import at.ac.tuwien.designthinking.server.dto.Recipe;

import java.util.List;

public interface IRecipeDAO extends IGenericDAO<Recipe,Integer>{

    /**
     *
     *  Returns the recipe with the matching id.
     *
     * @param id The id of the recipe.
     * @return The matching ingredient.
     */
    public Recipe getById (Integer id) throws DaoException;

    /**
     *
     *  Returns all recipes.
     */
    public List<Recipe> getAll() throws DaoException;

    //public List<Recipe> getByCategory() throws DaoException;

    public List<Recipe> getByContext(Context context) throws DaoException;

    public List<Recipe> getRecipesByIngredient (Ingredient ingredient) throws DaoException;

    public List<Recipe> getRecipesByIngredientlist(List<Ingredient> ingredients) throws DaoException;
}
