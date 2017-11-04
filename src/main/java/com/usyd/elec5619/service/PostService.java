package com.usyd.elec5619.service;
import java.util.List;

import com.usyd.elec5619.domain.*;

public interface PostService {
	public Posts getPostById(Long id);
	public void  saveNewPost(Posts post);
	public void  updatePost(Posts post);
    public List<Posts> getTopPostsList();
    public List<Posts> getRecentPostsList();
    public List<Posts> getPostsByUsername(String username);
    public List<Posts> findPostsByTag(Tag tag);
    public List<Posts> findAll();
    public void vote(Long postId, boolean like) throws AlreadyVotedException;
    public void deletePost(Long id);
    //void vote(Long postId, boolean like) throws AlreadyVotedException;
}
