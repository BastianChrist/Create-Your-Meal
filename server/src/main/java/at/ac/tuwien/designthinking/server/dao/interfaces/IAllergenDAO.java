package at.ac.tuwien.designthinking.server.dao.interfaces;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dto.Allergen;

import java.util.List;

public interface IAllergenDAO extends IGenericDAO<Allergen, Integer> {

    /**
     *
     *  Returns the allergen with the matching name.
     *
     * @param name The name of the allergen.
     * @return The matching Allergen.
     */
    public Allergen findAllergenByName (String name) throws DaoException;

    /**
     *
     *  Returns the user with the matching Id.
     *
     * @param id The id of the allergen.
     * @return The matching Allergen.
     */
    public Allergen findAllergenById(Integer id) throws DaoException;


    /**
     *
     *  Returns all allergens.
     */
    public List<Allergen> findAll() throws DaoException;
}
