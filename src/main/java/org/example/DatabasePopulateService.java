package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args) {
            String query = "INSERT INTO users (name, birthday) VALUES ('Oleg', '2000-01-01')";
            Connection h2Connection = Database.getH2Connection();
        Database database = Database.getInstance();
        database.executeUpdate("INSERT INTO test_table VALUES (7, 'Oleg')");
        database.executeResult("SELECT * FROM test_table");
        System.out.println("===============");
        database.executeUpdate("DELETE FROM test_table WHERE id = 7");
        database.executeResult("SELECT * FROM test_table");

    }
}