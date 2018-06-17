package at.ac.tuwien.designthinking.server.service;

import at.ac.tuwien.designthinking.server.dto.Context;
import at.ac.tuwien.designthinking.server.dto.Recipe;
import at.ac.tuwien.designthinking.server.persistence.RecipeDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bastian on 27.05.2018.
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeService.class);
    private static RecipeDAO recipeDAO;

    @Autowired
    public RecipeServiceImpl(RecipeDAO recipeDAO){this.recipeDAO = recipeDAO;}


    //TODO
    @Override
    public Recipe getById(int id) throws ServiceException {
        return null;
    }

    @Override
    public List<Recipe> getAll(Context context) throws ServiceException {
        return null;
    }

    @Override
    public List<Recipe> getByCategory() throws ServiceException {
        return null;
    }
}
