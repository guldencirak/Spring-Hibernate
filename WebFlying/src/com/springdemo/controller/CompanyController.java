package com.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import com.springdemo.entity.Company;
import com.springdemo.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/list")
	public String listCompanies(Model theModel) {
		
		List<Company> theCompanies=companyService.getCompaines();
		
		theModel.addAttribute("companies",theCompanies);
		
		return "/list-companies";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Company theCompany=new Company();
		
		theModel.addAttribute(theCompany);
		
		return "/company-form";
	}
	
	@PostMapping("/saveCompany")
	public String saveCompany(@ModelAttribute("company") Company theCompany ) {
		
		companyService.saveCompany(theCompany);
		
		return "redirect:/company/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("companyId") int theId, Model theModel) {
		
		Company theCompany=companyService.getCompany(theId);
		
		theModel.addAttribute(theCompany);
		
		return "/company-form";
	}	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("companyId") int theId) {
		
		companyService.deleteCompany(theId);
		
		return "redirect:/company/list";
	}
}
