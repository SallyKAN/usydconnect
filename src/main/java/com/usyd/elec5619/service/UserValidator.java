package com.usyd.elec5619.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.usyd.elec5619.domain.Users;

import org.springframework.beans.factory.annotation.Autowired;

public class UserValidator implements Validator {

	 @Autowired
	 UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return Users.class.equals(aClass);
	}

	@Override
	public void validate(Object object, Errors errors) {
		 Users user = (Users) object;
		 if (!StringUtils.isEmpty(user.getUsername())) {
	            if (userService.usernameExists(user.getUsername())) {
	                errors.rejectValue("username", "Registered");
	            }
	        }
		 if (!StringUtils.isEmpty(user.getEmail())) {
	            Users currentUser = userService.currentUser();

	            if (currentUser == null || !currentUser.getEmail().equalsIgnoreCase(user.getEmail())) {
	                if (userService.emailExists(user.getEmail())) {
	                    errors.rejectValue("email", "Registered");
	                }
	
	            }
	            
		 }
	}
}
	

