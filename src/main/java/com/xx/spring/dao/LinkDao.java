package com.xx.spring.dao;

import java.util.List;

import com.xx.spring.model.Link;

public interface LinkDao {

	int save(Link link);

	Link get(int id);

	List<Link> list();

	void update(int id, Link link);

	void delete(int id);

	Link get(String slug);

}
