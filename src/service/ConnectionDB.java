package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
class ConnectDB {
    final String DB_URL = "jdbc:mysql://localhost:3306/exam3?serverTimezone=UTC";
    final String jdbc_USERNAME = "chung123";
    final String jdbc_PASSWORD = "Chung1997";
    public ConnectDB() {
    }
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, jdbc_USERNAME, jdbc_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
