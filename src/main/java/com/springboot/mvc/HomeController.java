package com.springboot.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.Utility;
import com.springboot.modal.AddUser;
import com.springboot.modal.SessionUserInfo;
import com.springboot.modal.Users;
import com.springboot.service.UserJdbcRepository;


@Controller
public class HomeController
{
	Utility sessiontracker = new Utility();			

	@RequestMapping("/")
	public String home(){
		return "login";
	}
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/welcome")
	public ModelAndView firstPage(HttpServletRequest request, HttpSession session) {
		RestTemplate restTemplate = new RestTemplate();
		List<Users> updatedUsers = restTemplate.getForObject("http://localhost:8080/api/users", List.class);
		
		session = request.getSession(false);
		ModelAndView mv = new ModelAndView();
		if(session != null){
			
			mv.addObject("users", updatedUsers);
			mv.addObject("user", (Users)session.getAttribute("user"));
			mv.addObject("sessiontracker", sessiontracker.getList());
			mv.addObject("sumValidSessions", sessiontracker.getSizeSessionList());
			mv.setViewName("welcome");
			
			return mv;
		}	
		
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/addNewUser", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("welcome", "newuser", new AddUser());
	}

	@RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
	public ModelAndView processRequest(HttpServletRequest request, HttpSession session, @RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("phone")String phone) {
				
		RestTemplate restTemplate = new RestTemplate();

		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEnabled(true);
				
		restTemplate.postForObject("http://localhost:8080/api/adduser", user, Users.class);
		List<Users> updatedUsers = restTemplate.getForObject("http://localhost:8080/api/users", List.class);
		
		session = request.getSession(false);
		ModelAndView model = new ModelAndView();

		if(session != null){
			model.setViewName("welcome");
			
			model.addObject("users", updatedUsers);
			model.addObject("user", (Users)session.getAttribute("user"));
			model.addObject("sessiontracker", sessiontracker.getList());
			model.addObject("sumValidSessions", sessiontracker.getSizeSessionList());
		
			return model;
		}
		return new ModelAndView("login");
	}

	@RequestMapping("/getUsers")
	public ModelAndView getUsers() {
		RestTemplate restTemplate = new RestTemplate();

		List<Users> updatedUsers = restTemplate.getForObject("http://localhost:8080/api/users", List.class);
		
		ModelAndView model = new ModelAndView("getUsers");
		model.addObject("users", updatedUsers);
		return model;
	}

    
	
	@RequestMapping(value = "loginAuth", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password,
						HttpServletRequest request,
						HttpSession session,
						ModelMap modelMap) {
		RestTemplate restTemplate = new RestTemplate();
						
		Users validUser = restTemplate.getForObject("http://localhost:8080/api/usersByName?username="+username, Users.class);
		
		if(username.equalsIgnoreCase(validUser.getUsername()) && password.equalsIgnoreCase(validUser.getPassword())) {
			String sessionToken = session.getId();
			
			session = request.getSession();
			session.setMaxInactiveInterval(10*60);
	
			SessionUserInfo sui = new SessionUserInfo();
			
			sui.setUser(username);
			sui.setToken(sessionToken);
			sui.setLogintime(session.getCreationTime());
			
			if(sessiontracker.isValid(sui)){
				sessiontracker.storeSession(sui);
			}
			
			List<Users> updatedUsers = restTemplate.getForObject("http://localhost:8080/api/users", List.class);
			
			modelMap.addAttribute("users", updatedUsers);
			modelMap.addAttribute("user", validUser);
			session.setAttribute("user", validUser);
			modelMap.addAttribute("sessionToken", sessionToken);
			modelMap.addAttribute("sessiontracker", sessiontracker.getList());
			modelMap.addAttribute("sumValidSessions", sessiontracker.getSizeSessionList());
			
			return "welcome";
		} else {
			modelMap.addAttribute("loginError", "Your username and password are invalid.");
			return "login";	
		}
	}
	
	@RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response, HttpSession session, ModelMap modelMap ) throws ServletException, IOException {
		
		modelMap.addAttribute("loginError", "You have been logged out successfully.");
        
		String url = request.getRequestURI();
		request.getSession().invalidate();

        response.setHeader("pragma", "no-cache");              
        response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");             
        response.setHeader("Expires", "0"); 
		 
        if(session==null && !url.contains("login")) {
             response.sendRedirect(request.getContextPath() + "/login");
             response.setHeader("message", "Session Timeout."); 
         }
		return "login";
		
    }
}


