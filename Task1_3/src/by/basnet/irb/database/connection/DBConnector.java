package by.basnet.irb.database.connection;

import by.basnet.irb.beans.Result;
import exceptions.DBExceptions;

import java.sql.*;

import static by.basnet.irb.database.managment.Statements.*;

public final class DBConnector {
    private static Connection connection = null;
    private static Statement statement = null;


    public DBConnector() {
    }

    public static Connection getConnection(){
        try{
            if(connection == null){
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            }
        } catch (SQLException e) {
            throw new DBExceptions("Database connecting error: " + DB_URL, e);
        }
        return connection;
    }

    public static void connectionClose(Connection c){
        try{
            if(c!=null){
                c.close();
            }
        } catch (SQLException e){
            throw new DBExceptions("Connection error: "+ Connection.class.getSimpleName(), e);
        }
    }

    public static int getUpdate (String s){
            try {
                if(statement == null) {
                    statement = getConnection().createStatement();
                }
                return statement.executeUpdate(s);
            } catch (SQLException e) {
                throw new DBExceptions("Statement update error: ", e);
            }
    }

    public static ResultSet getQuery(String s){
        try{
            if(statement == null){
                statement = getConnection().createStatement();
            }
            return statement.executeQuery(s);
        } catch (SQLException e){
            throw new DBExceptions("Wrong SQL query: "+ s, e);
        }
    }


}



