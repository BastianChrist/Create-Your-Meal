package at.ac.tuwien.designthinking.server.dao.interfaces;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dto.Allergy;

import java.util.List;

public interface IAllergyDAO  extends IGenericDAO<Allergy, Integer> {

    /**
     *
     *  Returns the allergy with the matching name.
     *
     * @param name The name of the allergy.
     * @return The matching Allergy.
     */
    public Allergy findAllergyByName (String name) throws DaoException;

    /**
     *
     *  Returns the allergy with the matching Id.
     *
     * @param id The id of the allergy.
     * @return The matching Allergy.
     */
    public Allergy findAllergyById(Integer id) throws DaoException;


    /**
     *
     *  Returns all allergies.
     */
    public List<Allergy> findAll() throws DaoException;
}
