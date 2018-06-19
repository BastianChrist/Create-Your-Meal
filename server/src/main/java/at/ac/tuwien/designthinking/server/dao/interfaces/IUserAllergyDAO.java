package at.ac.tuwien.designthinking.server.dao.interfaces;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dto.Allergen;
import at.ac.tuwien.designthinking.server.dto.UserAllergies;

import java.util.List;

public interface IUserAllergyDAO extends IGenericDAO<UserAllergies,Integer> {

    /**
     *
     * Returns all allergens linked to a specific user
     *
     * @param userId The ID of the user
     * @return Is List of matching allergens.
     * @throws DaoException
     */
    public List<Allergen> getUserAllergies (int userId) throws DaoException;

    public void addUserAllergen(UserAllergies userAllergy, int userId) throws DaoException;

    public void deleteUserAllergy (int allergyId, int userId) throws DaoException;
}
