package io.javabrains.moviecatalogservice.models;

import java.util.List;

public class UserRating {
	private List<Rating> userRating;
	
	public List<Rating> getUserRating(){
		return userRating;
	}
	
	/*
	public void displayUserRating() {
		List<Rating> userRating = this.userRating;
		for(int i=0;i<userRating.size();i++) {
			System.out.println(userRating[i]);
		}
	}
	*/
	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}
}
