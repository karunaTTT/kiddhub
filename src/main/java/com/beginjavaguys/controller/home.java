package com.beginjavaguys.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//import com.beginjavaguys.model.Product;
//import com.beginjavaguys.service.Productservice;
import com.beginjavaguys.*;
import com.beginjavaguys.DAO.ProductserviceImpl;
import com.beginjavaguys.model.Product;


@Controller 
public class home {
	String message = "Welcome to your 1st Maven Spring project !";  

	 @RequestMapping("/login")  
    public ModelAndView showMessage() {  
        System.out.println("from controller");  
        return new ModelAndView ("login");    
    } 
	
	 @RequestMapping("/register")  
	    public ModelAndView showMessageL() {  
	        System.out.println("from controller");  
	        return new ModelAndView ("Register");    
	    } 
	 /*
	 @RequestMapping("/adminpg")  
	    public ModelAndView showMessage1() {  
	        System.out.println("from controller");  
	        return new ModelAndView ("adminpg");    
	    } 
	 
	 @RequestMapping("/multi")  
	    public ModelAndView showMessagep() {  
	        System.out.println("from controller");  
	        return new ModelAndView ("viewdata");    
	    } 
	 
	 
	 
	    
	 @RequestMapping("/bag")  
	    public ModelAndView showMessage2() {  
	        System.out.println("from controller");  
	        return new ModelAndView ("bag");    
	    } */
@Autowired 
private ProductserviceImpl productservice;

@Autowired
public home(ProductserviceImpl productservice)
{
	this.productservice = productservice;
}



	 @RequestMapping("/adminpg")
	 public String setupform(Map <String,Object>map)
	 {
		 Product pd = new Product();
		 map.put("product", pd);
		 map.put("productList",productservice.getallProduct());
		 System.out.println(map);
		 
		 
		 return "adminpg";
	 }
	 
	@RequestMapping(value="product.do",method=RequestMethod.POST)
	public String doaction(@ModelAttribute Product product,BindingResult result,@RequestParam String action,Map <String,Object>map)
	{
		Product productresult = new Product();
	//	System.out.println(action);
		//int choice = Integer.parseInt(action);
		switch(action)
		{
		case "add":
			System.out.println("data added1");
			productservice.add(product);
			System.out.println("data added2");
			productresult=product;
			System.out.println("data added3");
			System.out.println("loo"+productresult.getPid());
			break;

		case "edit":
			System.out.println("Action is edit !!!!!!"+action);
				productservice.edit(product);
				System.out.println("data added2");
			productresult=product;
			System.out.println("data added2");
			break;
		
	
		
		case "delete":
			productservice.delete(product.getPid());
			productresult=new Product();
					break;
		
		case "search":
			Product searchproduct =productservice.getProduct(product.getPid());
			productresult=searchproduct !=null ? searchproduct : new Product();
		}
		
		map.put("product", productresult);
		map.put("productList", productservice.getallProduct());
		
		return"adminpg";	
	}
	
	
	 }






