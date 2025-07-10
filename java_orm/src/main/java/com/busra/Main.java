package com.busra;

import com.busra.config.DataBaseConnectorConfig;

import java.sql.Connection;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String sql = "CREATE TABLE IF NOT EXISTS users ("+
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100)," +
                "email VARCHAR(100))";

        try {
            DataBaseConnectorConfig.setConnection();
            Connection connection = DataBaseConnectorConfig.getConnection();
            System.out.println("Connected");
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Table created");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}