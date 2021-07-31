package application;

import db.DataBaseConfiguration;

import java.sql.*;

public class JDBC1 {

    public static void main(String[] args) throws SQLException {

        Connection conn = DataBaseConfiguration.getConnection();
        DataBaseConfiguration.closeConnection();

//        try {
//
//            Connection connection = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/jdbc-test",
//                    "root",
//                    "M1987@t2003");
//
//            Statement statement = connection.createStatement();
//
//            ResultSet resultSet = statement.executeQuery(
//                    "select * from people");
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(
//                        "firstName"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}