package com.usyd.elec5619.service;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.usyd.elec5619.dao.UsersDao;
import com.usyd.elec5619.domain.Posts;
import com.usyd.elec5619.domain.Users;


@Service
@Transactional
public class UserServiceImp implements UserService{
	@Autowired
	private UsersDao usersDao;

    
	@Override

	public void addUser(Users users) {
		// TODO Auto-generated method stub
		usersDao.addUser(users);
	}

	@Override

	public void saveUser(Users users) {
		// TODO Auto-generated method stub
		this.usersDao.saveUser(users);
	}

	@Override	
	public List<Users> listUsers() {
		
		return null;
	}

	@Override
	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(String username) {
		usersDao.deleteUser(username);
		
	}



	@Override
	public Users getUserByUsername(String username) {
		 return usersDao.getUserByUsername(username);
	}

	@Override
	public boolean usernameExists(String username) {
		return getUserByUsername(username) != null;
	}

	@Override
	public Users getUserByEmail(String email) {
		return usersDao.getUserByEmail(email);
	}

	@Override
	public boolean emailExists(String email) {
		return getUserByEmail(email) != null;
	}

	@Override
	public Users currentUser() {

            return null;
	
	}
	

	@Override
	public boolean isAuthenticated() {
		SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication auth = securityContext.getAuthentication();

        return auth != null && !(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated();
	}

	@Override
	public boolean authenticate(String username, String password) {
		 return Objects.equals(username, password);
	}

}
