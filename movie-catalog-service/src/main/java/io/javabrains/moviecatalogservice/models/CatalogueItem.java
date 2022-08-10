package io.javabrains.moviecatalogservice.models;

public class CatalogueItem {
	private int rating;
	private String name, desc;
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public CatalogueItem(int rating, String name, String desc) {
		super();
		this.rating = rating;
		this.name = name;
		this.desc = desc;
	}
	
}
