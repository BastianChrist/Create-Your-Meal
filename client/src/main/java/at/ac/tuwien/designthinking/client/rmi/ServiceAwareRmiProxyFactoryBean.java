package at.ac.tuwien.designthinking.client.rmi;

import javafx.application.Platform;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * Created by Bastian on 27.05.2018.
 */
public class ServiceAwareRmiProxyFactoryBean extends RmiProxyFactoryBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAwareRmiProxyFactoryBean.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            return super.invoke(invocation);
        } catch (RemoteAccessException e) {
            //TODO: Info Fenster dass verbindung zum Server weg ist
            LOGGER.error("Verbindung zum server weg!");
            return null;
        }
    }
}
