package application;

import db.DataBaseConfiguration;

import java.sql.*;

public class JDBC1 {

    public static void main(String[] args) throws SQLException {
        Connection conn = DataBaseConfiguration.getConnection();
        DataBaseConfiguration.closeConnection();
    }
}