package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DataBaseConfiguration {

    // classe contendo métodos estáticos para conectar e
    // desconectar do banco de dados

    private static Connection conn = null;

    // retorna um objeto do tipo Properties com as informações
    // para conexão no banco de dados:

    private static Properties loadProperties() {

        try (FileInputStream fs = new FileInputStream("/Users/miriam/Java/intellij-jdbc-mysql-test/db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static Connection getConnection() {
        if (conn == null) {

            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursejdbc", "root", "M1987@t2003");
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());

            }
        }
        return conn;
    }


    public static void closeConnection() {
        if (conn != null) {

            try {
                conn.close();
            }

            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

}
