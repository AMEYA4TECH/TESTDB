package com;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class ListProductController {

	@RequestMapping("/listUsers")
	public ModelAndView listUsers() {
		List<LinkedHashMap> users =null;
		try{
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080//TestDBPro1/product/all";
		users= restTemplate.getForObject(url, List.class);
		}catch(Exception e){
			
			
		}
		
		return new ModelAndView("listUsers", "users", users);
	}

	@RequestMapping("/dispUser/{userid}")
	public ModelAndView dispUser(@PathVariable("userid") int userid) {
		Product user=null;
		try{
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080//TestDBPro1/product/{userid}";
		 user = restTemplate.getForObject(url, Product.class, userid);
		}catch(Exception e){}
		return new ModelAndView("dispUser", "user", user);
	}
	
	
	
	
}