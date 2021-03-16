package by.basnet.irb;

import by.basnet.irb.dao.IResultDAO;
import by.basnet.irb.database.connection.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class ResultLoader {
    public static void loadResults(IResultDAO reader){
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;
        conn = DBConnector.getConnection();


    }
}
