package com.usyd.elec5619.dao;

import java.util.Collection;
import java.util.List;

import com.usyd.elec5619.domain.Posts;
import com.usyd.elec5619.domain.Tag;


/*Tag Dao interface */
public interface TagDao {
	public void addTag(Tag tag);
	public void flush();
	public void openSession();
	public Tag getTagById(long id);
	public Tag getTagByTagname(String name);
	public Tag getTagByPostId(long id);
	public List<Tag> findAll();
	public void addTagCollection(Collection<Tag> tags);
}
