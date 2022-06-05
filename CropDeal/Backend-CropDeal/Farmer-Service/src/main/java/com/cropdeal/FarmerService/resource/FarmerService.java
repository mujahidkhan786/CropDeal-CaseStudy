package com.cropdeal.FarmerService.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cropdeal.FarmerService.models.Farmer;
import com.cropdeal.FarmerService.repository.FarmerRepository;


@Service
@Component
public class FarmerService {

	List<Farmer> farmerlist = new ArrayList();

	@Autowired
	private FarmerRepository farmerRepo;

	// update farmer
	public void updateFarmer(String id, Farmer farmer) {
		farmerlist = farmerlist.stream().map(f -> {
			if (f.getId().equals(id)) {
				f.setFarmer_name(farmer.getFarmer_name());
				f.setFarmeremail(farmer.getFarmeremail());
				f.setFarmer_contactNo(farmer.getFarmer_contactNo());
				f.setFarmer_address(farmer.getFarmer_address());
				f.setBank_details(farmer.getBank_details());
				f.setPassword(farmer.getPassword());
			}

			return f;
		}).collect(Collectors.toList());

		// farmerRepo.save(farmer);
	}
}
