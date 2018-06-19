package at.ac.tuwien.designthinking.server.dao.interfaces;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dto.Ingredient;
import at.ac.tuwien.designthinking.server.dto.IngredientCategory;

import java.util.List;

public interface IIngredientDAO extends IGenericDAO<Ingredient, Integer>{


    /**
     *
     *  Returns the ingredients with the matching name.
     *
     * @param name The name of the ingredient.
     * @return The matching ingredient.
     */
    public Ingredient findIngredientByName (String name) throws DaoException;

    /**
     *
     *  Returns the ingredient with the matching Id.
     *
     * @param id The id of the ingredient.
     * @return The matching ingredient.
     */
    public Ingredient findIngredientById(Integer id) throws DaoException;


    /**
     *
     *  Returns all ingredients.
     */
    public List<Ingredient> findAll() throws DaoException;

    public List<Ingredient> getIngredientsByCategory (IngredientCategory category) throws DaoException;
}
