package com.example.demo.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Stream;

import org.sqlite.SQLiteConfig;

public class DatabaseConnector {

    public static Connection getConnection() throws SQLException {
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        String url = System.getenv("PLANETARIUM");
        return DriverManager.getConnection(url, config.toProperties());
    }

    public static void resetTestDatabase() {
        Path sql = Path.of("src/main/resources/setup-reset.sql");
        StringBuilder sqlBuilder = new StringBuilder();
        try (Connection conn = getConnection(); Stream<String> lines = Files.lines(sql)) {
            conn.setAutoCommit(false);
            lines.forEach(sqlBuilder::append);
            String sqlString = sqlBuilder.toString();
            String [] sqlStatements = sqlString.split(";");
            for (String sqlStatement : sqlStatements) {
                try (Statement stmt = conn.createStatement()) {
                    stmt.executeUpdate(sqlStatement);
                }
            }
            conn.commit();
        } catch (IOException | SQLException e) {
            System.out.println("Error: " +e.getMessage());
        }
    }

    public static void main(String[] args) {
            resetTestDatabase();
    }
}
