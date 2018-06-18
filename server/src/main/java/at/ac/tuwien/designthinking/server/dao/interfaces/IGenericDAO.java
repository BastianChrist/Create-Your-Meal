package at.ac.tuwien.designthinking.server.dao.interfaces;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;

public interface IGenericDAO<Entity, PrimaryKey> {

    void save(Entity entity) throws DaoException;

    void update(Entity entity) throws DaoException;

    void remove(Entity entity) throws DaoException;

    Entity findById(PrimaryKey id) throws DaoException;
}