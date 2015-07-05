package com.gacha.server.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Namhoon
 */
@Data
@EqualsAndHashCode(of = { "latitude", "longitude" })
public class Restaurant {
	private Long id;
	private double latitude;
	private double longitude;
	private String name;
	private int score;
}
