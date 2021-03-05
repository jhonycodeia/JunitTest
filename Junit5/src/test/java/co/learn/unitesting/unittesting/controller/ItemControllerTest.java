package co.learn.unitesting.unittesting.controller;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import co.learn.unitesting.unittesting.business.ItemBusinessService;
import co.learn.unitesting.unittesting.model.Item;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;

	@Test
	public void testDummyItem() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);

		MvcResult response = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"value\":0}")).andReturn();

	}

	@Test
	public void testItemFromBusinessService() throws Exception {
		Mockito.when(businessService.retreiveHardcodedItem()).thenReturn(new Item(2, "Item2", 10, 10));

		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{id:2,name:Item2,price:10}")).andReturn();
		// JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),
		// false);
	}

	@Test
	public void testRetrieveAllItems() throws Exception {
		Mockito.when(businessService.retrieveAllItems()).thenReturn(
				Arrays.asList(new Item(2,"Item2",10,10),
						new Item(3,"Item3",20,20))
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("[{id:3,name:Item3,price:20}, {id:2,name:Item2,price:10}]"))
				.andReturn();
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void testRetrieveAllItems2() throws Exception {
		Mockito.when(businessService.retrieveAllItems()).thenReturn(
				Arrays.asList()
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("[]"))
				.andReturn();
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}

}
