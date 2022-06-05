package com.cropdeal.CropService.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cropdeal.CropService.model.Crop;
import com.cropdeal.CropService.repository.CropRepository;



@RestController
@CrossOrigin("http://localhost:4200")


public class CropController {

	@Autowired
	private CropRepository cropRepo;
	
	@PostMapping("/findcrop")
	public Crop addcrop(@RequestBody Crop crop) {
		return 	cropRepo.save(crop);
	
	}

	@GetMapping("/findcrop")
	public List<Crop> getcrop() {
		return cropRepo.findAll();
	}

	@GetMapping("/findcrop/{id}")
	public Optional<Crop> getcrop(@PathVariable String id) {
		return cropRepo.findById(id);
	}
	@PutMapping("/findcrop/{id}")
	public Crop updateCrop(@RequestBody Crop crop, @PathVariable("id") String id) {
		
         return cropRepo.save(crop);
		
	}

	@DeleteMapping("/findcrop/{id}")
	public String deletecrop(@PathVariable String id) {
		cropRepo.deleteById(id);
		return "crop deleted having id " + id;
	}

}
