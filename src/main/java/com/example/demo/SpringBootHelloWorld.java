package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class SpringBootHelloWorld {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	@GetMapping("/index")
	public String helloIndex(){
		return "index";
	}
	
	//添加SQL驗證帳號
	@GetMapping("result")
	public ModelAndView home(@RequestParam(required = false) String user_name,@RequestParam(required = false) String user_password) {
		
		String sql = "select count(user_name) from user_account where user_name = ? AND user_password = ?";
		int count =  jdbcTemplate.queryForObject(sql,new Object[] {user_name,user_password},Integer.class);
		
		if (count > 0) {
			
			ModelAndView model = new ModelAndView("hello");
			model.addObject("name", user_name);
			model.addObject("psd", user_password);
			return model;
			
			
		}else {
			
			ModelAndView model = new ModelAndView("error");
			return model;
		
		}
		
	}
	
	
	/*
	 * TestAccount寫死
	@GetMapping("/result")
    public ModelAndView home(@RequestParam(required = false) String user_name,@RequestParam(required = false) String user_password) {
	   
		
		String test_account = "Ruby";
		String test_password = "psd";
		
		if (user_name.equals(test_account) && user_password.equals(test_password)) {
			
			
			//List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql,TestAccount);
			
			//return model;
			
			ModelAndView model = new ModelAndView("hello");
			model.addObject("name", user_name);
			model.addObject("psd", user_password);
			return model;
			
			
		}else {
			ModelAndView model = new ModelAndView("error");
			return model;
		}
		
		return null;
		
    }
	
	*/
}