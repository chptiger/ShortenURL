package com.xx.spring.service;

import java.util.List;

import com.xx.spring.model.Link;

public interface LinkService {

	long save(Link link);

	Link get(long id);

	List<Link> list();

	void update(long id, Link link);

	void delete(long id);
}
