package pl.akdg.carrental.dto;

import java.util.Date;

public class MyRentals {
	String mark;
	String model;
	Date rental_date;
	Date return_date;
	int price;
	
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Date getRental_date() {
		return rental_date;
	}
	public void setRental_date(Date rental_date) {
		this.rental_date = rental_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public MyRentals(String mark, String model, Date rental_date, Date return_date, int price) {
		super();
		this.mark = mark;
		this.model = model;
		this.rental_date =  rental_date;
		this.return_date =  return_date;
		this.price = price;
	}
}
