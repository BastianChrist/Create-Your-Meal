package at.ac.tuwien.designthinking.server.persistence.h2;

import at.ac.tuwien.designthinking.server.persistence.IngridientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Bastian on 27.05.2018.
 */
@Repository
public class IngridientDAOH2 extends PersistenceH2 implements IngridientDAO {



    @Autowired
    public IngridientDAOH2(DataSource dataSource)throws SQLException{
        connection = dataSource.getConnection();
    }
}
