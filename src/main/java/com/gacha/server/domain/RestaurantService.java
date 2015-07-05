package com.gacha.server.domain;

import java.util.Collection;

/**
 * @author Namhoon
 */
public interface RestaurantService {
	Collection<Restaurant> find(double latitude, double longitude, double radius);
}
