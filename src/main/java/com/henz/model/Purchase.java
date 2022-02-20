package com.henz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchases")
public class Purchase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String purchase_date;;
	private int fk_category_id;
	private int fk_user_id;
	
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public int getFk_category_id() {
		return fk_category_id;
	}

	public void setFk_category_id(int fk_category_id) {
		this.fk_category_id = fk_category_id;
	}

	public int getFk_user_id() {
		return fk_user_id;
	}

	public void setFk_user_id(int fk_user_id) {
		this.fk_user_id = fk_user_id;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", purchase_date=" + purchase_date + ", fk_category_id=" + fk_category_id
				+ ", fk_user_id=" + fk_user_id + "]";
	}
}
