package by.basnet.irb.database.managment;

public class Statements {
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mysql";
    public static final String USER = "root";
    public static final String PASS = "root";

    public static final String CLEAR_LOGINS = "TRUNCATE TABLE logins;";
    public static final String CLEAR_TESTS = "TRUNCATE TABLE tests;";
    public static final String CLEAR_RESULTS = "TRUNCATE TABLE results;";


}
