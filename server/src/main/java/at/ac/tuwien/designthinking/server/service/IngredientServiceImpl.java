package at.ac.tuwien.designthinking.server.service;

import at.ac.tuwien.designthinking.server.dao.IngredientCategoryDAO;
import at.ac.tuwien.designthinking.server.dao.IngredientDAO;
import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dao.interfaces.IIngredientCategoryDAO;
import at.ac.tuwien.designthinking.server.dto.Ingredient;
import at.ac.tuwien.designthinking.server.dto.IngredientCategory;
import at.ac.tuwien.designthinking.server.dto.RecipeCategory;
import at.ac.tuwien.designthinking.server.service.exception.ServiceException;
import at.ac.tuwien.designthinking.server.service.interfaces.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bastian on 27.05.2018.
 */
@Service
public class IngredientServiceImpl implements IngredientService {
    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientService.class);

    @Autowired
    private  IngredientDAO ingredientDAO;

    @Autowired
    private IngredientCategoryDAO ingredientCategoryDAO;

    @Autowired
    public IngredientServiceImpl(IngredientDAO ingredientDAO){this.ingredientDAO = ingredientDAO;}

    @Override
    public Ingredient getById(int id) throws ServiceException {
        try {
            return ingredientDAO.findIngredientById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Ingredient> getAll() throws ServiceException {
        try {
            return ingredientDAO.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<IngredientCategory> getCategories() throws ServiceException {
        try {
            return ingredientCategoryDAO.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
/**
    @Override
    public List<Ingredient>  getByCategory() throws ServiceException {
        return null;
    }

    @Override
    public Ingredient changeIngredient(int id, Ingredient ingredient) throws ServiceException {
        return null;
    }

    **/
}
