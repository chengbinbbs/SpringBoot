package com.daysluck.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.daysluck.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	//jpa通过解析方法名称创建查询
	List<User> findByName(String name);
	
	//jpa利用注解实现复杂sql语句查询
	@Query("from User u where u.age>?1")
	List<User> findUsers(Integer age);
	
	//jpa利用注解实现复杂sql语句查询
	@Query("from User u where u.name=:name")
	List<User> findUserName(@Param("name")String name);
}
