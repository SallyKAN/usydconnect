package com.usyd.elec5619.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.elec5619.domain.Posts;
import com.usyd.elec5619.domain.Users;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

/* user Dao implementation */
@Repository
public  class UserDaoImp implements UsersDao {
	  @Autowired
	  private SessionFactory sessionFactory;
	  
	  private Session currentSession() {
	    return sessionFactory.getCurrentSession();//<co id="co_getCurrentSession"/>
	  }
	  
	  public void addUser(Users users) {
	    currentSession().save(users);//<co id="co_useSession"/>
	  }
	  
	  public void deleteUser(String username) {
		  currentSession().delete(getUserByUsername(username));
	  }

	  public Users getUsersById(long id) {
	    return (Users) currentSession().get(Users.class, id);//<co id="co_useSession"/>
	  }

	  public void saveUser(Users users) {
	    currentSession().update(users);//<co id="co_useSession"/>
	  }
	  //<end id="java_contextualHibernateDao"/> 
	  
	  public List<Posts> getRecentPosts() {
	  //  return currentSession().f  loadAll(Spittle.class); // this isn't right...just a placeholder for now
	    return null;
	  }
	  
	  @Override
	  public  Users getUserByUsername(String username) {
	   
		  Query query = currentSession().createQuery("from Users where username = :username");
		  query.setParameter("username", username);
		  return (Users)query.uniqueResult();
	  }


	  public List<Users> findAllUsers() {
	    
	    return null;
	  }
 
	@Override
	public Users getUserByEmail(String email) {
		return null;
				//(Users) currentSession().get(Users.class, email);
	}

	
	}
