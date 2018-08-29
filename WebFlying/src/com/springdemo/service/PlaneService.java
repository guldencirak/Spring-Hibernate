package com.springdemo.service;

import java.util.List;

import com.springdemo.entity.Plane;

public interface PlaneService {

	public List<Plane> getPlanes();
	
	public void savePlane(Plane thePlane);
	
	public Plane getPlane(int theId);
	
	public void deletePlane(int theId);
	
}
