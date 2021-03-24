package by.basnet.irb;

import by.basnet.irb.beans.Result;
import by.basnet.irb.dao.IResultDAO;
import by.basnet.irb.database.connection.DBConnector;

import java.sql.*;

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
            stmt.executeUpdate(SET_FOREIGN_KEY_TO_0);
            stmt.executeUpdate(CLEAR_LOGINS);
            stmt.executeUpdate(CLEAR_RESULTS);
            stmt.executeUpdate(CLEAR_TESTS);
            stmt.executeUpdate(SET_FOREIGN_KEY_TO_1);
            ps = conn.prepareStatement(INSERT_INTO_LOGINS+"");
            //+ GET_LOGIN_ID + GET_TEST_ID + INSERT_INTO_RESULTS
            while (reader.hasResult()){
                Result result = reader.nextResult();
                ps.setString(1, result.getLogin());
              // ps.setString(2, result.getName());
                /*ps.setString(3, result.getLogin());
                ps.setString(4,result.getName());
                ps.setDate(5, result.getDate());
                ps.setInt(6, result.getMark().getValue());*/
                ps.addBatch();
            }
            ps.executeBatch();
            System.out.println("OK");
        } catch (SQLException e) {
            System.out.println("Insert error: " + e.toString());
        } finally {
            DBConnector.closeStatement(stmt);
            DBConnector.closePreparedStatement(ps);
            reader.closeReader();
        }
    }

    private static int getId(String element, PreparedStatement selectElement, PreparedStatement insertElement) throws SQLException {
        final int FIRST_QUERY_INDEX = 1;
        final int ID_INDEX = 1;
        ResultSet resultSet = null;
        try{
            selectElement.setString(FIRST_QUERY_INDEX, element);
            resultSet = selectElement.executeQuery();
            if(!resultSet.next()){
                insertElement.setString(FIRST_QUERY_INDEX, element);
                insertElement.executeUpdate();
                resultSet = insertElement.executeQuery();
                resultSet.next();
            }
            return resultSet.getInt(ID_INDEX);
        }finally {
            DBConnector.closeResultSet(resultSet);
        }
    }
}