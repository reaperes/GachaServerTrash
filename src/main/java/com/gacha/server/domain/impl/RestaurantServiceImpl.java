package com.gacha.server.domain.impl;

import com.gacha.server.domain.Restaurant;
import com.gacha.server.domain.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * @author Namhoon
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Override
	public Collection<Restaurant> find(double latitude, double longitude, double radius) {
		final int numOfRestaurants = 11;

		Collection<Restaurant> restaurants = new ArrayList<>();
		for (int i = 0; i < numOfRestaurants; i++) {
			Restaurant restaurant = new Restaurant();
			restaurant.setId((long) i);
			restaurant.setLatitude(generateRandomValue(latitude, -radius, radius));
			restaurant.setLongitude(generateRandomValue(longitude, -radius, radius));
			restaurant.setName("Dummy data " + i);
			restaurant.setScore(i * 10);

			restaurants.add(restaurant);
		}

		return restaurants;
	}

	private double generateRandomValue(double latitude, double min, double max) {
		Random random = new Random();
		double randomValue = min + (max - min) * random.nextDouble();
		latitude += randomValue;
		return latitude;
	}
}
