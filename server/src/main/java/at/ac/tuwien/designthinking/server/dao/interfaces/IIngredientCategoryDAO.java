package at.ac.tuwien.designthinking.server.dao.interfaces;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dto.IngredientCategory;

import java.util.List;

public interface IIngredientCategoryDAO extends IGenericDAO<IngredientCategory, Integer> {

    public List<IngredientCategory> getAll() throws DaoException;
}
