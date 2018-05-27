package at.ac.tuwien.designthinking.client.application;


import at.ac.tuwien.designthinking.client.rmi.ServiceAwareRmiProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.support.RemoteInvocationFactory;
import at.ac.tuwien.designthinking.common.service.*;
import org.springframework.remoting.support.RemoteInvocationFactory;
import org.springframework.security.remoting.rmi.ContextPropagatingRemoteInvocationFactory;

/**
 * Created by Bastian on 27.05.2018.
 */
@Configuration
@ComponentScan("at.ac.tuwien.designthinking.client")
public class ClientMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientMain.class);

    private static String host = "localhost";
    private static String port = "1199";

    private RemoteInvocationFactory remoteInvocationFactory;

    /**
     * needed for all services, to be used with a ContextPropagatingRemoteInvocationFactory,
     * so the SecurityContext is forwarded to the server
     */
    @Autowired
    public void setRemoteInvocationFactory(RemoteInvocationFactory remoteInvocationFactory) {
        this.remoteInvocationFactory = remoteInvocationFactory;
    }

    //needed for setRemoteInvocationFactory
    @Bean
    public ContextPropagatingRemoteInvocationFactory createRemoteInvocationFactory() {
        return new ContextPropagatingRemoteInvocationFactory();
    }

    @Bean
    public IngridientService createUserServiceLink() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new ServiceAwareRmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://" + host + ":" + port + "/IngridientService");
        rmiProxyFactoryBean.setServiceInterface(IngridientService.class);
        rmiProxyFactoryBean.setRemoteInvocationFactory(remoteInvocationFactory);
        rmiProxyFactoryBean.afterPropertiesSet();
        return (IngridientService) rmiProxyFactoryBean.getObject();
    }

    @Bean
    public RecipeService createEquipmentServiceLink() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new ServiceAwareRmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://" + host + ":" + port + "/RecipeService");
        rmiProxyFactoryBean.setServiceInterface(RecipeService.class);
        rmiProxyFactoryBean.setRemoteInvocationFactory(remoteInvocationFactory);
        rmiProxyFactoryBean.afterPropertiesSet();
        return (RecipeService) rmiProxyFactoryBean.getObject();
    }

}


