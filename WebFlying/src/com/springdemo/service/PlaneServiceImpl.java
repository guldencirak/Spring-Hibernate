package com.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.dao.PassengerDAO;
import com.springdemo.dao.PlaneDAO;
import com.springdemo.entity.Plane;

@Service
public class PlaneServiceImpl implements PlaneService {

	@Autowired
	private PlaneDAO planeDAO;
	
	@Override
	@Transactional
	public List<Plane> getPlanes() {
		return planeDAO.getPlanes();
	}

	@Override
	@Transactional
	public void savePlane(Plane thePlane) {
		planeDAO.savePlane(thePlane);
	}

	@Override
	@Transactional
	public Plane getPlane(int theId) {
		return planeDAO.getPlane(theId);
	}

	@Override
	@Transactional
	public void deletePlane(int theId) {
		planeDAO.deletePlane(theId);
	}
}
