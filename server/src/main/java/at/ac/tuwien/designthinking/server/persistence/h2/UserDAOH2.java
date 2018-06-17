package at.ac.tuwien.designthinking.server.persistence.h2;

import at.ac.tuwien.designthinking.server.dto.User;
import at.ac.tuwien.designthinking.server.persistence.PersistenceException;
import at.ac.tuwien.designthinking.server.persistence.UserDAO;
import at.ac.tuwien.designthinking.server.persistence.h2.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Georg Edlinger on 02.06.18.
 */
@Repository
public class UserDAOH2 extends PersistenceH2 implements UserDAO {


    private final static String SELECT_ALL_STATEMENT = "SELECT * from UserAccount";
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOH2.class);
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Autowired
    public UserDAOH2(DataSource dataSource)throws SQLException {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        connection = dataSource.getConnection();
    }

    @Override
    public List<User> readUserAccounts() throws PersistenceException {

        try {
            List<User> userList = namedParameterJdbcTemplate.query(SELECT_ALL_STATEMENT, new UserMapper());
            LOGGER.debug("entities found " + userList.size());
            return userList;
        } catch (DataAccessException dataAccessException) {
            LOGGER.warn("dataAccessException occurred " + dataAccessException.getMessage());
            throw new PersistenceException(dataAccessException.getMessage());
        }
    }
}
