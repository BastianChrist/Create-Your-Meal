package at.ac.tuwien.designthinking.server.dao;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dao.interfaces.IAllergenDAO;
import at.ac.tuwien.designthinking.server.dto.Allergen;
import at.ac.tuwien.designthinking.server.dto.UserAccount;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AllergenDAO extends GenericDAO<Allergen,Integer> implements IAllergenDAO {


    @Override
    public Allergen findAllergenByName(String name) throws DaoException {

        if (name == null) {
            throw new DaoException("The name argument is required");
        }

        try {
            TypedQuery<Allergen> q = this.getEntityManager()
                    .createQuery("SELECT o FROM Allergen o WHERE o.name = (:name)", Allergen.class);
            q.setParameter("name", name);

            return q.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Allergen findAllergenById(Integer id) throws DaoException {

        if (id == null) {
            throw new DaoException("The id argument is required");
        }

        try {
            TypedQuery<Allergen> q = this.getEntityManager().createQuery("SELECT o FROM Allergen o WHERE o.id = (:id)", Allergen.class);
            q.setParameter("id", id);

            return q.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public List<Allergen> findAll() throws DaoException {
        try {
            TypedQuery<Allergen> q = this.getEntityManager().createQuery("SELECT o FROM Allergen o", Allergen.class);

            return q.getResultList();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
