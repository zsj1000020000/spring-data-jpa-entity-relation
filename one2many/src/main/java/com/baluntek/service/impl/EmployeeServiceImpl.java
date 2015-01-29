package com.baluntek.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.baluntek.dao.EmployeeRepository;
import com.baluntek.domain.Employee;
import com.baluntek.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void save(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

	@Override
	public void delete(Integer id) {
		this.employeeRepository.delete(id);
		
	}

	@Override
	public void update(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee employee = this.employeeRepository.findOne(id);
		return employee;
	}

	@Override
	public List<Employee> getEmployeesByPage(int page, int size) {
		List<Employee> employees = this.employeeRepository.findAll(new PageRequest(page, size)).getContent();
		return employees;
	}

	@Override
	public long getCount() {
		long count = this.employeeRepository.count();
		return count;
	}

}
