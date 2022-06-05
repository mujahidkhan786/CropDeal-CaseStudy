package com.casestudy.AdminService.resource;

import org.springframework.web.bind.annotation.GetMapping;

public class Adminresource {
	@GetMapping("/admin")
	public String dealer() {
		return "Admin list";
	}


}
