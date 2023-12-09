package management.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import management.model.Basket;
import management.model.Product;

public class BasketDAO {
	
    private String jdbcURL = "jdbc:mysql://localhost/space?serverTimezone=Europe/Moscow&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "199920032004";
    private static final String INSERT_BASKET_SQL = "INSERT INTO basket" + "(idusers,idproduct,price) VALUES" + "(?, ?, ?);";
    private static final String SELECT_BASKET_BY_ID = "SELECT * from basket where idusers=?;";
    private static final String SELECT_ALL_BASKET = "SELECT * FROM basket;";
    private static final String DELETE_BASKET_SQL = "DELETE FROM basket where id=?;";
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
    
    // добавление товара в корзину
    public void insertBasket(Basket basket) throws SQLException {
    	try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BASKET_SQL)){
    		preparedStatement.setInt((1), basket.getIdusers());
    		preparedStatement.setInt((2), basket.getIdproduct());
    		preparedStatement.setInt((3), basket.getPrice());
    		preparedStatement.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			}
    }

    // вывод корзины по пользователю
        public List <Basket> selectBasket(int idusers) {
        	List <Basket> baskets = new ArrayList<>();
        	try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_BASKET_BY_ID);){
        		statement.setInt(1, idusers);
        		ResultSet rs = statement.executeQuery();
        		
             	while(rs.next()) {
             		int id = rs.getInt("id");
             		int idproduct = rs.getInt("idproduct");
             		int price = rs.getInt("price");
             		baskets.add(new Basket(id,idusers,idproduct,price));
             	}
        		}
	        	 catch(SQLException e) {
	        		e.printStackTrace();
	        	}return baskets;}

    
    	public List <Basket> selectAllBasket() {
    	List <Basket> baskets = new ArrayList<>();

        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BASKET);){
         	ResultSet rs = preparedStatement.executeQuery();
         		
         	while(rs.next()) {
         		int id = rs.getInt("id");
         		int idusers = rs.getInt("idusers");
         		int idproduct = rs.getInt("idproduct");
         		int price = rs.getInt("price");
         		baskets.add(new Basket(id,idusers,idproduct,price));
         	}
    		}
        	 catch(SQLException e) {
        		e.printStackTrace();
        	}return baskets;}
        
     // удаление товара из корзины
        public boolean deleteBasket(int id) throws SQLException{
        	boolean rowDeleted;
        	try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BASKET_SQL);){
        		statement.setInt((1), id);
        		rowDeleted = statement.executeUpdate()>0;
        		
        	}return rowDeleted;
        }
   
}
