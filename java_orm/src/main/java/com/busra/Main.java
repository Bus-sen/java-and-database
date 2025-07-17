package com.busra;

import com.busra.config.DataBaseConnectorConfig;
import com.busra.dao.UserDAOImpl;
import com.busra.user.User;
import com.busra.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();


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

        /* [JA-7] - DELETE
        String deletedSql = "DELETE FROM users WHERE id = ?";
         */


        //try {
            //DataBaseConnectorConfig.setConnection();
            //Connection connection = DataBaseConnectorConfig.getConnection();
            //System.out.println("Connected");

            //UserDAOImpl userDAO = new UserDAOImpl(connection);
            //userDAO.createTable();

            /*
            User user = new User(1, "Ahmet", "ahmet@mail.com");
            userDAO.save(user);
             */

            //userDAO.findAll();


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

            /* [JA-7] - DELETE
            PreparedStatement preparedStatement = connection.prepareStatement(deletedSql);
            preparedStatement.setInt(1,2);
            preparedStatement.executeUpdate();
             */

/*
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
*/
    }
}