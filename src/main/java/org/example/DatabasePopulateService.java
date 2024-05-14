package org.example;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = Database.getConnection();
            Statement statement = connection.createStatement()){
            File file = new File("src/sql/populate_db.sql");
            statement.execute(ReadFile.readFile(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
