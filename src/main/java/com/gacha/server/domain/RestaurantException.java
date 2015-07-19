package com.gacha.server.domain;

/**
 * @author Namhoon
 */
public class RestaurantException extends RuntimeException {
	public RestaurantException(String message, Throwable t) {
		super(message, t);
	}
}
