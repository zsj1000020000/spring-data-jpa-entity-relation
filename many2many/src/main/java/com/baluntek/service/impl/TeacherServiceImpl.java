package com.baluntek.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.baluntek.dao.TeacherRepository;
import com.baluntek.domain.Teacher;
import com.baluntek.service.TeacherService;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public void save(Teacher teacher) {
		this.teacherRepository.save(teacher);

	}

	@Override
	public void delete(Integer id) {
		this.teacherRepository.delete(id);

	}

	@Override
	public void update(Teacher teacher) {
		this.teacherRepository.save(teacher);
	}

	@Override
	public Teacher getTeacherById(Integer id) {
		Teacher teacher = this.teacherRepository.getOne(id);
		return teacher;
	}

	@Override
	public List<Teacher> getTeachers(int page, int size) {
		Pageable pageable = new PageRequest(page,size);
		List<Teacher> teachers = this.teacherRepository.findAll(pageable).getContent();
		return teachers;
	}

	@Override
	public long count() {
		long count = this.teacherRepository.count();
		return count;
	}

}
