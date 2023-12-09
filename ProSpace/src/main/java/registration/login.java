package registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/space?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String pass = "199920032004";
            Connection con = DriverManager.getConnection(url, username, pass);
			PreparedStatement pst = con.prepareStatement("select * from users where email = ? and password = ?");
			pst.setString(1, email);
			pst.setString(2,password);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				session.setAttribute("name", rs.getString("name"));
				session.setAttribute("id", rs.getInt("id"));
				dispatcher = request.getRequestDispatcher("index");
			}
			else {
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request,response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
