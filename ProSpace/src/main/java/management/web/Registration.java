package management.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import management.dao.UserDAO;
import management.model.User;


@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    

    public Registration() {
    	this.userDAO = new UserDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String action = request.getServletPath();
		switch(action) {
		case "/registration":
			try {
				insertUser(request,response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;		
		} 
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User newUser = new User(name,email,password);
		userDAO.insertUser(newUser);
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
