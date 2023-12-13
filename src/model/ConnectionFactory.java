package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    final String user = "root";
    final String password = "diego1234";
    final String dbName = "trabalhoPOO_parte2";


    public Connection getConnection() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Properties properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("password", password);
            properties.setProperty("useSSL", "false");
            properties.setProperty("useTimezone", "true");
            properties.setProperty("serverTimezone", "UTC");
            properties.setProperty("allowPublicKeyRetrieval","true");

            String con = "jdbc:mysql://localhost/" + dbName;
            return DriverManager.getConnection(con, properties);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}