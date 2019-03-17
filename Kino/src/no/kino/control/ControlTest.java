package no.kino.control;

import java.sql.*;

import static org.junit.Assert.*;

public class ControlTest {
    private String databasename = "jdbc:mysql://localhost:3306/kino?useSSL=false";
    private static Connection connection;
    private ResultSet result;
    private Statement statement;
    public ControlTest() throws Exception {
        makeConnection();
    }

    public void makeConnection() throws Exception {
        try{
            connection = DriverManager.getConnection(databasename, "Case", "Esac");
            System.out.println("kontakt med databasen!");
        } catch(Exception e) {
            throw new Exception("Kan ikke oppnå kontakt med databasen");
        }
    }
    @org.junit.Test
    public void checkLoginStaff() throws SQLException {
        String username = "knut";
        String password = "1234";
        String sqlStatement = "SELECT * FROM tbllogin;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            String correctUsernameStaff = result.getString("l_brukernavn");
            String correctPassordStaff = result.getString("l_pinkode");
            int isAdmin = result.getInt("l_erPlanlegger");
            if(username.equals(correctUsernameStaff) && password.equals(correctPassordStaff) && isAdmin == 0) {

            }
        }
    }
}