package at.ac.tuwien.designthinking.server.dao;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dao.interfaces.IFavoriteRecipeDAO;
import at.ac.tuwien.designthinking.server.dto.FavoriteRecipe;
import at.ac.tuwien.designthinking.server.dto.Recipe;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class FavoriteRecipeDAO extends GenericDAO<FavoriteRecipe, Integer> implements IFavoriteRecipeDAO {


    @Override
    public List<Recipe> findFavoriteRecipesByUserId(Integer userId) throws DaoException {

        if (userId == null) {
            throw new DaoException("The id argument is required");
        }

        try {
            TypedQuery<Recipe> q = this.getEntityManager().createQuery("SELECT r FROM FavoriteRecipe fr,Recipe r WHERE fr.id = (:id) AND fr.id = r.id", Recipe.class);
            q.setParameter("id", userId);

            return q.getResultList();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
