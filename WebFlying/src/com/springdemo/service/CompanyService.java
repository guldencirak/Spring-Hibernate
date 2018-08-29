package com.springdemo.service;

import java.util.List;

import com.springdemo.entity.Company;

public interface CompanyService {

	public List<Company> getCompaines();
	
	public void saveCompany(Company theCompany);
	
	public Company getCompany(int theId);
	
	public void deleteCompany(int theId);
}
