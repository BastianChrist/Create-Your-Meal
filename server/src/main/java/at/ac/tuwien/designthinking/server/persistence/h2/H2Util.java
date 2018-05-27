package at.ac.tuwien.designthinking.server.persistence.h2;

import at.ac.tuwien.designthinking.server.persistence.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Bastian on 27.05.2018.
 */
public class H2Util {
    private static final Logger LOGGER = LoggerFactory.getLogger(H2Util.class);
    private static final String ERROR = "Could not create entity.";

    public static int getGeneratedKey(Statement statement) throws PersistenceException {
        try {
            ResultSet result = statement.getGeneratedKeys();

            if (result.next()) return result.getInt(1);
            else {
                LOGGER.error(ERROR);
                throw new PersistenceException(ERROR);
            }
        } catch (SQLException e) {
            LOGGER.error(ERROR);
            throw new PersistenceException(ERROR);
        }
    }
}
