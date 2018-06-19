package at.ac.tuwien.designthinking.server.dao;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dao.interfaces.IRecipeHistoryDAO;
import at.ac.tuwien.designthinking.server.dto.RecipeHistory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository("recipeHistoryDAO")
public class RecipeHistoryDAO extends GenericDAO<RecipeHistory, Integer> implements IRecipeHistoryDAO {

    @Override
    public List<RecipeHistory> getHistoryByUserId(Integer id) throws DaoException {
        if (id == null) {
            throw new DaoException("The id argument is required");
        }

        try {
            TypedQuery<RecipeHistory> q = this.getEntityManager().createQuery("SELECT o FROM RecipeHistory o WHERE o.userId = (:id)", RecipeHistory.class);
            q.setParameter("id", id);

            return q.getResultList();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

}
