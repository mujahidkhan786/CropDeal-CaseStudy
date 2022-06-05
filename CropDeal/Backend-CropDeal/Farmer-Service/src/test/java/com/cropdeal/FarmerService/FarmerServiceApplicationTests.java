package com.cropdeal.FarmerService;



import static org.mockito.Mockito.times;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.cropdeal.FarmerService.models.Farmer;
import com.cropdeal.FarmerService.repository.FarmerRepository;
import com.cropdeal.FarmerService.resource.FarmerController;


@RunWith(SpringRunner.class)
@SpringBootTest
class FarmerServiceApplicationTests {

	
	@Autowired
	private FarmerController service;
	

	@MockBean
	private FarmerRepository farmerrepo;
	@Test
	public void getFarmerTest() {
		when(farmerrepo.findAll()).thenReturn(Stream
				.of(new Farmer("123","abcd","abc@123","34567889", null),new Farmer("321","cba","cba@321","34567889", null)).collect(Collectors.toList()));
		assertEquals(2, service.getfarmer().size());
	}
	

	@Test
	public void addfarmerTest() {
		Farmer farmer = new Farmer("999", "def","def@33", "234567",null);
		when(farmerrepo.save(farmer)).thenReturn(farmer);
		assertEquals(farmer, service.addfarmer(farmer));
	}

	@Test
	public void deleteFarmerbyidTest() {
		String farmer = Farmer("999", "def","def@33", "234567",null);
		service.deleteFarmer(farmer);
		verify(farmerrepo, times(1)).deleteById(farmer);
	}

	private String Farmer(String string, String string2, String string3, String string4, Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	@Test
//	public void getFarmerbyIdTest() {
//		String id = "321";
//		((Stream) when(farmerrepo.findById(id))
//				.thenReturn(Optional.empty())).collect(Collectors.toList());
//		assertEquals(1, service.getfarmer(id));
//	}

	

}
