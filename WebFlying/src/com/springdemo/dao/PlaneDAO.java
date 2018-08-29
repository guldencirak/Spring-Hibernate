package com.springdemo.dao;

import java.util.List;

import com.springdemo.entity.Plane;

public interface PlaneDAO {

	public List<Plane> getPlanes();
	
	public void savePlane(Plane thePlane);
	
	public Plane getPlane(int theId);
	
	public void deletePlane(int theId);
}
