package com.nutrivex.platform.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="people")
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty
	@Column(name="last_name")
	private String lastName;
	
	@Column(name = "weight")
	private Float weight;
	
	@Column(name = "height")
	private Float height;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "nutrionist_spreciality")
	private String nutrionistSpeciality;
	
	@Column(name = "tuition_number")
	private Long tuitionNumber;
	
	//PUBLIC METHODS// 
	
	public String getNutrionistSpeciality() {
		return nutrionistSpeciality;
	}


	public void setNutrionistSpeciality(String nutrionistSpeciality) {
		this.nutrionistSpeciality = nutrionistSpeciality;
	}


	public Long getTuitionNumber() {
		return tuitionNumber;
	}


	public void setTuitionNumber(Long tuitionNumber) {
		this.tuitionNumber = tuitionNumber;
	}


	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Float getWeight() {
		return weight;
	}


	public void setWeight(Float weight) {
		this.weight = weight;
	}


	public Float getHeight() {
		return height;
	}


	public void setHeight(Float height) {
		this.height = height;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	private static final long serialVersionUID = 1L;

}
