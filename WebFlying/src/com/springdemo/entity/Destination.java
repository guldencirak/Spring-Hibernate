package com.springdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Destination")
public class Destination {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Explanation")
	private String explanation;
	
	@Column(name="Country")
	private String country;
	
	@Column(name="City")
	private String city;
	
	@Column(name="District")
	private String district;
	
	@OneToMany(mappedBy="departureDestination",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					  CascadeType.DETACH,CascadeType.REFRESH})
	private List<PlaneSchedule> departurePlaneSchedules;
	
	@OneToMany(mappedBy="arrivalDestination",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					  CascadeType.DETACH,CascadeType.REFRESH})
	private List<PlaneSchedule> arrivalPlaneSchedules;
	
	public Destination() {
		
	}
	
	public Destination(String name, String explanation, String country, String city, String district) {
		this.name = name;
		this.explanation = explanation;
		this.country = country;
		this.city = city;
		this.district = district;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	@Override
	public String toString() {
		return "Destination [id=" + id + ", name=" + name + ", explanation=" + explanation + ", country=" + country
				+ ", city=" + city + ", district=" + district + "]";
	}
	
	public void addDeparturePlaneSchedule(PlaneSchedule tempPlaneSchedule) {
		
		if(departurePlaneSchedules==null)
			departurePlaneSchedules=new ArrayList<>();
		
		departurePlaneSchedules.add(tempPlaneSchedule);
		
		tempPlaneSchedule.setDepartureDestination(this);
	}
	
	public void addArrivalPlaneSchedule(PlaneSchedule tempPlaneSchedule) {
		
		if(arrivalPlaneSchedules==null)
			arrivalPlaneSchedules=new ArrayList<>();
		
		arrivalPlaneSchedules.add(tempPlaneSchedule);
		
		tempPlaneSchedule.setDepartureDestination(this);
	}
}
