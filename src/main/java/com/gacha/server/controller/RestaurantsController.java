package com.gacha.server.controller;

import com.gacha.server.domain.Restaurant;
import com.gacha.server.domain.RestaurantService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public
	@ResponseBody
	Collection<Restaurant> get(
			@RequestParam("latitude") double latitude,
			@RequestParam("longitude") double longitude,
			@RequestParam("radius") double radius) {
		try {
			return service.find(latitude, longitude, radius);
		} catch (Exception e) {
			throw new ControllerException("Failed GET restaurants operation - latitude : " + latitude + ", longitude : " + longitude +
					", radius : " + radius, e);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = { "", "/" })
	@ResponseStatus(value = HttpStatus.OK)
	public void save(@RequestBody RestaurantDto dto) {
		Restaurant restaurant = dto.convertToRestaurant();
		try {
			service.save(restaurant);
		} catch (Exception e) {
			throw new ControllerException("Failed Save restaurant data - " + restaurant.toString(), e);
		}
	}

	@Getter
	@Setter
	static class RestaurantDto {
		private double latitude;
		private double longitude;
		private String name;
		private int score;

		Restaurant convertToRestaurant() {
			Restaurant restaurant = new Restaurant();
			restaurant.setLatitude(latitude);
			restaurant.setLongitude(longitude);
			restaurant.setName(name);
			restaurant.setScore(score);

			return restaurant;
		}
	}
}
