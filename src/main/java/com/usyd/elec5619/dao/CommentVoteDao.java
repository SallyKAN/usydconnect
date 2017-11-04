package com.usyd.elec5619.dao;

import java.util.List;

import com.usyd.elec5619.domain.CommentVote;
import com.usyd.elec5619.domain.PostVote;


/* For comment vote Dao interface */
public interface CommentVoteDao {
	public void addCommentVote(CommentVote commentVote);
	public CommentVote getUserVote(long commentId,long userId);
	public List<CommentVote> getVote(long commentId);
	public List<CommentVote> getUpVote(long commentId);
}
