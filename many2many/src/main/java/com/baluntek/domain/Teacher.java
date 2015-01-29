package com.baluntek.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tid;
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable( name = "teacher_student", //
	joinColumns=@JoinColumn(name="t_id",referencedColumnName="tid"),//
	inverseJoinColumns=@JoinColumn(name="s_id",referencedColumnName="sid")//
	)
	private List<Student> students = new ArrayList<Student>();

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + "]";
	}
	
	
	

}
