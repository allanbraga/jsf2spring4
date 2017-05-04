package com.app.main;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.main.entity.User;
import com.app.main.service.UserService;

@Component
@ManagedBean
@SessionScoped
public class CarBean {
	
	private String name = "Test";
	
	
	@Autowired
	UserService userService;
	
	public String getName() {
		User user =  userService.findByLogin("allan.braga");
		name = user.getEmail();
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String logout() {		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();        
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        
        try {        	
			context.redirect(context.getRequestContextPath() + "/logout");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;
    }
	
	
	
}
