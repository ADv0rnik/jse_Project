package by.basnet.irb.database.connection;

import exceptions.DBExceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static by.basnet.irb.database.managment.Statements.*;

public final class DBConnector {
    static Connection connection = null;

    public DBConnector() {
    }

    public static Connection getConnection(){
        try{
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            throw new DBExceptions("Database connecting error: " + DB_URL, e);
        }
        return connection;
    }


}
