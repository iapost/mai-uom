package com.example.ecar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class FrontEndController {
	
	@GetMapping("/ui/{page}")
	public String getUI(@PathVariable String page) throws Exception {
		return page;
	}

}
