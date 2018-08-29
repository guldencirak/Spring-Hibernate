package com.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.dao.CompanyDAO;
import com.springdemo.entity.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO companyDAO;
	
	@Override
	@Transactional
	public List<Company> getCompaines() {
		return companyDAO.getCompaines();
	}

	@Override
	@Transactional
	public void saveCompany(Company theCompany) {
		companyDAO.saveCompany(theCompany);
	}

	@Override
	@Transactional
	public Company getCompany(int theId) {
		return companyDAO.getCompany(theId);
	}

	@Override
	@Transactional
	public void deleteCompany(int theId) {
		companyDAO.deleteCompany(theId);
	}
}
