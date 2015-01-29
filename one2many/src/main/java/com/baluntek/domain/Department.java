package com.baluntek.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_department")
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="department",cascade = CascadeType.PERSIST)
	private List<Employee> employees = new ArrayList<Employee>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee employee) {
		if (!this.employees.contains(employee)) {
			
			this.employees.add(employee);
			employee.setDepartment(this);
		}
		
		
	}
	
	public void deleteEmployee(Employee employee) {
		if (this.employees.contains(employee)) {
			
			employee.setDepartment(null);
			this.employees.remove(employee);
		}
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employees="
				+ employees + "]";
	}
	
	
	
}
