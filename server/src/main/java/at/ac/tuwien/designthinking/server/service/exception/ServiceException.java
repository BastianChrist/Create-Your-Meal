package at.ac.tuwien.designthinking.server.service.exception;

/**
 * Created by Bastian on 27.05.2018.
 */
public class ServiceException extends Exception {


    public ServiceException() {

    }

    public ServiceException(String arg0) {
        super(arg0);
    }

    public ServiceException(Throwable arg0) {
        super(arg0);
    }

    public ServiceException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
}
