package com.boot;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipwreckController sc;

	@Test
	public void shipwreckGetTest() {
		Optional<Shipwreck> s=sc.get(1L);
		assertEquals(1L,s.get().getId().longValue());
	}
	
}
