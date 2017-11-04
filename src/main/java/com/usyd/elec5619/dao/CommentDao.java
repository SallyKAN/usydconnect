package com.usyd.elec5619.dao;

import java.util.List;

import com.usyd.elec5619.domain.Comment;


//Comment Dao Interface 
//Store the comment to databse
public interface CommentDao {
	 public void addComment(Comment comment);
	 public List<Comment> listCommentByPostId(long id);
	 public void deleteCommentById(long id);
	 public Comment getCommentById(long id);
}
