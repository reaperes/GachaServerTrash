package com.gacha.server.controller;

import com.gacha.server.domain.Restaurant;
import com.gacha.server.domain.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Namhoon
 */
@RestController
@RequestMapping("/restaurants")
public class RestaurantsController {
	@Autowired
	private RestaurantService service;

	@RequestMapping(method = RequestMethod.GET, value = { "", "/" })
	public @ResponseBody Collection<Restaurant> get(
			@RequestParam("latitude") double latitude,
			@RequestParam("longitude") double longitude,
			@RequestParam("radius") double radius
	) {
		try {
			return service.find(latitude, longitude, radius);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
