package com.gl.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.gl.demo.dto.ProductDTO;

/**
 * Interface for Product DAO.
 * @author giaule
 *
 */
public interface ProductDAO {
	List<ProductDTO> getAllProducts() throws SQLException;
	boolean addNewProduct(ProductDTO newProduct) throws SQLException;
	boolean updateProduct(ProductDTO product) throws SQLException;
	boolean deleteProduct(ProductDTO product)throws SQLException;
	ProductDTO getProductById(int id) throws SQLException;
}
