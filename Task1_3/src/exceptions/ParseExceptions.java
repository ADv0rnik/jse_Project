package exceptions;

public class ParseExceptions extends IllegalArgumentException{
    private String msg;

    public ParseExceptions(Throwable cause, String msg) {
        super(cause);
        this.msg = msg;
    }

    public ParseExceptions(Throwable cause) {
        super(cause);
    }

    public ParseExceptions(String msg) {
        this.msg = msg;
    }

    public ParseExceptions(String message, String msg) {
        super(message);
        this.msg = msg;
    }

    public ParseExceptions(String message, Throwable cause) {
        super(cause);
        this.msg = message;
    }

    @Override
    public String toString() {
        return "Parsing error: " + msg + " " + super.getCause();
    }
}
