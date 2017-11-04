package com.usyd.elec5619.domain;

import java.util.Date;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/* post model */
@Entity
@Table(name = "posts")
public class Posts {
	@Id
    @GeneratedValue
    private  Long id;
	@Column(length = 250, nullable = false)
    private  String title;
	
	@Lob @Column(nullable = false)
    private  String message;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)

	private Users user;
    
	@Column(nullable = false)
    private  Date date = new Date();
	
	@Column(nullable = false)
	private String postUsername;
	
	@Column(nullable = false)
	private Integer commentCount = 0;
	
	@Column(nullable = false)
	private Integer upVoteCount = 0;
	
	//@Column
	//private Integer viewCount = 1;

    
    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(name = "posts_tags",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    @OrderBy("name ASC")
    @Fetch (FetchMode.SELECT)
 
    private Collection<Tag> tags = new ArrayList<>();
    
   
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)
    @OrderBy("dateTime ASC")
    private List<Comment> comments = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostVote> postVote = new ArrayList<>();
   
    
   
    public void setId(Long id) {
   	 this.id = id;
}
    public long getId() {
    	return id;
}
    public void setTitle(String title) {
    	this.title=title;
}
    public String getTitle() {
    	return title;
}
    public void setMessage(String message) {
    	this.message = message;
}
    public String getMessage() {
    	return message;
}

    public void setTime(Date date) {
    	this.date = date;
}
    public Date getTime() {
    	return date;
}
    public Collection<Tag> getTags() {
        return tags;
    }

    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public List<PostVote> getPostRatings() {
        return postVote;
    }

    public void setPostRatings(List<PostVote> postVote ) {
        this.postVote = postVote;
    }
    public Users getUser() {
        return user;
   }

   public void setPostUsername(String postUsername) {
        this.postUsername = postUsername;
   }
   public String getPostUsername() {
       return postUsername;
  }

  public void setUser(Users user) {
       this.user = user;
  }
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
    public Integer getCommentCount(){
    	return commentCount;
    }
    public void setUpVoteCount(Integer upVoteCount) {
        this.upVoteCount = upVoteCount;
    }
    public Integer getUpVoteCount(){
    	return upVoteCount;
    }	
  /*  public void setviewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
    public Integer getviewCount(){
    	return viewCount;
    }	*/
}