package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.PlaneSchedule;

@Repository
public class PlaneScheduleDAOImpl implements PlaneScheduleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<PlaneSchedule> getPlaneSchedules() {
		Session currSession=sessionFactory.getCurrentSession();
		
		Query<PlaneSchedule> theQuery = currSession.createQuery("from PlaneSchedule",PlaneSchedule.class);
		
		List<PlaneSchedule> planeSchedules=theQuery.getResultList();
		
		return planeSchedules;
	}

	@Override
	public void savePlaneSchedule(PlaneSchedule thePlaneSchedule) {
		Session currSession=sessionFactory.getCurrentSession();

		currSession.saveOrUpdate(thePlaneSchedule);
	}

	@Override
	public PlaneSchedule getPlaneSchedule(int theId) {
		Session currSession=sessionFactory.getCurrentSession();
		
		PlaneSchedule planeSchedule=currSession.get(PlaneSchedule.class,theId);
		
		return planeSchedule;
	}

	@Override
	public void deletePlaneSchedule(int theId) {
		Session currSession=sessionFactory.getCurrentSession();
		
		Query theQuery=currSession.createQuery("delete from PlaneSchedule where Id=:PlaneScheduleId");
		
		theQuery.setParameter("PlaneScheduleId", theId);
		
		theQuery.executeUpdate();
	}
}
