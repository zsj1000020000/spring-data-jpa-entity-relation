package com.baluntek.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.baluntek.dao.DepartmentRepository;
import com.baluntek.domain.Department;
import com.baluntek.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public void save(Department department) {
		
		this.departmentRepository.save(department);
		
	}

	@Override
	public void delete(Integer id) {
		this.departmentRepository.delete(id);
		
	}

	@Override
	public void update(Department department) {
		this.departmentRepository.save(department);
		
	}

	@Override
	public Department getDepartmentById(Integer id) {
		Department department = this.departmentRepository.getOne(id);
		return department;
	}

	@Override
	public List<Department> getDepartmentsByPage(int page, int size) {
		List<Department> departments = this.departmentRepository.findAll(new PageRequest(page, size)).getContent(); 
		return departments;
	}

	@Override
	public long getCount() {
		long count = this.departmentRepository.count();
		return count;
	}

	@Override
	public List<Department> getDepartmentsByPageSort(int page, int size) {
		Sort sort = new Sort(Direction.DESC, "id");
		PageRequest pageRequest = new PageRequest(page, size, sort);
		List<Department> departments = this.departmentRepository.findAll(pageRequest).getContent();
		return departments;
	}

	
	public List<String> getNames() {
		List<String> names = this.departmentRepository.getNames();
		return names;
	}

	
}
