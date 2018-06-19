package at.ac.tuwien.designthinking.server.dao;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dao.interfaces.IIngredientCategoryDAO;
import at.ac.tuwien.designthinking.server.dto.IngredientCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class IngredientCategoryDAO extends GenericDAO<IngredientCategory, Integer> implements IIngredientCategoryDAO {

    @Override
    public List<IngredientCategory> getAll() throws DaoException {

        try {
            TypedQuery<IngredientCategory> q = this.getEntityManager().createQuery("SELECT c FROM IngredientCategory c", IngredientCategory.class);

            return q.getResultList();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public IngredientCategory getCategory(int id){
     //TODO
        return null;
    }
}
