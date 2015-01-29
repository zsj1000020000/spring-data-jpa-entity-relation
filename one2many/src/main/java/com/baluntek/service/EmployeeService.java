package com.baluntek.service;

import java.util.List;

import com.baluntek.domain.Employee;

public interface EmployeeService {

	public void save(Employee employee) ;
	public void delete(Integer id);
	public void update(Employee employee);
	public Employee getEmployeeById(Integer id);
	public List<Employee> getEmployeesByPage(int page , int size);
	public long getCount() ;
}
