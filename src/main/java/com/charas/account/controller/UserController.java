package com.charas.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charas.account.models.user.UserRegistrationRequestModel;
import com.charas.account.service.user.UserService;
import com.charas.utility.ApiResponseModel;



@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value="/hi")
	public String sayHello(){
		
		boolean isFormCreated  = userService.registerUser(null);
		
		return "Hello";
	}
	
	
	@PostMapping(value = "/user", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ApiResponseModel<Boolean>> register(UserRegistrationRequestModel 
							userRegistrationRequestModel){
		
		ApiResponseModel<Boolean> apiResponse = new ApiResponseModel<Boolean>();
		
		boolean isFormCreated  = userService.registerUser(userRegistrationRequestModel);
	
		apiResponse.setData(isFormCreated);
		
		return new ResponseEntity<ApiResponseModel<Boolean>>(apiResponse, new HttpHeaders(), HttpStatus.OK);
	}
	

}
