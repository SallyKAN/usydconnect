package com.usyd.elec5619.dao;
import com.usyd.elec5619.domain.*;

import java.util.List;

import org.springframework.data.domain.Page;


/* post model Dao interface */
public interface PostDao {
	void addPost(Posts post);
	void savePost(Posts post);
	void deletePosts(long id);
	Posts getPostsById(long id);
	List<Posts> getPostsByUsername(String username);
	List<Posts> getPostsByTitle(String title);
    List<Posts> findAll();
	List<Posts> getRecentPosts();
	List<Posts> getPostsForUsers(Users user);
    List<Posts> getPostsByPage();
	List<Posts> findByTags(Tag tag);
	List<Posts> findTopPosts();

}
