package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Company;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public List<Company> getCompaines() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Company> theQuery=currentSession.createQuery("from Company",Company.class);
		
		List<Company> compaines=theQuery.getResultList();
		
		return compaines;
	}

	@Override
	public void saveCompany(Company theCompany) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCompany);
	}

	@Override
	public Company getCompany(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Company theCompany=currentSession.get(Company.class, theId);
		
		return theCompany;
	}

	@Override
	public void deleteCompany(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery=currentSession.createQuery("delete from Company where Id=:CompanyId");
		
		theQuery.setParameter("CompanyId", theId);
		
		theQuery.executeUpdate();
	}
}
