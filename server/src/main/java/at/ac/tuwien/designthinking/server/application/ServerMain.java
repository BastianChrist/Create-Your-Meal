package at.ac.tuwien.designthinking.server.application;



/**
 * Created by Bastian on 27.05.2018.
 */

import at.ac.tuwien.designthinking.common.service.IngridientService;
import at.ac.tuwien.designthinking.common.service.RecipeService;
import org.apache.catalina.startup.Tomcat;
import org.apache.commons.cli.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 * Serverclass does Serverthingies
 * Opens ports for connection
 */
@Configuration
@ComponentScan("at.ac.tuwien.designthinking.server")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ServerMain implements WebApplicationInitializer{
    private static int WEB_PORT = 8080;

    // TODO: remove default value and make param mandatory.
    private static String WEB_DOMAIN = "localhost:8080";

    private static int RMI_PORT = 1199;

    private static final String ARG_RMI_PORT_SHORT = "r";
    private static final String ARG_RMI_PORT_LONG = "rmi-port";

    private static final String ARG_WEB_PORT_SHORT = "w";
    private static final String ARG_WEB_PORT_LONG = "web-port";

    private static final String ARG_WEB_DOMAIN_SHORT = "d";
    private static final String ARG_WEB_DOMAIN_LONG = "web-domain";

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerMain.class);

    private static AnnotationConfigWebApplicationContext applicationContext;


    @Bean(destroyMethod = "close")
    public BasicDataSource getDataSource() throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        return dataSource;
    }

    // Für RMI Datenübertragungsverbindungen sieht die Erstellung von Beans immer so aus also einfach in common einen Service erstellen und dann
    // mit RMI hier und im client verbinden implementation vom service im service ordner von Server und wichtig das @service ober der klasse
    // nicht vergessen
    @Bean(destroyMethod = "destroy")
    public RmiServiceExporter registerIngridientService(IngridientService ingridientService) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("IngriedientService");
        rmiServiceExporter.setService(ingridientService);
        rmiServiceExporter.setServiceInterface(IngridientService.class);
        rmiServiceExporter.setRegistryPort(RMI_PORT);

        return rmiServiceExporter;
    }

    @Bean(destroyMethod = "destroy")
    public RmiServiceExporter registerRecipeService(RecipeService recipeService) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("RecipeService");
        rmiServiceExporter.setService(recipeService);
        rmiServiceExporter.setServiceInterface(RecipeService.class);
        rmiServiceExporter.setRegistryPort(RMI_PORT);

        return rmiServiceExporter;
    }

    public static void main(String[] args) {

        CommandLine cmd = parseArguments(args);

        String rmiPort = null;
        String webPort = null;
        String webDomain = null;

        rmiPort = cmd.getOptionValue(ARG_RMI_PORT_LONG);
        webPort = cmd.getOptionValue(ARG_WEB_PORT_LONG);
        webDomain = cmd.getOptionValue(ARG_WEB_DOMAIN_LONG);

        try {

            if (rmiPort != null) {
                RMI_PORT = Integer.parseInt(rmiPort);
            }

            if (webPort != null)
                WEB_PORT = Integer.parseInt(webPort);

            if (webDomain != null)
                WEB_DOMAIN = webDomain;

        } catch (NumberFormatException e) {
            LOGGER.error("Params '" + ARG_RMI_PORT_LONG + "' and '" + ARG_WEB_PORT_LONG + "' have to be valid integers. Shutting down.");
            System.exit(1);
        }

        startApplicationAndWaitForTermination();

    }

    private static CommandLine parseArguments(String[] args) {

        Options options = new Options();

        Option rmiPortOption = new Option(ARG_RMI_PORT_SHORT, ARG_RMI_PORT_LONG, true, "port used by rmi-registry. Needed for basic functionality. default: 1199");
        rmiPortOption.setRequired(false);
        options.addOption(rmiPortOption);

        Option webPortOption = new Option(ARG_WEB_PORT_SHORT, ARG_WEB_PORT_LONG, true, "port used by tomcat. Needed for ics subscriptions. default: 8080");
        webPortOption.setRequired(false);
        options.addOption(webPortOption);

        Option webDomainOption = new Option(ARG_WEB_DOMAIN_SHORT, ARG_WEB_DOMAIN_LONG, true, "Domain used in ical url displayed to user.");
        webDomainOption.setRequired(false);
        options.addOption(webDomainOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Server", options);

            System.exit(1);
            return null;
        }

        return cmd;
    }

    private static void startApplicationAndWaitForTermination() {

        applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(ServerMain.class);
        applicationContext.refresh();

        Tomcat tomcat = null;
        try {
            tomcat = new Tomcat();
            tomcat.setPort(WEB_PORT);
            tomcat.start();
        } catch (Exception e) {
            LOGGER.error("couldn't start tomcat", e.getMessage());
        }

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String input = br.readLine();

                if ("exit".equals(input)) {
                    LOGGER.info("shutting down gracefully");

                    if (tomcat != null)
                        tomcat.stop();
                    applicationContext.close();
                    return;
                }
            }

        } catch (Exception e) {
            LOGGER.error("exception occured trying to read System.in", e.getMessage());
        }

    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        servletContext.addListener(new ContextLoaderListener(applicationContext));

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("testDispatcher", new DispatcherServlet(applicationContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");

    }

    public static String getWebDomain() {
        return WEB_DOMAIN;
    }



}
