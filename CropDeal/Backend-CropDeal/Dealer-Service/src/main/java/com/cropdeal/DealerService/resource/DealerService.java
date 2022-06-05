package com.cropdeal.DealerService.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DealerService {
	@GetMapping("/dealer")
	public String dealer() {
		return "deler list";
	}
	

}

