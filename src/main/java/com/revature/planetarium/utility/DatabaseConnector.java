package com.revature.planetarium.utility;

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

}
