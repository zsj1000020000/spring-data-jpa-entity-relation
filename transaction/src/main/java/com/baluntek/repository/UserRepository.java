package com.baluntek.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baluntek.damain.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {

}
