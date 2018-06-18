package at.ac.tuwien.designthinking.server.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dao.interfaces.IGenericDAO;

import java.io.Serializable;

@Transactional(propagation = Propagation.REQUIRED)
public class GenericDAO<Entity, PrimaryKey extends Serializable> implements IGenericDAO<Entity, PrimaryKey> {

    @PersistenceContext
    transient EntityManager entityManager;

    private Class<? extends Entity> daoType;

    @SuppressWarnings("unchecked")
    public GenericDAO() {
        this.daoType = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void save(Entity entity) throws DaoException {

        try {
            this.entityManager.persist(entity);
            this.entityManager.flush();
        } catch (DataAccessException ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public void update(Entity entity) throws DaoException {

        try {
            this.entityManager.merge(entity);
            this.entityManager.flush();
        } catch (DataAccessException ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public void remove(Entity entity) throws DaoException {

        try {
            this.entityManager.remove(this.entityManager.merge(entity));
            this.entityManager.flush();
        } catch (DataAccessException ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public Entity findById(PrimaryKey id) throws DaoException {

        if (id == null) {
            throw new DaoException("The id argument is required");
        }

        Entity entity = null;

        try {
            entity = this.entityManager.find(daoType, id);
        } catch (DataAccessException ex) {
            throw new DaoException(ex.getMessage());
        }

        return entity;
    }

}

