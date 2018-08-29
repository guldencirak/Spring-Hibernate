package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.entity.Passenger;
import com.springdemo.service.PassengerService;

@Controller
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private PassengerService passengerService;
	
	@GetMapping("/list")
	public String listPassengers(Model theModel) {
		
		List<Passenger> thePassengers=passengerService.getPassengers();
		
		theModel.addAttribute("passengers",thePassengers);
		
		return "/list-passengers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Passenger thePassenger=new Passenger();
		
		theModel.addAttribute(thePassenger);
		
		return "/passenger-form";
	}
	
	@PostMapping("/savePassenger")
	public String savePassenger(@ModelAttribute("passenger") Passenger thePassenger ) {
		
		passengerService.savePassenger(thePassenger);
		        
		return "redirect:/passenger/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("passengerId") int theId, Model theModel) {
		
		Passenger thePassenger=passengerService.getPassenger(theId);
		
		theModel.addAttribute(thePassenger);
		
		return "/passenger-form";
	}	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("passengerId") int theId) {
		
		passengerService.deletePassenger(theId);
		
		return "redirect:/passenger/list";
	}
}
