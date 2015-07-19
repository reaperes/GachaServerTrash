package com.gacha.server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gacha.server.AbstractIntegrationTest;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Namhoon
 */
public class RestaurantsControllerIntegrationTest extends AbstractIntegrationTest {
	@Test
	public void GET_restaurants__should_return_restaurant_array() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		URI uri = UriComponentsBuilder.fromHttpUrl(getServerUrl() + "/restaurants")
									  .queryParam("latitude", 1d)
									  .queryParam("longitude", 1d)
									  .queryParam("radius", 1d)
									  .build()
									  .encode()
									  .toUri();

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		String json = response.getBody();
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		assertThat(JsonPath.read(json, "$[0].id"), notNullValue());
		assertThat(JsonPath.read(json, "$[0].latitude"), notNullValue());
		assertThat(JsonPath.read(json, "$[0].longitude"), notNullValue());
		assertThat(JsonPath.read(json, "$[0].name"), notNullValue());
		assertThat(JsonPath.read(json, "$[0].score"), notNullValue());
	}

	@Test
	public void POST_restaurant__should_return_200_OK() throws JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		RestaurantsController.RestaurantDto dto = new RestaurantsController.RestaurantDto();
		dto.setLatitude(0);
		dto.setLongitude(0);
		dto.setName("test");
		dto.setScore(100);

		ObjectMapper objectMapper = new ObjectMapper();
		HttpEntity<?> entity = new HttpEntity<>(objectMapper.writeValueAsString(dto), headers);

		URI uri = UriComponentsBuilder.fromHttpUrl(getServerUrl() + "/restaurants")
									  .queryParam("latitude", 1d)
									  .queryParam("longitude", 1d)
									  .queryParam("radius", 1d)
									  .build()
									  .encode()
									  .toUri();

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}
}
