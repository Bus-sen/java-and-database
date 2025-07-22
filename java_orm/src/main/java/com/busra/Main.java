package com.busra;

import com.busra.config.DataBaseConnectorConfig;
import com.busra.dao.ProductDAO;
import com.busra.dao.ProductDAOImpl;
import com.busra.dao.UserDAOImpl;
import com.busra.model.Student;
import com.busra.service.ProductService;
import com.busra.user.User;
import com.busra.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAOImpl();
        ProductService service = new ProductService(productDAO);
        //service.insertProduct("Pencil",12.8);
        //service.deleteProduct(3);
        service.updateProduct(2,"Notebook",57.3);



        System.out.println("--------------------------------"); // [JA-19] ve öncesi
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            //Student student = new Student("Büşra","Şen");
            //session.persist(student);

            /* [JA-15] + [JA-16]
            Student readStudent = session.byId(Student.class).load(student.getId());    //get()
            System.out.println(readStudent.getName());

            readStudent.setName("Ahmet");
            session.persist(readStudent);
             */

            /* [JA-17]
            Student deleteStudent = session.byId(Student.class).load("3");
            session.remove(deleteStudent);  //delete
             */

            /* [JA-19]
            Student student = new Student("John", "Doe");
            session.persist(student);
            if (student.getName() != "Büşra")
                throw new IllegalArgumentException("Name is wrong");
            tx.commit();
             */
        } catch (Exception e) {
            if (tx != null){
                tx.rollback();
                //System.out.println("Roll back");
            }
            e.printStackTrace();
        }


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