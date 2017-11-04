package com.usyd.elec5619.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usyd.elec5619.domain.Comment;
import com.usyd.elec5619.domain.Posts;

/* implementation of the CommentDao class. We are using hibernate to interface with our database and server*/

@Repository
public class CommentDaoImp implements CommentDao {

	@Autowired
    private SessionFactory sessionFactory;
	private Session currentSession() {
	    return sessionFactory.getCurrentSession();//<co id="co_getCurrentSession"/>
	  }
	@Override
	public void addComment(Comment comment) {
		currentSession().save(comment);
	}

	@Override
	public List<Comment> listCommentByPostId(long id) {
		Query query = currentSession().createQuery("from Comment where post.id = :id");
		query.setParameter("id", id);
		List<Comment> commentList = query.list();
		return commentList;
	}

	@Override
	public void deleteCommentById(long id) {
		
		currentSession().delete(getCommentById(id));
	}

	@Override
	public Comment getCommentById(long id) {
		// TODO Auto-generated method stub
		return (Comment) currentSession().get(Comment.class, id);
	}

}
