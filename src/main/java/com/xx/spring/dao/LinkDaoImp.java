package com.xx.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xx.spring.model.Link;

@Repository
public class LinkDaoImp implements LinkDao {

	@Autowired
	private SessionFactory sessionFactory;

	public int save(Link link) {
		sessionFactory.getCurrentSession().save(link);
		return link.getId();
	}

	@Override
	public Link get(int id) {
		return sessionFactory.getCurrentSession().get(Link.class, id);
	}

	@Override
	public List<Link> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Link> cq = cb.createQuery(Link.class);
		Root<Link> root = cq.from(Link.class);
		cq.select(root);
		Query<Link> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(int id, Link link) {
		Session session = sessionFactory.getCurrentSession();
		Link link2 = session.byId(Link.class).load(id);
		link2.setDestination(link.getDestination());
		session.flush();
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Link link = session.byId(Link.class).load(id);
		session.delete(link);
	}

	@Override
	public Link get(String slug) {
		Session session = sessionFactory.getCurrentSession();
//		run SQL to check if exist URL
		return null;
	}

}
