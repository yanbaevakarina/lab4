package management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import management.model.Product;

public class ProductDAO {
	
    private String jdbcURL = "jdbc:mysql://localhost/space?serverTimezone=Europe/Moscow&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "199920032004";
    
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO products" + "(name,price) VALUES" + "(?, ?);";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT id,name,price from products where id=?;";
    private static final String SELECT_ALL_PRODUCT = "SELECT * FROM products;";
    private static final String DELETE_PRODUCT_SQL = "DELETE FROM products where id=?;";
    private static final String UPDATE_PRODUCT_SQL = "UPDATE products set name=?, price=? where id=?;";
    
    protected Connection getConnection() {
    	Connection connection=null;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
    	} catch(SQLException e) {
    		e.printStackTrace();
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}return connection;
    }
    
    // добавление продукта
    public void insertProduct(Product product) throws SQLException {
    	try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)){
	    		preparedStatement.setString((1), product.getName());
	    		preparedStatement.setInt((2), product.getPrice());
	    		preparedStatement.executeUpdate();
    			} catch(Exception e) {
    				e.printStackTrace();
    			} 
    }
    // обновление информации о продукте
        public boolean updateProduct(Product product) throws SQLException {
        	boolean rowUpdated = false;
        	try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL)){
	    		statement.setString((1), product.getName());
	    		statement.setInt((2), product.getPrice());
        		statement.setInt(3,product.getId());
        		
        		rowUpdated = statement.executeUpdate()>0;
        			} catch(Exception e) {
        				e.printStackTrace();
        			} return rowUpdated;
    }
    // вывод информации о продукте по id
        public Product selectProduct(int id) {
        	Product product = null;
        	try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);){
        		preparedStatement.setInt((1), id);
        		ResultSet rs = preparedStatement.executeQuery();
        		
        		while(rs.next()) {
        			String name = rs.getString("name");
        			int price = rs.getInt("price");
        			product = new Product(id,name,price);
        		}
        	} catch(SQLException e) {
        		e.printStackTrace();
        	}return product;}
        	
     // вывод всей таблицы продуктов 	
        public List<Product> selectAllProduct() {
        	List<Product> products = new ArrayList<>();

            try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);){
             	ResultSet rs = preparedStatement.executeQuery();
             		
             	while(rs.next()) {
             		int id = rs.getInt("id");
             		String name = rs.getString("name");
             		int price = rs.getInt("price");
             		products.add(new Product(id,name,price));
             	}
            } catch(SQLException e) {
             	e.printStackTrace();
        }return products;}
        
     // удаление продукта
        public boolean deleteProduct(int id) throws SQLException{
        	boolean rowDeleted;
        	try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);){
        		statement.setInt((1), id);
        		rowDeleted = statement.executeUpdate()>0;
        		
        	}return rowDeleted;
        }
        
        
        
      
     
}
