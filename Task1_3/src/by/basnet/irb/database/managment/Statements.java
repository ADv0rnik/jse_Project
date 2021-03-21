package by.basnet.irb.database.managment;

public class Statements {
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mysql";
    public static final String USER = "root";
    public static final String PASS = "root";

    public static final String CLEAR_LOGINS = "TRUNCATE TABLE results.logins; ";
    public static final String CLEAR_TESTS = "TRUNCATE TABLE results.tests; ";
    public static final String CLEAR_RESULTS = "TRUNCATE TABLE results.results; ";
    public static final String SET_FOREIGN_KEY_TO_0 = "SET FOREIGN_KEY_CHECKS = 0; ";
    public static final String SET_FOREIGN_KEY_TO_1 = "SET FOREIGN_KEY_CHECKS = 1; ";

    public static final String INSERT_INTO_LOGINS = "INSERT IGNORE INTO results.logins VALUES(null, ?); ";
    public static final String INSERT_INTO_TESTS = "INSERT IGNORE INTO results.tests VALUES (null, ?); ";
    public static final String GET_LOGIN_ID = "set @loginid = (SELECT idlogin FROM results.logins WHERE name = ?);";
    public static final String GET_TEST_ID = "set @testid = (SELECT idtest FROM results.tests WHERE name = ?);";
    public static final String INSERT_INTO_RESULTS = "INSERT INTO results.results VALUES (@loginid, @testid, ?, ?);";


}
