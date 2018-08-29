package com.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.dao.CompanyDAO;
import com.springdemo.dao.PlaneScheduleDAO;
import com.springdemo.entity.PlaneSchedule;

@Service
public class PlaneScheduleServiceImpl implements PlaneScheduleService {

	@Autowired
	private PlaneScheduleDAO planeScheduleDAO;
	
	@Override
	@Transactional
	public List<PlaneSchedule> getPlaneSchedules() {
		return planeScheduleDAO.getPlaneSchedules();
	}

	@Override
	@Transactional
	public void savePlaneSchedule(PlaneSchedule thePlaneSchedule) {
		planeScheduleDAO.savePlaneSchedule(thePlaneSchedule);
	}

	@Override
	@Transactional
	public PlaneSchedule getPlaneSchedule(int theId) {
		return planeScheduleDAO.getPlaneSchedule(theId);
	}

	@Override
	@Transactional
	public void deletePlaneSchedule(int theId) {
		planeScheduleDAO.deletePlaneSchedule(theId);
	}
}
