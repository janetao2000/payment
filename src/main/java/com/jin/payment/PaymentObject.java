package com.jin.payment;

import java.sql.Date;

public class PaymentObject implements Comparable{
	private int paymentNumber;
	private double amount;
	private Date date;
	
	public PaymentObject(int paymentNumber, double amount, Date date) {
		super();
		this.paymentNumber = paymentNumber;
		this.amount = amount;
		this.date = date;
	}
	public int getPaymentNumber() {
		return paymentNumber;
	}
	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public int compareTo(Object o) {
		return this.date.compareTo(((PaymentObject)o).date);
	}
	@Override
	public String toString() {
		return "PaymentObject [paymentNumber=" + paymentNumber + ", amount=" + amount + ", date=" + date.toString() + "]";
	}
	
}
