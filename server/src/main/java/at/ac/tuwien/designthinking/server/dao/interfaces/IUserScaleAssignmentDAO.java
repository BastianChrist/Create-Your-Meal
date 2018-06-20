package at.ac.tuwien.designthinking.server.dao.interfaces;

import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dto.UserScaleAssignment;

public interface IUserScaleAssignmentDAO {

    public UserScaleAssignment getUserScaleAssignmentByUserId (Integer userId) throws DaoException;
}
