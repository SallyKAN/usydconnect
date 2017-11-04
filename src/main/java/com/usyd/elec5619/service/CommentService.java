package com.usyd.elec5619.service;

import java.util.List;

import com.usyd.elec5619.domain.Comment;

public interface CommentService {
	 public void addComment(Comment comment);
	 public List<Comment> listCommentByPostId(long id);
	 public void deleteCommentById(long id);
	 public Comment getCommentById(long id);
	 //public void deleteCommentByList(List<Comment> commentList);
}
