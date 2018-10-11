package com.xx.spring.service;


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
	public long save(Link link) {
		return linkDao.save(link);
	}

}
