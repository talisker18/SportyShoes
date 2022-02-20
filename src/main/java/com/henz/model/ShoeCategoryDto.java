package com.henz.model;

public class ShoeCategoryDto {
	
	private int shoeId;
	private String shoeBrand;
	private String shoeModel;
	private int categoryId;
	private String categoryText;
	private int price;
	
	public ShoeCategoryDto(int shoeId, String shoeBrand, String shoeModel, int categoryId, String categoryText, int price) {
		this.shoeId = shoeId;
		this.shoeBrand = shoeBrand;
		this.shoeModel = shoeModel;
		this.categoryId = categoryId;
		this.categoryText = categoryText;
		this.price = price;
	}

	public int getShoeId() {
		return shoeId;
	}

	public void setShoeId(int shoeId) {
		this.shoeId = shoeId;
	}

	public String getShoeBrand() {
		return shoeBrand;
	}

	public void setShoeBrand(String shoeBrand) {
		this.shoeBrand = shoeBrand;
	}

	public String getShoeModel() {
		return shoeModel;
	}

	public void setShoeModel(String shoeModel) {
		this.shoeModel = shoeModel;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryText() {
		return categoryText;
	}

	public void setCategoryText(String categoryText) {
		this.categoryText = categoryText;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
