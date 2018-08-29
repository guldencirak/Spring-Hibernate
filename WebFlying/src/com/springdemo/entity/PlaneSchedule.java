package com.springdemo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PlaneSchedule")
public class PlaneSchedule {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="FlyingDate")
	private Date flyingDate;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="DepartureDestinationId")
	private Destination departureDestination;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="ArrivalDestinationId")
	private Destination arrivalDestination;
	
	public PlaneSchedule() {
		
	}

	public PlaneSchedule(Date flyingDate, Destination departureDestination, Destination arrivalDestination) {
		this.flyingDate = flyingDate;
		this.departureDestination = departureDestination;
		this.arrivalDestination = arrivalDestination;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFlyingDate() {
		return flyingDate;
	}

	public void setFlyingDate(Date flyingDate) {
		this.flyingDate = flyingDate;
	}

	public Destination getDepartureDestination() {
		return departureDestination;
	}

	public void setDepartureDestination(Destination departureDestination) {
		this.departureDestination = departureDestination;
	}

	public Destination getArrivalDestination() {
		return arrivalDestination;
	}

	public void setArrivalDestination(Destination arrivalDestination) {
		this.arrivalDestination = arrivalDestination;
	}

	@Override
	public String toString() {
		return "PlaneSchedule [id=" + id + ", flyingDate=" + flyingDate + ", departureDestination="
				+ departureDestination + ", arrivalDestination=" + arrivalDestination + "]";
	}
}
