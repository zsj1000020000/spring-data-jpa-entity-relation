package com.baluntek.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baluntek.domain.Student;
import com.baluntek.domain.Teacher;
import com.baluntek.service.StudentService;
import com.baluntek.service.TeacherService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	
	private static final Logger log = Logger.getLogger(StudentController.class);

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value="/save")
	public String save() {
		Student student = new Student();
		student.setName("zhangsan");
		List<Teacher> teachers = new ArrayList<Teacher>();
		Teacher t1 = new Teacher();
		t1.setName("t1");
		Teacher t2 = new Teacher();
		t2.setName("t2");
		teachers.add(t1);
		teachers.add(t2);
		student.getTeachers().addAll(teachers);
		this.studentService.save(student);
		
		return "home";
	}
	@RequestMapping(value="/save2")
	public String save2() {
		Student student = new Student();
		student.setName("zhangsan");
		Teacher teacher = this.teacherService.getTeacherById(1);
		student.getTeachers().add(teacher);

		this.studentService.save(student);
		
		return "home";
	}
	
	@RequestMapping(value="/delete" , method = RequestMethod.GET)
	public String delete() {
		
		this.studentService.delete(1);
		
		return "home";
	}
	@RequestMapping(value="/get" , method = RequestMethod.GET)
	public String get() {
		
		Student student = this.studentService.getStudentById(1);		
		log.info(student.toString());		
		return "home";
	}
	
	@RequestMapping(value="/getAll" , method = RequestMethod.GET)
	public String getAll() {
		List<Student> students = this.studentService.getStudents(0, 5);
		for (Student student : students) {
			log.info(student.toString());
		}				
		return "home";
	}
	
}
