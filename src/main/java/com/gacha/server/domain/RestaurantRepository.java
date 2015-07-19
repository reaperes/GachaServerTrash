package com.gacha.server.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Collection;

/**
 * @author Namhoon
 */
public interface RestaurantRepository extends Repository<Restaurant, Long>, CrudRepository<Restaurant, Long> {
	Collection<Restaurant> findByName(String name);
}
