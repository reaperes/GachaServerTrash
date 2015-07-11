package com.gacha.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Namhoon
 */
@RestController
public class HealthCheckController {
	@RequestMapping(method = RequestMethod.GET, value = { "/ping" })
	@ResponseBody
	public String ping() {
		return "pong";
	}
}
