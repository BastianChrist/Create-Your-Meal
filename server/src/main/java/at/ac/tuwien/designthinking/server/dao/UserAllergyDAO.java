package at.ac.tuwien.designthinking.server.dao;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dao.interfaces.IUserAllergyDAO;

import at.ac.tuwien.designthinking.server.dto.Allergy;
import at.ac.tuwien.designthinking.server.dto.UserAllergies;


import javax.persistence.TypedQuery;
import java.util.List;

public class UserAllergyDAO extends GenericDAO<UserAllergies,Integer> implements IUserAllergyDAO {

    @Override
    public List<Allergy> getUserAllergies(int userId) throws DaoException {

        try {
            TypedQuery<Allergy> q = this.getEntityManager()
                    .createQuery("SELECT a.name, a.allergenid, a.id FROM UserAllergies ua, Allergy a WHERE  ua.userId = (:userId) AND ua.allergyId=a.ID", Allergy.class);
            q.setParameter("userId", userId);

            return q.getResultList();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }


    @Override
    public List<Allergy> addUserAllergen(UserAllergies userAllergy, int userId) throws DaoException {
        return null;
    }

    @Override
    public void deleteUserAllergy(int allergyId, int userId) throws DaoException {

    }
}
