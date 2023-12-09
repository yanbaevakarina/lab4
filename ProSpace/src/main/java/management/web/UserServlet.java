package management.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import management.dao.UserDAO;
import management.model.User;


@WebServlet(urlPatterns = {"/new","/insert","/delete","/edit","/update", "/list"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    

    public UserServlet() {
    	this.userDAO = new UserDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String action = request.getServletPath();
		switch(action) {
		case "/new":
			showNewForm(request,response);
			break;
		case "/insert":
			try {
				insertUser(request,response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteUser(request,response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				showEditForm(request,response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			break;		
		case "/update":
			try {
				updateUser(request,response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/list":
			try {
				listUser(request,response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;		
		} 
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException{
	List <User> listUser = userDAO.selectAllUser();
	request.setAttribute("listUser", listUser);
	RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
	dispatcher.forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException{
	int id = Integer.parseInt(request.getParameter("id")); //получаем id запроса и вызываем метод удаления пользователя
	userDAO.deleteUser(id);
	response.sendRedirect("list"); // и перенаправляемся на страницу списка пользователей
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException{
	int id = Integer.parseInt(request.getParameter("id")); //получаем id запроса
	User existingUser = userDAO.selectUser(id); // получаем пользовательский объект и пересылаем этот пользовательский объект
	RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");//здесь будем редактировать наш пользовательский объект
	request.setAttribute("user", existingUser); // здесь будем отправлять нашего измененного пользователя
	dispatcher.forward(request, response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException{
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	User user = new User(id,name,email,password);
	userDAO.updateUser(user);
	response.sendRedirect("list");
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User newUser = new User(name,email,password);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
