package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseQueryService db = new DatabaseQueryService();
        db.findLongestProject();
        db.findMaxProjectClient();
        db.findMaxSalaryWorker();
        db.findYoungestEldestWorkers();
        db.printProjectPrices();
    }
}