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
        PreparedStatement psSelectLogin = null;
        PreparedStatement psInsertLogin = null;
        PreparedStatement psSelectTest = null;
        PreparedStatement psInsertTest = null;
        PreparedStatement psInsertResult = null;
        try{
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(SET_FOREIGN_KEY_TO_0);
            stmt.executeUpdate(CLEAR_LOGINS);
            stmt.executeUpdate(CLEAR_RESULTS);
            stmt.executeUpdate(CLEAR_TESTS);
            stmt.executeUpdate(SET_FOREIGN_KEY_TO_1);
            psSelectLogin = conn.prepareStatement(GET_LOGIN_ID);
            psInsertLogin = conn.prepareStatement(INSERT_INTO_LOGINS);
            psSelectTest = conn.prepareStatement(GET_TEST_ID);
            psInsertTest = conn.prepareStatement(INSERT_INTO_TESTS);
            psInsertResult = conn.prepareStatement(INSERT_INTO_RESULTS);
            while (reader.hasResult()){
                Result result = reader.nextResult();
                String login = result.getLogin();
                String test = result.getName();
                int loginId = getId(login, psSelectLogin, psInsertLogin);
                int testId = getId(test, psSelectTest, psInsertTest);
                psInsertResult.setInt(1, loginId);
                psInsertResult.setInt(2, testId);
                psInsertResult.setDate(3, result.getDate());
                psInsertResult.setInt(4, result.getMark().getValue());
                psInsertResult.executeUpdate();

            }
            System.out.println("OK");
        } catch (SQLException e) {
            System.out.println("Insert error: " + e.toString());
        } finally {
            DBConnector.closeStatement(stmt);
            DBConnector.closePreparedStatement(psInsertLogin);
            DBConnector.closePreparedStatement(psSelectLogin);
            DBConnector.closePreparedStatement(psSelectTest);
            DBConnector.closePreparedStatement(psInsertTest);
            DBConnector.closePreparedStatement(psInsertResult);
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