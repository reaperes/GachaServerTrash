package com.gacha.server.controller;

import com.gacha.server.AbstractTest;
import com.gacha.server.TestSupports;
import com.gacha.server.domain.Restaurant;
import com.gacha.server.domain.RestaurantService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author Namhoon
 */
public class RestaurantsControllerTest extends AbstractTest {
	@Mock private RestaurantService service;

	@InjectMocks private RestaurantsController controller;

	private MockMvc mockMvc;

	@Before
	public void before() {
		mockMvc = standaloneSetup(controller).build();
	}

	@Test
	public void GET_restaurants__should_return_restaurants() throws Exception {
		when(service.find(any(double.class), any(double.class), any(double.class))).then(invocation -> new ArrayList<Restaurant>() {{
			add(TestSupports.restaurantBuilder()
							.build());
		}});
		ResultActions actions = mockMvc.perform(get("/restaurants").param("latitude", "1")
																   .param("longitude", "1")
																   .param("radius", "1"));

		actions.andExpect(status().isOk())
			   .andExpect(content().contentType("application/json;charset=UTF-8"))
			   .andExpect(jsonPath("$[0].id").exists())
			   .andExpect(jsonPath("$[0].latitude").exists())
			   .andExpect(jsonPath("$[0].longitude").exists())
			   .andExpect(jsonPath("$[0].name").exists())
			   .andExpect(jsonPath("$[0].score").exists());
	}
}
