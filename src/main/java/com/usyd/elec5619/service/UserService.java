package com.usyd.elec5619.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.usyd.elec5619.domain.Posts;
import com.usyd.elec5619.domain.Users;


public interface UserService {
	public void addUser(Users users);
	public void saveUser(Users users);
	public List<Users> listUsers();
	public Users getUserByUsername(String username);
	public boolean usernameExists(String username);
	public Users getUserByEmail(String email);
	public boolean emailExists(String email);
	public boolean isAuthenticated();
	public Users currentUser();
	public Users getUserById(int id);
	public void removeUser(String username);
	public boolean authenticate(String username, String password);

}
