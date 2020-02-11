package com.springboot.rest;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.modal.Users;
import com.springboot.service.UserJdbcRepository;


@RestController
public class KineticController
{
	@Autowired
	UserJdbcRepository repo;
	
	
	@RequestMapping(value = "/api/adduser", method = RequestMethod.POST)
	public @ResponseBody void createUser(@RequestBody Users user)
	{
		repo.insert(user);
	}
	
	@RequestMapping(value = "/api/users", method = RequestMethod.GET)
	public @ResponseBody List<Users> getUsers(Model m)
	{
		
		List<Users> listUsers = repo.findAll();
		
		return listUsers;
		
	}
	
	@GetMapping("/api/usersByName")
	public Users getUsersByName(@RequestParam("username") String username)
	{
		Users user = repo.findByName(username);
		return user;	
	}
	@RequestMapping(value = "/api/usersDummy", method = RequestMethod.GET)
	public @ResponseBody Users getDummyUser()
	{
		Users user = new Users();
		user.setUsername("Dummy");
		user.setPhone("0798811601");
		user.setPassword("Password");
		user.setEnabled(true);
		return user;	
	}
	
			
}


