package by.basnet.irb.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static by.basnet.irb.statements.Statements.*;

public final class DBConnector {
    static Connection connection = null;

    public DBConnector() {
    }

    public static Connection getConnection(){
        try{
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


}
