package com.usyd.elec5619.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.elec5619.domain.Posts;
import com.usyd.elec5619.domain.Tag;



/*Tag Dao implementation */
@Repository
@Transactional
public class TagDaoImp implements TagDao {

	
	@Autowired
    private SessionFactory sessionFactory;
	private long tagId;
	private Session currentSession() {
	    return sessionFactory.getCurrentSession();//<co id="co_getCurrentSession"/>
	  }
	  
	@Override
	public Tag getTagById(long id) {
		return (Tag) currentSession().get(Tag.class, id);
	}

	@Override
	public Tag getTagByTagname(String name) {
		
		Query query = currentSession().createQuery("from Tag where name = :name");
		query.setParameter("name", name);
		return (Tag)query.uniqueResult();	
	}

	@Override
	public void addTag(Tag tag) {
		currentSession().save(tag);
		
	}
	public void addTagCollection(Collection<Tag> tags) {
		
		for(Tag tag : tags) {
			currentSession().save(tag);
		}	
	}

	@Override
	public Tag getTagByPostId(long id) {
		return null;

	}

	@Override
	public List<Tag> findAll() {
		List<Tag> list = currentSession().createCriteria(Tag.class).list();
		return list;
	}

	@Override
	public void flush() {
		currentSession().flush();
		
	}
	public void openSession(){
		sessionFactory.openSession();
	}

}
