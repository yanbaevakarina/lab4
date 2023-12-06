package usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import usermanagement.model.User;

public class UserDAO {
	
    private String jdbcURL = "jdbc:mysql://localhost/space?serverTimezone=Europe/Moscow&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "199920032004";
    
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "(name,email,password) VALUES" + "(?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "SELECT id,name,email,password from users where id=?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users;";
    private static final String DELETE_USERS_SQL = "DELETE FROM users where id=?;";
    private static final String UPDATE_USERS_SQL = "UPDATE users set name=?, email=?, password=? where id=?;";
    
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
    
    // добавление пользователя
    public void insertUser(User user) throws SQLException {
    	try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
	    		preparedStatement.setString((1), user.getName());
	    		preparedStatement.setString((2), user.getEmail());
	    		preparedStatement.setString((3), user.getPassword());
	    		preparedStatement.executeUpdate();
    			} catch(Exception e) {
    				e.printStackTrace();
    			}
    }
    // обновление информации о пользователе
        public boolean updateUser(User user) throws SQLException {
        	boolean rowUpdated = false;
        	try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)){
	    		statement.setString((1), user.getName());
	    		statement.setString((2), user.getEmail());
	    		statement.setString((3), user.getPassword());
        		statement.setInt(4,user.getId());
        		
        		rowUpdated = statement.executeUpdate()>0;
        			} catch(Exception e) {
        				e.printStackTrace();
        			} return rowUpdated;
    }
    // вывод информации о пользователе по id
        public User selectUser(int id) {
        	User user = null;
        	try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);){
        		preparedStatement.setInt((1), id);
        		ResultSet rs = preparedStatement.executeQuery();
        		
        		while(rs.next()) {
        			String name = rs.getString("name");
        			String email = rs.getString("email");
        			String password = rs.getString("password");
        			user = new User(id,name,email,password);
        		}
        	} catch(SQLException e) {
        		e.printStackTrace();
        	}return user;}
        	
     // вывод всей таблицы пользователей  	
        public List<User> selectAllUser() {
        	List<User> users = new ArrayList<>();

            try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
             	ResultSet rs = preparedStatement.executeQuery();
             		
             	while(rs.next()) {
             		int id = rs.getInt("id");
             		String name = rs.getString("name");
             		String email = rs.getString("email");
             		String password = rs.getString("password");
             		users.add(new User(id,name,email,password));
             	}
            } catch(SQLException e) {
             	e.printStackTrace();
        }return users;}
        
     // удаление пользователя 
        public boolean deleteUser(int id) throws SQLException{
        	boolean rowDeleted;
        	try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);){
        		statement.setInt((1), id);
        		rowDeleted = statement.executeUpdate()>0;
        		
        	}return rowDeleted;
        }
        
        
        
      
     
}
