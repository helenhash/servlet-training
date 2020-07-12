package com.gl.demo.dto;

/**
 * Product DTO.
 * @author giaule
 *
 */
public class ProductDTO {
	private int id;
	private String name;
	private String description;
	private float price;
	
	
	public int getId() {
		return id;
	}
	public ProductDTO(int id, String name, String description, float price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	
	public ProductDTO(String name, String description, float price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	} 
	
	
}
