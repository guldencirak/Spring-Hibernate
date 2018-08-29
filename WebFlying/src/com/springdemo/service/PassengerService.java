package com.springdemo.service;

import java.util.List;

import com.springdemo.entity.Passenger;

public interface PassengerService {

	public List<Passenger> getPassengers();
	
	public void savePassenger(Passenger thePassenger);
	
	public Passenger getPassenger(int theId);
	
	public void deletePassenger(int theId);
}
