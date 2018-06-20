package at.ac.tuwien.designthinking.server.dao;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dao.interfaces.IUserScaleAssignmentDAO;
import at.ac.tuwien.designthinking.server.dto.UserScaleAssignment;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class UserScaleAssignmentDAO extends GenericDAO<UserScaleAssignment, Integer> implements IUserScaleAssignmentDAO {


    @Override
    public UserScaleAssignment getUserScaleAssignmentByUserId(Integer userId) throws DaoException {
        try {
            TypedQuery<UserScaleAssignment> q = this.getEntityManager().createQuery("SELECT usa FROM UserScaleAssignment usa WHERE usa.userId= (:userId)", UserScaleAssignment.class);
            q.setParameter("userId", userId);

            return q.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
