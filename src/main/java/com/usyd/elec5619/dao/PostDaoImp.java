package com.usyd.elec5619.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.usyd.elec5619.domain.Posts;
import com.usyd.elec5619.domain.Tag;
import com.usyd.elec5619.domain.Users;


/* post model Dao implementation */
@Repository
@Transactional
public class PostDaoImp implements PostDao {

	@Autowired
    private SessionFactory sessionFactory;
	private Session currentSession() {
	    return sessionFactory.getCurrentSession();//<co id="co_getCurrentSession"/>
	  }
	  
	@Override
	public void addPost(Posts post) {
		currentSession().save(post);

	}

	@Override
	public Posts getPostsById(long id) {
		 
	    return (Posts) currentSession().get(Posts.class, id);
	}

	@Override
	public void deletePosts(long id) {
		currentSession().delete(getPostsById(id));

	}

	@Override
	public List<Posts> getPostsByUsername(String username) {
		Query query = currentSession().createQuery("from Posts where user.username = :username");
		query.setParameter("username", username);
		return (List<Posts>)query.list();	
		}

	@Override
	public List<Posts> getRecentPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Posts> getPostsForUsers(Users user) {
		return null;
	}

	@Override
	public void savePost(Posts post) {
		currentSession().update(post);
		
	}

	@Override
	public List<Posts> findAll() {
		List<Posts> list = currentSession().createCriteria(Posts.class).list();
		return list;
	}

	@Override
	public List<Posts> findTopPosts() {
		Query query = currentSession().createQuery("from Posts p order by p.upVoteCount");
		return (List<Posts>)query.list();
	}

	@Override
	public List<Posts> findByTags(Tag tag) {
		String name = tag.getName();
		Query query = currentSession().createQuery( "select distinct p from Posts p join  p.tags t where t.name =:name");
		query.setParameter("name", name);
		return (List<Posts>)query.list();
		
	}

	@Override
	public List<Posts> getPostsByPage() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Posts> getPostsByTitle(String title) {
		Query query = currentSession().createQuery("from Posts where title = :title");
		query.setParameter("title", title);
		return (List<Posts>)query.list();
	}



}
