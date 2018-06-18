package at.ac.tuwien.designthinking.server.dao;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dao.interfaces.IRecipeDAO;
import at.ac.tuwien.designthinking.server.dto.Recipe;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository("recipedao")
public class RecipeDAO extends GenericDAO<Recipe,Integer> implements IRecipeDAO {
    @Override
    public Recipe getById(Integer id) throws DaoException {
        if (id == null) {
            throw new DaoException("The id argument is required");
        }

        try {
            TypedQuery<Recipe> q = this.getEntityManager().createQuery("SELECT o FROM Recipe o WHERE o.id = (:id)", Recipe.class);
            q.setParameter("id", id);

            return q.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public List<Recipe> getAll() throws DaoException {
        try {
            TypedQuery<Recipe> q = this.getEntityManager().createQuery("SELECT o FROM Recipe o", Recipe.class);

            return q.getResultList();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
