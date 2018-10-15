package com.xx.spring.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xx.spring.model.Link;
import com.xx.spring.service.LinkService;
import com.xx.utilities.Utilities;

@RestController
public class LinkController {
	@Autowired
	private LinkService linkService;
	
//	Add new shorten link
	@PostMapping("/link")
	public ResponseEntity<?> save(@RequestBody Link link) {
//		1. validationf or url validation
		if(!StringUtils.isEmpty(link.getSlug())) {
			try {
				java.net.URL url = new URL(link.getSlug());
			} catch (MalformedURLException e) {
				return Utilities.getReturnMessage("Please input a valid URL");
			}
		}
//		2. assign value to destination
		
//		3. add createdOn column
		long id = linkService.save(link);
		return ResponseEntity.ok().body("New Link has been saved with ID " + id);
	}
	
//	get the link by id
	@GetMapping("/link/{id}")
	public ResponseEntity<Link> get(@PathVariable("id") long id) {
		Link link = linkService.get(id);
		return ResponseEntity.ok().body(link);
	}
	
//	get all links
	@GetMapping("/link")
	public ResponseEntity<List<Link>> list() {
		List<Link> links = linkService.list();
		return ResponseEntity.ok().body(links);
	}
	
//	update a link by id
	@PutMapping("/link/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Link link) {
		linkService.update(id, link);
		return ResponseEntity.ok().body("Link has been udpated successfully.");
	}
	
//	delete a link by id
	@DeleteMapping("/link/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		linkService.delete(id);
		return ResponseEntity.ok().body("Link has been deleted successfully.");
	}
}
