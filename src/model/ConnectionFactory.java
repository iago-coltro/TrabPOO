package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    final String user = "root";
    final String password = "admwindows";
    final String dbName = "trabalhopoo_parte2";


    public Connection getConnection() throws SQLException{
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
            System.out.println("Erro ao conectar no banco de dados.");
            throw new RuntimeException(e);
        }
    }
}