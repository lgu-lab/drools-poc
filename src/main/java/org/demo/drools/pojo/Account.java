package org.demo.drools.pojo;

public class Account {

	private final String id;
	
	private int amount;

	public Account(String id, int amount) {
		super();
		this.id = id;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public int getAmount() {
		return amount;
	}

//	public void setBalance(int amount) {
//		this.amount = amount;
//	}

	public void withdraw(int money) {
		amount -= money;
	}
}
