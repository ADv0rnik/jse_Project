package by.basnet.irb.database.managment;

public class Statements {
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mysql";
    public static final String USER = "root";
    public static final String PASS = "root";

    public static final String CLEAR_LOGINS = "TRUNCATE TABLE logins;";
    public static final String CLEAR_TESTS = "TRUNCATE TABLE tests;";
    public static final String CLEAR_RESULTS = "TRUNCATE TABLE results;";

    public static final String INSERT_INTO_LOGINS = "INSERT IGNORE INTO logins VALUES(null, ?);";
    public static final String INSERT_INTO_TESTS = "INSERT IGNORE INTO tests VALUES (null, ?);";
    public static final String GET_LOGIN_ID = "set @loginID = (SELECT idLogin FROM logins WHERE name = ?);";
    public static final String GET_TEST_ID = "set @testID = (SELECT idTest FROM tests WHERE name = ?);";
    public static final String INSERT_INTO_RESULTS = "INSERT INTO results VALUES (@loginID, @testID, ?, ?);";


}
