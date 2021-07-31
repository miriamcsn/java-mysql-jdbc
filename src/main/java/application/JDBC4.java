package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DataBaseConfiguration;

public class JDBC4 {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DataBaseConfiguration.getConnection();

            st = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ? "
                            + "WHERE "
                            + "(DepartmentId = ?)");

            st.setDouble(1, 200.0); // primeira interrogacao
            st.setInt(2, 2); // segunda interrogacao

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DataBaseConfiguration.closeStatement(st);
            DataBaseConfiguration.closeConnection();
        }
    }
}
