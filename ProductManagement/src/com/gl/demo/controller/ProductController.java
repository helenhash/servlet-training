package com.gl.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gl.demo.dto.ProductDTO;
import com.gl.demo.service.ProductService;
import com.gl.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductController
 * @author giaule
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService productService;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("dbURL");
		String jdbcUsername = getServletContext().getInitParameter("dbUsername");
		String jdbcPassword = getServletContext().getInitParameter("dbPassword");
		
		this.productService = new ProductServiceImpl(jdbcURL, jdbcUsername, jdbcPassword);

	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		try {
			switch (action) {
			case "new":
				RequestDispatcher dispatcher = request.getRequestDispatcher("newProductForm.jsp");
				dispatcher.forward(request, response);
				break;
			case "insert":
				String name = request.getParameter("name");
				String des = request.getParameter("description");
				float price = Float.parseFloat(request.getParameter("price"));
	
				ProductDTO newProduct = new ProductDTO(name, des, price);
				this.productService.addNewProduct(newProduct);
				response.sendRedirect("product");
				break;
			case "delete":
				break;
			case "edit":
				this.showEditForm(request, response);
				break;
			case "update":
				this.updateProduct(request, response);
				break;
			default:
				this.getListProduct(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void getListProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		List<ProductDTO> listBook = this.productService.getAllProducts();
		request.setAttribute("listProduct", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDTO existingBook = this.productService.getProductById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("newProductForm.jsp");
		request.setAttribute("product", existingBook);
		dispatcher.forward(request, response);

	}
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String des = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));

		ProductDTO newProduct = new ProductDTO(id, name, des, price);
		this.productService.updateProduct(newProduct);
		response.sendRedirect("product");
	}
}
