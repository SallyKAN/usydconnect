package com.usyd.elec5619.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usyd.elec5619.domain.CommentVote;
import com.usyd.elec5619.domain.PostVote;

/* For comment vote Dao implementation */
@Repository
public class CommentVoteDaoImp implements CommentVoteDao {

	
	@Autowired
    private SessionFactory sessionFactory;
	private Session currentSession() {
	    return sessionFactory.getCurrentSession();//<co id="co_getCurrentSession"/>
	  }
	public void addCommentVote(CommentVote commentVote) {
		currentSession().save(commentVote);

	}

	@Override
	public CommentVote getUserVote(long commentId, long userId) {
		Query query = currentSession().createQuery(
				"SELECT r FROM CommenVote r WHERE r.comment.id = :commentId AND r.user.id = :userId");
		query.setParameter("commentId",commentId );
		query.setParameter("userId",userId );
		return (CommentVote)query.uniqueResult();
	}

	@Override
	public List<CommentVote> getVote(long commentId) {
		Query query = currentSession().createQuery(
				"SELECT r FROM CommenVote r WHERE r.comment.id = :commentId");
		query.setParameter("commentId",commentId );
		return (List<CommentVote>)query.list();
	}

	@Override
	public List<CommentVote> getUpVote(long commentId) {
		Query query = currentSession().createQuery(
				"SELECT r FROM CommenVote r WHERE r.value = 1 AND r.comment.id = :commentId");
		query.setParameter("commentId",commentId );
		return (List<CommentVote>)query.list();
	}

}
