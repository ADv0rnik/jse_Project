package exceptions;

import java.sql.SQLException;

public class DBExceptions extends RuntimeException{
    private String msg;

    public DBExceptions(String msg, Throwable cause) {
        super(cause);
        this.msg = msg;
    }

    public DBExceptions(Throwable cause) {
        super(cause);
    }


    @Override
    public String toString() {
        return "Database Exception: " + msg + " " + super.getCause();
    }
}
