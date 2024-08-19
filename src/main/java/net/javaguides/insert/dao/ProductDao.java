package net.javaguides.insert.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ner.javaguides.insert.model.Product;

public class ProductDao {

	public int insertProduct(Product product) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO products" + "(name, description, price) VALUES" + "(?, ?, ?)";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_dev", "root", "");
				
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setDouble(3, product.getPrice());
			
			System.out.println(preparedStatement);
			
			result = preparedStatement.executeUpdate();
		} catch (SQLException e ) {
			printSQLException(e);
		}
		
		return result;
	}
	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
