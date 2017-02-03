package com.daysluck.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.daysluck.domain.User;
import com.daysluck.service.UserService;

/**
 * 
 * @author zhangcb
 * @date 2017-02-03
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int create(String name, Integer age) {
		return jdbcTemplate.update("insert into user(name,age) values(?,?)", name,age);
	}

	public int deleteByName(String name) {
		return jdbcTemplate.update("delete from user where name=?", name);
	}

	public List<User> getAllUsers(Integer age) {
		String sql = "select * from user where age>?";
		SqlRowSet srs=jdbcTemplate.queryForRowSet(sql,new Object[]{age});
		List<User> list = new ArrayList<User>();
		while(srs.next()){
			User user = new User();
			user.setId(srs.getInt("id"));
			user.setName(srs.getString("name"));
			user.setAge(srs.getInt("age"));
			list.add(user);
		}
		return list;
	}

}
