package com.baluntek.service;

import java.util.List;

import com.baluntek.domain.Department;

public interface DepartmentService {
	
	public void save(Department department);
	public void delete(Integer id);
	public void update(Department department);
	public Department getDepartmentById(Integer id);
	public List<Department> getDepartmentsByPage(int page , int size);
	public List<Department> getDepartmentsByPageSort(int page , int size);
	public long getCount() ;
	public List<String> getNames() ;
	

}
