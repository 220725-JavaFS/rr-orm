package com.ricketts.models;

import java.util.Objects;

public class Soda {
	
	private int sodaId;  
	private String brand; 
	private String flavor; 
	private int quantity; 
	private double ouncesPerCan; 
	private double price;
	
	
	public Soda() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Soda(int sodaId, String brand, String flavor, int quantity, double ouncesPerCan, double price) {
		super();
		this.sodaId = sodaId;
		this.brand = brand;
		this.flavor = flavor;
		this.quantity = quantity;
		this.ouncesPerCan = ouncesPerCan;
		this.price = price;
	}


	public Soda(String brand, String flavor, int quantity, double ouncesPerCan, double price) {
		super();
		this.brand = brand;
		this.flavor = flavor;
		this.quantity = quantity;
		this.ouncesPerCan = ouncesPerCan;
		this.price = price;
	}


	public int getSodaId() {
		return sodaId;
	}


	public void setSodaId(int sodaId) {
		this.sodaId = sodaId;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getFlavor() {
		return flavor;
	}


	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getOuncesPerCan() {
		return ouncesPerCan;
	}


	public void setOuncesPerCan(double ouncesPerCan) {
		this.ouncesPerCan = ouncesPerCan;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public int hashCode() {
		return Objects.hash(brand, flavor, ouncesPerCan, price, quantity, sodaId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Soda other = (Soda) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(flavor, other.flavor)
				&& Double.doubleToLongBits(ouncesPerCan) == Double.doubleToLongBits(other.ouncesPerCan)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity
				&& sodaId == other.sodaId;
	}


	@Override
	public String toString() {
		return "Soda [sodaId=" + sodaId + ", brand=" + brand + ", flavor=" + flavor + ", quantity=" + quantity
				+ ", ouncesPerCan=" + ouncesPerCan + ", price=" + price + "]";
	} 

	
	
}