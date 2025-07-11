package com.busra;

import com.busra.config.DataBaseConnectorConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        /* [JA-5]
        String insertSql = "INSERT INTO users(name, email) VALUES(?,?) ";
         */

        /* [JA-6]
        String readSql = "SELECT * FROM users";
         */

        /* [JA-7] - UPDATE
        String updatedSql = "UPDATE users SET name=? WHERE id=?";
         */

        String deletedSql = "DELETE FROM users WHERE id = ?";

        try {
            DataBaseConnectorConfig.setConnection();
            Connection connection = DataBaseConnectorConfig.getConnection();
            System.out.println("Connected");

            /* [JA-4]
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Table created");
            */

            /* [JA-5]
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, "Ali");
            preparedStatement.setString(2, "ali@mail.com");
            preparedStatement.executeUpdate();
             */

            /* [JA-6]
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(readSql);
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id"));
                System.out.println("name: " + resultSet.getString("name"));
                System.out.println("email: " + resultSet.getString("email"));
            }
             */

            /* [JA-7] - UPDATE
            PreparedStatement preparedStatement = connection.prepareStatement(updatedSql);
            preparedStatement.setString(1, "Ahmet Mete");
            preparedStatement.setInt(2, 2);
            preparedStatement.executeUpdate();
             */

            PreparedStatement preparedStatement = connection.prepareStatement(deletedSql);
            preparedStatement.setInt(1,2);
            preparedStatement.executeUpdate();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}