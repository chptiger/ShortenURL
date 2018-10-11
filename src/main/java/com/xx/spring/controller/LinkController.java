package com.xx.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xx.spring.model.Link;
import com.xx.spring.service.LinkService;

@RestController
public class LinkController {
	@Autowired
	private LinkService linkService;

	@PostMapping("/link")
	public ResponseEntity<?> save(@RequestBody Link link) {
		long id = linkService.save(link);
		return ResponseEntity.ok().body("New Link has been saved with ID" + id);
	}
}
