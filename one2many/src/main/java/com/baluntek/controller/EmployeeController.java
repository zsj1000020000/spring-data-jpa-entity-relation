package com.baluntek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baluntek.domain.Department;
import com.baluntek.domain.Employee;
import com.baluntek.service.DepartmentService;
import com.baluntek.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "/e_save" , method = RequestMethod.GET)
	public String save() {
		Employee employee = new Employee();
		employee.setName("e");
		Department department = this.departmentService.getDepartmentById(3);
		
		employee.setDepartment(department);
		
		this.employeeService.save(employee);
		return "home";
	}
	@RequestMapping(value = "/e_delete" , method = RequestMethod.GET)
	public String delete() {
		this.employeeService.delete(23);
		return "home";
	}
	@RequestMapping(value = "/e_update" , method = RequestMethod.GET)
	public String update() {
		Employee employee = this.employeeService.getEmployeeById(33);
		Department department = this.departmentService.getDepartmentById(2);
		employee.setDepartment(department);
		this.employeeService.update(employee);
		return "home";
	}
	
	
	
	
}
