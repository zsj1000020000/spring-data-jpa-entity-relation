package com.baluntek.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baluntek.domain.Student;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	

}
