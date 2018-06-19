package at.ac.tuwien.designthinking.server.dao;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dao.interfaces.IUserAllergyDAO;

import at.ac.tuwien.designthinking.server.dto.Allergen;
import at.ac.tuwien.designthinking.server.dto.UserAllergies;
import org.springframework.stereotype.Repository;


import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserAllergyDAO extends GenericDAO<UserAllergies,Integer> implements IUserAllergyDAO {

    @Override
    public List<Allergen> getUserAllergies(int userId) throws DaoException {

        try {
            TypedQuery<Allergen> q = this.getEntityManager()
                    .createQuery("SELECT a FROM UserAllergies ua, Allergen a WHERE  ua.userId = (:userId) AND ua.allergyId=a.ID", Allergen.class);
            q.setParameter("userId", userId);

            return q.getResultList();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }


    @Override
    public void addUserAllergen(UserAllergies userAllergy, int userId) throws DaoException {


    }

    @Override
    public void deleteUserAllergy(int allergyId, int userId) throws DaoException {

    }
}
