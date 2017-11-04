package com.usyd.elec5619.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.elec5619.dao.CommentDao;
import com.usyd.elec5619.domain.Comment;

@Service
@Transactional
public class CommentServiceImp implements CommentService {

	@Autowired
	private CommentDao commentDao;
	

	public void addComment(Comment comment) {
		commentDao.addComment(comment);
  
	}

	public List<Comment> listCommentByPostId(long id) {
		
		return commentDao.listCommentByPostId(id);
	}


	public void deleteCommentById(long id) {
		commentDao.deleteCommentById(id);

	}

	@Override
	public Comment getCommentById(long id) {
		return commentDao.getCommentById(id);
	}

}
