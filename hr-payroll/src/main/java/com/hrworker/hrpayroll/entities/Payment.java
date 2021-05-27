package com.hrworker.hrpayroll.entities;

public class Payment {

	private String name;
	private double dailyIncome;
	private int days;
	
	public Payment() {}
	
	public Payment(String name, double dailyIncome, int days) {
		this.name = name;
		this.dailyIncome = dailyIncome;
		this.days = days;
	}

	public String getName() {
		return name;
	}

	public double getDailyIncome() {
		return dailyIncome;
	}

	public int getDays() {
		return days;
	}

	public double getTotal() {
		return dailyIncome * days;
	}
	
}
