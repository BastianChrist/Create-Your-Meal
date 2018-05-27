package at.ac.tuwien.designthinking.common.service;

import java.util.List;

/**
 * Created by Bastian on 27.05.2018.
 */
public interface IngridientService<E> {
    /**
     * Returns an entity matching the unique id
     * @param id the id to be matched
     * @return an entity matching the id
     * @throws ServiceException if unexpected exception occured, contains descriptive and publicly displayable message
     */
    public E getById(int id) throws ServiceException;

    /**
     * Returns a list of all entities
     * @return a list of all entities
     * @throws ServiceException if unexpected exception occured, contains descriptive and publicly displayable message
     */
    public List<E> getAll() throws ServiceException;

    /**
     * Returns all ingridients from a category
     * @return a list of all entities from a specific category
     * @throws ServiceException
     */
    public List<E> getByCategory() throws ServiceException;
}
