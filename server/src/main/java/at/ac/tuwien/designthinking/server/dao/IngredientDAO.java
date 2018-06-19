package at.ac.tuwien.designthinking.server.dao;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dao.interfaces.IIngredientDAO;
import at.ac.tuwien.designthinking.server.dto.Ingredient;
import at.ac.tuwien.designthinking.server.dto.IngredientCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository("ingredientDAO")
public class IngredientDAO extends GenericDAO<Ingredient,Integer> implements IIngredientDAO {
    @Override
    public Ingredient findIngredientByName(String name) throws DaoException {

        if (name == null) {
            throw new DaoException("The name argument is required");
        }

        try {
            TypedQuery<Ingredient> q = this.getEntityManager()
                    .createQuery("SELECT o FROM Ingredient o WHERE o.name = (:name)", Ingredient.class);
            q.setParameter("name", name);

            return q.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Ingredient findIngredientById(Integer id) throws DaoException {
        if (id == null) {
            throw new DaoException("The id argument is required");
        }

        try {
            TypedQuery<Ingredient> q = this.getEntityManager().createQuery("SELECT o FROM Ingredient o WHERE o.id = (:id)", Ingredient.class);
            q.setParameter("id", id);

            return q.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public List<Ingredient> findAll() throws DaoException {
        try {
            TypedQuery<Ingredient> q = this.getEntityManager().createQuery("SELECT o FROM Ingredient o", Ingredient.class);

            return q.getResultList();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public List<Ingredient> getIngredientsByCategory(IngredientCategory category) throws DaoException {
        try {
            TypedQuery<Ingredient> q = this.getEntityManager().createQuery("SELECT o FROM Ingredient o WHERE o.category=(:category)", Ingredient.class);
            q.setParameter("category", category.getName());

            return q.getResultList();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
