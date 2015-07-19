package com.gacha.server.controller;

/**
 * @author Namhoon
 */
public class ControllerException extends RuntimeException {
	public ControllerException(String message, Throwable t) {
		super(message, t);
	}
}
