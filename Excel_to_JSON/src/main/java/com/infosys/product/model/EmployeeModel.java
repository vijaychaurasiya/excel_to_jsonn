package com.infosys.product.model;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class EmployeeModel {
    private String empid;
    private String firstname;
    private String lastname;
    private String fullname;
    private String role;
    private String location;
    
    public EmployeeModel() {}
	public EmployeeModel(String empid, String firstname, String lastname, String fullname, String role, String location) {
		super();
		this.empid = empid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.fullname = fullname;
		this.role = role;
		this.location = location;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "EmployeeModel [empid=" + empid + ", firstname=" + firstname + ", lastname=" + lastname + ", fullname="
				+ fullname + ", role=" + role + ", location=" + location + "]";
	}
	
	
    
    
    
}
