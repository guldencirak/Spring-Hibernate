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
@Table(name="Company")
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Explanation")
	private String explanation;
	
	@OneToMany(mappedBy="company",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					  CascadeType.DETACH,CascadeType.REFRESH})
	private List<Plane> planes;
	
	public Company() {
		
	}

	public Company(String name, String explanation) {
		this.name = name;
		this.explanation = explanation;
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
		return "Company [id=" + id + ", name=" + name + ", explanation=" + explanation + "]";
	}
	
	public void add(Plane tempPlane) {
		
		if(planes==null)
			planes=new ArrayList<>();
		
		planes.add(tempPlane);
		
		tempPlane.setCompany(this);
	}
}
