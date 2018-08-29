package com.springdemo.dao;

import java.util.List;

import com.springdemo.entity.Company;

public interface CompanyDAO {

	public List<Company> getCompaines();
	
	public void saveCompany(Company theCompany);
	
	public Company getCompany(int theId);
	
	public void deleteCompany(int theId);
}
