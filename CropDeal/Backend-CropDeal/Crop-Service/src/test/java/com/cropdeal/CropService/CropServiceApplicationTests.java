package com.cropdeal.CropService;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cropdeal.CropService.model.Crop;
import com.cropdeal.CropService.repository.CropRepository;
import com.cropdeal.CropService.resource.CropController;



@RunWith(SpringRunner.class)
@SpringBootTest
class CropServiceApplicationTests {

	@Autowired
	private CropController service;
	

	@MockBean
	private CropRepository croprepo;
	
	@Test
	 void addcropTest() {
		Crop crop = new Crop("123","abcd","abc@123","34567889", null);
		when(croprepo.save(crop)).thenReturn(crop);
		Crop res=service.addcrop(crop);
		assertEquals(crop.getId(),res.getId());
	}
	@Test
	 void getCropTest() {
		when(croprepo.findAll()).thenReturn(Stream
				.of(new Crop("123","abcd","abc@123","34567889", null),new Crop("321","cba","cba@321","34567889", null)).collect(Collectors.toList()));
		assertEquals(2, service.getcrop().size());
	}
	

//	@Test
//	public void addcropTest() {
//		Crop crop = new Crop("999", "def","def@33", "234567",null);
//		when(croprepo.save(crop)).thenReturn(crop);
//		assertEquals(Crop, service.addcrop(crop));
//	}
	

	@Test
	 void deleteCropbyidTest() {
		String crop = Farmer("999", "def","def@33", "234567",null);
		service.deletecrop(crop);
		verify(croprepo, times(1)).deleteById(crop);
	}

	private String Farmer(String string, String string2, String string3, String string4, Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Test
	 void getCropByIdTest() {
		String id="2";
		service.getcrop(id);
	    verify(croprepo).findById(id);
	}


}
