package com.baluntek.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baluntek.domain.Department;
import com.baluntek.domain.Employee;
import com.baluntek.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	private static Logger log = Logger.getLogger(DepartmentController.class);
	 
	
	@RequestMapping(value = "/d_save" , method = RequestMethod.GET)
	public String save() {
		Department department = new Department();
		department.setName("d1");
		
		Employee employee = new Employee();
		employee.setName("e1");
		
		department.addEmployee(employee);
		
		this.departmentService.save(department);
		
		return "home";
	}
	@RequestMapping(value = "/d_delete" , method = RequestMethod.GET)
	public String delete() {
		
		this.departmentService.delete(1);
		
		return "home";
	}
	@RequestMapping(value = "/d_update" , method = RequestMethod.GET)
	public String update() {
		Department department = this.departmentService.getDepartmentById(2);
		Employee employee = new Employee();
		employee.setName("张三");
		department.addEmployee(employee);
		this.departmentService.update(department);
		
		return "home";
	}
	@RequestMapping(value = "/d_update2" , method = RequestMethod.GET)
	public String update2() {
		Department department = this.departmentService.getDepartmentById(2);
		Employee employee = new Employee();
		employee.setId(30);
		department.getEmployees().remove(employee);
		this.departmentService.update(department);
		
		return "home";
	}
	@RequestMapping(value = "/d_get" , method = RequestMethod.GET)
	public String get() {
		Department department = this.departmentService.getDepartmentById(2);
		log.info(department.toString());
		return "home";
	}
	@RequestMapping(value = "/d_getAll" , method = RequestMethod.GET)
	public String getAll() {
		List<Department> departments = this.departmentService.getDepartmentsByPage(0, 5);
		for (Department department : departments) {
			log.info(department.toString());
		}
		return "home";
	}
	
	@RequestMapping(value = "/d_getAll2" , method = RequestMethod.GET)
	public String getAll2() {
		List<Department> departments = this.departmentService.getDepartmentsByPageSort(0, 5);
		for (Department department : departments) {
			log.info(department.toString());
		}
		return "home";
	}
	@RequestMapping(value = "/d_getNames" , method = RequestMethod.GET)
	public String getNames() {
		List<String> names = this.departmentService.getNames();
		log.info(names.size());
		return "home";
	}
	
	@RequestMapping(value = "/d_getEs" , method = RequestMethod.GET)
	public String getEmployees() {
		Department department = departmentService.getDepartmentById(2);
		List<Employee> employees = department.getEmployees();
		for (Employee e : employees) {
			log.info(e.getId());
		}
		return "home";
	}
	
	
}
