package com.baluntek.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baluntek.domain.Teacher;

@Repository("teacherRepository")
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

	
}
