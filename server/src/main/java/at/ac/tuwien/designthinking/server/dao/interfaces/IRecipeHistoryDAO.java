package at.ac.tuwien.designthinking.server.dao.interfaces;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dto.RecipeHistory;

import java.util.List;

public interface IRecipeHistoryDAO extends IGenericDAO<RecipeHistory, Integer> {


    public List<RecipeHistory> getHistoryByUserId(Integer id) throws DaoException;

   // public void addHistoryEntry (RecipeHistory history, Integer userId) throws DaoException; -> Moved to RecipeService

}
