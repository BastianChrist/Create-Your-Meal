package at.ac.tuwien.designthinking.server.dao.exception;

public class DaoException extends Exception {

    private static final long serialVersionUID = 4263076035650442851L;

    public DaoException() {

    }

    public DaoException(String arg0) {
        super(arg0);
    }

    public DaoException(Throwable arg0) {
        super(arg0);
    }

    public DaoException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}

