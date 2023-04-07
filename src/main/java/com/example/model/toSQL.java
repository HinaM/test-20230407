package com.example.model;

import org.springframework.stereotype.Component;


@Component
public class toSQL {
	
	  private String user_name;
	  private String user_password;
	  
	  
	  public String getName() {
		return user_name;
	  }
	  public void setEmail(String user_name) {
		this.user_name = user_name;
	  }
	  
	  public String getPassword() {
		return user_password;
	  }
	  public void setPassword(String user_password) {
		this.user_password = user_password;
	  }
	  
}