package com.unlapermisos2021.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unlapermisos2021.helpers.ViewRoutesHelper;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("")
	public String index(){
		return ViewRoutesHelper.LOGIN;
	}

}
