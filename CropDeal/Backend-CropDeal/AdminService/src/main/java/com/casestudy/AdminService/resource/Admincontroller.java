package com.casestudy.AdminService.resource;

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

import com.casestudy.AdminService.models.Admin;
import com.casestudy.AdminService.models.AuthenticationRequest;
import com.casestudy.AdminService.models.AuthenticationResponse;
import com.casestudy.AdminService.models.Crop;
import com.casestudy.AdminService.models.Dealer;
import com.casestudy.AdminService.models.Farmer;
import com.casestudy.AdminService.models.UserModel;
import com.casestudy.AdminService.repository.AdminRepository;
import com.casestudy.AdminService.repository.UserRepository;
import com.casestudy.AdminService.service.UserService;

import com.casestudy.AdminService.service.JwtUtils;

@CrossOrigin("http://localhost:4200")
@RestController

public class Admincontroller {
	@Autowired
	UserRepository repository;
	@Autowired
	AuthenticationManager authenticates;
	@Autowired
	UserService userService;
	@Autowired
	JwtUtils JwtUtils;

	@Autowired
	private RestTemplate restTemp;
	
	
	
//Admin controll on farmer
	
	@GetMapping("/farmer/ ")
	public List<Object> getFarmeratAdmin() {
		Object[] farmer = restTemp.getForObject("http://Farmer-Service/findfarmer", Object[].class);
		return Arrays.asList(farmer);
	}

	@GetMapping("/farmer/{id}")
	public List<Farmer> getFarmeratAdminbyID(@PathVariable("id") String id) {
		Farmer farmer = restTemp.getForObject("http://Farmer-Service/findfarmer/" + id, Farmer.class);
		return Arrays.asList(farmer);
	}

	@RequestMapping(value = "/delete/farmer/{_id}", method = RequestMethod.DELETE)
	public String deleteFarmerById(@PathVariable("_id") String _id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Farmer> entity = new HttpEntity<Farmer>(headers);
		return restTemp
				.exchange("http://Farmer-Service/deletefarmer/" + _id, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}
	//Admin controll on dealer
	

	@GetMapping("/admin/get/dealer/{id}")
	public List<Dealer> getDealeratAdminbyID(@PathVariable("id") String id) {
		Dealer dealer = restTemp.getForObject("http://Dealer-Service/finddealer/" + id, Dealer.class);
		return Arrays.asList(dealer);
	}

	@GetMapping("/admin/get/dealer")
	public List<Object> gatDealerAdmin() {
		Object[] dealer = restTemp.getForObject("http://Dealer-Service/finddealer", Object[].class);
		return Arrays.asList(dealer);
	}

	@RequestMapping(value = "/admin/delete/dealer/{_id}", method = RequestMethod.DELETE)
	public String deleteDealerById(@PathVariable("_id") String _id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Dealer> entity = new HttpEntity<Dealer>(headers);
		return restTemp
				.exchange("http://Dealer-Service/deletedealer/" + _id, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}
	
	//Admin controll on crops
	//-----------------------------------------------------------------------------------------------------------------------------------

	@GetMapping("/admin/get/crop")
	public List<Object> getCropatAdmin() {
		Object[] crop = restTemp.getForObject("http://Crop-Service/findcrop", Object[].class);
		return Arrays.asList(crop);
	}

	@GetMapping("/admin/get/crop/{id}")
	public List<Crop> getCropatAdminbyID(@PathVariable("id") String id) {
		Crop crop = restTemp.getForObject("http://Crop-Service/findcrop/" + id, Crop.class);
		return Arrays.asList(crop);
	}

	@RequestMapping(value = "/admin/delete/crop/{_id}", method = RequestMethod.DELETE)
	public String deleteCropById(@PathVariable("_id") String _id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Crop> entity = new HttpEntity<Crop>(headers);
		return "Crop Deleated" + restTemp
				.exchange("http://Crop-Service/deletecrop/" + _id, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}
	
	//--------------------------Cured operations-------------------------------------------------

	@Autowired
	private AdminRepository AdminRepo;

	@PostMapping("/addadmin")
	public String addadmin(@RequestBody Admin admin) {
		AdminRepo.save(admin);
		return "Added admin with id " + admin.getId();
	}

	@GetMapping("/findadmin")
	public List<Admin> getdealer() {
		return AdminRepo.findAll();
	}

	@GetMapping("/findadmin/{id}")
	public Optional<Admin> getdealer(@PathVariable String id) {
		return AdminRepo.findById(id);
	}

	@DeleteMapping("/deleteadmin/{id}")
	public String deleteDealer(@PathVariable String id) {
		AdminRepo.deleteById(id);
		return "dealer deleted having id " + id;
	}
	
	

	
	@GetMapping("/test")
	private String test()
	{
		return "Welcome";
	}
	
	@PostMapping("/reg")
	private ResponseEntity<?> subscribe(@RequestBody AuthenticationRequest request)
	{
		
		String username = request.getUsername();
		String password = request.getPassword();
//		String role = request.getRole();
		UserModel model = new UserModel();
		model.setUsername(username);
		model.setPassword(password);
//		model.setRole(role);
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
//		String role = request.getRole();
		try {
			authenticates.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error while authenticating" + username));
		}
		
		UserDetails loadedUser = userService.loadUserByUsername(username);
		String generatedToken = JwtUtils.generateToken(loadedUser);
		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
	}
	
	
	

		
	
}
