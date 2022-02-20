package com.henz.model;

public class PurchaseCategoryDto {
	
	private int purchaseId;
	private String purchaseDate;
	private String categoryText;
	private int userId;
	
	public PurchaseCategoryDto(int purchaseId, String purchaseDate, String categoryText, int userId) {
		this.purchaseId = purchaseId;
		this.purchaseDate = purchaseDate;
		this.categoryText = categoryText;
		this.userId = userId;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getCategoryText() {
		return categoryText;
	}

	public void setCategoryText(String categoryText) {
		this.categoryText = categoryText;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
