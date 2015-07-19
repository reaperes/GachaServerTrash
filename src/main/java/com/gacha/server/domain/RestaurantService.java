package com.gacha.server.domain;

import java.util.Collection;

/**
 * @author Namhoon
 */
public interface RestaurantService {
	void save(Restaurant restaurant);
	Restaurant find(long id);
	Collection<Restaurant> find(String name);
	Collection<Restaurant> find(double latitude, double longitude, double radius);
}
