package com.xx.spring.dao;

import java.util.List;

import com.xx.spring.model.Link;

public interface LinkDao {

	long save(Link link);

	Link get(long id);

	List<Link> list();

	void update(long id, Link link);

	void delete(long id);

	Link get(String slug);

}
