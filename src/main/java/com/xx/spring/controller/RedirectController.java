package com.xx.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xx.spring.service.LinkService;

@Controller
@RequestMapping("/")
public class RedirectController {
	
	@Autowired
	private LinkService linkServivce;
	
	public String redirect(String slug) {
		return "redirectr: " + linkServivce.get(slug);
	}

}
