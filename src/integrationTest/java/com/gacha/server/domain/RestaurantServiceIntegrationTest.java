package com.gacha.server.domain;

import com.gacha.server.AbstractIntegrationTest;
import com.gacha.server.TestSupports;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Namhoon
 */
public class RestaurantServiceIntegrationTest extends AbstractIntegrationTest {
	@Autowired
	private RestaurantService service;

	@Test
	public void save_and_find__should_succeed() {
		final String name = "test";

		Assert.assertThat(service.find("test").isEmpty(), CoreMatchers.is(true));

		Restaurant restaurant = TestSupports.createRestaurant();
		restaurant.setName(name);
		service.save(restaurant);

		Assert.assertThat(service.find("test").isEmpty(), CoreMatchers.is(false));
	}
}
