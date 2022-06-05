package com.cropdeal.DealerService.resource;

import java.util.Arrays;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cropdeal.DealerService.model.Crop;
import com.cropdeal.DealerService.model.Dealer;

import com.cropdeal.DealerService.repository.DealerRepository;




@RestController
@CrossOrigin("http://localhost:4200")

public class DealerController {

	@Autowired
	private DealerRepository DealerRepo;

	@Autowired
	private RestTemplate restTemp;
	
	
	


	@PostMapping("/adddealer")
	public Dealer adddealer(@RequestBody Dealer dealer) {
		return 	DealerRepo.save(dealer);
		
	}

	@GetMapping("/finddealer")
	public List<Dealer> getdealer() {
		return DealerRepo.findAll();
	}

	@GetMapping("/finddealer/{id}")
	public Optional<Dealer> getdealer(@PathVariable String id) {
		return DealerRepo.findById(id);
	}

	@DeleteMapping("/finddealer/{id}")
	public String deleteDealer(@PathVariable String id) {
		DealerRepo.deleteById(id);
		return "dealer deleted having id " + id;
	}
	
	
	
	//Dealer access to crop

	@GetMapping("/dealer/get/crop")
	public List<Crop> getCropatDealer() {
		Crop[] crop = restTemp.getForObject("http://Crop-Service/findcrop", Crop[].class);
		return Arrays.asList(crop);
	}

}

