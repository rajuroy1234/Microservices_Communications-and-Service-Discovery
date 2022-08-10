package io.javabrains.ratingscatalogservice.models;

public class Rating {
	private String name;
	private int ratings;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public Rating(String name, int ratings) {
		super();
		this.name = name;
		this.ratings = ratings;
	}
	
}
