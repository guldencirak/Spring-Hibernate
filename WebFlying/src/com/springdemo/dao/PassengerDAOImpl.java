package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Passenger;

@Repository
public class PassengerDAOImpl implements PassengerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Passenger> getPassengers() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Passenger> theQuery=currentSession.createQuery("from Passenger", Passenger.class);
		
		List<Passenger> passengers=theQuery.getResultList();
		
		return passengers;
	}

	@Override
	public void savePassenger(Passenger thePassenger) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(thePassenger);
	}

	@Override
	public Passenger getPassenger(int theId) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Passenger thePassenger=currentSession.get(Passenger.class, theId);
		
		return thePassenger;
	}

	@Override
	public void deletePassenger(int theId) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query theQuery=currentSession.createQuery("delete from Passenger where Id=:PassengerId");
		
		theQuery.setParameter("PassengerId", theId);
		
		theQuery.executeUpdate();
	}
}
