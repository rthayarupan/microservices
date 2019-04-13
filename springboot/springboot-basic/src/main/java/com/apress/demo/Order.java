package com.apress.demo;

import java.math.BigDecimal;

public class Order {

	public Order(String id, BigDecimal amount) {
		super();
		this.id = id;
		this.amount = amount;
	}

	private String id;
	private BigDecimal amount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return String.format("Order [id='%s', amount=%4.2f]", id, amount);
	}
}
