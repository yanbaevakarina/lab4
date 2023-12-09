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

import management.dao.ProductDAO;
import management.model.Product;


@WebServlet(urlPatterns = {"/new_pr","/insert_pr","/delete_pr","/edit_pr","/update_pr", "/list_pr","/index"})
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    

    public ProductServlet() {
    	this.productDAO = new ProductDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String action = request.getServletPath();
		switch(action) {
		case "/new_pr":
			showNewForm(request,response);
			break;
		case "/insert_pr":
			try {
				insertProduct(request,response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/delete_pr":
			try {
				deleteProduct(request,response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/edit_pr":
			try {
				showEditForm(request,response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			break;		
		case "/update_pr":
			try {
				updateProduct(request,response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/list_pr":
			try {
				listProduct(request,response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/index":
			try {
				listProductIndex(request,response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;		
		} 
	}
	
	private void listProduct(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException{
	List <Product> listProduct = productDAO.selectAllProduct();
	request.setAttribute("listProduct", listProduct);
	RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
	dispatcher.forward(request, response);
	}
	private void listProductIndex(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException{
	List <Product> listProduct = productDAO.selectAllProduct();
	request.setAttribute("listProduct", listProduct);
	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	dispatcher.forward(request, response);
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException{
	int id = Integer.parseInt(request.getParameter("id")); //получаем id запроса и вызываем метод удаления пользователя
	productDAO.deleteProduct(id);
	response.sendRedirect("list_pr"); // и перенаправляемся на страницу списка пользователей
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException{
	int id = Integer.parseInt(request.getParameter("id")); //получаем id запроса
	Product existingProduct = productDAO.selectProduct(id); // получаем пользовательский объект и пересылаем этот пользовательский объект
	RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");//здесь будем редактировать наш пользовательский объект
	request.setAttribute("product", existingProduct); // здесь будем отправлять нашего измененного пользователя
	dispatcher.forward(request, response);
	}
	
	private void updateProduct(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException{
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	int price = Integer.parseInt(request.getParameter("price"));
	Product product = new Product(id,name,price);
	productDAO.updateProduct(product);
	response.sendRedirect("list_pr");
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
		dispatcher.forward(request, response);
	}
	private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		Product newProduct = new Product(name,price);
		productDAO.insertProduct(newProduct);
		response.sendRedirect("list_pr");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
