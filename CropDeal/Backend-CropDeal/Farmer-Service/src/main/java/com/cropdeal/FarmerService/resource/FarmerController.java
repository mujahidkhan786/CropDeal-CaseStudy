package com.cropdeal.FarmerService.resource;


import java.util.Arrays;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cropdeal.FarmerService.Service.UserService;
import com.cropdeal.FarmerService.models.AuthenticationRequest;
import com.cropdeal.FarmerService.models.AuthenticationResponse;
import com.cropdeal.FarmerService.models.Crop;
import com.cropdeal.FarmerService.models.Farmer;
import com.cropdeal.FarmerService.models.UserModel;
import com.cropdeal.FarmerService.repository.FarmerRepository;
import com.cropdeal.FarmerService.repository.UserRepository;

import com.cropdeal.FarmerService.Service.JwtUtils;


@RestController
@CrossOrigin
//@RequestMapping("/api")
public class FarmerController {

	@Autowired
	private RestTemplate restTemp;

	@Autowired
	private FarmerRepository farmerRepo;

	@Autowired
	FarmerService farmercustom;
	
	@Autowired
	UserRepository repository;
	@Autowired
	AuthenticationManager authenticates;
	@Autowired
	UserService userService;
	@Autowired
	JwtUtils JwtUtils;
	
//	@GetMapping("/")
//	public String test() {
//		return "hello-farmer";
//	}
//-------------------------------------------Curd Operations----------------------------------------
	//--------------------------------------------------------------------------------------------
	@PostMapping("/addfarmer")
	public String addfarmer(@RequestBody Farmer farmer) {
		farmerRepo.save(farmer);
		return "Added farmer with id " + farmer.getId();
	}

	@GetMapping("/findfarmer")
	public List<Farmer> getfarmer() {
		return farmerRepo.findAll();
	}

	// get book base on id
	@GetMapping("/findfarmer/{id}")
	public Optional<Farmer> getfarmer(@PathVariable String id) {
		return farmerRepo.findById(id);
	}

	@PutMapping("/farmer/update/{id}")
	public void updateFarmer(@RequestBody Farmer farmer, @PathVariable("id") String id) {
		farmercustom.updateFarmer(id, farmer);

	}

	@DeleteMapping("/deletefarmer/{id}")
	public String deleteFarmer(@PathVariable String id) {
		farmerRepo.deleteById(id);
		return "farmer deleted havin id " + id;
	}
	
	
	
	//----------------------------------------Farmer Security---------------------------------------
	//------------------------------------------------------------------------------------------------------
	
	
	@GetMapping("/test")
	private String check()
	{
		return "Welcome";
	}
	
	@PostMapping("/reg")
	private ResponseEntity<?> subscribe(@RequestBody AuthenticationRequest request)
	{
		
		String username = request.getUsername();
		String password = request.getPassword();
		String role = request.getRole();
		UserModel model = new UserModel();
		model.setUsername(username);
		model.setPassword(password);
		model.setRole(role);
		try {
			repository.save(model);
		} catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error while subsribing the user with username " + username));
		}
		return ResponseEntity.ok(new AuthenticationResponse("client subscribed with username " + username));
	}
	
	@PostMapping("/auth")
	private ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request)
	{
		String username = request.getUsername();
		String password = request.getPassword();
		String role = request.getRole();
		try {
			authenticates.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error while authenticating" + username));
		}
		//return ResponseEntity.ok(new AuthenticationResponse("Succesfull authentication for user " + username));
		UserDetails loadedUser = userService.loadUserByUsername(username);
		String generatedToken = JwtUtils.generateToken(loadedUser);
		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
	}	
	
	
	@GetMapping("/farmer")
	public List<Farmer> getFarmeratAdmin() {
		Farmer[] farmer = restTemp.getForObject("http://farmer-service/api/findfarmer", Farmer[].class);
		return Arrays.asList(farmer);
}
	
	
	
	//---------------------------------------------------------------------------------------------------
                              // Farmer accessing the crops
	//----------------------------------------------------------------------------------------------------
	
	
	
	//---------get all crops----------------------------------------------------//
	@GetMapping("/farmer/get/crop")
	public List<Object> getCropatFarmer() {
		Object[] crop = restTemp.getForObject("http://crop-service/api/findcrop", Object[].class);
		return Arrays.asList(crop);
	}
	
	//------------------------------get crops by id-----------------------

	@GetMapping("/farmer/get/crop/{id}")
	public List<Crop> getCropatFarmerbyID(@PathVariable("id") String id) {
		Crop crop = restTemp.getForObject("http://crop-service/api/findcrop/" + id, Crop.class);
		return Arrays.asList(crop);
	}
	
	//-------------------------delete the crop by farmer---------------------

	@RequestMapping(value = "/farmer/delete/crop/{_id}", method = RequestMethod.DELETE)
	public String deleteCropById(@PathVariable("_id") String _id) {
		return restTemp.exchange("http://crop-service/api/deletecrop/" + _id, HttpMethod.DELETE, null, String.class)
				.getBody();
	}
	
	//-----------------------------adding crops by farmer---------------

	@RequestMapping(value = "/farmer/add/crop", method = RequestMethod.POST)
	public String addCropatFarmer(@RequestBody Crop crop) {
		HttpEntity<Crop> entity = new HttpEntity<Crop>(crop);
		return restTemp.exchange("http://crop-service/api/addcrop", HttpMethod.POST, entity, String.class).getBody();

	}

	
	//---------------------update the crop by farmer-----------------------------
		@RequestMapping(value="/farmer/update/crop/{id}", method = RequestMethod.PUT)
		public String updateCropatFarmer(@RequestBody Crop crop) {
			HttpEntity<Crop> entity = new HttpEntity<Crop>(crop);
			return restTemp.exchange("http://crop-service/api/updatecrop/", HttpMethod.PUT, entity, String.class).getBody();

		}
		
		
}
