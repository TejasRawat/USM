package com.charas.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestUIController {
	
	
	@GetMapping(value="")
	public ModelAndView getUiTemplate(HttpServletRequest request, HttpServletResponse response) {
	
		
		
		return null;
	}

}
