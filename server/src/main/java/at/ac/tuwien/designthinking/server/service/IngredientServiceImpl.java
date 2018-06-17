package at.ac.tuwien.designthinking.server.service;

import at.ac.tuwien.designthinking.server.dto.Ingredient;
import at.ac.tuwien.designthinking.server.persistence.IngredientDAO;
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
    private static IngredientDAO ingredientDAO;

    @Autowired
    public IngredientServiceImpl(IngredientDAO ingredientDAO){this.ingredientDAO = ingredientDAO;}

    //TODO
    @Override
    public Ingredient getById(int id) throws ServiceException {
        return null;
    }

    @Override
    public List<Ingredient> getAll() throws ServiceException {
        return null;
    }

    @Override
    public List<Ingredient>  getByCategory() throws ServiceException {
        return null;
    }

    @Override
    public Ingredient changeIngredient(int id, Ingredient ingredient) throws ServiceException {
        return null;
    }
}
