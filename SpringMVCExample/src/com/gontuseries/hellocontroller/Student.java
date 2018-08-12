package com.gontuseries.hellocontroller;

import java.util.Date;
/*import java.sql.Date;*/
import java.util.List;
/*import java.util.Date;*/

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
	
	@Pattern(regexp="[^0-9]*")
	private String name;
	/*@Size(min=15, max=30,message = "Password must be min : {min} and max : {max} ")*/
	@Size(min=3,max=15)
	private String password;
	
	@Max(8686)
	private Long mobileNo;
	@Past
	private Date dob;
	private List<String> skills;
	
	private Address studentAddress;
	
	
	
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
		public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
