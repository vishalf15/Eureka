package com.sclient.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sclient.eureka.util.ClientConstants;

@RestController
public class Controller {

	@Autowired
	ClientConstants constants;
	
	@RequestMapping(value = "/whoami/{username}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String whoami() {
		return String.format("Hello! %s and you'll become a(n) %s... iff you pass == %s and pass2 = %s  \n", constants.getName(), constants.getRole(), constants.getPass(), constants.getPass2());
	}
}
