package org.example;

import org.example.props.PropertyReader;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class Database {
    private static final Database INSTANCE = new Database();

    private static Connection h2Connection;

    private Database(){
        try {
            String h2ConnectionUrl = PropertyReader.getConnectionUrlForH2();
            this.h2Connection = DriverManager.getConnection(h2ConnectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Create connection exception");
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public static Connection getH2Connection() {
        return h2Connection;
    }

    public int executeUpdate(String query) {
        try(Statement statement = h2Connection.createStatement()) {
            return statement.executeUpdate(query);
        } catch(SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query.");
        }
    }

    public void execute(String fileName) {
        try(Statement statement = h2Connection.createStatement()) {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            statement.execute(content);
        } catch(SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query.");
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeResult(String query) {
        try(Statement statement = h2Connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                TestData td = new TestData(resultSet.getInt("id"), resultSet.getString("name"));
                System.out.println("h2 ------>>>> " + td.toString());
            }
        } catch(SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query.");
        }
    }

    public void closeConnection() {
        try {
            h2Connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
