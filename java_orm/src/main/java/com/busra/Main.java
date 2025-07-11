package com.busra;

import com.busra.config.DataBaseConnectorConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /* [JA-4]
        String sql = "CREATE TABLE IF NOT EXISTS users ("+
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100)," +
                "email VARCHAR(100))";
         */

        String insertSql = "INSERT INTO users(name, email) VALUES(?,?) ";

        try {
            DataBaseConnectorConfig.setConnection();
            Connection connection = DataBaseConnectorConfig.getConnection();
            System.out.println("Connected");

            /* [JA-4]
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Table created");
            */

            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, "Ali");
            preparedStatement.setString(2, "ali@mail.com");
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}