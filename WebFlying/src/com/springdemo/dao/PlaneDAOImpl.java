package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Plane;

@Repository
public class PlaneDAOImpl implements PlaneDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Plane> getPlanes() {
		
		Session currSession=sessionFactory.getCurrentSession();
		
		Query<Plane> theQuery = currSession.createQuery("from Plane",Plane.class);
		
		List<Plane> planes=theQuery.getResultList();
		
		return planes;
	}

	@Override
	public void savePlane(Plane thePlane) {
		
		Session currSession=sessionFactory.getCurrentSession();

		currSession.saveOrUpdate(thePlane);
	}

	@Override
	public Plane getPlane(int theId) {
		
		Session currSession=sessionFactory.getCurrentSession();
		
		Plane plane=currSession.get(Plane.class,theId);
		
		return plane;
	}

	@Override
	public void deletePlane(int theId) {
		
		Session currSession=sessionFactory.getCurrentSession();
		
		Query theQuery=currSession.createQuery("delete from Plane where Id=:PlaneId");
		
		theQuery.setParameter("PlaneId", theId);
		
		theQuery.executeUpdate();
	}
}
