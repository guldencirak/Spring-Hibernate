package com.springdemo.dao;

import java.util.List;

import com.springdemo.entity.PlaneSchedule;

public interface PlaneScheduleDAO {

	public List<PlaneSchedule> getPlaneSchedules();
	
	public void savePlaneSchedule(PlaneSchedule thePlaneSchedule);
	
	public PlaneSchedule getPlaneSchedule(int theId);
	
	public void deletePlaneSchedule(int theId);
}
