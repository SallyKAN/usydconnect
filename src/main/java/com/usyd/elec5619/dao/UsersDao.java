package com.usyd.elec5619.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.usyd.elec5619.domain.Posts;
import com.usyd.elec5619.domain.Users;

/* user Dao interface */
public interface UsersDao {
    
	  public void addUser(Users users);
	  public void saveUser(Users users);
	  public void deleteUser(String username);
	  public Users getUsersById(long id);
	  public Users getUserByUsername(String username);
	  public Users getUserByEmail(String email);
	  public List<Posts> getRecentPosts();
	  public List<Users> findAllUsers();
		
}
