package com.cropdeal.CropService.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CropService {
	@GetMapping("/crop")
	public String dealer() {
		return "crop list";
	}

}