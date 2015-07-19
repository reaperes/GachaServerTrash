package com.gacha.server.domain;

import com.gacha.server.AbstractIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Namhoon
 */
public class RestaurantRepositoryIntegrationTest extends AbstractIntegrationTest {
	@Autowired
	private RestaurantRepository repository;

	@Test
	public void repository__should_be_not_null() {
		Assert.assertNotNull(repository);
	}
}
