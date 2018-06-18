package at.ac.tuwien.designthinking.server.dao;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dao.interfaces.IAllergyDAO;
import at.ac.tuwien.designthinking.server.dto.Allergy;

import javax.persistence.TypedQuery;
import java.util.List;

public class AllergyDAO extends GenericDAO<Allergy,Integer> implements IAllergyDAO {

    @Override
    public Allergy findAllergyByName(String name) throws DaoException {
        if (name == null) {
            throw new DaoException("The name argument is required");
        }

        try {
            TypedQuery<Allergy> q = this.getEntityManager()
                    .createQuery("SELECT o FROM Allergy o WHERE o.name = (:name)", Allergy.class);
            q.setParameter("name", name);

            return q.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Allergy findAllergyById(Integer id) throws DaoException {
        if (id == null) {
            throw new DaoException("The id argument is required");
        }

        try {
            TypedQuery<Allergy> q = this.getEntityManager().createQuery("SELECT o FROM Allergy o WHERE o.id = (:id)", Allergy.class);
            q.setParameter("id", id);

            return q.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public List<Allergy> findAll() throws DaoException {
        try {
            TypedQuery<Allergy> q = this.getEntityManager().createQuery("SELECT o FROM Allergy o", Allergy.class);

            return q.getResultList();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
