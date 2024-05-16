package org.example;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        List<DatabaseQueryService.MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectClient();
        List<DatabaseQueryService.LongestProject> longestProjects = new DatabaseQueryService().findLongestProject();
        List<DatabaseQueryService.MaxSalaryWorker> maxSalaryWorker = new DatabaseQueryService().findMaxSalaryWorker();
        List<DatabaseQueryService.YoungestEldestWorkers> youngestEldestWorkers = new DatabaseQueryService().findYoungestEldestWorkers();
        List<DatabaseQueryService.ProjectPrices> projectPrices = new DatabaseQueryService().printProjectPrices();
        System.out.println(maxProjectCountClients);
        System.out.println(longestProjects);
        System.out.println(maxSalaryWorker);
        System.out.println(youngestEldestWorkers);
        System.out.println(projectPrices);
    }
}