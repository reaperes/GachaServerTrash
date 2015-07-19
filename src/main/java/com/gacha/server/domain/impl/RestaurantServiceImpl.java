package com.gacha.server.domain.impl;

import com.gacha.server.domain.Restaurant;
import com.gacha.server.domain.RestaurantException;
import com.gacha.server.domain.RestaurantRepository;
import com.gacha.server.domain.RestaurantService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * @author Namhoon
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantRepository repository;

	@Override
	public void save(Restaurant restaurant) {
		try {
			Preconditions.checkArgument(restaurant.getScore() >= 0 && restaurant.getScore() <= 100, "Score must be gte 0 and lte 100");
			repository.save(restaurant);
		} catch (Exception e) {
			throw new RestaurantException("Can not save Restaurant name - " + restaurant.getName(), e);
		}
	}

	@Override
	public Restaurant find(long id) {
		try {
			return repository.findOne(id);
		} catch (Exception e) {
			throw new RestaurantException("Can not find Restaurant id - " + id, e);
		}
	}

	@Override
	public Collection<Restaurant> find(String name) {
		try {
			return repository.findByName(name);
		} catch (Exception e) {
			throw new RestaurantException("Can not find Restaurant by name - " + name, e);
		}
	}

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
