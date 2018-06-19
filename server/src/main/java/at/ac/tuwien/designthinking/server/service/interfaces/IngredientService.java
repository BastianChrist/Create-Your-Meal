package at.ac.tuwien.designthinking.server.service.interfaces;

import at.ac.tuwien.designthinking.server.dto.Allergen;
import at.ac.tuwien.designthinking.server.dto.Ingredient;
import at.ac.tuwien.designthinking.server.dto.IngredientCategory;
import at.ac.tuwien.designthinking.server.dto.RecipeCategory;
import at.ac.tuwien.designthinking.server.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Bastian on 27.05.2018.
 */
public interface IngredientService {
    /**
     * Returns an entity matching the unique id
     * @param id the id to be matched
     * @return an entity matching the id
     * @throws ServiceException if unexpected exception occured, contains descriptive and publicly displayable message
     */
    Ingredient getById(int id) throws ServiceException;

    /**
     * Returns a list of all entities
     * @return a list of all entities
     * @throws ServiceException if unexpected exception occured, contains descriptive and publicly displayable message
     */
     List<Ingredient> getAll() throws ServiceException;

    /**
     * Returns a list of all allergens
     * @return a list of all allergens
     * @throws ServiceException if unexpected exception occured, contains descriptive and publicly displayable message
     */
     List<Allergen>getAllAllergens() throws ServiceException;

     public List<IngredientCategory> getCategories() throws ServiceException;

    /**
     * Returns all ingredients from a category
     * @return a list of all entities from a specific category
     * @throws ServiceException
     */
     List<Ingredient> getByCategory(IngredientCategory category) throws ServiceException;

   // Ingredient changeIngredient(int id, Ingredient ingredient) throws ServiceException;
}
