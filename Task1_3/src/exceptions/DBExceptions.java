package exceptions;

public class DBExceptions extends RuntimeException{
    private String msg;

    public DBExceptions(Throwable cause, String msg) {
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
