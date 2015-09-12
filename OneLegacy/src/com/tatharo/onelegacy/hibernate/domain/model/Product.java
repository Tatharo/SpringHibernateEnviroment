package com.tatharo.onelegacy.hibernate.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productstest")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
	private long id;
	private String testTable;
	private boolean falseOrTrue;
    
    
	
	public Product(String testTable, boolean falseOrTrue) {
		super();
		this.testTable = testTable;
		this.falseOrTrue = falseOrTrue;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTestTable() {
		return testTable;
	}
	public void setTestTable(String testTable) {
		this.testTable = testTable;
	}
	public boolean isFalseOrTrue() {
		return falseOrTrue;
	}
	public void setFalseOrTrue(boolean falseOrTrue) {
		this.falseOrTrue = falseOrTrue;
	}
}
