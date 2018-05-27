package at.ac.tuwien.designthinking.server.persistence.h2;

import org.springframework.beans.factory.DisposableBean;

import java.sql.Connection;

/**
 * Created by Bastian on 27.05.2018.
 */
public abstract class PersistenceH2 implements DisposableBean {

    Connection connection;

    @Override
    public void destroy() throws Exception {
        connection.close();
    }
}
