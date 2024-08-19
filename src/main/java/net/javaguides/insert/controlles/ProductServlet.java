package net.javaguides.insert.controlles;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ner.javaguides.insert.model.Product;
import net.javaguides.insert.dao.ProductDao;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/index")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductDao productDao = new ProductDao();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/create.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		
		Product product = new Product(name, description, Double.parseDouble(price));
		
		try {
			productDao.insertProduct(product);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);
	}

}
