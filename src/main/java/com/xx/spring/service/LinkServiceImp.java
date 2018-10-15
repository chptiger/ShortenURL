package com.xx.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xx.spring.dao.LinkDao;
import com.xx.spring.model.Link;

@Service
@Transactional(readOnly = true)
public class LinkServiceImp implements LinkService {

	@Autowired
	private LinkDao linkDao;
	
	@Transactional
	public int save(Link link) {
		return linkDao.save(link);
	}

	public Link get(int id) {
		return linkDao.get(id);
	}

	@Override
	public List<Link> list() {
		return linkDao.list();
	}

	@Override
	public void update(int id, Link link) {
		linkDao.update(id, link);
	}

	@Override
	public void delete(int id) {
		linkDao.delete(id);
	}

	@Override
	public Link get(String slug) {
		return linkDao.get(slug);
	}

}
