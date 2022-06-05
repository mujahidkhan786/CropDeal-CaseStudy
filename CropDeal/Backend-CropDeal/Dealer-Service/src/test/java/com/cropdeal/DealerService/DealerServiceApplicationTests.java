package com.cropdeal.DealerService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cropdeal.DealerService.model.Dealer;
import com.cropdeal.DealerService.repository.DealerRepository;
import com.cropdeal.DealerService.resource.DealerController;



@SpringBootTest
class DealerServiceApplicationTests {
	@Autowired
	private DealerController service;
	

	@MockBean
	private DealerRepository dealerrepo;
	
	@Test
	public void adddealerTest() {
		Dealer dealer = new Dealer("1","abc","abc@gmail.com","12412414","12244",null);
		when(dealerrepo.save(dealer)).thenReturn(dealer);
		Dealer res=service.adddealer(dealer);
		assertEquals(dealer.getId(),res.getId());
	}
	@Test
	public void getdealerTest() {
		when(dealerrepo.findAll()).thenReturn(Stream
				.of(new Dealer("1","abc","abc@gmail.com","12412414","12244",null)).collect(Collectors.toList()));
		assertEquals(1, service.getdealer().size());
	}
	



	@Test
	public void deletedealerbyidTest() {
		String dealer = Dealer("1","abc","abc@gmail.com","12412414","12244",null);
		service.deleteDealer(dealer);
		verify(dealerrepo, times(1)).deleteById(dealer);
	}

	private String Dealer(String string, String string2, String string3, String string4, String string5,
			Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Test
	public void getdealerByIdTest() {
		String id="1";
		service.getdealer(id);
	    verify(dealerrepo).findById(id);
	}
//
//
//}

}
