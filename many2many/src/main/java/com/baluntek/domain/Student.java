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
@Table(name = "t_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sid;
	private String name;

	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
	@JoinTable(name = "teacher_student", 
	joinColumns = @JoinColumn(name = "s_id", referencedColumnName = "sid"), 
	inverseJoinColumns = @JoinColumn(name = "t_id", referencedColumnName = "tid")
	)
	
	private List<Teacher> teachers = new ArrayList<Teacher>();

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + "]";
	}

}
