package com.gacha.server.domain.impl;

import com.gacha.server.AbstractTest;
import com.gacha.server.TestSupports;
import com.gacha.server.domain.Restaurant;
import com.gacha.server.domain.RestaurantException;
import com.gacha.server.domain.RestaurantRepository;
import com.gacha.server.domain.RestaurantService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Namhoon
 */
public class RestaurantServiceImplTest extends AbstractTest {
	@InjectMocks
	private RestaurantServiceImpl service;

	@Mock
	private RestaurantRepository repository;

	@Test
	public void find__should_return_restaurants__which_distance_is_less_then_radius() {
		final double lat = 1d;
		final double lng = 1d;
		final double rad = 0.1d;

		Collection<Restaurant> restaurants = service.find(lat, lng, rad);
		for (Restaurant r : restaurants) {
			assertTrue(Math.abs(r.getLatitude() - lat) <= rad);
			assertTrue(Math.abs(r.getLongitude() - lng) <= rad);
			assertNotNull(r.getName());
			assertNotNull(r.getScore());
		}
	}

	@Test
	public void save__should_fail__when_score_is_over_100() {
		Restaurant restaurant = TestSupports.createRestaurant();
		restaurant.setScore(101);

		try {
			service.save(restaurant);
			Assert.fail();
		} catch (RestaurantException e) {
		}

		Mockito.verify(repository, Mockito.never()).save(restaurant);
	}
}
