package com.springdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.entity.Company;
import com.springdemo.entity.Plane;
import com.springdemo.service.CompanyService;
import com.springdemo.service.PlaneService;

@Controller
@RequestMapping("/plane")
public class PlaneController {

	@Autowired
	private PlaneService planeService;
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/list")
	public String listPlanes(Model theModel) {
		
		List<Plane> thePlanes=planeService.getPlanes();
		
		theModel.addAttribute("planes",thePlanes);
		
		return "/list-planes";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Plane thePlane=new Plane();
		
		theModel.addAttribute(thePlane);
		
		List<Company> theCompanies=companyService.getCompaines();
		
		theModel.addAttribute("companies",theCompanies);
		  
		return "/plane-form";
	}
	
	@PostMapping("/savePlane")
	public String savePlane(@ModelAttribute("plane") Plane thePlane ) {
		
		planeService.savePlane(thePlane);
		
		return "redirect:/plane/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("planeId") int theId, Model theModel) {
		
		Plane thePlane=planeService.getPlane(theId);
		
		theModel.addAttribute(thePlane);
		
		return "/plane-form";
	}	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("planeId") int theId) {
		
		planeService.deletePlane(theId);
		
		return "redirect:/plane/list";
	}
}
