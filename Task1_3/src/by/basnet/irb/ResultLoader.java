package by.basnet.irb;

import by.basnet.irb.beans.Result;
import by.basnet.irb.dao.IResultDAO;
import by.basnet.irb.database.connection.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import static by.basnet.irb.database.connection.DBConnector.getConnection;
import static by.basnet.irb.database.managment.Statements.*;

public class ResultLoader {
    public static void loadResults(IResultDAO reader){
        Connection conn;
        Statement stmt = null;
        PreparedStatement ps = null;
        try{
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(CLEAR_LOGINS );
            stmt.executeUpdate(SET_FOREIGN_KEY_TO_0);
            stmt.executeUpdate(CLEAR_RESULTS);
            stmt.executeUpdate(SET_FOREIGN_KEY_TO_1);
            stmt.executeUpdate(CLEAR_TESTS);
            ps = DBConnector.getPreparedStatement( SET_FOREIGN_KEY_TO_0 + INSERT_INTO_LOGINS + INSERT_INTO_TESTS + GET_LOGIN_ID + GET_TEST_ID + INSERT_INTO_RESULTS + SET_FOREIGN_KEY_TO_1);
            while (reader.hasResult()){
                Result result = reader.nextResult();
                String login = result.getLogin();
                String test = result.getName();
                Date date = result.getDate();
                int mark = result.getMark().getValue();
                ps.setString(1,login);
                ps.setString(2,test);
                ps.setString(3,login);
                ps.setString(4,test);
                ps.setDate(5, date);
                ps.setInt(6, mark);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            System.out.println("Insert error: " + e.toString());
        } finally {
            DBConnector.closeStatement(stmt);
            DBConnector.closePreparedStatement(ps);
            reader.closeReader();
        }
    }
}