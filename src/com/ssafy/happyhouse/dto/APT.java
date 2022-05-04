package com.ssafy.happyhouse.dto;

public class APT {
	private String name;
	private String price;
	private double area;
	private String date;
	private double lat;
	private double lng;
	public APT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public APT(String name, String price, double area, String date, double lat, double lng) {
		super();
		this.name = name;
		this.price = price;
		this.area = area;
		this.date = date;
		this.lat = lat;
		this.lng = lng;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	@Override
	public String toString() {
		return "APT [name=" + name + ", price=" + price + ", area=" + area + ", date=" + date + ", lat=" + lat
				+ ", lng=" + lng + "]";
	}
	
		
	
	
}
