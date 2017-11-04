package com.usyd.elec5619.dao;

import java.util.List;

import com.usyd.elec5619.domain.PostVote;

/* post vote Dao interface */
public interface PostVoteDao {
	public void addPostVote(PostVote postVote);
	public PostVote getUserVote(long postId,long userId);
	public List<PostVote> getVote(long postId);
	public List<PostVote> getUpVote(long postId);
}
