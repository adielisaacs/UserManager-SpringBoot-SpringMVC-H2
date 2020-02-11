package com.springboot.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.modal.Users;

@Repository
public class UserJdbcRepository implements RowMapper<Users>{
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public Users findByName(String username) {
	    return jdbcTemplate.queryForObject("select * from users where username=?", new Object[] {
	    		username
	        },
	        new BeanPropertyRowMapper <Users> (Users.class));
	}
	
	public List<Users> findAll() {
	    return jdbcTemplate.query("select * from users", new UserJdbcRepository());
	}
	
	public void deleteById(String username) {
	     jdbcTemplate.update("delete from users where username=?", new Object[] {
	    		username
	    });
	}
	public void insert(Users user) {
	     jdbcTemplate.update("INSERT INTO users (username, phone, password,enabled) VALUES(?, ?, ?, ?)",
	        new Object[] {
	        		user.getUsername(), user.getPhone(), user.getPassword(),user.isEnabled()
	        });
	}
	public int update(Users user) {
	    return jdbcTemplate.update("update users " + " set username = ?, phone = ?, password = ? " + " where username = ?",
	        new Object[] {
	        		user.getUsername(), user.getPhone(), user.getPassword(), user.getUsername()
	        });
	}

	@Override
	public Users mapRow(ResultSet rs, int arg1) throws SQLException {
		Users user = new Users();
		user.setUsername(rs.getString("username"));
		user.setPhone(rs.getString("phone"));
		user.setPassword(rs.getString("password"));
		user.setEnabled(new Boolean(rs.getString("enabled")));
        return user;
	}
}
