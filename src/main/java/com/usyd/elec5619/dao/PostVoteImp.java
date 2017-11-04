package com.usyd.elec5619.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usyd.elec5619.domain.PostVote;
import com.usyd.elec5619.domain.Posts;


/* post vote Dao implementation */
@Repository
public class PostVoteImp implements PostVoteDao {

	@Autowired
    private SessionFactory sessionFactory;
	private Session currentSession() {
	    return sessionFactory.getCurrentSession();//<co id="co_getCurrentSession"/>
	  }
	public PostVote getUserVote(long postId, long userId) {
		Query query = currentSession().createQuery(
				"SELECT r FROM PostVote r WHERE r.post.id = :postId AND r.user.id = :userId");
		query.setParameter("postId",postId );
		query.setParameter("userId",userId );
		return (PostVote)query.uniqueResult();
	}
	@Override
	public void addPostVote(PostVote postVote) {
		currentSession().save(postVote);
		
	}
	@Override
	public List<PostVote> getVote(long postId) {
		Query query = currentSession().createQuery(
				"SELECT r FROM PostVote r WHERE r.post.id = :postId");
		query.setParameter("postId",postId );
		return (List<PostVote>)query.list();
	
	}
	@Override
	public List<PostVote> getUpVote(long postId) {
		Query query = currentSession().createQuery(
				"SELECT r FROM PostVote r WHERE r.value = 1 AND r.post.id = :postId");
		query.setParameter("postId",postId );
		return (List<PostVote>)query.list();
	}

}
