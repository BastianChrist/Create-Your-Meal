package at.ac.tuwien.designthinking.server.dao;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dao.interfaces.IRecipeDAO;
import at.ac.tuwien.designthinking.server.dto.Context;
import at.ac.tuwien.designthinking.server.dto.Ingredient;
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

    @Override
    public List<Recipe> getByContext(Context context) throws DaoException {


        if (context.getType() == null){
            TypedQuery<Recipe> q = this.getEntityManager().createQuery("SELECT o FROM Recipe o WHERE o.isWarm =(:isWarm) AND o.time_needed <= (:time_needed) ", Recipe.class);
            q.setParameter("isWarm", context.isWarm());
            q.setParameter("time_needed",context.getMaxCookTime());
            return q.getResultList();
        } else {
            TypedQuery<Recipe> q = this.getEntityManager().createQuery("SELECT o FROM Recipe o WHERE o.isWarm =(:isWarm) AND o.type =(:type) AND o.time_needed <= (:time_needed) ", Recipe.class);
            q.setParameter("isWarm", context.isWarm());
            q.setParameter("type",context.getType());
            q.setParameter("time_needed",context.getMaxCookTime());
            return q.getResultList();
        }
     //   TypedQuery<Recipe> q = this.getEntityManager().createQuery("SELECT o FROM Recipe o WHERE o.isWarm =(:isWarm) AND o.type =(:type) AND o.time_needed like (:time_needed) ", Recipe.class);
        //return q.getResultList();
    }

    @Override
    public List<Recipe> getRecipesByIngredient(Ingredient ingredient) throws DaoException {

        if (ingredient == null) {
            throw new DaoException("The ingredient argument is required");
        }

        try {
            TypedQuery<Recipe> q = this.getEntityManager().createQuery("SELECT r FROM RecipeIngredients ri,Recipe r WHERE ri.ingredientId = (:ingredientId) AND recipeId = r.id", Recipe.class);
            q.setParameter("ingredientId", ingredient.getId());

            return q.getResultList();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }


}
