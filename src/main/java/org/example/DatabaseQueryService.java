package org.example;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseQueryService {

    public class LongestProject {
        private String name;

        @Override
        public String toString() {
            return "LongestProject{" +
                    "name='" + name +
                    '}';
        }

        public LongestProject(String name){
            this.name = name;
        }
    }

    public List<LongestProject> findLongestProject() throws SQLException {
        List<LongestProject> longestProjects = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            File file = new File("src/sql/find_longest_project.sql");
            ResultSet resultSet = statement.executeQuery(ReadFile.readFile(file));
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                longestProjects.add(new LongestProject(name));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return longestProjects;
    }

    public class MaxProjectCountClient {
        private String name;
        private int projectCount;

        @Override
        public String toString() {
            return "MaxProjectCountClient{" +
                    "name='" + name + '\'' +
                    ", projectCount=" + projectCount +
                    '}';
        }

        public MaxProjectCountClient(String name, int projectCount){
            this.name = name;
            this.projectCount = projectCount;
        }
    }

    public List<MaxProjectCountClient> findMaxProjectClient() throws SQLException {
        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            File file = new File("src/sql/find_max_projects_client.sql");
            ResultSet resultSet = statement.executeQuery(ReadFile.readFile(file));
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                int projectCount = resultSet.getInt("Project_Count");
                maxProjectCountClients.add(new MaxProjectCountClient(name, projectCount));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return maxProjectCountClients;
    }

    public class MaxSalaryWorker {
        private String name;
        private Long salary;

        @Override
        public String toString() {
            return "MaxSalaryWorker{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }

        public MaxSalaryWorker(String name, Long salary){
            this.name = name;
            this.salary = salary;
        }
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws SQLException {
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            File file = new File("src/sql/find_max_salary_worker.sql");
            ResultSet resultSet = statement.executeQuery(ReadFile.readFile(file));
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Long salary = resultSet.getLong("salary");
                maxSalaryWorkers.add(new MaxSalaryWorker(name, salary));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return maxSalaryWorkers;
    }

    public class YoungestEldestWorkers {
        private String name;
        private String type;
        private Date birthday;

        @Override
        public String toString() {
            return "YoungestEldestWorkers{" +
                    "name='" + name + '\'' +
                    ", type=" + type +'\'' +
                    ", birthday=" + birthday +
                    '}';
        }

        public YoungestEldestWorkers(String name, String type, Date birthday){
            this.name = name;
            this.type = type;
            this.birthday = birthday;
        }
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() throws SQLException {
        List<YoungestEldestWorkers> youngestEldestWorkers = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            File file = new File("src/sql/find_youngest_eldest_workers.sql");
            ResultSet resultSet = statement.executeQuery(ReadFile.readFile(file));
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                Date birthday = resultSet.getDate("birthday");
                youngestEldestWorkers.add(new YoungestEldestWorkers(name, type, birthday));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return youngestEldestWorkers;
    }

    public class ProjectPrices {
        private String name;
        private Long price;

        @Override
        public String toString() {
            return "ProjectPrices{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

        public ProjectPrices(String name, Long price){
            this.name = name;
            this.price = price;
        }
    }

    public List<ProjectPrices> printProjectPrices() throws SQLException {
        List<ProjectPrices> projectPrices = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            File file = new File("src/sql/print_project_prices.sql");
            ResultSet resultSet = statement.executeQuery(ReadFile.readFile(file));
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Long price = resultSet.getLong("price");
                projectPrices.add(new ProjectPrices(name, price));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return projectPrices;
    }
}
