package com.gacha.server.controller;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Namhoon
 */
class ApiError {
	@Getter
	@Setter
	private String message;

	ApiError(Exception e) {
		this.message = e.getMessage();
	}
}
