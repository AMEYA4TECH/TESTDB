package com;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("productPost")
public class PostProductAdd {

	@RequestMapping(method = RequestMethod.POST)
	//@RequestMapping(value="addProduct.jsp",method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("product")Product product)
	{
		ModelAndView model= null;
		try
		{
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8080/TestDBPro1/product/";
			com.Product response1=  restTemplate.postForObject(url, product,Product.class);
			/*HttpHeaders headers = new HttpHeaders();
        	headers.add("Accept", "application/json");
        	//headers.setContentType(MediaType.APPLICATION_JSON);
        	headers .add("Content-Type", "application/json ; charset=utf-8");
            
            ObjectMapper mapper1 = new ObjectMapper();
           
            HttpEntity<Product> requestEntity = new HttpEntity<Product>(product, headers);*/
          
            		//(url, HttpMethod.POST, requestEntity, ExternalAPIResponse.class);
            
					 //(url, Product.class, userid);
			
			
			/*
			boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
			if(isValidUser)
			{
				System.out.println("User Login Successful");
				request.setAttribute("loggedInUser", loginBean.getUsername());
				model = new ModelAndView("welcome");
			}
			else
			{
				model = new ModelAndView("login");
model.addObject("loginBean", loginBean);
				request.setAttribute("message", "Invalid credentials!!");
			}*/

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return model;
	}

}
