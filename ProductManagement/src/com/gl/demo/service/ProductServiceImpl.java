package com.gl.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.gl.demo.dao.ProductDAO;
import com.gl.demo.dao.ProductDAOImpl;
import com.gl.demo.dto.ProductDTO;

/**
 * Product Service Implement.
 * @author giaule
 *
 */
public class ProductServiceImpl implements ProductService{
	private ProductDAO productDAO;
	
	
	public ProductServiceImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.productDAO = new ProductDAOImpl(jdbcURL, jdbcUsername, jdbcPassword);
	}

	@Override
	public List<ProductDTO> getAllProducts() throws SQLException {
		return this.productDAO.getAllProducts();
	}

	@Override
	public boolean addNewProduct(ProductDTO newProduct) throws SQLException {
		return this.productDAO.addNewProduct(newProduct);
	}

	@Override
	public boolean updateProduct(ProductDTO product) throws SQLException {
		return this.productDAO.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(ProductDTO product) throws SQLException {
		return this.productDAO.deleteProduct(product);
	}

	@Override
	public ProductDTO getProductById(int id) throws SQLException {
		return this.productDAO.getProductById(id);
	}

}
