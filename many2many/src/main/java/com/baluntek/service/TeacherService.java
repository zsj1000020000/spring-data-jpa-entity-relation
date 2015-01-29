package com.baluntek.service;

import java.util.List;
import com.baluntek.domain.Teacher;

public interface TeacherService {

	public void save(Teacher teacher) ;
	public void delete(Integer id);
	public void update(Teacher teacher);
	public Teacher getTeacherById(Integer id);
	public List<Teacher> getTeachers(int page , int size);
	public long count();
	
}
