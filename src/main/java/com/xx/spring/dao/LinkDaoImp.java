package com.xx.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xx.spring.model.Link;

@Repository
public class LinkDaoImp implements LinkDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public long save(Link link) {
		sessionFactory.getCurrentSession().save(link);
		return link.getId();
	}

}
