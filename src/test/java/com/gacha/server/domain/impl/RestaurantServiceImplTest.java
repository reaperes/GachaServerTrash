package com.gacha.server.domain.impl;

import com.gacha.server.AbstractTest;
import com.gacha.server.domain.Restaurant;
import com.gacha.server.domain.RestaurantService;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static java.awt.geom.Point2D.distance;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Namhoon
 */
public class RestaurantServiceImplTest extends AbstractTest {
	private RestaurantService service;

	@Before
	public void before() {
		service = new RestaurantServiceImpl();
	}

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
}
