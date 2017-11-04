package com.usyd.elec5619.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.usyd.elec5619.dao.PostDao;
import com.usyd.elec5619.dao.PostVoteDao;
import com.usyd.elec5619.dao.TagDao;
import com.usyd.elec5619.dao.UsersDao;
import com.usyd.elec5619.domain.PostVote;
import com.usyd.elec5619.domain.Posts;
import com.usyd.elec5619.domain.Tag;
import com.usyd.elec5619.domain.Users;
import com.usyd.elec5619.domain.Vote;

@Service
@Transactional
public class PostServiceImp implements PostService  {

	
	@Autowired
	private PostDao postDao;
	@Autowired
	private UserService userService;
	@Autowired
	private PostVoteDao postVoteDao;
	@Autowired
	private TagDao tagDao;
	
	
	
	@Override
	public Posts getPostById(Long id) {
		
		return postDao.getPostsById(id);
	}

	@Override
	@Transactional
	public void saveNewPost(Posts post) {
		 postDao.addPost(post);
	}

	@Override
	@Transactional
	public void updatePost(Posts post) {
		postDao.savePost(post);
	}

	@Override
	public List<Posts> getTopPostsList() {
		
		return null;
	}

	@Override
	public List<Posts> getRecentPostsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Posts> findPostsByTag(Tag tag) {
		return postDao.findByTags(tag);
		
		
	}

	@Override
	@Transactional
	public void deletePost(Long id) {
		postDao.deletePosts(id);
		
	}

	@Override
	public List<Posts> findAll() {
		
		return postDao.findAll();
	}

	@Override
	public void vote(Long postId, boolean like) throws AlreadyVotedException {
		
		Posts post = getPostById(postId);
		PostVote postVote = new PostVote();
		postVote.setValue(like ? Vote.UPVOTE_VALUE : Vote.DOWNVOTE_VALUE);
		postVote.setPost(post);
		postVoteDao.addPostVote(postVote);
		
	}

	@Override
	public List<Posts> getPostsByUsername(String username) {
		return postDao.getPostsByUsername(username);
	}


}