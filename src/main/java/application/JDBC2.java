package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DataBaseConfiguration;

public class JDBC2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DataBaseConfiguration.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("select * from department");

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DataBaseConfiguration.closeResultSet(rs);
            DataBaseConfiguration.closeStatement(st);
            DataBaseConfiguration.closeConnection();
        }
    }
}
