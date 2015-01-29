package com.baluntek.service;

import java.util.List;

import com.baluntek.domain.Student;

public interface StudentService {

	public void save(Student student) ;
	public void delete(Integer id);
	public void update(Student student);
	public Student getStudentById(Integer id);
	public List<Student> getStudents(int page , int size);
	public long count();
	
}
