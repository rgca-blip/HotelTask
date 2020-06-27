package com.Hotel.RoomBookingManagementSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Hotel.RoomBookingManagementSystem.Entity.CustomerEntity;

@SpringBootTest
class RoomBookingManagementSystemApplicationTests extends CustomerTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getProductsList() throws Exception {
		String uri = "/all";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		CustomerEntity[] productlist = super.mapFromJson(content, CustomerEntity[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	public void createProduct() throws Exception {
		String uri = "/add";
		CustomerEntity customer = new CustomerEntity(1, "abc", "cde", new Date(5), "jsd@djs", "sjhjsasa");
		/*
		 * customer.setCustomer_id(1l); customer.setFirstname("abc");
		 * customer.setLastname("cde"); customer.setDob(new Date(5));
		 * customer.setEmail("jsd@djs"); customer.setPassword("sjhjsasa");
		 */
		String inputJson = super.mapToJson(customer);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Customer is created successfully");
	}
}
