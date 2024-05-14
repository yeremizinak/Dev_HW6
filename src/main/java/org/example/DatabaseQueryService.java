package org.example;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueryService {
    public void findLongestProject() throws SQLException {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            File file = new File("src/sql/find_longest_project.sql");
            ResultSet resultSet = statement.executeQuery(ReadFile.readFile(file));
            while (resultSet.next()) {
                System.out.println(resultSet.getLong("name"));
                System.out.println("_____________");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void findMaxProjectClient() throws SQLException {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            File file = new File("src/sql/find_max_projects_client.sql");
            ResultSet resultSet = statement.executeQuery(ReadFile.readFile(file));
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Name"));
                System.out.println(resultSet.getLong("Project_Count"));
                System.out.println("_____________");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void findMaxSalaryWorker() throws SQLException {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            File file = new File("src/sql/find_max_salary_worker.sql");
            ResultSet resultSet = statement.executeQuery(ReadFile.readFile(file));
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getLong("salary"));
                System.out.println("_____________");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void findYoungestEldestWorkers() throws SQLException {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            File file = new File("src/sql/find_youngest_eldest_workers.sql");
            ResultSet resultSet = statement.executeQuery(ReadFile.readFile(file));
            while (resultSet.next()) {
                System.out.println(resultSet.getString("type"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getDate("birthday"));
                System.out.println("_____________");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printProjectPrices() throws SQLException {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            File file = new File("src/sql/print_project_prices.sql");
            ResultSet resultSet = statement.executeQuery(ReadFile.readFile(file));
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getLong("price"));
                System.out.println("_____________");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
