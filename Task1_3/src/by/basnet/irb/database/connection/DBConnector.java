package by.basnet.irb.database.connection;

import by.basnet.irb.beans.Result;
import exceptions.DBExceptions;

import java.sql.*;

import static by.basnet.irb.database.managment.Statements.*;

public final class DBConnector {

    public DBConnector() {
    }

    public static Connection getConnection(){
        Connection connection;
        try{
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            throw new DBExceptions("Database connecting error: " + DB_URL, e);
        }
        return connection;
    }

    public static Statement getStatement(){
        Statement statement = null;
        try{
            statement = getConnection().createStatement();
        } catch (SQLException e){
            throw new DBExceptions("Statement creating error: ", e);
        }
        return statement;
    }

    public static int Update (String s){
        try {
            return getStatement().executeUpdate(s);
        } catch (SQLException e) {
            throw new DBExceptions("Statement update error: " + s, e);
        }
    }

    public static ResultSet Query(Statement statement, String s){
        ResultSet rs = null;
        try{
            if(statement == null){
                statement = getConnection().createStatement();
                rs = statement.executeQuery(s);
            }
            return rs;
        } catch (SQLException e){
            throw new DBExceptions("Wrong SQL query: "+ s, e);
        }
    }

    public static PreparedStatement getPreparedStatement(String s){
        PreparedStatement ps;
        try{
            ps = getConnection().prepareStatement(s);
        }catch (SQLException e){
            throw new DBExceptions("Prepared statement creating error: "+ s, e);
        }
        return ps;
    }

    public static void closeConnection(Connection c){
        try{
            if(c!=null){
                c.close();
            }
        } catch (SQLException e){
            throw new DBExceptions("Connection error: "+ Connection.class.getSimpleName(), e);
        }
    }

    public static void closeStatement(Statement statement){
        try{
            if(statement != null){
                statement.close();
            }
        }catch (SQLException e){
            throw new DBExceptions("Statement closing error: ", e);
        }
    }

    public static void closeResultSet(ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e){
            throw new DBExceptions("Result Ser closing error :", e);
        }
    }

    public static void closePreparedStatement(PreparedStatement ps) {
        try {
            if(ps != null){
                ps.close();
            }
        }catch (SQLException e){
            throw new DBExceptions("PreparedStatement closing error: ", e);
        }
    }
}