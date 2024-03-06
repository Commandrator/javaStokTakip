/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uruntakipprogrami;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author CASPER
 */
public class DatabaseFunctions {
    Connection connection = DatabaseConnection.getConnection();

    public void getUrun() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("call getAllUrun();")) {
            System.out.printf("\u001B[33m%-5s %-20s %-30s\n", "ID", "Name", "Content");
            System.out.println("--------------------------------------------------");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String content = resultSet.getString("content");
                System.out.printf("%-5d %-20s %-30s\n", id, name, content);
            }
            System.out.println("--------------------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUrun(String name, String content) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("CALL insertUrun(?, ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, content);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUrun(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("CALL deleteUrun(?)")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchUrun(String namePattern, String contentPattern){
        try (CallableStatement callableStatement = (CallableStatement) connection.prepareCall("{CALL searchUrun(?, ?)}")) {
            callableStatement.setString(1, namePattern);
            callableStatement.setString(2, contentPattern);
            ResultSet resultSet = callableStatement.executeQuery();

            System.out.printf("\u001B[33m%-5s %-20s %-30s\n", "ID", "Name", "Content");
            System.out.println("--------------------------------------------------");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String urunName = resultSet.getString("name");
                String urunContent = resultSet.getString("content");
                System.out.printf("%-5d %-20s %-30s\n", id, urunName, urunContent);
            }
            System.out.println("--------------------------------------------------");

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
