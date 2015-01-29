package com.baluntek.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.baluntek.dao.StudentRepository;
import com.baluntek.domain.Student;
import com.baluntek.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void save(Student student) {
		this.studentRepository.save(student);
		
	}

	@Override
	public void delete(Integer id) {
		
		this.studentRepository.delete(id);
	}

	@Override
	public void update(Student student) {
		
		this.studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Integer id) {
		Student student = this.studentRepository.getOne(id);
		return student;
	}

	@Override
	public List<Student> getStudents(int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size);
		List<Student> students = this.studentRepository.findAll(pageRequest).getContent();
		return students;
	}

	@Override
	public long count() {
		long count = this.studentRepository.count();
		return count;
	}

}
