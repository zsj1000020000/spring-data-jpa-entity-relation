package com.baluntek.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.baluntek.domain.Department;

@Repository("departmentRepository")
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	@Query("select d.name from Department d")
	public List<String> getNames();
}
