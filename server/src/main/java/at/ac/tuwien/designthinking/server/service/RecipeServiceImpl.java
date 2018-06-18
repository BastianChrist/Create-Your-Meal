package at.ac.tuwien.designthinking.server.service;

import at.ac.tuwien.designthinking.server.dao.RecipeDAO;
import at.ac.tuwien.designthinking.server.dao.RecipeHistoryDAO;
import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dto.Context;
import at.ac.tuwien.designthinking.server.dto.Recipe;
import at.ac.tuwien.designthinking.server.dto.RecipeHistory;
import at.ac.tuwien.designthinking.server.service.exception.ServiceException;
import at.ac.tuwien.designthinking.server.service.interfaces.RecipeService;
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

    @Autowired
    private RecipeDAO recipeDAO;

    @Autowired
    private RecipeHistoryDAO recipeHistoryDAO;



    @Autowired
    public RecipeServiceImpl(RecipeDAO recipeDAO){this.recipeDAO = recipeDAO;}

    @Override
    public Recipe getById(int id) throws ServiceException {
        try {
            return recipeDAO.getById(id);
        } catch (DaoException e) {
           throw new ServiceException(e);
        }
    }

    @Override
    public List<Recipe> getAll(Context context) throws ServiceException {
        try {
            return recipeDAO.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Recipe> getByCategory() throws ServiceException {
        return null;
    }

    @Override
    public void addHistoryEntry(RecipeHistory history, Integer userId) throws ServiceException {

        history.setId(null);
        history.setUserId(userId);

        try {
            this.recipeHistoryDAO.save(history);
        } catch (DaoException e) {
           throw new ServiceException(e);
        }
    }
}
