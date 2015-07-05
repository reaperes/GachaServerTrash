package com.gacha.server;

import com.gacha.server.domain.Restaurant;

/**
 * @author Namhoon
 */
public class TestSupports {
	public static RestaurantBuilder restaurantBuilder() {
		return new RestaurantBuilder();
	}
	
	public static class RestaurantBuilder {
		private Long id = 0L;
		private double latitude = 0;
		private double longitude = 0;
		private String name = "test";
		private int score = 50;
		
		private RestaurantBuilder() {
		}
		
		public RestaurantBuilder id(Long id) {
			this.id = id;
			return this;
		}
		
		public RestaurantBuilder latitude(double latitude) {
			this.latitude = latitude;
			return this;
		}
		
		public RestaurantBuilder longitude(double longitude) {
			this.longitude = longitude;
			return this;
		}
		
		public RestaurantBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public RestaurantBuilder score(int score) {
			this.score = score;
			return this;
		}

		public Restaurant build() {
			Restaurant restaurant = new Restaurant();
			restaurant.setId(this.id);
			restaurant.setLatitude(this.latitude);
			restaurant.setLongitude(this.longitude);
			restaurant.setName(this.name);
			restaurant.setScore(this.score);

			return restaurant;
		}
	}
}
