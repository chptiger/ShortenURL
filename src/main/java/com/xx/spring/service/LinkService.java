package com.xx.spring.service;

import java.util.List;

import com.xx.spring.model.Link;

public interface LinkService {

	int save(Link link);

	Link get(int id);
	
	Link get(String slug);

	List<Link> list();

	void update(int id, Link link);

	void delete(int id);
}
