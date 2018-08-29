package com.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.dao.PassengerDAO;
import com.springdemo.entity.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerDAO passengerDAO;
	
	@Override
	@Transactional
	public List<Passenger> getPassengers() {
		return passengerDAO.getPassengers();
	}

	@Override
	@Transactional
	public void savePassenger(Passenger thePassenger) {
		passengerDAO.savePassenger(thePassenger);
	}

	@Override
	@Transactional
	public Passenger getPassenger(int theId) {
		return passengerDAO.getPassenger(theId);
	}

	@Override
	@Transactional
	public void deletePassenger(int theId) {
		passengerDAO.deletePassenger(theId);
	}
}
